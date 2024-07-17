package sungJuk;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import collection.PersonDTO;

/**
 * 24.07.17(수) sort, interface 이용하여 성적 프로그램 구현
 * @author 홍재헌
 *
 */
public class SungJukDTO implements Comparable<SungJukDTO>{
	private int no, kor, eng, math, tot;
	private double avg;
	private String name;
	
	public void calc(int kor, int eng, int math) {
		this.tot = kor + eng + math;
		this.avg = tot / 3.0;
	}
	
	public SungJukDTO() { }
	
	public SungJukDTO(int no, String name, int kor, int eng, int math) {
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		NumberFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(2);
		return no + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t"
				+ nf.format(avg);
	}

	@Override
	public int compareTo(SungJukDTO sungJukDTO) {
		return this.name.compareTo(sungJukDTO.name);
	}
	
}
