package ezen.oop.exception;
/**
 * 사용자 정의 예외 클래스
 * @author 홍재헌
 *
 */
public class NotBalanceException extends Exception {
//	String message;
	private int errorCode;
	
	public NotBalanceException() {}
	public NotBalanceException(String message, int errCode) {
		super(message);
		this.errorCode = errCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	@Override
	public String toString() {
		return getMessage() + " [에러코드 : " + errorCode + "]";
	}
	
	


}
