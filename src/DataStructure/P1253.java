package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1253 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int Result = 0;
		long A[] = new long[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		for (int k=0; k<N; k++) {
			long find = A[k];
			int i = 0;
			int j = N-1;
			
			while (i<j) { // 투 포인터 알고리즘
				if (A[i] + A[j] == find) { // find는 서로 다른 두 수의 합이어야 함을 체크
					if (i != k && j != k) { // 결괏값에 반영 및 while문 종료
						Result++;
						break;
					}
					else if (i == k) { // 포인터 변경 및 계속 수행
						i++;
					}
					else if (j == k) { // 포인터 변경 및 계속 수행
						j--;
					}
				}
				else if (A[i] + A[j] < find) { // 포인터 i 증가
					i++;
				}
				else { // 포인터 j 감소
					j--;
				}
			}
		}
		System.out.println(Result);
		bf.close();
	}
}
