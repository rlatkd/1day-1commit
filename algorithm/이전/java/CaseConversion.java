/*
 
 대문자 -> 소문자
 소문자 -> 대문자
 
 배열, for, if
 
 ASCII A:65~Z:90 a:97~z:122
 */

public class CaseCoversion {

	public static void main(String[] args) {
		
		String str = "heLlOWOrlD";
		
		char[] arr;
		
		//String타입의 데이터를 char타입의 배열로 변환
		arr = str.toCharArray();
		
		System.out.println(arr);  //heLlOWOrlD
		
		
		for (int i = 0; i < arr.length; i++) {
			
			//해당 글자가 A~Z사이(대문자)면
			if (arr[i] >= 'A' && arr[i] <= 'Z') {
				
				//소문자로 변경
				arr[i] = (char) (arr[i] + ('a' - 'A'));
				
			//해당 글자가 a~z사이(소문자)면
			} else if (arr[i] >= 'a' && arr[i] <= 'z') {
				
				//대문자로 변경
				arr[i] = (char) (arr[i] - ('a' - 'A'));
			}
		}
		
		System.out.println(arr);  //heLlOWOrlD
		
		/*
		foreach는 기존 배열이 바뀌지않음 (여기서 사용하면 안됨)
		for (char c : arr) {
			if (c >= 'A' && c <= 'Z') {
				c = (char) (c + ('a' - 'A'));
			} else if (c >= 'a' && c <= 'z') {
				c = (char) (c - ('a' - 'A'));
			}
		}
		System.out.println(arr);  //heLlOWOrlD
		*/
	}
}
