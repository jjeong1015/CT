package Search;
// 트리의 지름(트리를 구성하는 노드 중 두 노드 사이의 거리가 가장 긴 것)을 구하시오.
// 1번째 줄에는 트리의 노드 개수 V, 2번째 줄부터 V개의 줄에 걸쳐 에지의 정보가 주어진다. 노드 번호가 주어지고, 연결된 에지의 정보를 의미하는 정수 2개(노드 번호, 거리)가 주어진다.
// 트리의 지름 출력
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1167 {
	static boolean visited[]; // 방문 기록 저장
	static int[] distance; // 거리 저장
	static ArrayList<Edge>[] A;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 노드 개수
		A = new ArrayList[N+1];
		for (int i=1; i<=N; i++) { // 인접 리스트의 ArrayList 초기화
			A[i] = new ArrayList<Edge>();
		}
		for (int i=0; i<N; i++) { // 인접 리스트에 그래프 데이터 저장
			int S = scanner.nextInt();
			while (true) {
				int E = scanner.nextInt();
				if (E == -1)
					break;
				int V = scanner.nextInt();
				A[S].add(new Edge(E, V));
			}
		}
		distance = new int[N+1]; // distance 배열 초기화
		visited = new boolean[N+1]; // visited 배열 초기화
		BFS(1); // 1을 시작점으로 실행
		int Max = 1;
		for (int i=2; i<=N; i++) { // 배열에서 가장 큰 값을 지니고 있는 노드를 시작점으로 지정
			if (distance[Max] < distance[i])
				Max = i;
		}
		distance = new int[N+1]; // distance 배열 초기화
		visited = new boolean[N+1]; // visited 배열 초기화
		BFS(Max); // 새로운 시작점으로 실행
		Arrays.sort(distance);
		System.out.println(distance[N]); // 배열에서 가장 큰 수를 정답으로 출력
	}
	private static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index); // 큐 자료구조에 시작 노드 삽입
		visited[index] = true; // 배열에 현재 노드 방문 기록
		while (!queue.isEmpty()) { // 큐가 비어있을 때까지
			int now_node = queue.poll(); // 큐에서 노드 데이터 가져오기
			for (Edge i : A[now_node]) { // 가져온 노드 출력하기
				int e = i.e;
				int v = i.value;
				if (!visited[e]) { // 현재 노드의 연결 노드 중 방문하지 않은 노드
					visited[e] = true; // 방문 기록
					queue.add(e); // 큐에 데이터 삽입
					distance[e] = distance[now_node]+v; // 현재 노드 거리 + 에지 가중치로 방문하지 않은 노드 거리 배열 업데이트
				}
			}
		}
	}
}
class Edge { // 에지 클래스 별도 구현
	int e; // 목적지 노드
	int value; // 에지 가중치
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}
