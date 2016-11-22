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
}