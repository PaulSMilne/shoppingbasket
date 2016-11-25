import static org.junit.Assert.*;
import org.junit.*;
import shoppingbasket.*;

public  class DiscountTest{

     double subtotal;

     @Before
     public void before(){
          subtotal = 100.00;
     }


     @Test
     public void canDiscountTenPercent(){
          double subTotal = Discount.overTwenty(subtotal);
          assertEquals(90.00, subTotal, 0);
     }

     @Test
     public void canDiscountTwoPercent(){
          double subTotal = Discount.loyaltyCard(subtotal);
          assertEquals(98.00, subTotal, 0);
     }
}

