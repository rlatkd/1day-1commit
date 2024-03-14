import java.util.Scanner;

public class Atm {
   public static void main(String[] args) {
          //메뉴를 보여주고 사용자에 선택 ....
         //원하시는 메뉴를 선택하지 않으면 강제로 다시 메뉴를 보여 주세요
         //1.예금
         //2.출금
         //3.잔고
         //4.종료
         //잔액 변수를 생성 (balance)
         //예금 처리  + 누적 (예금 금액을 받아서) balance 누적
         //출금 처리  - 누적 (출금 금액을 받어서) balance에서 뺌
         //잔고      balance  출력
         //종료      프로그램 끝 (함수의 종료  , 프로그램의 강제 종료)
      
      Scanner sc = new Scanner(System.in);
      int balance = 0;
      int choice = 0;
      
      do {
         System.out.println("\n메뉴를 선택해주세요.");
         System.out.println("1. 예금");
         System.out.println("2. 출금");
         System.out.println("3. 잔고");
         System.out.println("4. 종료");
         System.out.print("응답: ");
         choice = Integer.parseInt(sc.nextLine()); 
         
         switch(choice) {
            case 1: 
               System.out.print("예금할 금액 :");
               balance += Integer.parseInt(sc.nextLine());
               break;
            case 2:
               System.out.print("출금할 금액 :");
               int amount = Integer.parseInt(sc.nextLine());
               if(balance - amount < 0) System.out.println("잔고가 부족합니다.");
               else balance -= amount;
               break;
            case 3:
               System.out.println("잔고 :" + balance);
               break;
            case 4:
               System.out.println("프로그램을 종료합니다.");
               return;
            default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
         }
      }while(true);      
   }
}
