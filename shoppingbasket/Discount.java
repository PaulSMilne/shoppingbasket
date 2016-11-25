package shoppingbasket;
import java.util.*;

public class Discount{

     static double discountByPercentage(double subTotal, double percentage){
          double multiplier = percentage/100;
          double discounted = subTotal -= subTotal*multiplier;
          discounted = discounted*100;
          discounted = Math.round(discounted);
          discounted = discounted/100;
          return discounted;
     }

     public static double overTwenty(double subtotal){
          double subTotal = discountByPercentage(subtotal, 10);
          return subTotal;
     }

     public static double loyaltyCard(double subtotal){
          double subTotal = discountByPercentage(subtotal, 2);
          return subTotal;
     }


}