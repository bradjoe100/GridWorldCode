/** 
 * ChameleonKid.java -
 * Behaves similarily to the Chameleon Critter class,
 * but only checks the front and back to change colors,
 * and darkens if no color is found.
 * 
 * @author Grant Zhou
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

 /**
  * A <code>ChameleonKid</code> takes on the color of the front and back actors as
  * it moves through the grid. <br />
  */
 public class ChameleonKid extends ChameleonCritter
 {
     private static final double DARKENING_FACTOR = 0.1;

    
    /**
     * Gets the actors for processing. Implemented to return the actors that
     * occupy neighboring grid locations. Override this method in subclasses to
     * look elsewhere for actors to process.<br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        int dirs[] = new int[]{ getDirection(), getDirection() + Location.HALF_CIRCLE };
        ArrayList<Actor> neighbors = new ArrayList<Actor>();
        for (int dir : dirs)
           if (getGrid().isValid(getLocation().getAdjacentLocation(dir)) && 
               getGrid().get(getLocation().getAdjacentLocation(dir)) != null)
               neighbors.add(getGrid().get(getLocation().getAdjacentLocation(dir)));
        return neighbors;
    }

     /**
      * Randomly selects a neighbor from the front or back and changes this critter's color to be the
      * same as that neighbor's. If there are no neighbors in the front or back, color is darkened.
      */
     public void processActors(ArrayList<Actor> actors)
     {
        if (actors.isEmpty()) {
            Color c = getColor();
            int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
            int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
            int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
            setColor(new Color(red, green, blue));
            return;
        }

        int r = (int) (Math.random() * actors.size());
        Actor other = actors.get(r);
        setColor(other.getColor());
     }
 }
 