package Search;

import java.util.Scanner;

public class P2750 {

	public static void main(String[] args) {
		int n = 0;
		int num [] = new int [6];
		Scanner scanner = new Scanner(System.in);
		System.out.println("몇 개를 입력하시겠습니까?");
		n = scanner.nextInt();
		
		for (int i=0; i<n; i++) {
			num[i] = scanner.nextInt(); 
		}
		
		for(int i=0; i<num.length-1;i++) {
			for(int j=i+1; j<num.length;j++) {
				if(num[i]>num[j]) {
					int tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
				}
			}
			System.out.println(num[i]);
		}
	}
}
