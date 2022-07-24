package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P11286 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if (first_abs == second_abs)
				return o1 > o2 ? 1 : -1; // 절댓값이 같으면 음수 우선 정렬
			else
				return first_abs - second_abs; // 절댓값을 기준으로 정렬
					
		});
		for (int i=0; i<N; i++) {
			int request = Integer.parseInt(br.readLine());
			if (request == 0) { // 요청이 0일 경우 : 큐가 비어 있으면 0, 비어 있지 않으면 큐의 front값 출력(poll())
				if (MyQueue.isEmpty())
					System.out.println("0");
				else
					System.out.println(MyQueue.poll());
			}
			else { // 요청이 1일 경우 : 새로운 데이터를 우선순위 큐에 더하기(add())
				MyQueue.add(request);
			}
		}
	}
	
}
