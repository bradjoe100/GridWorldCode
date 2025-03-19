/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */
import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new UnboundedGrid<>());
        CircleBug alice = new CircleBug(2);
        alice.setColor(Color.ORANGE);
        DancingBug bob = new DancingBug();
        bob.setColor(Color.BLUE);
        SpiralBug carol = new SpiralBug(4);
        carol.setColor(Color.GREEN);
        ZBug dan = new ZBug(4);
        dan.setColor(Color.RED);
        world.add(new Location(17, 18), alice);
        world.add(new Location(10, 0), bob);
        world.add(new Location(30, 20), carol);
        world.add(new Location(30, 30), dan);
        world.show();
    }
}