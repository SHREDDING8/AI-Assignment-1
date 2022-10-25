package com.shredding;

import java.util.ArrayList;

/**
 * class of describe cell of A star Map
 * @autor Egor Zavrazhnov
 * @version 1.0
 */

public class AStarCell implements Comparable<AStarCell> {
    int cost;
    int step;
    int path;
    int[] position = new int[] {0,0};
    AStarCell parentCell;
    boolean isDiscovered = false;
    boolean isTortuga = false;

    ArrayList<AStarCell> lastPositionsNoChoice = new ArrayList<>();


    /**
     * Constructor to create A star cell without position
     * @param cost the cost of cell
     * @param step the step for current path
     * @param path the path from current point to finish point
     */
    AStarCell(int cost, int step, int path){
        this.cost = cost;
        this.step = step;
        this.path = path;
    }
    /**
     * Constructor to create A star cell with position
     * @param cost the cost of cell
     * @param step the step for current path
     * @param path the path from current point to finish point
     * @param position the position cell on the map
     */
    AStarCell(int cost, int step, int path, int[] position){
        this.cost = cost;
        this.step = step;
        this.path = path;
        this.position = position;
    }

    /**
     * Function to compare A star cells
     @param cell comparing cell
     @return value difference
     */
    @Override
    public int compareTo(AStarCell cell) {
        return this.cost - cell.cost;
    }
}
