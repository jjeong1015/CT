package Search;
// X라는 정수가 존재하는지 알아내는 프로그램
// 1번째 줄에 자연수 N, 그 다음 줄에 N개의 정수(A[1], ..., A[N])가 주어진다. 그 다음 줄에 M, 그 다음 줄에 M개의 수들이 주어지는데 이 수들이 A 안에 존재하는지 알아내라.
// M개의 줄에 답을 출력한다. 존재하면 1, 존재하지 않으면 0 출력
import java.util.Scanner;

public class P1920 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int ndata[] = new int[n];
		for (int i=0; i<ndata.length; i++) {
			ndata[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int mdata[] = new int[m];
		for (int i=0; i<mdata.length; i++) {
			mdata[i] = scanner.nextInt();
		}
		
		for (int i=0; i<ndata.length-1; i++) {
			for (int j=i+1; j<ndata.length; j++) {
				if (ndata[i]>ndata[j]) { // 왼쪽에 있는 i가 오른쪽에 있는 j보다 값이 클 경우 교환
					int temp = ndata[i];
					ndata[i] = ndata[j];
					ndata[j] = temp;
				}
			}
		}
	}

}
