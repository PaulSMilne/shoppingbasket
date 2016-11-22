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

     @Test
     public void canGetCustomerName(){
          Customer customer = shoppingbasket.getCustomer();
          String name = customer.getName();
          assertEquals("Zippy", name);
     }

     @Test
     public void canGetCustomerLoyaltyState(){
          Customer thisCustomer = shoppingbasket.getCustomer();
          boolean state = thisCustomer.getLoyaltyState();
          assertEquals(false, state);
     }

     @Test
     public void canGetPurchasesList(){
          ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
          assertEquals(0, purchases.size()); 
     }

     @Test
     public void candAddPurchaseToPurchasesList(){
          ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
          purchases.add(purchase1);
          assertEquals(1, purchases.size());
          purchases.add(purchase1);
          assertEquals(2, purchases.size());
    }

    @Test
    public void canGetPurchasesSubtotal(){
          ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
          purchases.add(purchase1);
          purchases.add(purchase2);
          purchases.add(purchase3);
          double subTotal = shoppingbasket.getSubTotal();
          assertEquals(140.97, subTotal, 0);
    }

     @Test
     public void canGetTotal(){
      ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
      purchases.add(purchase1);
      purchases.add(purchase2);
      purchases.add(purchase3);
      double total = shoppingbasket.getTotal();
      assertEquals(140.97, total, 0.0000);
    }

     @Test
     public void canApplyCustomerLoyaltyDiscount(){
      ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
      purchases.add(purchase1);
      purchases.add(purchase2);
      purchases.add(purchase3);
      customer.flipLoyaltyState();
      double total = shoppingbasket.getTotal();
      assertEquals(138.15, total, 0.00);
    }

    @Test
    public void canGetBogoffDiscount(){
      ArrayList<Purchase> purchases = shoppingbasket.getPurchases();

      Purchase purchase4 = new Purchase("Mini Widget", 5.99);
      Purchase purchase5 = new Purchase("Micro Widget", 1.99);

      purchase1.flipBogoffState();
      purchase2.flipBogoffState();
      purchase3.flipBogoffState();
      purchase4.flipBogoffState();
      purchases.add(purchase1);
      purchases.add(purchase2);
      purchases.add(purchase3);
      purchases.add(purchase4);
      purchases.add(purchase5);
      double subTotal = shoppingbasket.bogoffDiscount();
      assertEquals(20.98, subTotal, 0);
    }

    @Test
    public void canGetGrandTotalwithAllDiscounts(){
      ArrayList<Purchase> purchases = shoppingbasket.getPurchases();
      purchase1.flipBogoffState();
      purchase2.flipBogoffState();
      customer.flipLoyaltyState();
      purchases.add(purchase1);
      purchases.add(purchase2);
      purchases.add(purchase3);
      double total = shoppingbasket.getTotal();
      assertEquals(123.46 ,total, 0);
    }
}