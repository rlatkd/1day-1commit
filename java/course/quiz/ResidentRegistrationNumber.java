import java.util.Scanner;

public class ResidentRegistrationNumber {
	
	static String jumin;
	static String juminOneFour;
	
	static boolean isNumberLength() {
		if (jumin.length() != 14 || !jumin.substring(6,7).equals("-")) {
			System.out.println("주민등록번호가 형식에 맞지 않습니다. 123456-1234567 형식에 맞게 입력해주세요.");
			return false;
		}
		System.out.println("주민등록번호가 14자리입니다.");
		return true;
	}
	
	static boolean isFirstNumber() {
		if (Integer.parseInt(juminOneFour) == 1 || Integer.parseInt(juminOneFour) == 2 || Integer.parseInt(juminOneFour) == 3 || Integer.parseInt(juminOneFour) == 4) {
			System.out.println("첫 번째 자리가 1~4 사이입니다.");
			return true;
		}
		System.out.println("첫 번째 자리가 1~4 사이가 아닙니다.");
		return false;
	}
	
	static void man() {
		if (Integer.parseInt(juminOneFour) == 1 || Integer.parseInt(juminOneFour) == 3) {
			System.out.println("성별은 남자입니다.");
		} else {
			System.out.println("성별은 여자입니다.");
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("주민등록번호를 입력해주세요.");
		
		jumin = scanner.next();
		
		if (!isNumberLength()) return;
		
		juminOneFour = jumin.substring(0,1);
		
		System.out.println("주빈등록번호 첫 번째 자리: " + juminOneFour);
		
		if (!isFirstNumber()) return;
		
		man();
	}
}
