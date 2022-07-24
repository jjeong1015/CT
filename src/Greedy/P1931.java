package Greedy;
import java.util.Arrays;
import java.util.Comparator;
// 각 회의마다 시작 시간과 끝나는 시간이 주어질 때 회의 시간이 겹치지 않으면서 가장 많이 진행하기 위한 횟수는 몇 번인지 구하기
// 1번째 줄에 회의의 수 N, 2번째 줄부터 N+1줄까지 각 회의의 시작 시간과 끝나는 시간이 공백을 사이에 두고 주어진다. 시작 시간과 끝나는 시간은 -1보다 작거나 같은 자연수 또는 0이다.
// 1번째 줄에 진행할 수 있는 회의의 최대 개수를 출력한다.
import java.util.Scanner;

public class P1931 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 회의 개수
		int A[][] = new int [N][2]; // 회의 정보 저장 -> 왜 2차원 배열?
		for (int i=0; i<N; i++) {
			A[i][0] = scanner.nextInt();
			A[i][1] = scanner.nextInt();
		}
		Arrays.sort(A, new Comparator<int[]>() { // 정렬
			@Override
			public int compare(int S[], int E[]) {
				if (S[1] == E[1]) { // 종료 시간이 같을 때
					return S[0] - E[0];
				}
				return S[1] - E[1];
			}
		});
		int count = 0;
		int end = -1;
		for (int i=0; i<N; i++) {
			if (A[i][0] >= end) { // 앞 회의의 종료 시간보다 시작 시간이 빠른 회의가 나온 경우(겹치지 않는 다음 회의가 나온 경우)
				end = A[i][1]; // 현재 회의의 종료 시간으로 종료 시간 업데이트하기
				count++; // 진행할 수 있는 회의 수 1 증가
			}
		}
		System.out.println(count); // 총 진행 가능 회의 수 출력하기
		/*
		int S[] = new int[N];
		int E[] = new int[N];
		int T[] = new int[N];
		
		for (int i=0; i<N; i++) {
			S[i] = scanner.nextInt();
			E[i] = scanner.nextInt();
			T[i] = E[i] - S[i];
		}
		
		for (int i=0; i<N-1; i++) {
			for (int j=i+1; j<N; j++) {
				if (T[i]>T[j]) {
					int temp = T[i];
					T[i] = T[j];
					T[j] = temp;
				}
			}
			System.out.print(T[i] + " "); // N-1 때문에 마지막이 짤림
		}
		*/
	}
}
