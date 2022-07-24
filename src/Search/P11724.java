package Search;
// 방향 없는 그래프가 주어졌을 때 연결 요소의 개수를 구하는 프로그램을 작성하시오.
// 1번째 줄에 노드의 개수 N과 에지의 개수 M, 2번째 줄부터 M개의 줄에 에지의 양끝 점 u와 v가 주어진다. 같은 에지는 한 번만 주어진다.
// 1번째 줄에 연결 요소의 개수를 출력한다.
import java.io.BufferedReader; // Substream classes for per-character I/O
import java.io.IOException; // Default class for exceptions that were threaded while accessing information using streams, files, and directories
import java.io.InputStreamReader; // A bridge from byte streams to character streams
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11724 {
	static ArrayList<Integer>[] A; // Declare an array that can be resized (normal arrays are resized X)
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Buffer Usage Reasons -> Receive Entire Input on One Line, Faster than Scanner
		StringTokenizer st = new StringTokenizer(br.readLine()); // Read Line (n, m)
		// When using the readLine() method
		// 1. When reading a value, the string value reads all of the characters (enter values) in one line
		// 2. If the return value is fixed to a string and input to a type other than the string, it must be transformed
		// 3. Declare import java.io.IOException as exception handling and write the throws IOException next to the main thread
		// 4. Invoke the values entered through readLine() in order by dividing them into lines
		// cf) When using read() method, transform to int value and read
		int n = Integer.parseInt(st.nextToken()); // n in br (number before space)
		int m = Integer.parseInt(st.nextToken()); // m in br (number after space)
		A = new ArrayList[n+1]; // Why n+1 instead of n -> To make the calculation easier
		visited = new boolean[n+1]; // Why n+1 instead of n -> To make the calculation easier
		for (int i=1; i<n+1; i++) { // Initialize each ArrayList in the adjacency list (where s(=u), e(=v) will enter)
			A[i] = new ArrayList<Integer>();
		}
		for (int i=0; i<m; i++) { // To save graph data to an adjacency list
			st = new StringTokenizer(br.readLine()); // readLine -> read s(=u), e(=v) as many as m
			int s = Integer.parseInt(st.nextToken()); // Read Integer.parseInt -> String as an integer
			int e = Integer.parseInt(st.nextToken()); // nextToken -> Read in spaces
			A[s].add(e); // Because it is a two-way edge, the path from the s vertex to the e vertex (indicating that the s vertex is adjacent (directly connected) to the e vertex)
			A[e].add(s); // The path from e vertex to s vertex (+ there is an edge between the two vertices)
		}
		int count=0;
		for (int i=1; i<n+1; i++) { 
			if (!visited[i]) { // If there are nodes that have not been visited
				count++; // Add the number of connecting elements
				DFS(i); // Running DFS
			}
		}
		System.out.println(count);
	}
	
	static void DFS(int v) {
		if (visited[v]) { // Current node == visited node
			return;
		}
		visited[v]=true; // Record the current node visit in the array
		for (int i:A[v]) {
			if (visited[i] == false) { // Navigating DFS for nodes that have not been visited among connection nodes (recursive function)
				DFS(i);
			}
		}
	}
}