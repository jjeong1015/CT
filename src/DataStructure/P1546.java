package DataStructure;
import java.util.Scanner;

public class P1546 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int score[] = new int[N];
		double avg = 0;
		int sum = 0;
		int max = 0;
		for (int i=0; i<N; i++) {
			score[i] = scanner.nextInt();
			sum += score[i];
			if (score[i] > max) {
				max = score[i];
			}
		}
		avg = sum * 100 / max / N;
		System.out.print(avg);
	}
}
