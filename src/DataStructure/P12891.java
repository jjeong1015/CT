package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12891 {
	
	static int checkArr[];
	static int myArr[];
	static int checkSecret;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Result = 0;
		char A[] = new char[5]; // 문자열 데이터
		checkArr = new int[4]; // 비밀번호 체크 배열
		myArr = new int[4]; // 현재 상태 배열
		checkSecret = 0; // 몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수
		A = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0)
				checkSecret++;
		}
		for (int i=0; i<P; i++) { // 초기 P 부분 문자열 처리 부분
			Add(A[i]);
		}
		if (checkSecret == 4)
			Result++;
		for (int i=P; i<S; i++) { // 한 칸씩 이동하면서 제거되는 문자열과 새로 들어오는 문자열 처리 (슬라이딩 윈도우 처리 부분)
			int j = i - P;
			Add(A[i]);
			Remove(A[j]);
			if (checkSecret == 4) // 유효한 비밀번호인지(checkSecret == 4) 판단해 결괏값에 업데이트 -> 4자릿수와 관련된 크기가 모두 충족될 때 유효한 비밀번호
				Result++;
		}
		System.out.println(Result); // 결괏값 출력하기
		br.close();
	}
	
	private static void Add(char c) { // 새로 들어온 문자를 처리하는 함수
		switch (c) { // 새로 들어온 문자를 myArr에 업데이트하거나 checkSecret 값 변경하기
		case 'A':
			myArr[0]++;
			if (myArr[0] == checkArr[0])
				checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == checkArr[1])
				checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == checkArr[2])
				checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == checkArr[3])
				checkSecret++;
			break;
		}
	}
	
	private static void Remove(char c) { // 제거되는 문자를 처리하는 함수
		switch (c) { // 제거되는 문자를 myArr에 업데이트하거나 checkSecret 값 변경하기
		case 'A':
			if (myArr[0] == checkArr[0])
				checkSecret--;
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == checkArr[1])
				checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == checkArr[2])
				checkSecret--;
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == checkArr[3])
				checkSecret--;
			myArr[3]--;
			break;
		}
	}
}
