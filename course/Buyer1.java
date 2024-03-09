/*
시나리오(요구사항)
저희는 가전제품 매장 솔루션을 개발하는 사업팀입니다
A라 전자제품 매장이 오픈되면

[클라이언트 요구사항]
가전제품은 제품의 가격 , 제품의 포인트 정보를 모든 제품이 가지고 있습니다
각각의 가전제품은 제품별 고유한 이름정보를 가지고 있다
ex)
각각의 전자제품은 이름을 가지고 있다 (ex) Tv , Audio , Computer
각각의 전자제품은 다른 가격정보를 가지고 있다( Tv:5000 , Audio : 6000)
제품의 포인트는 가격의 10%적용한다

시뮬레이션 시나리오
구매자: 제품을 구매하기 위한 금액정보 , 포인트 정보를 가지고 있다
ex) 10만원 , 포인트 0
구매자는 제품을 구매할 수 있다 , 구매행위를 하게 되면 가지고 있는 돈은 감소하고 (가격) 포인트는 증가한다
구매자는 처음 초기 금액을 가질 수 있다
*/


//가전제품
class Product {
	
	//제품의 가격
	int price;
	
	//제품의 포인트 정보
	int bonuspoint;
	
	//생성자
	//포인트는 가격의 10% 적용 -> 생성자에서 가격 parameter를 받아야함
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int)(this.price / 10);
	}
}

//가전제품을 상속하는 kttv
class KtTv extends Product {
	
	//생성자
	KtTv() {
		
		//kttv의 제품가격은 500(고정)이고 부모인 가전제품에게 전달
		super(500);
	}
	
	//Object에 toString()있으니 오버라이드로 사용
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product {
	
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

//구매자
class Buyer {
	
	//구매자는 처음 초기금액을 가질 수 있다
	int money = 2000;
	int bonuspoint;
	
	void buy(Product product) {	//가전제품의 제품정보를 받아와야함
		
		if (this.money < product.price) {
			System.out.println();
			System.out.println("고객님 잔액이 부족합니다.");
			
			//함수 종료
			return;
		}
		else {
			this.money -= product.price;
			this.bonuspoint += product.bonuspoint;
			System.out.printf("현재 잔액은 %d원입니다.\n", this.money);
			System.out.printf("구매하신 물품은 %s입니다.\n", product.toString());
			System.out.printf("포인트가 적입되었습니다. 현재 포인트: %s\n", this.bonuspoint);
		}
	}
}

public class Buyer1 {

	public static void main(String[] args) {
		
		//각 인스턴스 생성
		KtTv kt = new KtTv();
		Audio audio = new Audio();
		Notebook notebook = new Notebook();
		
		Buyer buyer = new Buyer();
		
		buyer.buy(kt);
		buyer.buy(audio);
		buyer.buy(notebook);
		buyer.buy(kt);
		buyer.buy(audio);
		buyer.buy(notebook);
	}
}
