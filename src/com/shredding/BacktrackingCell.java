package com.shredding;

/**
 * class of describe cell of Backtracking map
 * @autor Egor Zavrazhnov
 * @version 1.0
 */

public class BacktrackingCell {
    int[] position;
    int minPath = -1;
    int minPathTortuga = -1;

    boolean isVisitedCurrent = false;


    /**
     * Constructor to create Backtracking cell
     * @param position the position of cell on the map
     */
    public BacktrackingCell(int[] position){
        this.position = position;
    }
}
