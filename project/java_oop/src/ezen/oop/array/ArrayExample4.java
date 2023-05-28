package ezen.oop.array;

/*
 * 배열 복사하기
 */

public class ArrayExample4 {
	
	
	public static void main(String[] args) {
		int[] array = {5, 1, 3, 7, 4, 2, 6, 9, 8};
		//---------코드 진행중에 배열이 추가가 되는 상황이면 배열을 복사하여 사용해야함, 추가로 사이즈 증가가 안됨
		
		/*
		int[] array2 = new int[array.length+1];
		for (int i = 0; i < array.length; i++) {
			array2[i] = array[i];
		}
		for (int j = 0; j < array2.length; j++) {
			System.out.println(array2[j]);
		}
		*/
//		메소드 호출을 이용한 배열 복사
		int[] copyArray = ArrayUtil.arrayCopy(array, 3);
		for (int i = 0; i < copyArray.length; i++) {
			System.out.println(copyArray[i]);
			
		}
		
//		배열 정렬 로직을 작성하시오. 
		
		/*	--내가 한거
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if(array[i] > array[j]) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		*/
//		강사님이 하신거
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array.length-1; j++) {
//					if(array[j] > array[j+1]) {
//						int tmp = array[j];
//						array[j] = array[j+1];
//						array[j+1] = tmp;
//					}
//				}
//			}
		
		ArrayUtil.sort(array, ArrayUtil.ASC);
		ArrayUtil.sort(array, ArrayUtil.DESC);
		
//		배열 정렬하여 출력하기 (1 - 9까지 차례대로 출력)
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
			
		}
		
	}

}
