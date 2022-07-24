package Greedy;
// 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성
// 1번째 줄에 N,K 2번째 줄부터 N개의 줄에 동전의 가격 A[]가 오름차순으로 주어짐
// 1번째 줄에 K원을 만드는 데 필요한 동전 개수의 최소값 출력
import java.util.Scanner; // Scanner 클래스 호출 -> stdio.h(입, 출력)랑 비슷함

public class P11047 {
	public static void main(String[] args) {
		int N;
		int K;
		Scanner scanner = new Scanner(System.in); // 입력 받기 -> 이걸 쓰기 위해 Scanner 클래스 호출 (클래스 이름 객체 이름 = new 클래스 이름();)
		
		do {
			N = scanner.nextInt(); // 동전 종류 -> 1<=N<=10, scanner가 객체 이름 -> 위에 scanner 대신 a를 넣으면 여기 scanner에도 대신 a를 넣으면 됨
		} while (N<1 || N>10);
		
		do {
			K = scanner.nextInt(); // 목표 금액 -> 1<=K<=100,000,000, int형 입력 및 리턴
		} while (K<1 || K>100000000);
		
		int A[] = new int[N]; // 동전 종류만큼 자리 확보 -> 1<=A[]<=1,000,000 -> 배열 최댓값 지정하기, 배열 선인 및 초기화
		
		for (int i=0; i<N; i++) { // 배열에 값 집어넣기
			A[i] = scanner.nextInt(); // 동전 가격(종류) 입력 -> 오름차순으로 받기 -> 오름차순으로 받지 않았으면 다시 입력하기 -> 전에 입력한 값이 현재 입력한 값보다 크면 다시 받기
			//while (A[i]<A[i+1]) { // A[i+1]이 A[i]보다 클 때까지 다시 입력 -> 이전에 받은 거 지우기
				//A[i] = 0; // 이전에 받은 A[i] 0으로 초기화해서 다시 받기
				//System.out.println("다시 입력하세요");
				//A[i] = scanner.nextInt();
			//}
		}
		
		int count = 0; // 들어간 동전 개수 카운트
		for (int i=N-1; i>=0; i--) { // 금액이 큰 동전부터 선택해야 개수를 최소로 구성 가능
			if (A[i] <= K) { // 현재 K(목표 금액)보다 동전 금액이 같거나 작을 경우
				count += (K / A[i]); // 동전 개수 += 목표 금액 / 현재 동전 금액 -> 한 동전에 몇 개까지 넣을 수 있는지
				K = K % A[i]; // 목표 금액 = 목표 금액 % 현재 동전 금액 -> 넣고 남은 금액으로 다시 하기
			}
		}
		System.out.println(count);
		/*
		for (int i=0; i<N; i++) {
			A[i] = scanner.nextInt(); // 동전 가격(종류) 입력 -> 오름차순으로 받기 -> 오름차순으로 받지 않았으면 다시 입력하기 -> 전에 입력한 값이 현재 입력한 값보다 크면 다시 받기
			while (A[i]<A[i+1]) { // A[i+1]이 A[i]보다 클 때까지 다시 입력
				System.out.println("다시 입력하세요");
				A[i] = scanner.nextInt();
			}
		}
		
		for (int i=0; i<A.length-1; i++) { // 동전 가격 받은 거 내림차순 정렬 -> 큰 거부터 금액 비교하려고 함 -> 동전 개수를 최소로 하기 위해서
			for (int j=i+1; j<A.length; j++) {
				if (A[i]<A[j]) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
			System.out.print(A[i]);
			System.out.println(" ");
		}
		
		// 동전 종류로 안되면 어떻게 해야 하는지도 만들어야 할 듯
		for (int i=0; i<A.length; i++) { // 금액 비교하기
			if (A[i] <= K) { // 해당 금액이 동전 합보다 같거나 작은 경우
				
				count++; // 10원짜리 2개 들어가도 카운트는 1번만 되게 할 것
			}
			else
				return;
		}
		*/
	}
}
