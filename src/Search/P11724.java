package Search;
// 방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 프로그램을 작성하시오.
// 1번째 줄에 노드의 개수 N과 에지의 개수 M, 2번째 줄부터 M개의 줄에 에지의 양끝 점 u와 v가 주어진다. 같은 에지는 한 번만 주어진다.
// 1번째 줄에 연결 요소의 개수를 출력한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11724 {
	private static final Integer Interger = null;
	static ArrayList<Integer>[] A;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Interger.parseInt(st.nextToken());
		int m = Interger.parseInt(st.nextToken());
		A = new ArrayList[n+1];
		visited = new boolean[n+1];
		for (int i=1; i<n+1; i++) { // 인접 리스트 각 ArrayList 초기화하기
			A[i] = new ArrayList<Integer>();
		}
		for (int i=0; i<m; i++) { // 인접 리스트에 그래프 데이터 저장하기
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e); // 양방향 에지이므로 양쪽에 에지를 더하기
			A[e].add(s);
		}
		int count=0;
		for (int i=1; i<n+1; i++) { 
			if (!visited[i]) { // 방문하지 않은 노드가 있을 경우
				count++; // 연결 요소 개수 추가
				DFS(i); // DFS 실행
			}
		}
		System.out.println(count);
	}
	
	static void DFS(int v) {
		if (visited[v]) { // 현재 노드 == 방문한 노드
			return;
		}
		visited[v]=true; // 배열에 현재 노드 방문 기록하기
		for (int i:A[v]) {
			if (visited[i] == false) { // 연결 노드 중 방문하지 않았던 노드 DFS 탐색하기 (재귀 함수)
				DFS(i);
			}
		}
	}
	
	/*
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("노드 개수, 에지 개수를 입력하세요 : ");
		long node = scanner.nextLong();
		long edge = scanner.nextLong();
		
		for(int i=0; i<edge; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
		}
		// 스택 함수 호출해서 링크드리스트로 꼬리에 꼬리를 물어 연결하기
	}
	*/
}