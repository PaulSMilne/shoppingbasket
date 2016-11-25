package shoppingbasket;
import java.util.*;

public class ShoppingBasket{

     Customer customer;
     ArrayList<Purchase> purchases;
     boolean loyalty;

     public ShoppingBasket(Customer customer){
          this.customer = customer;
          this.loyalty = customer.getLoyaltyState();
          this.purchases = new ArrayList<Purchase>();
     }

     public Customer getCustomer(){
          return this.customer;
     }

     public boolean getCustomerLoyalty(){
          Customer customer = getCustomer();
          boolean loyalty = customer.getLoyaltyState();
          return loyalty; 
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

     // public double bogofDiscount(){
     //      ArrayList<Purchase> purchases = getPurchases();

     //      List<Purchase> bogofItems = new ArrayList<Purchase>();

     //      for (Purchase item : purchases){
     //           boolean state = item.getBogofState();
     //           if (state == true) {
     //                bogofItems.add(item); // gets list of bogof items
     //           }
     //      }
     //      Double totalDiscount = 0.00;
     //      Map<Purchase, Integer> bogofFrequency = new HashMap<Purchase,Integer>();
     //      for (Purchase item : bogofItems){
     //           int frequency = Collections.frequency(bogofItems, item);
     //           if (frequency > 1){
     //           Integer count = bogofFrequency.get(item);
     //           bogofFrequency.put(item, (frequency==null) ? 1 : frequency + 1);
     //           }
     //      }
     //      //      if (frequency > 1){
     //      //           int multiplier = frequency/2;
     //      //           double price = item.getPrice();
     //      //           double itemDiscount = price*multiplier;
     //      //           totalDiscount += itemDiscount;
     //           }
     //      }
     //      return totalDiscount;
     // }

     public double getTotal(){ 
          double subTotal = getSubTotal();

          // double bogofDiscount = bogofDiscount();
          // subTotal -= bogofDiscount;

          if (subTotal > 20.00) {
               subTotal = Discount.overTwenty(subTotal);
          }

          if (loyalty == true) {
               double total = Discount.loyaltyCard(subTotal);
               return total;
          } else {
               double total = subTotal;
               return total;
          }
     }
 }