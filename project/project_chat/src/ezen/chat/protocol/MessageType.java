package ezen.chat.protocol;
/**
 * 메세지 종류를 판별하기 위해 이넘 클래스 생성
 * 화면에 종류를 판별할 필요가 없기 때문에 나열만 하면 됨
 * @author 홍재헌
 * 230531 수업
 */
public enum MessageType {
	CONNECT, DIS_CONNECT, CHAT_MESSAGE, USER_LIST, DM_MESSAGE, DELTE_LIST
}
