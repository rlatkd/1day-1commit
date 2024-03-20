//WeightManager.java
package kr.or.dataobject;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WeightManager {
   private Scanner sc;
   private String userName;
   private String userWeight;
   private String userPassword;
   private String path;
   private String[] textData;
   private File file;
   private File fileData;
   
   public WeightManager() {
      this.sc = new Scanner(System.in);
      this.userName = "기본값";
      this.userWeight = "기본값";
      this.userPassword = "기본값";
      this.path = "C://WeightMgData/";
      this.textData = null;
      this.fileData = new File(path);
   }
   
    public void run() {
        int menuNumber;
       
        while (true) {
            try {
                showMenu();
                menuNumber = sc.nextInt();
                sc.nextLine();
                System.out.println();
 
                if (menuNumber < 1 || menuNumber > 5)
                    throw new MenuChoiceException(menuNumber);
 
                switch (menuNumber) {
                   case 1:
                      inputWeight();
                      break;
                   case 2:
                      searchWeight();
                      break;
                   case 3:
                      changeWeight();
                      break;
                   case 4:
                      changePassword();
                      break;
                   case 5:
                       System.out.println("프로그램을 종료합니다.");
                       return;
                }
            } catch (MenuChoiceException e) {
                e.showWrongChoice();
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                System.out.println();
            } catch (IOException e) {
                System.out.println(e + "오류발생");
            } catch (Exception e) {
                String temp = sc.nextLine();
                System.out.println("입력하신 " + temp + "는 숫자가 아닙니다.");
                System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                System.out.println();
            }
        }
    }

    public void showMenu() {
        System.out.println("\n다음 사항에 맞게 입력하여 주십시요");
        System.out.println("======> 몸무게 입력은  1번");
        System.out.println("======> 몸무게 검색은  2번");
        System.out.println("======> 몸무게 변경은  3번");
        System.out.println("======> 비밀번호변경은 4번");
        System.out.println("======> 프로그램종료는 5번");
        System.out.println("을 입력한후 Enter을 눌러주십시요");
        System.out.print("메뉴 선택 : ");
    }

    public void inputWeight() throws IOException{
        System.out.println("이름을 입력하여 주십시요.");
        System.out.print("이름: "); 
        
        this.userName = sc.nextLine();
        System.out.println();
       
        File file = new File(path+this.userName + ".txt");
        
        if (!file.exists()) {
            System.out.println("몸무게를 입력하여 주십시요.");
            System.out.print("몸무게: ");
            this.userWeight = sc.nextLine();
            
            System.out.println();
            System.out.println("비밀번호를 입력하여 주십시요.");
            System.out.print("비밀번호: ");
            this.userPassword = sc.nextLine();
            
            System.out.println();
           
            showResult();
            
            if (!fileData.exists()) fileData.mkdir();
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.userWeight + ":");
            bw.write(this.userPassword);
           
            bw.close();
            System.out.println("___입력이 완료되어_..[" + path +this.userName + ".txt ]._가(이) 생성되었습니다.");
        } else {
            System.out.println("현재 [" + this.userName + "] 사용자가 존재합니다.");
            System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
            System.out.println();
        }
    }
    
    public void searchWeight() throws IOException{
        if (fileCheck()) {
            printStar();
            System.out.println("\t\t" + this.userName + "님의 몸무게는 "+ textData[0] + " kg 입니다.");
            printStar();
            System.out.println();
        } else {
            return;
        }
        System.out.println();
    }

   public void printStar() {
      System.out.println("*****************************************************************");
   }
   
    public void changeWeight() throws IOException{
        if (fileCheck()) {
            printStar();
            System.out.println("\t\t" + this.userName + "님의 몸무게는 " + this.textData[0] + "kg 입니다.");
            printStar();
            System.out.println("\t\t변경할 몸무게를 입력하여 주십시오.");
            System.out.print("\t\t변경할 몸무게: ");
            this.userWeight = sc.nextLine();
           
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.userWeight + ":");
            bw.write(this.userPassword);
           
            bw.close();            
        } else {
            return;        
        }
        showResult();
    }
    
    public void changePassword() throws IOException{      
        if (fileCheck()) {
            printStar();
            System.out.println("\t\t" + this.userName + "님의 비밀번호는는 " + this.userPassword + "입니다.");
            printStar();
            System.out.println("\t\t변경할 패스워드를 입력하여 주십시요.");
            System.out.print("\t\t변경할 패스워드: ");
            this.userPassword = sc.nextLine();
           
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.userWeight + ":");
            bw.write(this.userPassword);
            
            bw.close();
        } else {
            return;        
        }
        showResult();
    }
   
    public boolean fileCheck() throws IOException{  
        FileReader fr = null;
        BufferedReader br = null;
        String cmpData;
        boolean boo = false;
       
        System.out.println("검색할 이름을 입력하여 주십시요.");
        System.out.print("이름: ");
        this.userName = sc.nextLine();   
        System.out.println();
       
        file= new File(fileData.getAbsolutePath() + "/"+this.userName + ".txt");
       
        if (file.exists()) {
            fr= new FileReader(file);
            br= new BufferedReader(fr);
            cmpData = br.readLine();
            textData = cmpData.split(":");
          
            br.close();
                       
            for (int cnt = 3; cnt > 0; cnt--) {
                System.out.println("비밀번호를 입력하여 주십시요.");
                System.out.print("비밀번호: ");
                this.userPassword = sc.nextLine();
                System.out.println();
                if (textData[1].equals(this.userPassword)) {
                    this.userWeight = textData[0];
                    boo = true;
                    break;
                } else {
                    if (cnt > 1) {
                       System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
                       System.out.print((cnt-1) + "번의 기회가 남았습니다. 올바른 비밀번호를 입력해주세요. ");
                    } else {
                       System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
                       System.out.println("메뉴 선택을 처음부터 다시 진행합니다.");
                       System.out.println("======================================");
                       System.out.println();
                    }
                }              
            }                              
        } else {
            System.out.println(userName + "님 이(가) 존재하지 않습니다.");
            boo = false;
        }          
        return boo;
    }
           
    public void showResult(){
       System.out.println();
       printStar();
       System.out.println("\t이름 : "+ this.userName +", \t몸무게 : " + this.userWeight + ",\t 비밀번호 : " + this.userPassword);
       printStar();
       System.out.println();
    }
}


//MenuChoiceException
package kr.or.dataobject;

public class MenuChoiceException extends Exception {
    int wrongChoice;
     
    public MenuChoiceException(int choice) {
        super("잘못된 선택이 이뤄졌습니다.");
        wrongChoice = choice;
    }
 
    public void showWrongChoice() {
        System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
    }
}


//Main.java
package kr.or.dataobject;

public class Main {
   public static void main(String[] args) {
      new WeightManager().run();
   }
}