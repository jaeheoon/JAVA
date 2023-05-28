package ezen.oop;
/**
 * 와일드카드 접근제한자 설명 
 * @author 홍재헌
 * 230518 수업
 */
public class Applicant<T> {
	private T kind;
	
	public Applicant() {}
	
	public Applicant(T kind) {
		this.kind = kind;
	}

	public T getKind() {
		return kind;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "Applicant [kind=" + kind + "]";
	}
	
}
