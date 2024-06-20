package kr.or.kosa;
import java.util.*;

public class Operation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n3 = 0;
		
		System.out.print("입력값(숫자): ");
		int n1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("입력값(기호): ");
		String operator = sc.nextLine();
		
		System.out.print("입력값(숫자): ");
		int n2 = Integer.parseInt(sc.nextLine());
		
		if(operator.equals("*")) {
			n3 = n1*n2;
		}else if(operator.equals("+")) {
			n3 = n1+n2;
		}else if(operator.equals("-")) {
			n3 = n1 - n2;
		}else if(operator.equals("/")) {
			n3 = n1/n2;
		}
		System.out.printf("연산 결과 : %d", n3);
	}
}