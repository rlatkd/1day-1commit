import javax.swing.JOptionPane;

class TimerThread extends Thread {
	
	static boolean isTimeOver = false;

	@Override
	public void run() {
		for (int i = 10; i > 0 ; i--) {
			try {
				System.out.println("남은 시간: " + i);
				Thread.sleep(1000);
			} 	catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		isTimeOver = true;
	}
}

class InputThread extends Thread {
	
	private int right;
	private int wrong;
	
	public int getRight() {
		return right;
	}

	public int getWrong() {
		return wrong;
	}
	
	public float getRightPercent() {
		try {
			return (float) right / (right + wrong);
		} catch (ArithmeticException e) {
			return 0;
		}
	}

	@Override
	public void run() {
		while(true) {
			int random1 = (int) (Math.random() * 8) + 2;
			int random2 = (int) (Math.random() * 8) + 2;
			int result = random1 * random2;
		
			String inputData = JOptionPane.showInputDialog(random1 + "X" + random2);
			
			if (TimerThread.isTimeOver) return;
			
			try {
				if (inputData != null && !inputData.equals("") && Integer.parseInt(inputData) == result) {
					System.out.println("정답입니다");
					right += 1;
				} else {
					System.out.println("오답입니다");
					wrong += 1;
				}
			} catch (NumberFormatException e) {
				System.out.println("오답입니다");
				wrong += 1;
			}
		}
	}
}

public class GugudanMultiThread {

	public static void main(String[] args) {
		TimerThread timer = new TimerThread();
		timer.start();
		
		InputThread input = new InputThread();
		input.start();
		
		try {
			timer.join(); 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		input.interrupt();
		System.out.printf("정답수: %d개, 오답수: %d개, 정답률: %.2f%%", input.getRight(),input.getWrong(), input.getRightPercent()*100);
	}
}
