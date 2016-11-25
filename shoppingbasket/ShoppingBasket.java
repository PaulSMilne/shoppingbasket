package shoppingbasket;
import java.util.*;

public class ShoppingBasket{

     Customer customer;
     ArrayList<Purchase> purchases;
     Bogof bogof;

     public ShoppingBasket(Customer customer){
          this.customer = customer;
          this.purchases = new ArrayList<Purchase>();
          this.bogof = new Bogof();
     }

     public ArrayList<Purchase> getPurchases(){
          return this.purchases;
     }

     public Customer getCustomer(){
           return this.customer;
     }

     public double addPurchase(purchase){
          boolean bogof = purchase.getBogofState;
          if (bogof == true){
               bogoff.addPurchase();
          } else {
               purchases.add(purchase);
          }
          //other discounts
          return total;
      }

     public double removePurchase(){
          //do some code
          return total;
     }
}