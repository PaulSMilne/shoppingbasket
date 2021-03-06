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
          ArrayList<Purchase> purchases = getPurchases();
          ArrayList<Purchase> removal = new ArrayList<Purchase>(); // to hold item/s to remove from purchases

          removal.add(purchase);
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

     public double bogofDiscount(){

          ArrayList<Purchase> purchases = getPurchases();
          ArrayList<Double> bogofPrices = new ArrayList<Double>();

          for (Purchase item : purchases){
               boolean state = item.getBogofState();
               if (state == true) {
                    double price = item.getPrice();
                    bogofPrices.add(price); // gets list of prices of bogof items
               }
          }

          if (bogofPrices.size() >= 2) {
               int bogofPriceListSize = bogofPrices.size();
               int bogofPriceListExtent = bogofPriceListSize / 2; // determines how many of the cheaper items to add together
               Collections.sort(bogofPrices); // sorts ascending from cheapest item
               List<Double> freebies = bogofPrices.subList(0, bogofPriceListExtent); // makes new list of cheapest half of list

               double discount = 0.00;
               for (double price : freebies) {
                    discount += price;
               }
               return discount; // returns total of prices in the cheapest half of the list
          } else {
               return 0.00; // if there is only item discount is 0
          }
     }
     public double discountByPercentage(double subTotal, double percentage){
          double multiplier = percentage/100;
          double discounted = subTotal -= subTotal*multiplier;
          discounted = discounted*100;
          discounted = Math.round(discounted);
          discounted = discounted/100;
          return discounted;
     }

     public double getTotal(){ //applies 2% loyalty discount
          double subTotal = getSubTotal();
          double bogofDiscount = bogofDiscount();
          subTotal -= bogofDiscount;
          if (subTotal > 20.00) {
               subTotal = discountByPercentage(subTotal, 10);
          }
          boolean state = customer.getLoyaltyState();
          if (state == true) {
               double total = discountByPercentage(subTotal, 2);
               return total;
          } else {
               double total = subTotal;
               return total;
          }
     }
 }