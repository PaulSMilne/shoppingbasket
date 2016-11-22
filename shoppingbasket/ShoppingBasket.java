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

     public double getTotal(){ //applies 2% loyalty discount
          double subTotal = getSubTotal();
          double bogoffDiscount = bogoffDiscount();
          subTotal -= bogoffDiscount;
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

     public double bogoffDiscount(){

          ArrayList<Purchase> purchases = getPurchases();

          ArrayList<Double> bogoffPrices = new ArrayList<Double>();

          for (Purchase item : purchases){
               boolean state = item.getBogoffState();
               if (state == true) {
                    double price = item.getPrice();
                    bogoffPrices.add(price);
               }
          }
          int bogoffPriceListSize = bogoffPrices.size();
          int bogoffPriceListExtent = bogoffPriceListSize / 2;

          Collections.sort(bogoffPrices);

          List<Double> freebies = bogoffPrices.subList(0, bogoffPriceListExtent);

          double discount = 0.00;

          for (double price : freebies) {
               discount += price;
          }
          return discount;
     }
}