package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1377 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		mData A[] = new mData[N]; // 클래스를 데이터로 담는 배열
		for (int i=0; i<N; i++) {
			A[i] = new mData(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(A); // A 배열 정렬(O(nlogn) 시간 복잡도)
		int Max = 0;
		for (int i=0; i<N; i++) {
			if (Max < A[i].index - i) // A[i]의 정렬 전 index - 정렬 후 index 계산의 최댓값 저장
				Max = A[i].index - i;
		}
		System.out.println(Max + 1); // 최댓값 + 1을 정답으로 출력
	}
}

class mData implements Comparable<mData> { // 별도 클래스 선언
	int value;
	int index;
	
	public mData(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(mData o) { // value 기준 오름차순 정렬
		return this.value - o.value;
	}
}
