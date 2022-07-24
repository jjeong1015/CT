package DataStructure;

import java.util.Deque; // double-ended queue (큐의 양쪽으로 요소 삽입과 삭제 가능)
import java.util.LinkedList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class P11003 {
	
	public static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 버퍼에 넣고 한 번에 출력하기 위해 사용
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque = new LinkedList<>(); // 데이터를 담을 덱 자료구조
		for (int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken()); // 현재 데이터 값
			
			while (!mydeque.isEmpty() && mydeque.getLast().value > now) { // 덱의 마지막 위치에서부터 now보다 큰 값은 덱에서 제거
				mydeque.removeLast();
			}
			mydeque.addLast(new Node(now, i)); // 덱의 마지막 위치에 now 값 저장
			
			if (mydeque.getFirst().index <= i-L) { // 덱의 1번째 위치에서부터 L의 범위를 벗어난 값(now index-L <= index)을 덱에서 제거(범위에서 벗어난 값은 덱에서 제거)
				mydeque.removeFirst();
			}
			bw.write(mydeque.getFirst().value + " "); // 덱의 1번째 데이터 출력
		}
		bw.flush(); // 현재 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 지움
		bw.close(); // 스트림 닫음(+flush 함수 호출)
	}
	
	static class Node { // 덱에 저장할 노드 클래스(자신의 위치, 자신의 값 담기) 별도 생성
		public int value;
		public int index;
		
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}
