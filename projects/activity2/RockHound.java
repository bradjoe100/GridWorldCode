/**
 * RockHound.java -
 * A varient of the Critter class that
 * has the ability to eat rocks
 * 
 * @author Grant Zhou
 * @since March 25 2025
 */

 import java.util.ArrayList;

 /**
  * A <code>RockHound</code> eats rocks combined with acting as a critter as
  * it moves through the grid. <br />
  */
 public class RockHound extends Critter
 {
    /**
     * Processes the elements of <code>actors</code>. New actors may be added
     * to empty locations. Implemented to "eat" (i.e. remove) selected actors
     * that are not critters. <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (!(a instanceof Critter))
                a.removeSelfFromGrid();
        }
    }
 }
 