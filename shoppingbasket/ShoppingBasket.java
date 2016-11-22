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

          //take the common items in the two lists out of the purchases list
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

         //create an empty List for the prices of the bogof items
          ArrayList<Double> bogofPrices = new ArrayList<Double>();

          for (Purchase item : purchases){
               boolean state = item.getBogofState();
               if (state == true) {
                    double price = item.getPrice();
                    bogofPrices.add(price);
               }
          }

          //checks if there is more than one item in the list
          if (bogofPrices.size() >= 2) {
               
               //gets size of price list and half that to get the number of items to discount
               int bogofPriceListSize = bogofPrices.size();
               int bogofPriceListExtent = bogofPriceListSize / 2;

               //the price list is sorted with lowest price first
               Collections.sort(bogofPrices);

               //Creates a sublist of lowest half of prices to add together for the total discount. Will work for both odd and even numbers of prices.
               List<Double> freebies = bogofPrices.subList(0, bogofPriceListExtent);

               double discount = 0.00;

               for (double price : freebies) {
                    discount += price;
               }
               return discount;
          } else {
               return 0.00; //if there is only item there is no discount
          }
     }

     public double getTotal(){ //applies 2% loyalty discount
          double subTotal = getSubTotal();

          double bogofDiscount = bogofDiscount();
          subTotal -= bogofDiscount;

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