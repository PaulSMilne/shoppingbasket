package shoppingbasket;

public class Purchase{

     String name;
     double price;
     boolean bogofState;

     public Purchase(String name, double price){
          this.name = name;
          this.price = price;
          this.bogofState = false;
     }

     public String getName(){
          return this.name;
     }

     public double getPrice(){
          return this.price;
     }

     public boolean getBogofState(){
          return this.bogofState;
     }

     public void flipBogofState(){
          if(this.bogofState == false){
          this.bogofState = true;
          } else {
               this.bogofState = false;
          }
     }

}