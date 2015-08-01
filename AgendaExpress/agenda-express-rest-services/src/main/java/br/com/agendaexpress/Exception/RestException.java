package br.com.agendaexpress.Exception;

import java.io.Serializable;

public class RestException extends Exception implements Serializable {

	private static final long serialVersionUID = -3271224507317632528L;

	private Integer codigoErro;

	private String msg;

	public RestException(String msg) {
		this.msg = msg;
		
	}

	public RestException(Integer codigoErro, String message) {
		super(message);
		this.msg = message;
		this.setCodigoErro(codigoErro);
	}

	public RestException(Exception e) {
		super(e);
	}

	public RestException(Throwable cause) {
		super(cause);
	}

	public RestException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public Integer getCodigoErro() {
		return codigoErro;
	}

	public void setCodigoErro(Integer codigoErro) {
		this.codigoErro = codigoErro;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}