/*
 10진수를 2진수로 변환
 19(10) -> 10011(2)
 array, while, for
 
 19 / 2		9...1
 9 / 2		4...1
 4 / 2		2...0
 2 / 2		1...0
 1 / 2		0...1
 -> 10011
 */

import java.util.Arrays;
import java.util.Scanner;

public class BinaryNumber {

	public static void main(String[] args) {

		//입력
		Scanner scanner = new Scanner(System.in);
		
		//입력받은 값
		int inputNumber = Integer.parseInt(scanner.next());
		
		//인덱스
		int index = 0;
		
		//2진수 값 저장할 배열생성
		int[] binaryNumbers = new int[10];
	
		//inputNumber를 2로 나누면서
		//나머지를 다시 inputNumber에 저장(1 or 0)
		//inputNumber가 0일때까지 반복
		//index 증가
		while (inputNumber != 0) {
			binaryNumbers[index] = inputNumber % 2;
			inputNumber = inputNumber / 2;
			index++;
		}
		
		//거꾸로 나옴 (19->10011인데 11001로)
		/*
		for (int i = 0; i < index; i++) {
			System.out.printf("%d ", binaryNumbers[i]);
		}
		*/
		
		//다시 거꾸로 for문(10011출력)
		for (int i = index - 1; i >= 0; i--) {
			System.out.printf("%d", binaryNumbers[i]);
		}
		System.out.println("(2)");
	}
}
