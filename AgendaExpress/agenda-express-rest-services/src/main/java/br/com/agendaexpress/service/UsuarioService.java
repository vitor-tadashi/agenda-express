package br.com.agendaexpress.service;

import java.util.ArrayList;
import java.util.List;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.agendaexpress.beans.UsuarioBean;
import br.com.agendaexpress.dao.PessoaDAO;
import br.com.agendaexpress.dao.PessoaFisicaDAO;
import br.com.agendaexpress.dao.PessoaJuridicaDAO;
import br.com.agendaexpress.dao.SeguidorDAO;
import br.com.agendaexpress.dao.UsuarioDAO;
import br.com.agendaexpress.entity.PessoaEntity;
import br.com.agendaexpress.entity.PessoaFisicaEntity;
import br.com.agendaexpress.entity.PessoaJuridicaEntity;
import br.com.agendaexpress.entity.SeguidorEntity;
import br.com.agendaexpress.entity.SeguidorEntityPK;
import br.com.agendaexpress.entity.UsuarioEntity;
import br.com.agendaexpress.enun.AtivoInativoEnum;
import br.com.agendaexpress.exceptions.BusinessException;
import br.com.agendaexpress.exceptions.DAOException;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private SeguidorDAO seguidorDAO;

	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Autowired
	private PessoaJuridicaDAO pessoaJuridicaDAO;
	
	@Autowired
	private PessoaFisicaDAO pessoaFisicaDAO;

	private MapperFacade mapper = new DefaultMapperFactory.Builder()
			.mapNulls(false).build().getMapperFacade();

	public UsuarioService() {
	} 

	public void addUsuario(UsuarioBean usuarioBean) throws DAOException,
			BusinessException {
		UsuarioEntity usuarioEntity = mapper.map(usuarioBean,
				UsuarioEntity.class);
		System.out.println();
		PessoaEntity pessoaSalva = pessoaDAO.save(usuarioEntity.getPessoa());
		
		if(usuarioBean.getPessoa() != null && usuarioBean.getPessoa().getPessoaFisica() != null){
			PessoaFisicaEntity pessoaFisicaEntity = mapper.map(usuarioBean.getPessoa().getPessoaFisica(),
					PessoaFisicaEntity.class);
			pessoaFisicaEntity.setIdPessoa(pessoaSalva.getIdPessoa());
			pessoaFisicaDAO.save(pessoaFisicaEntity);
		}
		
		if(usuarioBean.getPessoa() != null && usuarioBean.getPessoa().getPessoaJuridica() != null){
			PessoaJuridicaEntity pessoaJuridicaEntity = mapper.map(usuarioBean.getPessoa().getPessoaJuridica(),
					PessoaJuridicaEntity.class);
			pessoaJuridicaEntity.setIdPessoa(pessoaSalva.getIdPessoa());
			pessoaJuridicaDAO.save(pessoaJuridicaEntity);
		}	
		usuarioEntity.setPessoa(pessoaSalva);
		usuarioEntity.setAtivo(AtivoInativoEnum.ATIVO.getValue());
		usuarioDAO.save(usuarioEntity);
		System.out.println();
	}

	public void delUsuario(Integer id) throws DAOException {
		UsuarioEntity usuarioEntity = usuarioDAO.findById(id);
		usuarioEntity.setAtivo(AtivoInativoEnum.INATIVO.getValue());
		usuarioDAO.save(usuarioEntity);
	}

	public void updateUsuario(UsuarioBean usuarioBean) throws DAOException {
		UsuarioEntity usuarioEntity = usuarioDAO.findById(usuarioBean
				.getIdUsuario());
		if (usuarioEntity != null) {
			mapper.map(usuarioBean, usuarioEntity);
			usuarioDAO.update(usuarioEntity);
		}
	}

	public List<UsuarioBean> findUsuarioByFilter(UsuarioBean usuarioBean)
			throws DAOException {
		if (usuarioBean.getIdUsuario() != null) {
			UsuarioEntity usuarioEntity = usuarioDAO.findById(usuarioBean
					.getIdUsuario());

			UsuarioBean bean = mapper.map(usuarioEntity, UsuarioBean.class);
			if (bean != null) {
				List<UsuarioBean> list = new ArrayList<UsuarioBean>();
				list.add(bean);
				return list;
			}
			return null;
		} else {
			UsuarioEntity usuarioEntity = mapper.map(usuarioBean,
					UsuarioEntity.class);
			List<UsuarioEntity> listUsuarios = usuarioDAO
					.findUsuario(usuarioEntity);
			if (listUsuarios == null) {
				return null;
			}
			return mapper.mapAsList(listUsuarios, UsuarioBean.class);
		}
	}

	public void seguir(Integer idUsuarioSeguidor, Integer idUsuario)
			throws DAOException, BusinessException {
		if (idUsuarioSeguidor == null) {
			throw new BusinessException("idUsuarioSeguidor null");
		}
		if (idUsuario == null) {
			throw new BusinessException("idUsuario null");
		}
		if (idUsuario == idUsuarioSeguidor) {
			throw new BusinessException(
					"idUsuarioSeguidor deve ser diferente do idUsuario");
		}

		UsuarioEntity usuario = usuarioDAO.findById(idUsuario);
		if (usuario == null) {
			throw new BusinessException("idUsuario não existe");
		}

		UsuarioEntity usuarioSeguidor = usuarioDAO.findById(idUsuarioSeguidor);
		if (usuarioSeguidor == null) {
			throw new BusinessException("idUsuarioSeguidor não existe");
		}

		SeguidorEntity exists = seguidorDAO.findById(new SeguidorEntityPK(
				usuario.getPessoa().getIdPessoa(), usuarioSeguidor.getPessoa()
						.getIdPessoa()));
		if (exists != null) {
			throw new BusinessException("Usuário já está sendo seguindo.");
		}
		SeguidorEntity seguidor = new SeguidorEntity();
		seguidor.setId(new SeguidorEntityPK(usuario.getPessoa().getIdPessoa(),
				usuarioSeguidor.getPessoa().getIdPessoa()));
		seguidorDAO.save(seguidor);
	}

}
