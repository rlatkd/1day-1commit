import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Lotto {
	//로또 번호 들어갈 배열 선언
	private int[] numbers;
	
	//입력
	private Scanner scanner;
	
	//랜덤
	private Random random;
	
	//생성자(member field 초기화)
	public Lotto() {
		numbers = new int[6];
		scanner = new Scanner(System.in);
		random = new Random();
	}
	
	//로또 번호 고르기
	public void selectLottoNumbers() {
		
		//라벨(반복문 밖으로 탈출 말고 돌아가고 싶을 때)
		loop_1: while (true) {  //조건이 true면 계속 실행
			
			//메뉴에서 선택한 번호
			String selectnum = showMenu();
			
			switch (selectnum) {
			
				//1번 메뉴 선택하면 로또 번호 추출
				case "1":
					do {  //조건; 로또 번호 추출했는데 그 번호들이 조건에~면~할거다~
					makeLottoNumbers();
					} while (!checkAverage());  //조건 false일 때 계속 반복
					showLottoNumbers();
					break;
				case "2":
					System.out.println("안녕히가세요");
					break loop_1;
				default:
					System.out.println("잘못된 입력입니다.");
					break;
			}
		}
	}

	//메뉴보여주고 입력받는 함수
	private String showMenu() {
		System.out.println("***************************");
		System.out.println("**1. 당첨 예상 번호 추출하기**");
		System.out.println("**2. 프로그램 종료**");
		System.out.println("***************************");
		System.out.println("원하는 메뉴 번호를 입력하세요 :");
		
		//사용자가 입력한 값이 선택한 번호에 저장
		String selectnum = scanner.nextLine();
		
		//선택한 번호 반환
		return selectnum;
	}
		
	//로또 번호 추출
	private void makeLottoNumbers() {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 45 + 1);
			
			//중복값 배제
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					
					//만약 같으면 인덱스 한 칸 전으로 돌아가고
					i--;
					
					//j루프 탈출(다시 i돈다)
					break;
				}
			}
		}
	}
	
	//로또 번호 합의 평균 범위가 조건범위 안에 안들면 재추출 (특수조건)
	private boolean checkAverage() {
		
		int sum = 0;
		int average;
		
		for (int num : numbers) {
			sum += num;
		}
		
		average = sum / numbers.length;
		System.out.println("평균: " + average);
	
		return (average >= 15 && average <= 35);  //true면 오케이 false면 재추출
	}
	
	//최종으로 뽑은 로또 번호 알려주기(오름차순으로)
	private void showLottoNumbers() {
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(numbers));
	}
}

public class Lotto3 {

	public static void main(String[] args) {
		
		new Lotto().selectLottoNumbers();
	}

}
