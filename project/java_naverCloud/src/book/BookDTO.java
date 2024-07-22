package book;

import java.io.Serializable;

/**
 * 24.07.22(월) 파일 입출력 사용하여 도서 관리 프로그램 구현
 * @author 홍재헌
 * 도서 DTO
 */
public class BookDTO implements Comparable<BookDTO>, Serializable{
	private int code, price, qty, total;
	private String title, author;
	
	public BookDTO() { }

	public BookDTO(int code, int price, int qty, String title, String author) {
		this.code = code;
		this.price = price;
		this.qty = qty;
		this.title = title;
		this.author = author;
	}
	
	public void calc() {
		this.total = price * qty;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getTotal() {
		return total;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "코드 : " + code + " / 제목 : " + title + " / 저자 : " + author + " / 단가 : " + price + " / 개수 : " + qty + " / 합계 : " + total;
	}

	@Override
	public int compareTo(BookDTO o) {
		return this.title.compareTo(o.title);
	}
	
}
