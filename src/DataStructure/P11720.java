package DataStructure;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11720 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 숫자 개수
		String sNum = scanner.next(); // 입력값을 String 변수 sNum에 저장한 후 char[]형 변수로 변환
		char[] cNum = sNum.toCharArray();
		int sum = 0;
		for (int i=0; i<cNum.length; i++) {
			sum += cNum[i] - '0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
		}
		System.out.println(sum);
		/*
		String sum = null;
		for (int i=0; i<N; i++) {
			String num = scanner.nextLine();
			String tokens[] = num.split("");
			sum += tokens[i];
			System.out.print("i는 "+ i);
		}
		System.out.print(sum);
		*/
	}

}
