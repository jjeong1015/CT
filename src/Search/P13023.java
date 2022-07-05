package Search;
// A-B-C-D-E 친구 관계가 존재하는지 여부를 구하는 프로그램을 작성하시오.
// 1번째 줄에 사람의 수 N과 친구 관계의 수 M, 2번째 줄부터 M개의 줄에 정수 a와 b가 주어진다. a와 b는 친구 관계라는 뜻이고 같은 친구 관계가 2번 이상 주어지지 않는다.
// A-B-C-D-E 친구 관계가 존재하면 1, 존재하지 않으면 0 출력
import java.util.*;

public class P13023 {
	static boolean visited[];
	static ArrayList<Integer>[] A;
	static boolean arrive;
	
	public static void main(String[] args) {
		arrive = false;
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 노드 개수
		int M = scanner.nextInt(); // 에지 개수
		
		A = new ArrayList[N]; // 그래프 데이터 저장 인접 리스트
		visited = new boolean[N]; // 방문 기록 저장 배열
		
		for (int i=0; i<M; i++) {
			int S = scanner.nextInt();
			int E = scanner.nextInt();
			A[S].add(E);
			A[E].add(S);
		}
		
		for (int i=0; i<N; i++) {
			DFS(i,1); // depth 1부터 시작
			if (arrive)
				break;
		}
		if (arrive)
			System.out.println("1");
		else
			System.out.println("0"); // 5의 깊이가 없다면 0 출력
	}
	public static void DFS(int now, int depth) { // DFS 구현
		if (depth == 5 || arrive) { // depth 5가 되면 프로그램 종료
			arrive = true;
			return; // 함수 종료
		}
		visited[now] = true; // 방문 배열에 현재 노드 방문 기록하기
		for (int i : A[now]) {
			if (!visited[i]) { // 현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기
				DFS(i, depth + 1); // 재귀 호출 할 때마다 depth 1씩 증가
			}
		}
		visited[now] = false;
	}
}
