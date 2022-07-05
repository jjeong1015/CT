package Search;
// 그래프를 DFS, BFS로 탐색한 결과를 출력하는 프로그램 작성
// 1번째 줄에 노드 개수 N, 에지 개수 M, 탐색 시작 노드 번호 V가 주어진다. 2번째 줄에는 에지가 연결하는 두 노드의 번호가 주어진다. 두 노드 사이 여러 개의 에지가 있을 수 있으며 에지는 양방향이다.
// 1번째 줄에 DFS 출력, 2번째 줄에 BFS 출력, V로부터 방문한 점 순서대로 출력
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1206 {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 노드 개수
		int M = scanner.nextInt(); // 에지 개수
		int Start = scanner.nextInt(); // 시작점
		A = new ArrayList[N+1];
		for (int i=1; i<=N; i++) {
			A[i] = new ArrayList<Integer>(); // ArrayList 초기화
		}
		for (int i=0; i<M; i++) {
			int S = scanner.nextInt(); // start
			int E = scanner.nextInt(); // end
		}
		for (int i=1; i<=N; i++) { // 방문할 노드가 여러 개일때, 번호 작은 거 먼저 방문하기 위해 정렬
			Collections.sort(A[i]); // 각 노드와 관련된 에지 정렬
		}
		visited = new boolean[N+1]; // 방문 배열 포기화
		DFS(Start);
		System.out.println();
		visited = new boolean[N+1]; // 방문 배열 초기화
		BFS(Start);
		System.out.println();
	}
	
	public static void DFS(int Node) {
		System.out.print(Node + " "); // 현재 노드 출력
		visited[Node] = true; // 배열에 현재 노드 방문 기록
		for (int i: A[Node]) {
			if (!visited[i]) { // 현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행 (재귀 함수 형태)
				DFS(i);
			}
		}
	}
	
	public static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node); // 큐 자료구조에 시작 노드 삽입하기
		visited[Node] = true; // 배열에 현재 노드 방문 기록
	
		while (!queue.isEmpty()) { // 큐가 비어 있을 때까지
			int now_Node = queue.poll(); // 큐에서 노드 데이터 가져오기 (poll 연산)
			System.out.print(now_Node + " "); // 가져온 노드 출력하기
			for (int i : A[now_Node]) {
				if (!visited[i]) { // 현재 노드의 연결 노드 중 미방문 노드를 큐에 삽입하고 방문 배열에 기록하기
					visited[i] = true; 
					queue.add(i);
				}
			}
		}
	}
}
