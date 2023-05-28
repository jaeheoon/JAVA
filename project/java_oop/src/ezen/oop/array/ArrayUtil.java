package ezen.oop.array;

/*
 * 배열 관련 공통 기능 정의
 */

public class ArrayUtil {
	/*
	 * 배열 복사 기능하는 메소드 생성
	 */
	public static int[] arrayCopy(int[] array, int increament) {
		int[] copyArray = new int[array.length+increament];
		for (int i = 0; i < array.length; i++) {
			copyArray[i] = array[i];
		}
		return copyArray;
	}
	
	/*
	 * 배열 정렬 기능(오름차순, 내림차순 모두 지원)
	 */
	
//	오름차순, 내림차순을 구분하기 위한 상수
	public static final int ASC = 0;	//오름 차순을 의미하는 ASC
	public static final int DESC = 1;	//내림 차순을 의미하는 ASC
	
//	이 함수는 위 함수와 다르게 리턴하는 것이 없고 원본 배열을 변경하는 것이기 때문에 반환타입이 없음
	public static void sort(int[] array, int sortBy) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-1; j++) {
				if(sortBy == ASC) {
					if(array[j] > array[j+1]) {
						int tmp = array[j];
						array[j] = array[j+1];
						array[j+1] = tmp;
							}
						}
				else if(array[j] < array[j+1]) {
						int tmp = array[j];
						array[j] = array[j+1];
						array[j+1] = tmp;
							}
						}
					}
				}
			}
