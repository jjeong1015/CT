package DataStructure;

import java.util.Scanner;

public class P10986 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		long S[] = new long[N]; // 합 배열
		long C[] = new long[M]; // 같은 나머지의 인덱스를 카운트파는 배열
		long answer = 0;
		S[0] = scanner.nextInt();
		for (int i=1; i<N; i++) { // 수열 합 배열 만들기
			S[i] = S[i-1] + scanner.nextInt();
		}
		for (int i=0; i<N; i++) { // 합 배열의 모든 값에 %(나머지) 연산 수행하기
			int remainder = (int) (S[i] % M); // 합 배열을 M으로 나눈 나머지 값
			if (remainder == 0) answer++; // 0 ~ i까지의 구간 합 자체가 0(이미 M으로 나누어떨어짐)일 때 정답에 더하기
			C[remainder]++; // 나머지가 같은 인덱스의 개수 카운팅하기
		}
		for (int i=0; i<M; i++) {
			if (C[i] > 1) { // C[i](i가 나머지인 인덱스 개수)에서 2가지를 뽑는 경우의 수 더하기
				answer = answer + (C[i] * (C[i] - 1) / 2);
			}
		}
		System.out.println(answer);
	}
}
