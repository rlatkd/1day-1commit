//Book.java
public class Book {
	private String title;
	private String price;
	
	public Book(String title, String price) {
		this.title = title;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}


//BookManager.java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookManager {
	private Scanner sc;
	private Map<String, Book> map;
	public BookManager() {
		this.sc = new Scanner(System.in);
		this.map = new HashMap<String, Book>();	
	}
	
	public void run() {
		while(true) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1.추가\t2.삭제\t3.검색\t4.도서 목록\t5.ISBN 목록\t0.종료");
			switch (sc.nextLine()) {
			case "1" :
				addBook();
				break;
			case "2" :
				deleteBook();
				break;
			case "3" :
				searchBook();
				break;
			case "4" :
				viewBookList();
				break;
			case "5" :
				viewIsbnList();
				break;
			case "0" :
				return;
			default : System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
	}

	private void addBook() {
		String isbn;
		while (true) {
			System.out.print("추가할 도서 ISBN: ");
			isbn = sc.nextLine();
			if (map.containsKey(isbn)) {
				System.out.println("이미 존재하는 책입니다. 다시 입력해주세요.");
			} else {
				break;
			}
		}
		System.out.print("도서명: ");
		String title = sc.nextLine();
		System.out.print("가격: ");
		String price = sc.nextLine();

		map.put(isbn, new Book(title, price));
		
		System.out.printf("ISBN: %s\t이름: %s\t가격: %s 생성하였습니다.\n", isbn, title, price);
	}
	private void deleteBook() {
		String isbn;
		while (true) {
			System.out.print("삭제할 도서 ISBN: ");
			isbn = sc.nextLine();
			if (!map.containsKey(isbn)) {
				System.out.println("존재하지 않는 책입니다. 다시 입력해주세요.");
			} else {
				break;
			}
		}
		map.remove(isbn);
		System.out.println("삭제가 완료되었습니다.");
	}
	private void searchBook() {
		String isbn;
		while (true) {
			System.out.println("메인메뉴로 돌아가고 싶으시면 [q!] 를 입력해주세요.");
			System.out.print("검색할 도서 ISBN: ");
			isbn = sc.nextLine();
			if (isbn.equals("q!")) {
				return;
			} else if (!map.containsKey(isbn)) {
				System.out.println("존재하지 않는 책입니다. 다시 입력해주세요.");
			} else {
				break;
			}
		}
		Book book = map.get(isbn);
		System.out.printf("검색 결과>> ISBN: %s\t이름: %s\t가격: %s 입니다.\n", isbn, book.getTitle(), book.getPrice());
	}	
	private void viewBookList() {
		for (Map.Entry<String, Book> m : map.entrySet()) {
			System.out.println(m.getKey() + " / " + m.getValue().getTitle() + " / " + m.getValue().getPrice());
		}
	}
	private void viewIsbnList() {
		for (Map.Entry<String, Book> m : map.entrySet()) {
			System.out.println(m.getKey());
		}
	}
}


//Main.java
public class Main {
	public static void main(String[] args) {
		BookManager bm = new BookManager();
		bm.run();
	}
}
