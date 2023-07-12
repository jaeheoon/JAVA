package ezen.portfolio.article.dto;

public class Memo {
	
	private int id;
	private String content;
	private String writeDate;
	private String memberId;
	
	public Memo() {}

	public Memo(int id, String content, String writeDate, String memberId) {
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.memberId = memberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "Memo [id=" + id + ", content=" + content + ", writeDate=" + writeDate + ", memberId=" + memberId + "]";
	}
}
