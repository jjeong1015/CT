package Greedy;
// 수식의 괄호를 적절하게 배치해 수식의 값을 최소로 만드는 프로그램 작성
// 1번째 줄에 식이 주어진다. 식은 '0'~'9', '+'와 '-'만으로 이뤄져 있고, 가장 처음과 마지막 문자는 숫자다. 연속된 2개 이상의 연산자가 나타나지 않으며 5자리보다 많이 연속되는 숫자는 없다. 식의 길이는 50 이하다.
// 1번째 줄에 정답을 출력한다.
import java.util.Scanner;
public class P1541 {
	static int answer = 0; // 정답 변수
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String example = scanner.nextLine();
		String str[] = example.split("-"); // 들어온 데이터를 "-" 기호를 기준으로 split 수행하기(문자열 나누고 배열에 저장)
		for (int i=0; i<str.length; i++) {
			int temp = mySum(str[i]); // 결괏값 = mySum() 함수 수행하기
			if (i==0) // 가장 앞 데이터일 때 answer에 결괏값 더하기
				answer = answer + temp; // 가장 앞에 있는 값만 더함
			else // answer에 결괏값 빼기
				answer = answer - temp; // 뒷부분은 더한 값들을 뺌
		}
		System.out.println(answer);
	}
	static int mySum(String a) { // 현재 String에 있는 수를 모두 더하는 함수
		int sum = 0;
		String temp[] = a.split("[+]"); // 들어온 데이터를 "+" 기호를 기준으로 split 수행하기(문자열 나누고 배열에 저장)
		for (int i=0; i<temp.length; i++) {
			sum += Integer.parseInt(temp[i]); // String 값을 Integer형으로 변환해 리턴값에 더하기
		}
		return sum;
	}
}
