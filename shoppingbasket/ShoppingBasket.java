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
          boolean bogof = purchase.getBogofState();
          if (bogof == true){
               //check if purchase already exists.
               //if no add with quantity as value
               //if yes interate value with quantity
          } else {
               //add to hashmap - if item exists already, iterate int
          }
          //calculate basket total
          return total;
      }

     public double removePurchase(Purchase purchase){
          boolean bogof = purchase.getBogofState();
          if (bogof == true) {
               bogoff.removePurchase(purchase);
          } else {
               //decrease int counter in map, if 0 remove from map
          }
          //calculate basket total
          return total;
     }
}