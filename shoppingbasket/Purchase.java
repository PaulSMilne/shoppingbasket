package shoppingbasket;

public class Purchase{

     String name;
     double price;
     boolean bogofState;
     boolean eligible;

     public Purchase(String name, double price){
          this.name = name;
          this.price = price;
          this.bogofState = false;
          this.eligible = true;
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

     public boolean getEligible(){
          return this.eligible;
     }

     public void flipBogofState(){
          if(this.bogofState == false){
          this.bogofState = true;
          } else {
               this.bogofState = false;
          }
     }

     public void flipEligibleState(){
          if(this.eligible == true){
          this.eligible = false;
          } else {
               this.eligible = true;
          }
     }

}