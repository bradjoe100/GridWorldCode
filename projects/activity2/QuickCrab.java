/* 
 * QuickCrab.java -
 * Behaves like the CrabCritter but if possible,
 * moves two spaces instead of one
 * 
 * @author Grant Zhou
 * @since March 25 2025
 */

 import java.awt.Color;
 import java.util.ArrayList;
 
 /**
  * A <code>CrabCritter</code> looks at a limited set of neighbors when it eats and moves.
  * <br />
  * This class is not tested on the AP CS A and AB exams.
  */
 public class QuickCrab extends CrabCritter
 {
 
    /**
     * @return list of empty locations immediately to the right and to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        for (Location loc : getLocationsInDirections(dirs, 2))
            if (getGrid().get(loc) == null)
                locs.add(loc);

        return locs;
    }

     /**
      * If the crab critter doesn't move, it randomly moves left or right.
      */
     public void makeMove(Location loc)
     {
         if (loc.equals(getLocation()))
             super.makeMove(selectMoveLocation(super.getMoveLocations()));
         else
             super.makeMove(loc);
     }
    
     /**
     * Finds the valid locations of this critter n steps away in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @param n - number of steps away
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions, int n)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location next = loc;
            for (int i = 0; i < n; i++)
                next = next.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(next))
                locs.add(next);
        }
        return locs;
    }    
 }
 