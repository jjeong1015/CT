package Search;
// N x M 크기의 미로가 주어질 때 (1, 1)에서 출발해 (N, M)의 위치로 이동하기 위해 지나야 하는 칸 수의 최솟값을 구하는 프로그램을 작성하시오.
// 1번째 줄에 두 정수 N, M, 다음 N개의 줄에는 미로의 내용이 M개의 정수로 주어진다. 
// 1번째 줄에 지나야 하는 칸 수의 최솟값을 출력한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P2178 {
	static int dx[] = {0, 1, 0, -1}; // dx, dy -> 상하좌우 탐색을 위한 define값 정의 변수
	static int dy[] = {1, 0, -1, 0};
	static boolean[][] visited;
	static int[][] A;
	static int N, M; // row, column
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M]; // A 배열 초기화
		visited = new boolean[N][M]; // visited 배열 초기화
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j+1)); // A 배열에 데이터 저장
			}
		}
		BFS(0, 0);
		System.out.println(A[N-1][M-1]);
	}
	
	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		while (!queue.isEmpty()) {
			int now[] = queue.poll(); // 큐에서 노드 데이터 가져오기 (poll 연산)
			visited[i][j] = true; // visited 배열에 현재 노드 방문 기록
			for (int k=0; k<4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if (x >= 0 && y >= 0 && x < N && y < M) { // 좌표 유효성 검사
					if (A[x][y] != 0 && !visited[x][y]) { // 갈 수 있는 칸 && 방문하지 않은 노드
						visited[x][y] = true; // visited 배열에 현재 노드 방문 기록
						A[x][y] = A[now[0]][now[1]]+1; // A 배열에 depth를 현재 노드의 depth+1로 업데이트하기
						queue.add(new int[] {x, y}); // 큐에 데이터 삽입
					}
				}
			}
		}
	}
	/*
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong(); // m<=100 조건이지만 n>=2 조건만 있기에 n과 같이 m도 long으로 맞춰줌
		
		for (int i=0; i<n; i++) { // (4, 6)의 경우 i는 4줄까지 j는 6줄까지 받게 하기
			for (int j=0; j<m; m++) {
				int space = scanner.nextInt();
			}
			System.out.println(" "); // (1줄에 6개 다 받았으면 다음 줄로 넘기기)
		}
	}
	*/
}
