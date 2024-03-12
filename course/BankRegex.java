import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankRegex {

	public static void main(String[] args) {
		System.out.println("------아이디-------");
		//입력할 ID
		String idSource1 = "상훈";
		String idSource2 = "123";
		String idSource3 = "rlatkdgns123";
		String idSource4 = "12312312312312";
		
		//ID 정규표현식 조건
		// 8~16자의 알파벳 소문자 또는 대문자 또는 숫자
		Pattern idPattern = Pattern.compile("[a-zA-Z0-9]{8,16}");
		
		//ID 조건에 맞는지 검사
		Matcher idMatcher1 = idPattern.matcher(idSource1);
		Matcher idMatcher2 = idPattern.matcher(idSource2);
		Matcher idMatcher3 = idPattern.matcher(idSource3);
		Matcher idMatcher4 = idPattern.matcher(idSource4);
		
		//결과 출력; true-유효
		System.out.println(idSource1 + ": " + idMatcher1.find());
		System.out.println(idSource2 + ": " + idMatcher2.find());
		System.out.println(idSource3 + ": " + idMatcher3.find());
		System.out.println(idSource4 + ": " + idMatcher4.find());
		
		System.out.println("------비밀번호------");
		//입력할 비밀번호
		String passwordSource1 = "1234";
		String passwordSource2 = "adasdasf";
		String passwordSource3 = "!123123a1231";
		String passwordSource4 = "!Rlatkdgns123";
		
		//비밀번호 정규표현식 조건
		// 10~16자의 알파벳 대문자, 소문자, 숫자, 특수문자를 최소 1개씩 입력
		Pattern passwordPattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,16}");
		
		//비밀번호 조건에 맞는지 검사
		Matcher passwordMatcher1 = passwordPattern.matcher(passwordSource1);
		Matcher passwordMatcher2 = passwordPattern.matcher(passwordSource2);
		Matcher passwordMatcher3 = passwordPattern.matcher(passwordSource3);
		Matcher passwordMatcher4 = passwordPattern.matcher(passwordSource4);
		
		//결과 출력; true-유효
		System.out.println(passwordSource1 + ": " + passwordMatcher1.find());
		System.out.println(passwordSource2 + ": " + passwordMatcher2.find());
		System.out.println(passwordSource3 + ": " + passwordMatcher3.find());
		System.out.println(passwordSource4 + ": " + passwordMatcher4.find());
		
		System.out.println("------계좌번호------");
		//입력할 계좌번호(국민은행)
		String accountNumberSource1 = "1234";
		String accountNumberSource2 = "aaaaa";
		String accountNumberSource3 = "ㅁㅁㅁㅁㅁ";
		String accountNumberSource4 = "324702-01-111111";
		
		//계좌번호(국민은행) 정규표현식 조건
		// 10~16자의 알파벳 대문자, 소문자, 숫자, 특수문자를 최소 1개씩 입력
		Pattern accountNumberPattern = Pattern.compile("324702-[0-9]{2}-[0-9]{6}");
		
		//계좌번호(국민은행) 조건에 맞는지 검사
		Matcher accountNumberMatcher1 = accountNumberPattern.matcher(accountNumberSource1);
		Matcher accountNumberMatcher2 = accountNumberPattern.matcher(accountNumberSource2);
		Matcher accountNumberMatcher3 = accountNumberPattern.matcher(accountNumberSource3);
		Matcher accountNumberMatcher4 = accountNumberPattern.matcher(accountNumberSource4);
		
		//결과 출력; true-유효
		System.out.println(accountNumberSource1 + ": " + accountNumberMatcher1.find());
		System.out.println(accountNumberSource2 + ": " + accountNumberMatcher2.find());
		System.out.println(accountNumberSource3 + ": " + accountNumberMatcher3.find());
		System.out.println(accountNumberSource4 + ": " + accountNumberMatcher4.find());
	}
}
