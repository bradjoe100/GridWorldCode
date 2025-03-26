/**
 *  KingCrab.java -
 *  Similar to the CrabCritter, but actors will move away from it
 *  when neighboring it.
 */

import java.util.ArrayList;
 
 /**
  * A <code>KingCrab</code> looks at a limited set of neighbors when it eats and moves.
  * <br />
  */
 public class KingCrab extends CrabCritter
 {

    /**
     * Processes the elements of <code>actors</code>. Actors may move themselves
     * to new locations. Implemented to "eat" (i.e. remove) selected actors
     * that cannot run away. <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            Location aMoveLoc = a.getLocation().getAdjacentLocation(getLocation().getDirectionToward(a.getLocation()));
            if (getGrid().isValid(aMoveLoc))
                a.moveTo(aMoveLoc);
            else
                a.removeSelfFromGrid();
        }
    }
 }
 