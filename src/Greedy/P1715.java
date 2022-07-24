package Greedy;
import java.util.Arrays;
import java.util.PriorityQueue;
// N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램 작성(고르는 순서에 따라 비교 횟수가 달라짐) 
// 1번째 줄에 N이 주어진다. 그 다음 N개의 줄에 숫자 카드 묶음의 각각의 크기가 주어진다. 숫자 카드 묶음의 크기는 1,000보다 작거나 같은 양의 정수다.
// 1번째 줄에 최소 비교 횟수 출력
import java.util.Scanner;

public class P1715 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		PriorityQueue<Integer>pq = new PriorityQueue(); // Integer 타입으로 우선순위 큐 선언 -> (기본)낮은 숫자 순으로 우선순위 결정
		for (int i=0; i<N; i++) {
			int data = scanner.nextInt();
			pq.add(data); // 우선순위 큐에 데이터 저장(추가)
		}
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while (pq.size() != 1) { // 우선순의 큐 크기가 1이 될 때까지
			data1 = pq.remove(); // 2개 카드 묶음을 큐에서 뽑음 (remove 연산->삭제)
			data2 = pq.remove();
			sum += data1 + data2; // 2개 카드 묶음을 합치는 데 필요한 비교 횟수를 결괏값에 더함
			pq.add(data1 + data2); // 2개 카드 묶음의 합을 우선순위 큐에 다시 넣음 (add 연산->추가)
		}
		System.out.println(sum); // 누적된 동전 수 출력하기
		/*
		int size[] = new int[N]; 
		for (int i=0; i<N; i++) {
			size[i] = scanner.nextInt();
		}
		
		for (int i=0; i<size.length-1; i++) { // 왜 범위를 벗어나는 예외 발생 ?
			for (int j=i+1; j<size.length; j++) {
				if (size[i]<size[j]) { // 오름차순 정렬해서 작은 수부터 먼저 더해지도록 하기
					int temp = size[i];
					size[i] = size[j];
					size[j] = temp;
				}
			}
			System.out.print(size[i]);
		}
		*/
	}
}
