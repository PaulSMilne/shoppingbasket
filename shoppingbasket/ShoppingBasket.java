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

     public void addPurchase(Purchase purchase){
          ArrayList<Purchase> purchases = getPurchases();
          purchases.add(purchase);
     }

     public void removePurchase(Purchase purchase){

          //create a new list with the item to remove
          ArrayList<Purchase> removal = new ArrayList<Purchase>();
          removal.add(purchase);

          ArrayList<Purchase> purchases = getPurchases();

          //removeAll takes the common items in the two lists out of the purchases list.
          purchases.removeAll(removal); 
     }

     public double getSubTotal(){
          double subTotal = 0.00;
          for (Purchase purchase : purchases){
               double price = purchase.getPrice();
               subTotal += price;
          }
          return subTotal;
     }

     public double bogoffDiscount(){
          ArrayList<Purchase> purchases = getPurchases();

          //create an empty List for the prices of the bogoff items
          ArrayList<Double> bogoffPrices = new ArrayList<Double>();

          for (Purchase item : purchases){
               boolean state = item.getBogoffState();
               if (state == true) {
                    double price = item.getPrice();
                    bogoffPrices.add(price);
               }
          }

          //get size of price list and half that to get the number of items to discount
          int bogoffPriceListSize = bogoffPrices.size();
          int bogoffPriceListExtent = bogoffPriceListSize / 2;

          //the price list is sorted with lowest price first
          Collections.sort(bogoffPrices);

          //creates a sublist of lowest half of prices to add together for the total discount
          List<Double> freebies = bogoffPrices.subList(0, bogoffPriceListExtent);

          double discount = 0.00;

          for (double price : freebies) {
               discount += price;
          }
          return discount;
     }

     public double getTotal(){ //applies 2% loyalty discount
          double subTotal = getSubTotal();

          double bogoffDiscount = bogoffDiscount();
          subTotal -= bogoffDiscount;

          if (subTotal > 20.00) {
               double tenPerCentDiscount = subTotal*0.10;
               subTotal -= tenPerCentDiscount;
               subTotal = subTotal*100; // code for rounding
               subTotal = Math.round(subTotal);
               subTotal = subTotal/100;
          }

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