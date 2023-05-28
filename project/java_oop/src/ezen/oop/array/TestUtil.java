package ezen.oop.array;
/**
 * 실행 클래스
 * @author 홍재헌
 * 230521 테스트
 */
import java.util.Arrays;

public class TestUtil {
	Test[] studentScore = {
			new Test("홍길동", 60, 75),
			new Test("강호동", 70, 80),
			new Test("유재석", 80, 55),
			new Test("박명수", 90, 100)
		};
		
	public void getScore(){
		Arrays.sort(studentScore);
		for (int i = 0; i < studentScore.length; i++) {
			int rank = 1;
			for (int j = 0; j < studentScore.length; j++) {
				if (studentScore[i].getTotalScore()<studentScore[j].getTotalScore()) {
					rank++;
				}
			studentScore[i].setRank(rank);
			}
			System.out.println(studentScore[i]);
		}
	}
}
	

