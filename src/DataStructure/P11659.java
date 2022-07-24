package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// 버퍼 사용 이유 -> 키보드 입력이 있을 때마다 한 문자씩 버퍼로 전송, 버퍼가 가득 차거나 개행 문자가 나타나면 내용을 한 번에 프로그램에 전달 -> 한 번에 묶어 보내는 것이 효율적이고 빠름
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		// readLine() 할 경우
		// 1) 리턴 값이 string으로 고정되어 string이 아닌 다른 타입으로 입력 받을 경우 형변환 해야 함
		// 2) 예외처리로 import java.io.IOException 선언과 main 옆에 throws IOException 작성
		int suNo = Integer.parseInt(stringTokenizer.nextToken()); // readLine()을 통해 입력받은 값을 공백 단위로 구분하여 순서대로 호출
		int quizNo = Integer.parseInt(stringTokenizer.nextToken());
		long S[] = new long[suNo+1];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i=1; i<=suNo; i++) {
			S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
		}
		for (int q=0; q<quizNo; q++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println(S[j] - S[i-1]);
		}
		/*
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int A[] = new int[N];
		int S[] = new int[N];
		int sum[] = new int[M];
		int i, j =0;
		for (i=1; i<=N; i++) {
			A[i] = scanner.nextInt();
			S[1] = A[1];
			S[i+1] = S[i] + A[i+1];
			System.out.print(S[i]);
		}
		for (i=0; i<M; i++) {
			i = scanner.nextInt();
			j = scanner.nextInt();
		}
		sum[i] = A[i+1] + A[j+1]; // 배열의 인덱스 시작은 0이지만 입력 시작은 1부터라서
		System.out.print(sum[i]);
		*/
	}
	
}
