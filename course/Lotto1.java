public class Lotto1 {

   public static void main(String[] args) {
      
      int[] numarr = new int[6];
      
      for(int i = 0; i < numarr.length; i++) {
         numarr[i] = (int) (Math.random() * 45 + 1);
         for(int j = 0; j < i; j++) {
            if(numarr[j] == numarr[i]) { // 중복값 검사
               i--;
               break;
            }
         }
      }
      
      for(int num : numarr) System.out.println(num);
      System.out.println();
      
      for(int i = 0; i < numarr.length; i++) { // 버블 정렬
         for(int j = 0; j < numarr.length - i - 1; j++) { 
            if(numarr[j] > numarr[j + 1]) { 
               int temp = numarr[j];
               numarr[j] = numarr[j + 1];
               numarr[j + 1] = temp; 
            }
         }
      }
      
      for(int num : numarr) System.out.println(num);
      
   }
}