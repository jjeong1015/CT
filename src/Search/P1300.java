package Search;
// N x M 인 배열 A에 들어 있는 수는 A[i][j]=ixj고 1차원 배열 B에 넣으면 B의 크기는 N X M이 된다. B를 오름차순 정렬했을 때 B[k]를 구하라.
// 1번째 줄에 배열의 크기 N, 2번째 줄에 k가 주어진다.
// B[k] 출력
import java.util.Scanner;

public class P1300 {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 배열 크기
		int K = scanner.nextInt(); // 구하고자 하는 index
		long start = 1, end = K;
		long answer = 0;
		
		while (start <= end) { 
			long middle = (start+end)/2;
			long cnt = 0; // 중앙값보다 작은 수 몇 개인지 계산
			for (int i=1; i<=N; i++) {
				cnt += Math.min(middle/i, N); // cnt에 중앙 인덱스를 i로 나눈 값과 N중 작은 값을 더함 -> 작은 수 카운트
			}
			if (cnt < K) { // 현재 중앙값보다 작은 수의 개수가 K보다 작음
				start = middle + 1;
			}
			else { // 현재 중앙값보다 작은 수의 개수가 K보다 크거나 같음
				answer = middle; // 현재 단계의 중앙값을 정답 변수에 저장
				end = middle - 1; // 정답 변수에 중앙값 저장
			}
		}
		System.out.println(answer);
	}
}
