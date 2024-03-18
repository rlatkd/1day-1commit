/*
 입력된 수의 각 자리값 합
 for while
 */

import java.util.Scanner;

public class SumEachDigit {
	public static void main(String[] args) {
		//스캐너
		Scanner sc = new Scanner(System.in);
		//입력받은 수(문자열로 취급)
		String input = sc.next();
		//입력받은 수 배열로 변환(char배열)
		char[] array = new char[input.length()];
		//합 초기값
		int sum = 0;
		//문자열 하나씩 뽑아서 char배열에 추가
		for (int i = 0; i < input.length(); i++) {
			array[i] = input.charAt(i);
		}
		//배열 하나씩 뽑아서 합
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			sum += (array[i] - '0');
		}
		System.out.println("합" + sum);
	}
}