package me.domain;

/**
 * @author wt
 *    @ 自定义异常类
 */
public class ErrorMess extends Exception {
	private String Message;  //异常信息

	public ErrorMess(String mess) {
		super();
		Message = mess;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String mess) {
		Message = mess;
	}

}
