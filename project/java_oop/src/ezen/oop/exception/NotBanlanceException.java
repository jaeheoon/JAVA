package ezen.oop.exception;

/**
 * 사용자 정의 예외 클래스
 * @author 홍재헌
 *
 */
public class NotBanlanceException extends Exception {
//	String message;
	private int errorCode;
	
	public NotBanlanceException() {}
	
	public NotBanlanceException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	@Override
	public String toString() {
		return getMessage()+" [에러코드 : "+errorCode+"]";
	}
}






