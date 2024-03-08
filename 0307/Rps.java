import java.util.Scanner;

public class Rps {

   public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      
      //가위바위보 내가 낼 숫자 값 (가위1 바위2 보3)
      int num = 0;
      
      //종료 논리
      boolean fin = true;
      
      System.out.printf("가위(1), 바위(2), 보(3) 게임을 시작합니다.");
      
      do {
         //컴퓨터가 낼 랜덤 값
         double random = Math.random();
         random = (3*random+1); //1 <= random < 4;
         int com = (int)random;
         System.out.println("\n컴퓨터가 낸 값: " + com);
         
         //가위바위보 냄(1,2,3)
         System.out.printf("\n> user님 입력하세요.\n> ");
         num = Integer.parseInt(sc.nextLine());
         
         //낸 숫자가 1~3사이일 때 해당
         if (num >=1 && num <=3) {
            
            //이기는 경우1(나:가위, 컴:보)
            if (num==1 && com==3) {
               System.out.printf("> 축하드립니다. 이겼습니다.");
               fin = false;
            }
            
            //이기는 경우2(가위<바위<보)
            else if (num-1 == com) {
               System.out.printf("> 축하드립니다. 이겼습니다.");
               fin = false;
            }
            
            //지는 경우1(나:보, 컴:가위)
            else if (num==3 && com==1) {
               System.out.printf("> 지셨습니다.\n> 다시 진행합니다.");
            }
            
            //지는 경우2(가위<바위<보)
            else if (num+1 == com) {
               System.out.printf("> 지셨습니다.\n> 다시 진행합니다.");
            }
            
            //비기는 경우(나=컴)
            else if (num == com) {
               System.out.println("> 비겼습니다.\n> 다시 진행합니다.");
            }
         } else {
            System.out.printf("> 잘못된 입력입니다. 다시 입력해주세요.");   //1~3 벗어나면 다시입력
         }
         
      } while (fin);
      
      // 이기는 경우 종료
      if (fin == false)
         return;

      }
}