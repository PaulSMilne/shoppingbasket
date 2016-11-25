package shoppingbasket;
import java.util.*;

public class ShoppingBasket{

     Customer customer;
     ArrayList<Purchase> purchases;

     public ShoppingBasket(Customer customer){
          this.customer = customer;
          this.purchases = new ArrayList<Purchase>();
     }

     public ArrayList<Purchase> getPurchases(){
          return this.purchases;
     }

     public Customer getCustomer(){
           return this.customer;
     }

     public double addPurchase(purchase){
          //do some code
          return total;
      }

     public double removePurchase(){
          //do some code
          return total;
     }
}