package br.com.agendaexpress.exceptions;

public class DAOException extends Exception {

	private static final long serialVersionUID = -6341879383709010673L;

	public DAOException(Exception e){
		super(e);
	}
	
}
