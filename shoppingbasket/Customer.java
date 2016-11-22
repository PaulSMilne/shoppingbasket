package shoppingbasket;

public class Customer{

     String name;
     boolean loyaltyState;

     public Customer(String name){
          this.name = name;
          this.loyaltyState = false;
     }

     public String getName(){
          return this.name;
     }

     public boolean getLoyaltyState(){
          return this.loyaltyState;
     }

     public void flipLoyaltyState(){
          if (this.loyaltyState == false){
               this.loyaltyState = true;
          } else {
               this.loyaltyState = false;
          }
     }

}