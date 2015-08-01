package br.com.agendaexpress.exceptions;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 2642250329603194928L;

	public BusinessException(String msg) {
		super(msg);
	}
}
