package Search;
// 숫자 N이 주어졌을 때 N의 자리 숫자 중 왼쪽부터 어떻게 끊어도 소수인 수를 찾아보자
// 1번째 줄에 N(1<=N<=8)이 주어진다.
// N의 자리 숫자 중 어떻게 끊어도 소수인 수를 오름차순 정렬해 1줄에 1개씩 출력한다.
import java.util.Scanner;

public class P2023 {
	
	static int N;

	public static void main(String[] args) {
		/*
		long count;
		long num[] = new long[99999999];
		long prime;
		Scanner scanner = new Scanner(System.in);
		System.out.print("N의 자리 숫자를 입력하세요 : ");
		int n = scanner.nextInt();
	
		if (n==1) {
			for (int i=1; i<10; i++) {
				prime = 1;
				prime += 1;
				num[i] = 1;
				num[i] += 1;
				if ((prime == 2)||(prime == 3)||(prime == 5)||(prime == 7)) {
					// 숫자 1부터 9까지 다 나오게 한 다음 이 조건문에 속하는 건 출력하기
					System.out.println(prime); // 출력하면 왜 2가 8개 나오지?
				}
			}
		}
		
		if (n==2) {
			// 숫자 10부터 99 (짝수 && 소수끼리의 곱 && 제곱 있는 수) 제외하고 출력
			for (int i=10; i<100; i++) {
				prime = 10;
				prime += 1;
				num[i] = 10;
				num[i] += 1;
			}
		}
		
		if (n==3) {
			// 숫자 100부터 999 (짝수 && 소수끼리의 곱 && 제곱 있는 수) 제외하고 출력
			for (int i=100; i<1000; i++) {
				prime = 100;
				prime += 1;
				num[i] = 100;
				num[i] += 1;
			}
		}
		
		if (n==4) {
			// 숫자 1000부터 9999 (짝수 && 소수끼리의 곱 && 제곱 있는 수) 제외하고 출력
			for (int i=1000; i<10000; i++) {
				prime = 1000;
				prime += 1;
				num[i] = 1000;
				num[i] += 1;
			}
		}
		
		if (n==5) {
			// 숫자 10000부터 99999 (짝수 && 소수끼리의 곱 && 제곱 있는 수) 제외하고 출력
			for (int i=10000; i<100000; i++) {
				prime = 10000;
				prime += 1;
				num[i] = 10000;
				num[i] += 1;
			}
		}
		
		if (n==6) {
			// 숫자 100000부터 999999 (짝수 && 소수끼리의 곱 && 제곱 있는 수) 제외하고 출력
			for (int i=100000; i<1000000; i++) {
				prime = 100000;
				prime += 1;
				num[i] = 100000;
				num[i] += 1;
			}
		}
		
		if (n==7) {
			// 숫자 1000000부터 9999999 (짝수 && 소수끼리의 곱 && 제곱 있는 수) 제외하고 출력
			for (int i=1000000; i<10000000; i++) {
				prime = 1000000;
				prime += 1;
				num[i] = 1000000;
				num[i] += 1;
			}
		}
		
		if (n==8) {
			// 숫자 10000000부터 99999999 (짝수 && 소수끼리의 곱 && 제곱 있는 수) 제외하고 출력
			for (int i=10000000; i<100000000; i++) {
				prime = 10000000;
				prime += 1;
				num[i] = 10000000;
				num[i] += 1;
			}
		}
		
		// 오름차순 정렬
		for(int i=0; i<num.length-1;i++) {
			for(int j=i+1; j<num.length;j++) {
				if(num[i]>num[j]) {
					long tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
				}
			}
			//System.out.println(num[i]);
		}
		*/
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		DFS(2,1); // DFS 실행하기 2, 3, 5, 7로 탐색 시작
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	static void DFS(int number, int jarisu) {
		if (jarisu == N) { // 자릿수 = N -> 뭔 소리야 ㅅㅂ
			if (isPrime(number)) { // 소수 출력
				System.out.println(number); 
			}
			return; // 탐색 종료
		}
		for (int i=1; i<10; i++) { // 1~9 반복
			if (i%2 == 0) {
				continue;
			}
			if (isPrime(number*10 + i)) { // 끝자리 수가 홀수이면서 소수인 경우
				DFS(number*10+i, jarisu+1); // 재귀함수로 자릿수 늘림 -> DFS 실행 : 자릿수 + 1, 수 * 10 + 끝자리 수
			}
		}
	}
	static boolean isPrime(int num) {
		for (int i=2; i<=num/2; i++) // 소수 구하기 함수
			if (num % i == 0)
				return false; // 소수 아님
		return true;
	}
}
