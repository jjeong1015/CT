package DataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> myQueue = new LinkedList<>();
		int N = scanner.nextInt();
		for (int i=1; i<=N; i++) {
			myQueue.add(i); // 큐에 카드 저장하기
		}
		while (myQueue.size() > 1) { // 카드가 1장 남을 때까지
			myQueue.poll(); // 맨 위의 카드를 버림
			myQueue.add(myQueue.poll()); // 맨 위의 카드를 가장 아래의 카드 밑으로 이동 : poll() -> add()
		}
		System.out.println(myQueue.poll()); // poll -> queue에 첫번째 값을 반환하고 제거, 비어있다면 null
	}
	
}
