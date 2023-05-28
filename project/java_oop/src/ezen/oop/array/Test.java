package ezen.oop.array;
/**
 * 자료형 클래스
 * @author 홍재헌
 * 230521 테스트
 */
public class Test implements Comparable<Test>{
		private String name;
		private int korScore;
		private int engScore;
		private int rank = 1;
		
		public Test() {}
		
		public Test(String name, int korScore, int engScore) {
			this.name = name;
			this.korScore = korScore;
			this.engScore = engScore;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getKorScore() {
			return korScore;
		}
		public void setKorScore(int korScore) {
			this.korScore = korScore;
		}
		public int getEngScore() {
			return engScore;
		}
		public void setEngScore(int engScore) {
			this.engScore = engScore;
		}
		public int getTotalScore() {
			return korScore + engScore;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}

		@Override
		public String toString() {
			return name + "의 총 점수는: " + (korScore + engScore) + "점, 등수는: " + rank + "등";
		}
		
		@Override
		public int compareTo(Test o) {
			return this.getName().compareTo(o.getName());
		}
		
	}

