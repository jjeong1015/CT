package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P2750 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int A[] = new int[N];
		for (int i=0; i<N; i++) {
			A[i] = scanner.nextInt();
		}
		for (int i=0; i<N-1; i++) {
			for (int j=0; j<N-1-i; j++) {
				if (A[j] > A[j+1]) {
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
		for (int i=0; i<N; i++) {
			System.out.println(A[i]);
		}
	}
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int su[] = new int[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			su[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<su.length-1; i++) {
			for (int j=i+1; j<su.length; j++) {
				if (su[i] > su[j]) {
					int temp = su[i];
					su[i] = su[j];
					su[j] = temp;
				}
			}
		}
		
		for (int i=0; i<su.length; i++)
			System.out.println(su[i]);
	}
	*/
}
