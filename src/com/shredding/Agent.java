package com.shredding;

/**
 * Enumerator of possible Game participants
 */
enum agents{
    jack,
    Davy,
    Kraken,
    Rock,
    Chest,
    Tortuga,
    danger,
    empty,
}


/**
 * class of describe agent on map
 * @autor Egor Zavrazhnov
 * @version 1.0
 */
public class Agent {

    agents agent;
    int[] position = new int[] {0,0} ;

    /**
     * Constructor to create Agent with position
     * @param agent type of Game participant
     * @param position position on the map
     */
    Agent(agents agent,int[] position){
        this.agent = agent;
        this.position = position;
    }
    /**
     * Constructor to create Agent without position
     * @param agent type of Game participant
     */
    Agent(agents agent){
        this.agent = agent;
    }
}
