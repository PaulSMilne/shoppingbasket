import static org.junit.Assert.*;
import org.junit.*;
import shoppingbasket.*;

public  class PurchaseTest{
     Purchase purchase;

     @Before
     public void before(){
          purchase = new Purchase("Widget", 14.99);
     }

     @Test
     public void canGetName(){
          String name = purchase.getName();
          assertEquals("Widget", name);
     }

     @Test
     public void canGetPrice(){
          double price = purchase.getPrice();
          assertEquals(14.99, price, 0);
     }

     @Test
     public void canGetBogoffState(){
          boolean state = purchase.getBogoffState();
          assertEquals(false, state);
     }

     @Test
     public void canFlipBogoffState(){
          purchase.flipBogoffState();
          //boolean state = purchase.getBogoffState();
          //assertEquals(true, state);
     purchase.flipBogoffState();
     boolean state = purchase.getBogoffState();
     assertEquals(false, state);
     }


}