package Search;
// 블루레이의 크기 중 최솟값을 구하는 프로그램 작성
// 1번째 줄에 레슨의 수 N, M이 있고 2번째 줄에 레슨의 길이가 레슨 순서대로 분 단위인 자연수로 주어진다. 레슨의 길이는 10,000분을 넘지 않는다.
// 1번째 줄에 블루레이 크기 중 최솟값을 출력한다.
import java.util.Scanner;

public class P2343 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 레슨 개수
		int M = scanner.nextInt(); // 블루레이 개수
		int A[] = new int[N]; // 정렬 배열 선언
		int start = 0;
		int end = 0;
		for (int i=0; i<N; i++) {
			A[i] = scanner.nextInt();
			if (start < A[i]) start = A[i]; // 시작 인덱스 저장(배열 중 최댓값)
			end = end + A[i]; // 종료 인덱스 저장(배열 총합)
		}
		while (start <= end) {
			int middle = (start+end)/2; // 중간 인덱스
			int sum = 0; // 레슨 합
			int count = 0; // 현재 사용한 블루레이 개수
			for (int i=0; i<N; i++) { // 중간 인덱스 값으로 모든 레슨을 저장할 수 있는지 확인
				if (sum + A[i] > middle) { // 레슨 합 + 레슨 시간 > 중간 인덱스
					count++; // count값 올리기
					sum = 0; // 0으로 리셋 -> 블루레이에 저장할 수 없어 새 블루레이로 교체한다는 뜻
				}
				sum = sum + A[i]; // sum에 현재 레슨 시간값 더하기
			}
			if (sum != 0) // 0이 아닐 경우 마지막 블루레이 필요
				count++; // count값 올리기
			if (count > M) // 중간 인덱스값으로 모든 레슨 저장 불가능
				start = middle + 1; // 시작 인덱스 = 중간 인덱스 + 1;
			else // 모든 레슨 저장 가능
				end = middle - 1; // 시작 인덱스 = 중간 인덱스 - 1;
			System.out.println(count);
		}
		System.out.println(start); // 시작 인덱스 출력
	}

}
