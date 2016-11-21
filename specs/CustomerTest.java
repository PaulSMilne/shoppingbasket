import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;
import shoppingbasket.*;

/**
 * Created by Paul Milne on 21/11/2016.
 */
public class CustomerTest {

    Customer customer;

    @Before
    public void before(){
        Customer customer;
        customer = new Customer("Zippy");
    }

    @Test
    public void getName(){
        String name = customer.getName();
        assertEquals("Zippy", name);
    }

    @Test
    public void getLoyalty(){
        boolean state = customer.getLoyalty();
        assertEquals(false, state);
    }

    @Test
    public void flipLoyalty(){
        customer.flipLoyalty();
        boolean state = customer.getLoyalty();
        assertEquals(true, state);
    }

}