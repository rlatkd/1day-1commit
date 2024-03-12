/*
 입력된 두 수의 최대공약수
 for, while, if
 */

import java.util.Scanner;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//입력값
		int num1 = Integer.parseInt(sc.next());
		int num2 = Integer.parseInt(sc.next());
		
		System.out.printf("입력한 값: %d, %d\n", num1, num2);

		//입력한 둘 중 큰값, 작은값 구분하기 위함
		int bigNum;
		int smallNum;
		
		if (num1 >= num2) {
			bigNum = num1;
			smallNum = num2;
		} else {
			bigNum = num2;
			smallNum = num1;
		}
		
		//최대공약수 초기값
		int gcd = 1;
		
		//1부터 작은 값까지 반복
		for (int i = 1; i < smallNum; i++) {
			if (bigNum % i == 0 && smallNum % i == 0) {
				gcd = i;
			}
		}
		
		//i=0부터 돌면 0으로 나눌 수 없으니 예외 나옴
		//Exception in thread "main" java.lang.ArithmeticException: / by zero
		/*
		for (int i = 0; i < smallNum; i++) {
			if (bigNum % i == 0 && smallNum % i == 0) {
				gcd = i;
			}
		}
		
		//검증
		try {
			for (int i = 0; i < smallNum; i++) {
				if (bigNum % i == 0 && smallNum % i == 0) {
					gcd = i;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		System.out.println("최대공약수: " + gcd);
	}
}
