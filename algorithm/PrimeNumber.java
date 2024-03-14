/*
 소수 판별
 
 반복문, if
 */

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		//입력받기
		Scanner sc = new Scanner(System.in);
		
		//입력받은 수
		int inputNumber = Integer.parseInt(sc.next());
		
		//소수인지 
		boolean isPrime = true;
		
		//입력받은 수 2,3,4,...로 나눠서 나머지가 0이면 소수가 아님(약수가 있음)
		for (int i = 2; i < inputNumber; i++) {
			if (inputNumber % i == 0) {
				System.out.printf("%d은(는) 소수가 아닙니다.", inputNumber);
				
				//소수아님
				isPrime = false;
			}
		}
		
		//소수일때
		if (isPrime) System.out.printf("%d은(는) 소수입니다.", inputNumber);
	}
}