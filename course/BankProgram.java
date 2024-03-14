//BankProgram
package quiz.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankProgram {
   public static void main(String[] args) {
      Bank bank = new Bank();
      Scanner sc = new Scanner(System.in);
      while(true) {
         System.out.println("1. 전체 계좌 목록\t2. 계좌 등록\t3.소유주명으로 계좌 조회\t4.입금\t5.출금\t6.거래내역 조회\t0.종료");
         switch(sc.nextLine()) {
            case "1" :
               List<Account> accounts = bank.getAccounts();
               printAccounts(accounts);
               break;
            case "2" :
               System.out.print("계좌 번호 : ");
               String accountno = sc.nextLine();
               System.out.print("계좌 소유주 : ");
               String name = sc.nextLine();
               System.out.print("잔액 : ");
               long balance = Integer.parseInt(sc.nextLine());
               bank.addAccount(accountno, name, balance);   
               break;
            case "3" :
               System.out.print("계좌 소유주 : ");
               name = sc.nextLine();
               printAccounts(bank.findAccount(name));
               break;
            case "4" :
               System.out.print("계좌 번호 : ");
               accountno = sc.nextLine();
               System.out.print("금액 : ");
               long amount = Integer.parseInt(sc.nextLine());
               
               Account account = bank.getAccount(accountno);
               if(account == null) break;
               account.deposit(amount);
               System.out.printf("입금 금액: %d, 잔액 : %d\n", amount, account.getBalance());
               break;
            case "5" :
               System.out.print("계좌 번호 : ");
               accountno = sc.nextLine();
               System.out.print("금액 : ");
               amount = Integer.parseInt(sc.nextLine());
               
               account = bank.getAccount(accountno);
               if(account == null) break;
               if(account.withdraw(amount))
                  System.out.printf("출금 금액: %d, 잔액 : %d\n", amount, account.getBalance());
               break;
            case "6" :
               System.out.print("계좌 번호 : ");
               accountno = sc.nextLine();
               account = bank.getAccount(accountno);
               if(account == null) break;
               List<Transaction> transactions = account.getTransactions();
               printTransactions(transactions);
               break;
            case "0" :
               System.out.println("종료합니다.");
               return;
            default : break;
         }
      }
   }
   public static void printTransactions(List<Transaction> transactions) {
      for(Transaction transaction : transactions) {
         System.out.printf("[금액 : %d(%s), 잔액 : %d, 시간 : %s]\n", transaction.getAmount(), transaction.getKind(), transaction.getBalance(), transaction.getTransactionDateTime());
      }
   }
   public static void printAccounts(List<Account> accounts) {
      for(Account account : accounts) {
         System.out.printf("[계좌번호 : %s, 소유자명 : %s, 잔액 : %d]\n", account.getAccountNo(), account.getName(), account.getBalance());
      }
   }
}

//Bank
package quiz.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
   private List<Account> accounts;
   
   public Bank() {
      this.accounts = new ArrayList<>();
   }
   public void addAccount(String accountNo, String name, long balance) {
      for(Account account : this.accounts) {
         if(account.getAccountNo().equals(accountNo)) {
            System.out.println("계좌 번호 겹침");
            return;
         }
      }
      this.accounts.add(new Account(accountNo, name, balance)); 
   }
   public Account getAccount(String accountNo) {
      for(Account account : this.accounts) {
         if(account.getAccountNo().equals(accountNo)) {
            return account;
         }
      }
      System.out.println("해당 계좌는 존재하지 않음");
      return null;
   }
   public List<Account> findAccount(String name) {
      List<Account> myAccounts = new ArrayList<>();
      for(Account account : this.accounts) {
         if(account.getName().equals(name)) {
            myAccounts.add(account);
         }
      }
      return myAccounts;
   }
   public List<Account> getAccounts() {
      return this.accounts;
   }
   public int getTotalAccount() {
      return accounts.size();
   }
}

//Account
package quiz.bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Account {
   private String accountNo;
   private String name;
   private long balance;
   private List<Transaction> transactions;
   private DateTimeFormatter formatter;

   public Account(String accountNo, String name, long balance) {
      this.accountNo = accountNo;
      this.name = name;
      this.balance = balance;
      this.transactions = new ArrayList<>();
      this.formatter = DateTimeFormatter.ofPattern("yyyy년MM월dd일HH시mm분");
   }
   public void deposit(long amount) {
      this.balance += amount;
        LocalDateTime currentTime = LocalDateTime.now();
      Transaction transaction = new Transaction(currentTime.format(formatter), "입금", amount, balance);
      this.transactions.add(transaction);
   }
   public boolean withdraw(long amount) {
      if(balance < amount) {
         System.out.println("잔액 부족");
         return false;
      }
      balance -= amount;
        LocalDateTime currentTime = LocalDateTime.now();
      Transaction transaction = new Transaction(currentTime.format(formatter), "출금", amount, balance);
      this.transactions.add(transaction);
      return true;
   }
   public long getBalance() {
      return this.balance;
   }
   public List<Transaction> getTransactions() {
      return this.transactions;
   }
}

//Transaction
package quiz.bank;

import lombok.Data;

@Data
public class Transaction {
   private String transactionDateTime;
   private String kind;
   private long amount;
   private long balance;
   
   public Transaction(String transactionDateTime, String kind, long amount, long balance) {
      this.transactionDateTime = transactionDateTime;
      this.kind = kind;
      this.amount = amount;
      this.balance = balance;
   }
}
