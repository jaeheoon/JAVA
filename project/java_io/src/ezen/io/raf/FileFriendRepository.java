package ezen.io.raf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * 친구정보 파일 저장 및 관리 구현체
 * RandomAccessFile 활용
 * 
 * @author 김기정
 * 230530 수업
 */
public class FileFriendRepository implements FriendRepository {

	/** 파일 저장 경로 */
	private static final String FILE_PATH = "friends.dbf";

	/** 레코드(친구)수 저장을 위한 파일 컬럼 사이즈 고정 */
	private static final int RECORD_COUNT_LENGTH = 4;

	/** 레코드(친구 이름,나이,몸무게,전화번호) 저장을 위한 컬럼별 사이즈 고정 -> 이것을 고정형 사이즈라고 한다 */
	private static final int NAME_LENGTH = 10; // 이름(10바이트) - 5글자 자리수 확보
	private static final int AGE_LENGTH = 4; // 나이(4바이트) - int형이기 때문에 4바이트 고정 확보
	private static final int WEIGHT_LENGTH = 8; // 몸무게(8바이트) - 더블형이기 때문에 8바이트 고정 확보
	private static final int TELEPHONE_LENGTH = 40; // 전화번호(40바이트)
//	String은 고정 자리를 확보해야한다 글자의 크기가 어디까지인지 모르기 때문이다
	/** 친구정보 저장을 위한 레코드 사이즈 : 62바이트 */
	public static final int RECORD_LENGTH = NAME_LENGTH + AGE_LENGTH + WEIGHT_LENGTH + TELEPHONE_LENGTH;

	private RandomAccessFile file;

	/** 저장된 친구(레코드)수 */
	private int recordCount = 0;

	public FileFriendRepository() throws IOException {
		// 읽고 쓰기 가능한 RandomAccessFile 객체 생성
		file = new RandomAccessFile(FILE_PATH, "rw");
		
		// 저장된 파일이 있는 경우..
		if (file.length() != 0) {
			recordCount = file.readInt();
		}
	}
	
//	친구 목록 수 반환
	@Override
	public int getRecordCount() {
		return recordCount;
	}
	
	
	@Override
	public void save(Friend friend) throws IOException {
		// 파일의 마지막 위치로 파일 포인터 이동.
		file.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);		//(RECORD_COUNT_LENGTH : 친구의 목록 수) + ((recordCount * RECORD_LENGTH) : 친구 목록의 정보들)

		// 새로운 레코드(친구) 추가
		// 10 + 4 + 8 + 40 >>이름, 나이, 몸무게, 전화번호
		String name = friend.getName();
		int age = friend.getAge();
		double weight = friend.getWeight();
		String telephone = friend.getTelephone();
		
		int charCount = name.length();
		// 10바이트(5글자)로 이름 저장
		for (int i = 0; i < (NAME_LENGTH / 2); i++) {						//(TELEPHONE_LENGTH / 2) : 길이/2 하는 이유는 문자열 하나에 2바이트씩 쓰기 때문에 10바이트 = 5글자라는 뜻
			// EX) "김기정 "
			file.writeChar((i < charCount ? name.charAt(i) : ' '));			//김기정만 쓰면 6바이트밖에 안되니 남는 공간에 ' '라는 빈 문자를 추가해서 채워준다
		}

		// 나이(4바이트)
		file.writeInt(age);
		// 몸무게(8바이트)
		file.writeDouble(weight);

		// 40바이트(20글자)로 전화번호 저장
		charCount = telephone.length();
		for (int i = 0; i < (TELEPHONE_LENGTH / 2); i++) {
			// EX) "010-9179-8707 "
			file.writeChar((i < charCount ? telephone.charAt(i) : ' '));
		}

		// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
		// 등록된 레코드(친구) 수 1 증가
		file.seek(0);
		file.writeInt(++recordCount);
	}

	@Override
	public List<Friend> findAll() throws IOException {
		List<Friend> list = new ArrayList<Friend>();
		for (int i = 0; i < recordCount; i++) {
			Friend friend = read(i);
			list.add(friend);
		}
		return list;
	}

	/** 특정 위치의 레코드 정보를 Friend로 반환 - 헬퍼메소드*/
	private Friend read(int index) throws IOException {
		Friend friend = null;
		String name = "";
		int age = 0;
		double weight = 0.0;
		String telephone = "";
		
		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		for (int i = 0; i < (NAME_LENGTH / 2); i++) {
			name += file.readChar();  // "김기정  "
		}
		name = name.trim(); // "김기정"	- trim을 안하면 김,기,정,' ',' ' 이런식으로 나오기 때문에 제거해줘야한다
		age = file.readInt();
		weight = file.readDouble();
		for (int i = 0; i < (TELEPHONE_LENGTH / 2); i++) {
			telephone += file.readChar();
		}
		telephone = telephone.trim(); // 전화번호도 마찬가지로 뒤에 2바이트가 빈 공간이기때문에 trim 추가해준다

		friend = new Friend(name, age, weight, telephone);
		return friend;
	}

	@Override
	public void close() {
		try {
			if (file != null) file.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
