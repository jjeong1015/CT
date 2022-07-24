package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11660 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 버퍼 사용 이유 -> 키보드 입력이 있을 때마다 한 문자씩 버퍼로 전송, 버퍼가 가득 차거나 개행 문자가 나타나면 내용을 한 번에 프로그램에 전달 -> 한 번에 묶어 보내는 것이 효율적이고 빠름
		StringTokenizer st = new StringTokenizer(br.readLine());
		// readLine() 할 경우
		// 1) 리턴 값이 string으로 고정되어 string이 아닌 다른 타입으로 입력 받을 경우 형변환 해야 함
		// 2) 예외처리로 import java.io.IOException 선언과 main 옆에 throws IOException 작성
		int N = Integer.parseInt(st.nextToken()); // readLine()을 통해 입력받은 값을 공백 단위로 구분하여 순서대로 호출
		int M = Integer.parseInt(st.nextToken());
		int A[][] = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int D[][] = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) { // 구간 합 구하기
				D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
			}
		}
		for (int i=0; i<M; i++) { // 구간 합 배열로 질의 답변
			int X1 = Integer.parseInt(st.nextToken()); // i 위치 시작
			int Y1 = Integer.parseInt(st.nextToken()); // j 위치 시작
			int X2 = Integer.parseInt(st.nextToken()); // i 위치 끝
			int Y2 = Integer.parseInt(st.nextToken()); // j 위치 끝
			
			int result = D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1];
			System.out.println(result);
		}
	}
	
}
