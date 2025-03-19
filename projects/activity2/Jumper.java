import java.awt.Color;

/**
 * Jumper.java
 * Contains the Jumper class.
 * The Jumper moves two spaces per turn, and leaves Blossoms instead of Flowers.
 */

public class Jumper extends Bug {
        
        private int dir;

        public Jumper() {
            super();
            setColor(Color.BLUE);
            dir = 0;
        }

        @Override
        public void act() {
            if (canMove()) {
                move();
            } else if (dir < 8) {
                turn();
                dir++;
            } else if (dir >= 8 && canMoveOne()) {
                move();
            } else {
                turn();
            }
        }
        
        @Override
        public void move()
        {
            Grid<Actor> gr = getGrid();
            if (gr == null)
                return;
            Location loc = getLocation();
            Location next1 = loc.getAdjacentLocation(getDirection());
            Location next2 = next1.getAdjacentLocation(getDirection());
            if (gr.isValid(next2))
                moveTo(next2);
            else if (gr.isValid(next1))
                moveTo(next1);
            else
                removeSelfFromGrid();
            Blossom b = new Blossom((int) (Math.random() * 20) + 5);
            b.putSelfInGrid(gr, loc);
            dir = 0;
        }

        @Override
        public boolean canMove() {
            Grid<Actor> gr = getGrid();
            if (gr == null)
                return false;
            Location loc = getLocation();
            Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
            if (!gr.isValid(next))
                return false;
            Actor neighbor = gr.get(next);
            return (neighbor == null) || (neighbor instanceof Flower);
        }

        public boolean canMoveOne() {
            return super.canMove();
        }

}
