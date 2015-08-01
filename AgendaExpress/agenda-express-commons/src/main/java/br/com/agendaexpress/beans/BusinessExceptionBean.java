package br.com.agendaexpress.beans;

public class BusinessExceptionBean {

	private String msg;

	private String code;

	public BusinessExceptionBean(){
	}
	public BusinessExceptionBean(String msg){
		this.msg = msg;
	}
	public BusinessExceptionBean(String msg, String code){
		this.msg = msg;
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
