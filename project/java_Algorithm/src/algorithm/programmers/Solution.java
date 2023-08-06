package algorithm.programmers;

import java.util.Arrays;

public class Solution {
	public static int[] solution(int[] arr, int divisor) {
        int count = 0;
        int number = 0;
        for (int i : arr) {
			if (i % divisor == 0 ) {
				count++;
			} 
		}
        
        if(count == 0){
            int[] answer = {-1};
            return answer;
        }
        
        int[] answer = new int[count];
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] % divisor == 0 ) {
        		answer[number] = arr[i];
        		number++;
			}
		}
        Arrays.sort(answer);
        return answer;
    }

	public static void main(String[] args) {
		int[] array = {5, 9, 7, 10};
//		long a = solution(121);
//		boolean a = solution("Pyy");
		int[] a = solution(array, 5);
		for (int i : a) {
			System.out.println(i);
		}
//		String[] array = {"jane", "kim"};
// 		String a = solution(array);
//		System.out.println(a);
	}
}
