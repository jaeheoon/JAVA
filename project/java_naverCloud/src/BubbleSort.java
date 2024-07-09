package array;

/**
 * 24.07.09(화) 버블정렬
 * @author 홍재헌
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {30, 36, 25, 45, 28};
		
		System.out.print("정렬 전 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
		
//		Bubble Sort
		int temp = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + "  ");
			}
			System.out.println((i+1)+"번째 반복");
		}
		
		System.out.print("정렬 후 : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println();
	}

}
