package shoppingbasket;

public class Purchase{

     String name;
     double price;
     boolean bogoffState;

     public Purchase(String name, double price){
          this.name = name;
          this.price = price;
          this.bogoffState = false;
     }

     public String getName(){
          return this.name;
     }

     public double getPrice(){
          return this.price;
     }

     public boolean getBogoffState(){
          return this.bogoffState;
     }

     public void flipBogoffState(){
          if(this.bogoffState == false){
          this.bogoffState = true;
          } else {
               this.bogoffState = false;
          }
     }

}