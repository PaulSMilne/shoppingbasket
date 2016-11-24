import java.util.*;
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

    //  @Test
    //  public void canGetCustomerName(){
    //       Customer customer = shoppingbasket.getCustomer();
    //       String name = customer.getName();
    //       assertEquals("Zippy", name);
    //  }

    //  @Test
    //  public void canGetCustomerLoyaltyState(){
    //       Customer thisCustomer = shoppingbasket.getCustomer();
    //       boolean state = thisCustomer.getLoyaltyState();
    //       assertEquals(false, state);
    //  }

    //  @Test
    //  public void canGetPurchasesList(){
    //       ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
    //       assertEquals(0, purchases.size()); 
    //  }

    //  @Test
    //  public void candAddPurchaseToPurchasesList(){
    //       shoppingbasket.addPurchase(purchase1);
    //       ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
    //       assertEquals(1, purchases.size());
    //       shoppingbasket.addPurchase(purchase2);
    //       purchases = shoppingbasket.getPurchases();
    //       assertEquals(2, purchases.size());
    // }

    // @Test
    // public void canRemovePurchaseFromPurchaseList(){
    //     shoppingbasket.addPurchase(purchase1);
    //     shoppingbasket.addPurchase(purchase2);
    //     ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
    //     assertEquals(2, purchases.size());

    //     shoppingbasket.removePurchase(purchase1);
    //     purchases = shoppingbasket.getPurchases();
    //     assertEquals(1, purchases.size());
    // }

    // @Test
    // public void canGetPurchasesSubtotal(){
    //       ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
    //       shoppingbasket.addPurchase(purchase1);
    //       shoppingbasket.addPurchase(purchase2);
    //       shoppingbasket.addPurchase(purchase3);
    //       double subTotal = shoppingbasket.getSubTotal();
    //       assertEquals(140.97, subTotal, 0);
    // }

    //  @Test
    //  public void canGetTotal(){
    //   ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
    //   shoppingbasket.addPurchase(purchase1);
    //   shoppingbasket.addPurchase(purchase2);
    //   shoppingbasket.addPurchase(purchase3);
    //   double total = shoppingbasket.getTotal();
    //   assertEquals(126.87, total, 0.0000);
    // }

    //  @Test
    //  public void canApplyCustomerLoyaltyDiscount(){
    //   ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
    //   shoppingbasket.addPurchase(purchase1);
    //   shoppingbasket.addPurchase(purchase2);
    //   shoppingbasket.addPurchase(purchase3);
    //   customer.flipLoyaltyState();
    //   double total = shoppingbasket.getTotal();
    //   assertEquals(124.33, total, 0.00);
    // }

    @Test
    public void canGetBogofDiscount(){
      ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
      purchase1.flipBogofState();
      purchase2.flipBogofState();
      purchase3.flipBogofState();
      shoppingbasket.addPurchase(purchase1);
      shoppingbasket.addPurchase(purchase1);
      //shoppingbasket.addPurchase(purchase1);
      // shoppingbasket.addPurchase(purchase2);
      // shoppingbasket.addPurchase(purchase2);
      // shoppingbasket.addPurchase(purchase3);
      double discount = shoppingbasket.bogofDiscount();
      assertEquals(14.99, discount, 0);
    }

//     @Test
//     public void canGetGrandTotalwithAllDiscounts(){
//       ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
//       purchase1.flipBogofState();
//       purchase2.flipBogofState();
//       customer.flipLoyaltyState();
//       shoppingbasket.addPurchase(purchase1);
//       shoppingbasket.addPurchase(purchase2);
//       shoppingbasket.addPurchase(purchase3);
//       double total = shoppingbasket.getTotal();
//       assertEquals(111.11 ,total, 0);
//     }

//     @Test
//     public void underTwentyTotal(){
//       Purchase purchase1 = new Purchase("Mini Widget", 5.99);
//       Purchase purchase2 = new Purchase("Micro Widget", 1.99);
//       shoppingbasket.addPurchase(purchase1);
//       shoppingbasket.addPurchase(purchase2);
//       double total = shoppingbasket.getTotal();
//       assertEquals(7.98, total, 0);
//     }

//     @Test
//     public void oneItemTotal(){
//       purchase1.flipBogofState();
//       shoppingbasket.addPurchase(purchase1);
//       double total = shoppingbasket.getTotal();
//       assertEquals(14.99, total, 0);
//       customer.flipLoyaltyState();
//       total = shoppingbasket.getTotal();
//       assertEquals(14.69, total, 0);
//     }
//   @Test
//   public void twoItemBogofTotal(){
//     purchase1.flipBogofState();
//     purchase2.flipBogofState();
//     shoppingbasket.addPurchase(purchase1);
//     shoppingbasket.addPurchase(purchase2);
//     double total = shoppingbasket.getTotal();
//     assertEquals(23.39, total, 0);
//   }
  
//   @Test
//   public void twoItemsOneBogofTotal(){
//     Purchase purchase1 = new Purchase("Mini Widget", 5.99);
//     Purchase purchase2 = new Purchase("Micro Widget", 1.99);
//     purchase2.flipBogofState();
//     shoppingbasket.addPurchase(purchase1);
//     shoppingbasket.addPurchase(purchase2);
//     double total = shoppingbasket.getTotal();
//     assertEquals(7.98, total, 0);
//   }

//   @Test
//   public void canDiscountByPercentage(){
//     double discounted = shoppingbasket.discountByPercentage(57.99, 2.00);
//     assertEquals(56.83, discounted, 0);
//   }
}