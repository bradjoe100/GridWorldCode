/**
 * BlusterCritter.java -
 * A varient of the Critter class that
 * changes color depending on its neighbors two or less steps away
 * 
 * @author Grant Zhou
 * @since March 25 2025
 */

import java.awt.Color;
import java.util.ArrayList;

 /**
  * A <code>BlusterCritter</code> changes colors depending on the
  * number of neighbers two or less steps away as it moves through the grid. <br />
  */
 public class BlusterCritter extends Critter
 {
    private int c;
    private int colorChange;
    
    private static final double DARKENING_FACTOR = 0.05;

    public BlusterCritter(int c) { this.c = c; }

    public BlusterCritter() { c = 4; }

    /**
     * Gets the actors for processing. Implemented to return the actors that
     * occupy grid locations less than two steps away. <br />
     * Postcondition: The state of all actors is unchanged.
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        Location loc = getLocation();
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for (int r = -2; r <= 2; r++) {
            for (int c = -2; c <= 2; c++) {
                Location next = new Location(loc.getRow() + r, loc.getCol() + c);
                if (gr.isValid(next) && gr.get(next) != null)
                    actors.add(gr.get(next));
            }
        }
        return actors;
    }

    /**
     * Processes the elements of <code>actors</code>. New actors may be added
     * to empty locations. Implemented to count selected actors
     * that are critters, and change its own color accordingly. <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * @param actors the actors to be processed
     */
    public void processActors(ArrayList<Actor> actors)
    {
        colorChange = c;
        for (Actor a : actors)
            if (a instanceof Critter)
                colorChange--;
        
        Color c = getColor();
        int red = Math.min(255, (int) (c.getRed() * (1 - ((colorChange <= 0) ? 1 : -1) * DARKENING_FACTOR)));
        int green = Math.min(255, (int) (c.getGreen() * (1 - ((colorChange <= 0) ? 1 : -1) * DARKENING_FACTOR)));
        int blue = Math.min(255, (int) (c.getBlue() * (1 - ((colorChange <= 0) ? 1 : -1) * DARKENING_FACTOR)));
        setColor(new Color(red, green, blue));
    }
 }
 