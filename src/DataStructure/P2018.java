package DataStructure;

import java.util.Scanner;

public class P2018 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int sum = 1;
		int count = 1; // N이 15일 때 숫자 15만 뽑는 경우의 수를 미리 넣고 초기화
		int start = 1; // start index
		int end = 1; // end index
		while (end != N) { // 포인터가 이동할 때마다 현재의 총합과 N을 비교해 값이 같으면 count 1 증가
			if (sum == N) { // count 증가 end 증가 sum 값 변경
				count++; // 경우의 수 1 증가
				end++; // end를 오른쪽으로 한 칸 이동 -> 연속된 자연수의 범위를 한 칸 더 확장
				sum += end; // sum = sum + end
			}
			else if (sum > N) { // sum 값 변경, start 증가
				sum -= start; // sum = sum - start
				start++; // start를 오른쪽으로 한 칸 이동 -> 연속된 자연수에서 왼쪽 값을 삭제
			}
			else { // end 증가, sum 값 변경
				end++; // end를 오른쪽으로 한 칸 이동 -> 연속된 자연수의 범위를 한 칸 더 확장
				sum += end; // sum = sum + end
			}
		}
		/*
		for (int i=0; i<N; i++) {
			num++;
			sum += num;
			System.out.println("if문 들어가기 전 sum값 " + sum);
			if (sum == N) {
				System.out.println("i는 " + i);
				System.out.println("sum은 " + sum);
				System.out.println("N은 " + N);
				++count;
			}
			//num++;
			System.out.println(num);
		}
		*/
		System.out.print(count);
	}
	
}
