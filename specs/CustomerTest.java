import static org.junit.Assert.*;
import org.junit.*;
import shoppingbasket.*;

public  class CustomerTest{
     Customer customer;

     @Before
     public void before(){
          customer = new Customer("Zippy");
     }

     @Test
     public void canGetName(){
          String name = customer.getName();
          assertEquals("Zippy", name);
     }

     @Test
     public void canGetLoyaltyState(){
          boolean state = customer.getLoyaltyState();
          assertEquals(false, state);
     }

     @Test
     public void canFlipLoyaltyState(){
          customer.flipLoyaltyState();
          boolean state = customer.getLoyaltyState();
          assertEquals(true, state);
          customer.flipLoyaltyState();
          state = customer.getLoyaltyState();
          assertEquals(false, state);
    }


}