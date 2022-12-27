package kiosk.cartframe;

import java.util.Random;

public class GenerateCardNum {

   String number;
   
   public String getNumber() {
      return number;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   private static Random r;
   
   final private static String CARD_NUMBER = "0123456789";
   
   public GenerateCardNum() {
   }
   
   public static String  randomCardNumber() {
      if (r == null) {
         r = new Random();
      }
      StringBuilder sb = new StringBuilder();
      
      sb.append(
            String.format("%04d-%04d-%04d-%04d", 
                  (r.nextInt(9999) + 0),
                  (r.nextInt(9999) + 0),
                  (r.nextInt(9999) + 0),
                  (r.nextInt(9999) + 0))
            );
      return sb.toString();
   }
   
   @Override
	public String toString() {
		return super.toString();
	}
   
   public static void main(String[] args) {
	System.out.println(new GenerateCardNum().randomCardNumber());
}
   
}