package shoppingbasket;
import java.util.*;

public class ShoppingBasket{

     Customer customer;
     ArrayList<Purchase> purchases;

     public ShoppingBasket(Customer customer){
          this.customer = customer;
          this.purchases = new ArrayList<Purchase>();
     }

     public Customer getCustomer(){
          return this.customer;
     }

     public ArrayList<Purchase> getPurchases(){
          return this.purchases;
     }

     public double getSubTotal(){
          double subTotal = 0.00;
          for (Purchase purchase : purchases){
               double price = purchase.getPrice();
               subTotal += price;
          }
          return subTotal;
     }

     public double applyLoyaltyDiscount(){ //applies 2% loyalty discount
          double subTotal = getSubTotal();
          boolean state = customer.getLoyaltyState();
          if (state == true) {
               double total = subTotal -= (subTotal * 0.02);
               total = total*100; // code for rounding
               total = Math.round(total);
               total = total/100;
               return total;
          } else {
               double total = subTotal;
               return total;
          }
     }
}