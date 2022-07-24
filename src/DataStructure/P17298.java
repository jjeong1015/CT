package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class P17298 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A[] = new int[N];
		int ans[] = new int[N];
		String str[] = br.readLine().split(" "); // Cut the string based on the separator ("") and insert it into the array
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> myStack = new Stack<>();
		myStack.push(0); // initialize by pushing the initial value because the stack is always empty at first
		for (int i=1; i<N; i++) {
			while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) { // If the stack is not empty and the current sequence is greater than the sequence indicated by the stack top index
				ans[myStack.pop()] = A[i]; // save the number of octaves in the answer array as the current sequence
			}
			myStack.push(i); // new data push
		}
		while (!myStack.empty()) { // If the stack is not empty after completing the repeat statement
			ans[myStack.pop()] = -1; // put -1 in the stacked index
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i=0; i<N; i++) {
			bw.write(ans[i] + " "); // output
		}
		bw.write("\n");
		bw.flush();
		/*
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for (int i=0; i<A.length-1; i++) {
			for (int j=i+1; j<A.length; j++) {
				if (count == 0) {
					if (A[i] < A[j]) {
						//System.out.println("if문 : " + A[j] + " " + "j값 : " + j + " ");
						System.out.print(A[j] + " ");
						++count;
					}
					else
						//System.out.println("else문 : -1" + " ");
						System.out.print("-1" + " ");
				}
				else {
					j = A.length -1 ; // i값 다음으로 넘어가도록 하려고 ex) i=0이었다면 i=1로
					//System.out.println("i값 : " + i + " " + "j값 : " + j + " ");
				}
			}
			count = 0;
		}
		*/
	}
}
