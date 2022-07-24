package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		int A[] = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int count = 0;
		int i = 0;
		int j = N - 1;
		while (i<j) { // 투 포인터 이동 원칙에 따라 포인터를 이동하며 처리
			if (A[i] + A[j] < M) { // 재료 합 < M -> 작은 번호 재료를 한 칸 위로 변경하기
				i++;
			}
			else if (A[i] + A[j] > M) { // 재료 합 > M -> 큰 번호 재료를 한 칸 아래로 변경하기
				j--;
			}
			else { // 경우의 수 증가, 양쪽 index 변경하기
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);
		bf.close();
	}
	/*
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int num[] = new int[N];
		int count = 0;
		
		for (int i=0; i<N; i++) {
			num[i] = scanner.nextInt();
		}
		
		for (int i=0; i<num.length-1; i++) {
			for (int j=i+1; j<num.length; j++) {
				if (num[i]>num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				if ((num[i] + num[j]) == M)
					count++;
			}
		}
		System.out.println("count값은 " + count);
	}
	*/
}