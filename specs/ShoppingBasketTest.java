import static org.junit.Assert.*;
import org.junit.*;
import shoppingbasket.*;

public  class ShoppingBasketTest{
     ShoppingBasket shoppingbasket;
     Customer customer;
     Purchase purchase1;
     Purchase purchase2;
     Purchase purchase3;

     @Before
     public void before(){
          customer = new Customer("Zippy");
          purchase1 = new Purchase("Basic Widget", 14.99);
          purchase2 = new Purchase("Advanced Widget", 25.99);
          purchase3 = new Purchase("Deluxe Widget", 99.99);
          shoppingbasket = new ShoppingBasket(customer);
     }

     @Test
     public void canGetCustomerName(){
          Customer customer = shoppingbasket.getCustomer();
          String name = customer.getName();
          assertEquals("Zippy", name);
     }



}