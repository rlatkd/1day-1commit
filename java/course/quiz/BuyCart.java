/*
문제 풀어 보세요 ^^
요구사항
 >> 매장카트 구현하기 입니다 <<
카트 (Cart) >> member field 
카트 매장에 있는 [모든 전자제품]을 담을 수 있다 
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... [카트에 담는다]
---------------------------------------
계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력
hint) 카트 물건을 담는 행위 (Buy() 함수안에서 cart  담는 것을 구현 )
hint) Buyer ..>> summary()  main 함수에서 계산할때  사용합니다
Buyer >> buy() , summary()  >> 카트에 물건 계산 (어떤물건 , 각 가격 >> 당신은 총 얼마 지급)
구매자는 default 금액을 가지고 있고 초기금액을 설정할 수 도 있다
	계산대(장바구니)
	물건을 계산
	1. 구매한 물건의 총액
	2. 포인트 총액
	3. 구매한 물건 리스트 
	의 내용을 출력
*/

//가전제품
class Product {
	int price;
	int bonuspoint;
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price / 10);
	}
}

class KtTv extends Product {
	KtTv() {
		super(500);
	}
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product2 {
	Audio() {
		super(150);
	}
	@Override
	public String toString() {
		return "Audio";
	}
}

class Notebook extends Product {
	Notebook() {
		super(500);
	}
	@Override
	public String toString() {
		return "Notebook";
	}
}

class Buyer {
	//default금액 or 초기금액 설정가능 -> 초기화x
	int money;
	int bonuspoint;
	
	//카트에 담겨진 제품들 배열 생성
	Product[] productCart;
	
	//10개까지 만들기 위한 인덱스번호 초기화
	int index = 0;
	
	Buyer() {
		this(2000,0);
	}
	Buyer(int money, int bonuspoint) {
		this.money = money;
		this.bonuspoint = bonuspoint;
		
		productCart = new Product[10];	//습관처럼 나와야함
	}

	//구매행위
	void buy(Product product) {	//제발 까먹지 마라
		System.out.println();
		if (this.money < product.price) {
			System.out.println("고객님 잔액이 부족합니다.");
			return;
		}
		//구매할제품 갯수가 10개 초과라면 종료
		if (this.index >= 10) {	//[0]~[9] 10개
			System.out.println("고객님 그만 구매하세요.");
			return;
		}
		//구매했으므로 인덱스 넘어감(다음제품 골라야댐)
		productCart[index++] = product;	//왜 이건 카트의 index인지 -> 이해완료
		this.money -= product.price;
		this.bonuspoint += product.bonuspoint;
		System.out.printf("현재 잔액은 %d원입니다.\n", this.money);
		System.out.printf("구매하신 물품은 %s입니다.\n", product.toString());
		System.out.printf("포인트가 적입되었습니다. 현재 포인트: %s\n", this.bonuspoint);
	}
	
	/*
	계산대(장바구니)
	물건을 계산
	1. 구매한 물건의 총액
	2. 포인트 총액
	3. 구매한 물건 리스트 
	의 내용을 출력
	*/
	
	//구매목록 요약
	void summary() {
		System.out.println();
		
		//default 초기화
		int totalPrice = 0;
		int totalBonusPoint = 0;
		
		//구매한 제품들
		String productList = "";
		
		//제어문 다시 이해 필요
		for (int i = 0; i < index; i++) {	//왜 이건 index고 -> 이해완료
			totalPrice += productCart[i].price;
			totalBonusPoint += productCart[i].bonuspoint;
			productList += productCart[i].toString() + " ";
		}
		System.out.println("*****************");
		System.out.printf("구매한 제품 목록: %s\n", productList);
		System.out.printf("구매한 총액: %d\n", totalPrice);
		System.out.printf("포인트 총액: %d\n", totalBonusPoint);
	}
}

public class BuyCart {
	public static void main(String[] args) {
		KtTv kt2 = new KtTv();
		Audio audio = new Audio();
		Notebook notebook = new Notebook();
		Buyer buyer = new Buyer(5000, 0);	//초기값 설정
		
		buyer.buy(kt);
		buyer.buy(audio);
		buyer.buy(notebook);
		buyer.buy(kt);
		buyer.buy(audio);
		buyer.buy(notebook);
		
		buyer.summary();
	}
}
