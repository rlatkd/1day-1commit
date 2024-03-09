public class Star {

	public static void main(String[] args) {
		
		for (int i1=1; i1<=10; i1++) {
			for (int j1=1; j1<=10; j1++) {
				if (i1==j1) {
					break;
				}
				System.out.printf("%s", "*");
			}
			System.out.println();
		}

    }

}

public class Star {

	public static void main(String[] args) {
		
		for (int i2=10; i2>0; i2--) {
			for (int j2=1; j2<i2; j2++) {
				System.out.printf("%s", "*");
			}
			System.out.println();
		}

    }

}

public class Star {

	public static void main(String[] args) {
		
		for (int i3=1; i3<=10; i3++) {
			for (int j3=0; j3<i3; j3++) {
				System.out.printf("%s", "*");
			}
			System.out.println();
		}
		for (int i4=0; i4<10; i4++) {
			for (int j4=9; j4>i4; j4--) {
				System.out.printf("%s", "*");
			}
			System.out.println();
		}

    }

}