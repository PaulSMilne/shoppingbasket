package shoppingbasket;

/**
 * Created by user on 21/11/2016.
 */
public class Customer {

    private String name;
    private boolean loyalty;

    public Customer(String name){
        this.name = name;
        this.loyalty = false;
    }

    public String getName(){
        return this.name;
    }

    public boolean getLoyalty(){
        return this.loyalty;
    }

    public void flipLoyalty(){
        boolean currentLoyalty = getLoyalty();
        if (currentLoyalty == false){
            this.loyalty = true;
        }
        this.loyalty = false;
    }
}
