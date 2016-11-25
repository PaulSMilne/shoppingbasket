package shoppingbasket;
import java.util.*;

public class ShoppingBasket{

     Customer customer;
     HashMap<Purchase, int> purchases;
     Bogof bogof;

     public ShoppingBasket(Customer customer){
          this.customer = customer;
          this.purchases = new Hashmap<Purchase, int>();
          this.bogof = new Bogof();
     }

     public HashMap<Purchase, 1> getPurchases(){
          return this.purchases;
     }

     public Customer getCustomer(){
           return this.customer;
     }

     public double addPurchase(Purchase purchase, int quantity){
          boolean bogofState = purchase.getBogofState();
          if (bogofState == true){
               bogof.addPurchase(purchase, quantity)
          } else {
               //put to this.purchases
          }
          //calculate basket total
          return total;
      }

     public double removePurchase(Purchase purchase, int quantity){
          boolean bogofState = purchase.getBogofState();
          if (bogofState == true) {
               bogof.removePurchase(purchase, quantity)
          } else {
               //replace item in Hashmap with new params, if quantity == 0 remove from map
          }
          //calculate basket total
          return total;
     }
}