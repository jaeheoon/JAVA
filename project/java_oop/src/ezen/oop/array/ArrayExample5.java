package ezen.oop.array;

/*
 * 동적 다차원 배열
 */

public class ArrayExample5 {
	
	public static void main(String[] args) {
		int[][] scores;
		scores = new int[3][];
		scores[0] = new int[10];	//첫번째 배열에 있는 함수는 10개
		scores[1] = new int[9];		//두번째 배열에 있는 함수는 9개
		scores[2] = new int[15];	//세번째 배열에 있는 함수는 15개
		
		scores[0][0] = 100;
		//--------
		scores[2][14] = 85;
		
//		int[][] scores = {{100, 50, 10}, {55}, {44, 70}};
		for (int i = 0; i < scores.length; i++) {
			for (int j = 0; j < scores[i].length; j++) {
				System.out.print(scores[i][j]+", ");
			}
			System.out.println();
		}
	}

}
