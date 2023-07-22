package algorithm.baekjoon;

public class Main {
	public static int solution(int[] num_list) {
		int odd = 0;
		int even = 0;
		for (int i = 0; i < num_list.length; i++) {
			if (i % 2 == 1) {
				odd += num_list[i];
			} else {
				even += num_list[i];
			}
		}
		if (odd > even) {
			return odd;
		} else {
			return even;
		}
	}

	public static void main(String[] args) {
		int[] array = {4, 2, 6, 1, 7, 6};
		
		int a = solution(array);
		
		System.out.println(a);
	}
}
