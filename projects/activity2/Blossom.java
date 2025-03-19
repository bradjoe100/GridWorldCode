/**
 * Blossom.java
 * Contains the Blossom class.
 * 
 * @author Grant Zhou
 * @since March 18, 2025
 */

public class Blossom extends Flower {

    private int lifespan;
    private int age;
    
    public Blossom() {
        super();
        lifespan = 10;
        age = 0;
    }

    public Blossom(int n) {
        super();
        lifespan = n;
        age = 0;
    }

    @Override
    public void act() {
        super.act();
        age++;
        if (age >= lifespan)
            removeSelfFromGrid();
    }
}
