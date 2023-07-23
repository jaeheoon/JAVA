package ezen.shoppingmall.domain.article.dto;

public class Memo {
	
	private int id;
	private String content;
	private String writeDate;
	private String memberId;
	private String memberName;
	
	public Memo() {}

	public Memo(int id, String content, String writeDate, String memberId, String memberName) {
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.memberId = memberId;
		this.memberName = memberName;
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
	
	

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "Memo [id=" + id + ", content=" + content + ", writeDate=" + writeDate + ", memberId=" + memberId
				+ ", memberName=" + memberName + "]";
	}
}
