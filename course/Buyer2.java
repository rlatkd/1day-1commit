class Buyer{
	int money = 10000;
	int bonuspoint;
	Product[] cart = new Product[10];
	int cnt = 0;
	
	void Buy(Product n) { //다형성
		//구매
		//money  ..검증
		//제품 정보 (가격 , 포인트)
		if(this.money < n.price) {
			System.out.println("고객님 잔액이 부족합니다^^ " + this.money);
			return; //함수의 종료
		}
		//실 구매
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("현재 잔액은 : " + this.money);
		System.out.println("구매한 물건은 : " + n.toString());
		
		if(cnt < 10) {
			cart[cnt] = n;
			cnt++;
		}else{
			System.out.println("카트가 초과했습니다.");
		}
	}
	
	void summary() {
		int totalPrice = 0;
		for(Product p : cart) {
			if(p != null) {
				totalPrice += p.price;
				System.out.print(" [" + p.toString() + "] ");
			}
		}
		System.out.printf("를 구매하셨으며, 총 가격은 [%d]입니다.", totalPrice);
	}
	
}