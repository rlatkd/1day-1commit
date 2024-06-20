package lotto;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Scanner;

import exception.OutOfRangeNumberException;

public class Lotto {
	private Scanner scanner;	
	private int[] lottoNumbers;
	private int round;
	private int[] neverAppearedNumbers;
	
	int numberRange;
	int index = 1;
	
	public Lotto() {
		this.scanner = new Scanner(System.in);
		
		this.lottoNumbers = new int[6];
		
		this.round = 1;
		
		this.numberRange = 45;
		
		this.neverAppearedNumbers = new int[] {5, 9, 18, 25, 32};

		makeLottoNumbers();
	}
	private void sortNumber(int[] numbers) {
		for(int i = 0; i < numbers.length; i++) {
	        for(int j = 0; j < numbers.length - i - 1; j++) { 
	        	if(numbers[j] > numbers[j + 1]) { 
	               int temp = numbers[j];
	               numbers[j] = numbers[j + 1];
	               numbers[j + 1] = temp; 
	            }
	        }
	    }
	}
	public void start() {
		printMenu();
	}
	private void printMenu() {
		while (round <= 5) {
			//System.out.printf("안녕하세요 로또 %d회입니다.", round);
			System.out.printf("%d번째 로또 구매입니다.", round);
			System.out.println();
			System.out.println("원하시는 메뉴를 선택해주세요.");
			System.out.println("1. 로또구매(수동)\t2.로또구매(자동)\t3.당첨번호확인\t0.종료");
			System.out.print("메뉴 번호 입력 : ");
			switch (scanner.nextLine()) {
				case "1" : buyLottoManual(new int[6]); break;
				case "2" : buyLottoAuto(new int[6]); break;
				case "3" : checkLottoNumbers(); break;
				case "0" : System.out.println("프로그램을 종료합니다."); return;
				
				default : System.out.println("잘못된 입력입니다."); 
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}
	private void checkLottoNumbers() {
		System.out.print("로또 당첨 번호는 " );
		printNumbers(lottoNumbers);
		System.out.print("입니다.\n");
		makeLottoNumbers();
	}
	private void makeLottoNumbers() {
		for (int i = 0; i < lottoNumbers.length; i++) {
			lottoNumbers[i] = (int) (Math.random() * numberRange + 1);
		}
		
		String newLotto = index + "회차 " + Arrays.toString(lottoNumbers)+ "\n";
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("Lotto.txt", true);
			byte[] lottotxt = newLotto.getBytes();
			fos.write(lottotxt);
			index++;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		sortNumber(lottoNumbers);
	}
	private void buyLottoManual(int[] userNumbers) {
		System.out.println();
		System.out.println("원하시는 번호 6자를 입력해주세요.");
		for (int i = 0; i < userNumbers.length; i++) {
			System.out.print(i + 1 + "번 번호 입력 : ");
			try {
				int number = Integer.parseInt(scanner.nextLine());
				if(number < 1 || number > 45) throw new OutOfRangeNumberException();
				userNumbers[i] = number;
			}catch(NumberFormatException | OutOfRangeNumberException e) {
				System.out.println("잘못된 입력입니다. 1 ~ 45 사이의 숫자 한 개만 입력해주세요");
				i--;
			}
		}
		System.out.println();
		System.out.println("고객님이 구매하신 로또 번호는");
		
		printNumbers(userNumbers);
		System.out.println("입니다.");
		
		sortNumber(userNumbers);
		
		if (isSame(userNumbers)) {
			System.out.println("축하드립니다. 당첨되셨습니다. 당첨금은 2만원입니다.");
		} else {
			System.out.println("안타깝지만 당첨되지 않으셨습니다. 다음에 또 와주세요.");
		}
		round++;
	}
	private void printNumbers(int[] numbers) {
		for (int number : numbers) {
			System.out.print(number + " ");
		}
	}
	private void buyLottoAuto(int[] userNumbers) {
		boolean flag1 = true;
		while(flag1) {
			System.out.println();
			
			System.out.println("15주간 나오지 않은 번호를 제외하시겠습니까?");
			
			System.out.print("나오지 않은 번호는 ");
			
			for (int number : neverAppearedNumbers) {
				System.out.print(number + " ");
			}
			
			System.out.print("입니다.\n");
			
			System.out.println("1.네\t2.아니오");
			
			System.out.print("입력 : ");
			switch(scanner.nextLine()) {
				case "1" : exceptNeverAppearedNumbers(userNumbers); flag1 = false; break;
				case "2" : makeAutoNumbers(userNumbers); flag1 = false; break;
				default : System.out.println("잘못된 입력입니다.");
			}
		}
		sortNumber(userNumbers);
		boolean flag2 = true;
		while(flag2) {
			System.out.println("고객님이 구매하실 로또 번호는");
			
			printNumbers(userNumbers);
			
			System.out.print("입니다.\n");
			System.out.println("구매하시겠습니까?");
			System.out.println("1.네\t2.아니오");
			System.out.print("입력 : ");
			
			switch(scanner.nextLine()) {
				case "1" : flag2 = false; break;
				case "2" : return;
				default : System.out.println("잘못된 입력입니다.");
			}
		}
		if (isSame(userNumbers)) {
			System.out.println("축하드립니다. 당첨되셨습니다. 당첨금은 2만원입니다.");
		} else {
			System.out.println("안타깝지만 당첨되지 않으셨습니다. 다음에 또 와주세요.");
		}
		round ++;
	}
	private void makeAutoNumbers(int[] userNumbers) {
		for (int i = 0; i < userNumbers.length; i++) {
			userNumbers[i] = (int) (Math.random() * numberRange + 1);
		}
	}
	private void exceptNeverAppearedNumbers(int[] userNumbers) {
		for (int i = 0; i < userNumbers.length; i++) {
			int specialNumber = (int) (Math.random() * numberRange + 1);
			for (int j = 0; j < neverAppearedNumbers.length; j++) {
				if (specialNumber == neverAppearedNumbers[j]) {
					if (i != 0) i--;
				} else {
					userNumbers[i] = specialNumber;
				}
			}		
		}
	}
	private boolean isSame(int[] userNumbers) {
		for (int i = 0; i < userNumbers.length; i++) {
			if (lottoNumbers[i] != userNumbers[i]) return false;
		}
		return true;
	}
}