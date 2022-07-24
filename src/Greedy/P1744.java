package Greedy;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
// 주어진 수열의 각 수를 적절히 묶어 그 합을 최대로 만드는 프로그램을 작성하시오.
// 1번째 줄에 수열의 크기 N이 주어진다. 2번째 줄부터 N개의 줄에 수열의 각 수가 주어진다.
// 합이 최대가 나오게 수를 묶었을 대 그 합을 출력한다. 정답은 항상 231보다 작다.
import java.util.Scanner;

public class P1744 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); // 양수 우선순위 큐 -> 높은 숫자 순으로 우선순위 결정
		PriorityQueue<Integer> minusPq = new PriorityQueue<>(); // 음수 우선순위 큐
		int one = 0; // 1의 개수 카운트
		int zero = 0; // 0의 개수 카운트
		for (int i=0; i<N; i++) { // 데이터를 4개의 그룹에 분리 저장하기
			int data = scanner.nextInt();
			if (data > 1) {
				plusPq.add(data);
			}
			else if (data == 1) {
				one++;
			}
			else if (data == 0) {
				zero++;
			}
			else {
				minusPq.add(data);
			}
		}
		int sum = 0;
		while (plusPq.size() > 1) { // 양수 우선순위 큐 크기가 2보다 작을 때까지
			int first = plusPq.remove(); // 수 2개를 큐에서 뽑음
			int second = plusPq.remove(); 
			sum = sum + first * second; // 2개의 수를 곱한 값을 결괏값에 더함
		}
		if (!plusPq.isEmpty()) {
			sum = sum + plusPq.remove(); // 양수 우선순위 큐에 데이터가 남아 있으면 이 데이터를 결괏값에 더함
		}
		while (minusPq.size() > 1) { // 음수 우선순위 큐 크기가 2보다 작을 때까지
			int first = minusPq.remove(); // 수 2개를 큐에서 뽑음
			int second = minusPq.remove();
			sum = sum + first * second; // 2개의 수를 곱한 값을 결괏값에 더함
		}
		if (!minusPq.isEmpty()) { // 음수 우선순위 큐에 데이터가 남아 있고, 데이터 0이 1개도 없으면 이 데이터를 결괏값에 더함
			if (zero == 0) {
				sum = sum + minusPq.remove();
			}
		}
		sum = sum + one; // 숫자 1의 개수를 결괏값에 더함
		System.out.println(sum);
		
		/*
		int num[] = new int[N];
		for (int i=0; i<N; i++) {
			num[i] = scanner.nextInt();
		}
		Arrays.sort(num); // 오름차순 정렬
		for (int i:num) {
			System.out.print(i + " ");
		}
		// 음수는 -1을 곱해서 모두 절댓갑으로 양수를 만들고 절댓값이 큰 거대로 또 정렬
		// 큰 수부터 내려가 원래값이 음수 음수일 경우 그냥 곱하기
		
		
		for (int i=0; i<num.length-1; i++) { // index 9 out of bounds of length 9 라는 오류 발생
			for (int j=i+1; j<num.length; j++) {
				if (num[i]>num[j]) { // 오름차순 정렬해서 작은 수부터 먼저 더해지도록 하기
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
			System.out.print(num[i]);
		}
		*/
	}
}
