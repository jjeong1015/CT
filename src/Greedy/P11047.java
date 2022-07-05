package Greedy;
// 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성
// 1번째 줄에 N,K 2번째 줄부터 N개의 줄에 동전의 가격 A[]가 오름차순으로 주어짐
// 1번째 줄에 K원을 만드는 데 필요한 동전 개수의 최소값 출력
import java.util.Scanner;
public class P11047 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 동전 종류 -> 1<=N<=10 (while로 받으면 될 듯)
		int K = scanner.nextInt(); // 동전 합 -> 1<=K<=100,000,000
		int A[] = new int[N]; // 동전 종류만큼 자리 확보 -> 1<=A[]<=1,000,000
		int count = 0; // 들어간 동전 개수 카운트
		
		for (int i=0; i<N; i++) {
			A[i] = scanner.nextInt(); // 동전 가격(종류) 입력 -> 오름차순으로 받기
		}
		
		for (int i=0; i<A.length-1; i++) { // 동전 가격 받은 거 내림차순 정렬 -> 큰 거부터 금액 비교하려고 함 -> 동전 개수를 최소로 하기 위해서
			for (int j=i+1; j<A.length; j++) {
				if (A[i]<A[j]) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
			//System.out.print(A[i]);
			//System.out.println(" ");
		}
		
		// 동전 종류로 안되면 어떻게 해야 하는지도 만들어야 할 듯
		for (int i=0; i<A.length; i++) { // 금액 비교하기
			if (A[i] <= K) { // 해당 금액이 동전 합보다 같거나 작은 경우
				
				count++; // 10원짜리 2개 들어가도 카운트는 1번만 되게 할 것
			}
			else
				return;
		}
	}
}
