package array;

/**
 * 24.07.09(화) 선택정렬
 * @author 홍재헌
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {30, 36, 25, 45, 28};
		
		System.out.print("정렬 전 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		
//		Selection Sort
		int temp = 0;
		
//		오름차순
//		for (int i = 0; i < arr.length-1; i++) {
//			for (int j = i+1; j < arr.length; j++) {
//				if(arr[i] > arr[j]) {
//					temp = arr[i];
//					arr[i] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}
		
//		내림차순
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.print("정렬 후 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

}
