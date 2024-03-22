/*
 숫자 사각형 1
 입력된 수(N) 만큼 N행 N열의 형태로 연속으로 출력되는 숫자 사각형을 출력
 input: 4
 output:
 1 5 9 13
 2 6 10 14
 3 7 11 15
 4 8 12 16
 for, while
 */

import java.util.Scanner;

public class NumberMatrix1 {
	public static void main(String[] args) {
		//입력
		int input = Integer.parseInt(new Scanner(System.in).next());
		
		//출력할 값의 초기값
		int count = 1;
		
		//4*4 matrix
		for (int i = 0; i < input; i++) {
			for (int j = 0; j < input; j++) {
				if (j != input - 1) {
					System.out.print(count + " ");  //숫자마다 띄어쓰기
				} else {
					System.out.print(count);  //각 행의 마지막 숫자는 띄어쓰기 없이
				}
				
				//출력하고 값 +1
				count += 1;
			}
			System.out.println();  //1행씩 출력
		}
	}
}
