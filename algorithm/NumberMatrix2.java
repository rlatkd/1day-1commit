/*
 숫자 사각형 1
 입력된 수(N) 만큼 N행 N열의 형태로 연속으로 출력되는 숫자 사각형을 출력
 input: 4
 output:
 1 2 3 4
 8 7 6 5
 9 10 11 12
 16 15 14 13
 for, while
 */

import java.util.Iterator;
import java.util.Scanner;

public class NumberMatrix2 {
	public static void main(String[] args) {
		int input = Integer.parseInt((new Scanner(System.in)).next());
		int count1 = 1;
		int count2 = 0;
		int row = 1;
		System.out.printf("%d행", row);
		for (int i = 0; i < input; i++) {
			if (row % 2 != 0) {  //홀수행일때
				count1 = count2;
				for (int j = 0; j < input; j++) {
					System.out.print(count1);
					count1 += 1;
				}
			} else {  //짝수행일때
				for (int j = 0; j < input; j++) {
					
					System.out.print(count2);
					count2 -= 1;
				}
			}
			row += 1;
			count2 = count1 + input;
			System.out.println();
			System.out.printf("%d행", row);
		}
		
		
	}
}
