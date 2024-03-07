// 짱짱...
package kr.or.kosa;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Cinema {
	private String name;
	private String location;
	
	private String[][] seats;
	private Scanner scanner;
	
	public Cinema(String name, String location) {
    this.name = name;
    this.location = location;
    
		seats = new String[4][5];
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j] = (i+1) + "-" + (j+1);
			}
		}
		scanner = new Scanner(System.in);
	}
	
	public void printMainMenu(){
		while(true) {
			System.out.println();
			System.out.println("********************************");
			System.out.println("*******영화 예매 시스템*******");
			System.out.println("********************************");
			System.out.println("1. 예매하기");
			System.out.println();
			System.out.println("2. 예매조회");
			System.out.println();
			System.out.println("3. 예매취소");
			System.out.println();
			System.out.println("0. 종료");
			System.out.println();
			System.out.print("입력 : ");
			
			String userChoice = scanner.nextLine(); 
			
			switch(userChoice) {
				case "1" : printReservationMenu();
					break;
				case "2" : printCheckMyReservationMenu(); 
					break;
				case "3" : printCancelMyReservationMenu();
					break;
				case "0" : System.out.println("예매를 종료합니다.");
					return;			
				default : System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	private void printReservationMenu() {
		while(true) {
			System.out.println("******좌석 현황*******");
			printSeatStatus();
			System.out.println("-------------------------");
			System.out.println("좌석을 선택해주세요. 예)1-1");
			System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
			System.out.print("입력 : ");
			
			String userSeat = scanner.nextLine();
			
			if(isValidSeatFormat(userSeat) && isValidSeat(userSeat)) {
				System.out.println("예매 가능합니다. 예매하시겠습니까?");
				System.out.println("네(1), 아니오(2), 초기화면(0) 중 하나를 입력해주세요.");
				System.out.print("입력 : ");
				
				String userChoice = scanner.nextLine();
				
				switch(userChoice) {
					case "1" : String reservationNum = makeReservation(userSeat);
							   System.out.println("예매가 완료되었습니다.");
							   System.out.printf("예매한 좌석번호 : [%s] / 예매번호 : [%s]\n", 
									   userSeat, reservationNum);
							   System.out.println("감사합니다.");
						return;
					case "2" : System.out.println("예매가 취소되었습니다.");
						break;		
					case "0" : System.out.println("초기 화면으로 돌아갑니다.");
						return;	
					default : System.out.println("잘못된 입력입니다.");
				}
			}else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	private void printSeatStatus() {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if(seats[i][j].equals((i + 1) + "-" + (j + 1))) {
					System.out.print("[" + seats[i][j] + "]");
				}else {
					System.out.print("[예매]");
				}
			}
			System.out.println();
		}
	}
	
    private boolean isValidSeatFormat(String seat) {
        String regex = "\\d+-\\d+";
        return Pattern.matches(regex, seat);
    }

	private boolean isValidSeat(String seat) {
		int[] seatInfo = getSeatAddress(seat);
		int row = seatInfo[0];
		int column = seatInfo[1];
		
		if(row < seats.length && column < seats[row].length 
				&& seats[row][column].equals(seat)) {
			return true;
		}
		return false;
	}
	
	private String makeReservation(String seat) {
		int[] seatAddress = getSeatAddress(seat);
		String reservationNum = "" + (seatAddress[0] + 1) + 
								(seatAddress[1] + 1) + ((int)(Math.random() * 899) + 100);
		seats[seatAddress[0]][seatAddress[1]] = reservationNum;
		return reservationNum;
	}
	
	private int[] getSeatAddress(String seat) {
		
		String[] seatAddress = seat.split("-");
		int row = Integer.parseInt(seatAddress[0]) - 1;
		int column = Integer.parseInt(seatAddress[1]) - 1;
		return new int[]{row, column};
	}
	
	private void printCheckMyReservationMenu() {
		System.out.println("예매 번호를 입력해주세요.");
		System.out.print("입력 : ");
		String userChoice = scanner.nextLine();
		
		findReservationSeats(userChoice);
	}
	
	// 예매번호 조회 후 취소
	private void printCancelMyReservationMenu() {
		System.out.println("예매 번호를 입력해주세요.");
		System.out.print("입력 : ");
		String userReservationNum = scanner.nextLine();
		
		if(findReservationSeats(userReservationNum)) {
			System.out.println("예매를 취소하시겠습니까?");
			System.out.println("네(1), 아니오(2) 중 하나를 입력해주세요.");
			
			String userChoice = scanner.nextLine();
			
			switch(userChoice) {
				case "1" : cancelMyReservation(userReservationNum);
						 break;
				case "2" : System.out.println("예매 취소를 하지 않습니다.");
						 break;
				default : System.out.println("잘못된 번호를 입력하셨습니다.");
			}
		}
	}
	
	// 예매번호 조회
	private boolean findReservationSeats(String reservatoinNum) {
		if(isValidReservationNumFormat(reservatoinNum)) {
			for(String[] arr : seats) {
				for(String value : arr ) {
					if(value.equals(reservatoinNum)) {
						int row = Integer.parseInt(reservatoinNum.substring(0, 1));
						int column = Integer.parseInt(reservatoinNum.substring(1, 2));
						System.out.printf("고객님이 예매하신 좌석은 %d-%d 입니다.\n", row, column);
						return true;
					}
				}
			}
		}
		System.out.println("예매번호가 틀렸습니다.");
		return false;
	}
	
    private boolean isValidReservationNumFormat(String reservatoinNum) {
        String regex = "\\d+";
        return Pattern.matches(regex, reservatoinNum);
    }

	// 예매 취소
	private void cancelMyReservation(String seat) {
		int row = Integer.parseInt(seat.substring(0, 1));
		int column = Integer.parseInt(seat.substring(1, 2));
		
		seats[row-1][column-1] = row + "-" + column;
		
		System.out.println("예매가 취소되었습니다. 감사합니다.");
	}

}