/*
 최빈수
 0~9 아무거나 10개 입력
 가장 많이 출현한 수를 출력
 배열, for
 */

import java.util.Arrays;
import java.util.Scanner;

public class No03 {
	
	public static void main(String[] args) {
		
		//입력
		Scanner scanner = new Scanner(System.in);
		
		//입력된 값으로 10칸 배열 생성
		int[] input = new int[10];
		
		//입력한 숫자로 배열 생성
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(scanner.nextLine());
		}
		
		//해당 숫자 몇 번 셋는지 카운트용 10칸 배열 생성
		int[] mode = new int[10];
		
		//mode[2] = 5  >>  2가 5번 출현
		for (int i = 0; i < mode.length; i++) {
			mode[input[i]]++;
		}
		
		//최빈수의 카운트 횟수(비교용)
		int modeCount = 0;
		
		//최빈수
		int modeNumber = 0;
		
		for (int i = 0; i < mode.length; i++) {
			//for문 돌면서 새로운 mode[i](0~9중 하나의 횟수)가 더 크다면 그게 최빈수의 횟수
			if (modeCount < mode[i]) {
				modeCount = mode[i];
				//그럼 i는 최빈수
				modeNumber = i;
			}
		}
		
		//검증
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(mode));
		System.out.println(modeNumber);
		System.out.println(modeCount);
		System.out.printf("최빈수: %d, 횟수: %d", modeNumber, modeCount);
	}
}