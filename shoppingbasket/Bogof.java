package shoppingbasket;
import java.util.*;

public class Bogof{

     HashMap<Purchase, int> bogofs;

     public Bogof(){
          this.bogofs = new HashMap<Purchase, int>();
     }

     public HashMap<Purchase, int> getBogofs{
          return this.bogofs;
     }

     public void setBogofs(Purchase purchase, int quantity){
          Bogof bogofs = getBogofs();
          if (quantity == 0){
               bogofs.remove(purchase);
          } else {
          bogofs.put(purchase, quantity);
          }
     }

     public double getBogofTotal(){
          double bogofTotal = 0.00;
          Bogof bogofs = getBogofs;
          for (Entry<KeyClass, ValueClass> entry : bogofs.entrySet()){
               Purchase purchase = bogofs.getKey();
               int quantity = bogofs.getValue();
               int mulitiplier = quantity / 2;
               double price = purchase.getPrice();
               double returnPrice = price*multiplier;
               bogofTotal += returnPrice;
          }
          return bogofTotal;
     }

}