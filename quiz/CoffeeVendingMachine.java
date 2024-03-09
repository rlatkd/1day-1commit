/*
 1. 자판기 정의
 2. 요구사항 정의서(시나리오)
 ex) 커피자판기
 	 자판기는 ... 자판기 ... 자판기기능 ...
 
 [[[[[자판기란~~~~ 정의 필요]]]]]
 
 커피 자판기는 사각형 모양에 크기가 1.5m이고 파란색이다.
 효성산업에서 제조되었고 시리얼넘버는 HS-1234이다.
 ㅣ
 커피 자판기에는 커피의 종류가 총 3개 있다.
 각각의 이름은 "맥심", "조지아", "카누"이고 가격은 500, 600, 700원이다.
 "핫", "콜드" 선택할 수 있다.
 
 
 if 특정 커피 재고가 남아있다면) 그 커피를 구입할 수 있다.
 else) 그 커피를 구입할 수 없다.
 
 사용자가 동전 or 지폐를 투입하면
 	if 넣은금액>=커피가격) 커피를 선택할 수 있다.
 		커피가 제조된 후 커피가 나오고 차액을 거슬러준다.
 	else) 살 수 없다.
 		돈 부족하면 알림
 		if) 반환 버튼 누르면
 			액수를 다시 돌려준다.
 
 커피 자판기
 -고유
	모양
	크기
	색상
	기기시리얼넘버
	제조공장
 -상태
 	커피 재고
 	안에 현금 잔액
 	전원
 	메시지
 -부품: 커피
	 	-고유데이터
	 		이름
	 		가격
	 		용량
	 	-상태
	 		온도
	 	-부품: -
 -기능
 	선택된 커피 제조
 	커피가 나온다
 	차액(거스름돈) 반환
 	돈 부족하면 알림(메시지)
 */

class Coffee {	//[[[[[별도의 파일로 분리하는게 좋음]]]]]
	String name;	//커피이름
	int price;		//
	int volume;
		
	Coffee(String name, int price, int volume) {
		this.name = name;
		this.price = price;
		this.volume = volume;
	}
	
	Coffee makeCoffee(){
      return new Coffee(this.name, this.price, this.volume);
    }

	int getPrice() {
		return this.price;
	}
	
	String getName() {
		return this.name;
	}
	
	int getVolume() {
		return this.volume;
	}
	
}

public class Japanki {		//[[[[[자판기를 커스텀할 수 있다면 overloading으로 구현해야함]]]]]
	String shape;
	int size;
	String color;
	String serialNum;
	String factory;

	int maximJego;
	int georgiaJego;
	int kanuJego;
	
	int japankiCashAmount;
	
	int userCash;
	int userBalance;
	
	boolean isPowerOn;
	
	Coffee maximCoffee;
	Coffee georgiaCoffee;
	Coffee kanuCoffee;
	
	Japanki() {
		this.shape = "직사각형";
		this.size = 1500;
		this.color = "blue";
		this.serialNum = "HS-1234";
		this.factory = "효성산업";

		this.maximJego = 0;
		this.georgiaJego = 3;
		this.kanuJego = 4;
		this.japankiCashAmount = 2000;
		this.isPowerOn = true;

		this.userCash = 0;
		this.userBalance = 0;
		
		this.maximCoffee = new Coffee("맥심", 500, 500);
		this.georgiaCoffee = new Coffee("조지아", 600, 500);
		this.kanuCoffee = new Coffee("카누", 700, 500);
	}
	
	int inputCash(int cash) {
		if(cash < maximCoffee.getPrice()) {
			System.out.println("잔액이 부족합니다.");
			return cash;
		}
		this.userCash = cash;
		System.out.println("커피를 골라주세요.");
		return 0;
	}
	
	Coffee choiceCoffee(String coffeeName) {
		if(coffeeName.equals(maximCoffee.getName())) {
			if (this.maximJego == 0) {
				System.out.println("재고가 없습니다.");
			}else if(this.userCash < this.maximCoffee.getPrice()) {
				System.out.println("잔액이 부족합니다.");
			}else {
				this.userBalance = getBalance(maximCoffee.getPrice());
				--this.maximJego;
				this.japankiCashAmount += this.maximCoffee.getPrice();
				return new Coffee(this.maximCoffee);
			}
		}else if(coffeeName.equals(georgiaCoffee.getName())) {
			if (this.georgiaJego == 0) {
				System.out.println("재고가 없습니다.");
			}else if(this.userCash < this.georgiaCoffee.getPrice()) {
				System.out.println("잔액이 부족합니다.");
			}else {
				this.userBalance = getBalance(georgiaCoffee.getPrice());
				--this.georgiaJego; 
				this.japankiCashAmount += this.georgiaCoffee.getPrice();
				return new Coffee(this.georgiaCoffee);
			}
		}else if(coffeeName.equals(kanuCoffee.getName())){
			if (this.kanuJego == 0) {
				System.out.println("재고가 없습니다.");
			}else if(this.userCash < this.kanuCoffee.getPrice()) {
				System.out.println("잔액이 부족합니다.");
			}else {
				this.userBalance = getBalance(kanuCoffee.getPrice());
				--this.kanuJego; 
				this.japankiCashAmount += this.kanuCoffee.getPrice();
				return new Coffee(this.kanuCoffee);
			}
		}else {
			System.out.println("존재하지 않는 커피입니다.");
		}
		return null;
	}
	
	int getBalance(int price) {
		return this.userCash - price;
	}
	
	int getUserBalance() {
		return this.userBalance;
	}

	public static void main(String[] args) {
		
	}

}
