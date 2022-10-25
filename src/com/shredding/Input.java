package com.shredding;

import java.util.Random;


/**
 * class of generation and validation input
 * @autor Egor Zavrazhnov
 * @version 1.0
 */
public class Input {
    int[][] positions = new int[6][2];
    int variant = 0;

    Agent jack = new Agent(agents.jack,positions[0]);
    Agent Davy = new Agent(agents.Davy,positions[1]);
    Agent Kraken = new Agent(agents.Kraken,positions[2]);
    Agent Rock = new Agent(agents.Rock,positions[3]);
    Agent Chest = new Agent(agents.Chest,positions[4]);
    Agent Tortuga = new Agent(agents.Tortuga,positions[5]);

    /**
     * Null Constructor
     */
    public Input(){
    }

    /**
     * Constructor to store Inputs
     * @param positionsIn the initial positions
     * @param variantIn the initial variant
     */
    public Input(int[][] positionsIn,int variantIn){
        this.positions = positionsIn;
        this.variant = variantIn;
    }

    /**
     * Function to generate random input
     */
    public void generate(){
        Random random = new Random();

        while (isNonInvalidInput()) {
            for (int i = 1; i < 6; i++) {

                positions[i] = new int[]{random.nextInt(9), random.nextInt(9)};

            }
            jack = new Agent(agents.jack, positions[0]);
            Davy = new Agent(agents.Davy, positions[1]);
            Kraken = new Agent(agents.Kraken, positions[2]);
            Rock = new Agent(agents.Rock, positions[3]);
            Chest = new Agent(agents.Chest, positions[4]);
            Tortuga = new Agent(agents.Tortuga, positions[5]);
        }

        variant = random.nextInt(1,3);
    }

    /**
     * Function to checking of valid input
     * @return true if invalid input, false if valid input
     */
    public boolean isNonInvalidInput(){

        if (!(positions[0][0] == 0 && positions[0][1] == 0)){
            return true;
        }
        if(positions[4][0] == positions[0][0] && positions[4][1] == positions[0][1]){
            return true;
        }

        if(positions[5][0] == positions[0][0]&& positions[5][1] == positions[0][1]){
            return true;
        }

        //davy & jack
        if (positions[1][0] == positions[0][0] && positions[1][1] == positions[0][1] ){
            return true;
        }

        // davy & tortuga

        if (positions[1][0] == positions[5][0] && positions[1][1] == positions[5][1] ){
            return true;
        }

        // davy & chest
        if (positions[1][0] == positions[4][0] && positions[1][1] == positions[4][1] ){
            return true;
        }

        // davy & rock
        if (positions[1][0] == positions[3][0] && positions[1][1] == positions[3][1] ){
            return true;
        }

        // davy & kraken
        if (positions[1][0] == positions[2][0] && positions[1][1] == positions[2][1] ){
            return true;
        }

        // KRAKEN

        // kraken & jack

        if (positions[2][0] == positions[0][0] && positions[2][1] == positions[0][1]){
            return true;
        }

        // kraken & tortuga

        if (positions[2][0] == positions[5][0] && positions[2][1] == positions[5][1]){
            return true;
        }

        // kraken & chest

        if (positions[2][0] == positions[4][0] && positions[2][1] == positions[4][1]){
            return true;
        }

        // ROCK

        // rock & jack

        if (positions[3][0] == positions[0][0] && positions[3][1] == positions[0][1]){
            return true;
        }

        // rock & tortuga

        if (positions[3][0] == positions[5][0] && positions[3][1] == positions[5][1]){
            return true;
        }

        // rock & chest

        if (positions[3][0] == positions[4][0] && positions[3][1] == positions[4][1]){
            return true;
        }


        // rock & davy
        if (positions[3][0] == positions[1][0] + 1 && positions[3][1] == positions[1][1]){
            return true;
        }
        if (positions[3][0] == positions[1][0] - 1 && positions[3][1] == positions[1][1]){
            return true;
        }

        if (positions[3][0] == positions[1][0]&& positions[3][1] == positions[1][1] + 1){
            return true;
        }

        if (positions[3][0] == positions[1][0]&& positions[3][1] == positions[1][1] - 1){
            return true;
        }

        if (positions[3][0] == positions[1][0] + 1&& positions[3][1] == positions[1][1] + 1){
            return true;
        }

        if (positions[3][0] == positions[1][0] + 1&& positions[3][1] == positions[1][1] - 1){
            return true;
        }

        if (positions[3][0] == positions[1][0] - 1&& positions[3][1] == positions[1][1] + 1){
            return true;
        }
        if (positions[3][0] == positions[1][0] - 1&& positions[3][1] == positions[1][1] - 1){
            return true;
        }



//        CHEST

        // chest & davy

        if (positions[4][0] == positions[1][0] + 1 && positions[4][1] == positions[1][1]){
            return true;
        }
        if (positions[4][0] == positions[1][0] - 1 && positions[4][1] == positions[1][1]){
            return true;
        }

        if (positions[4][0] == positions[1][0]&& positions[4][1] == positions[1][1] + 1){
            return true;
        }

        if (positions[4][0] == positions[1][0]&& positions[4][1] == positions[1][1] - 1){
            return true;
        }

        if (positions[4][0] == positions[1][0] + 1&& positions[4][1] == positions[1][1] + 1){
            return true;
        }

        if (positions[4][0] == positions[1][0] + 1&& positions[4][1] == positions[1][1] - 1){
            return true;
        }

        if (positions[4][0] == positions[1][0] - 1&& positions[4][1] == positions[1][1] + 1){
            return true;
        }
        if (positions[4][0] == positions[1][0] - 1&& positions[4][1] == positions[1][1] - 1){
            return true;
        }

        // chest & KRAKEN

        if (positions[4][0] == positions[2][0] + 1 && positions[4][1] == positions[2][1]){
            return true;
        }
        if (positions[4][0] == positions[2][0] - 1 && positions[4][1] == positions[2][1]){
            return true;
        }

        if (positions[4][0] == positions[2][0]&& positions[4][1] == positions[2][1] + 1){
            return true;
        }

        if (positions[4][0] == positions[2][0]&& positions[4][1] == positions[2][1] - 1){
            return true;
        }




        // TORTUGA

        // TORTUGA & davy

        if (positions[5][0] == positions[1][0] + 1 && positions[5][1] == positions[1][1]){
            return true;
        }
        if (positions[5][0] == positions[1][0] - 1 && positions[5][1] == positions[1][1]){
            return true;
        }

        if (positions[5][0] == positions[1][0]&& positions[5][1] == positions[1][1] + 1){
            return true;
        }

        if (positions[5][0] == positions[1][0]&& positions[5][1] == positions[1][1] - 1){
            return true;
        }

        if (positions[5][0] == positions[1][0] + 1&& positions[5][1] == positions[1][1] + 1){
            return true;
        }

        if (positions[5][0] == positions[1][0] + 1&& positions[5][1] == positions[1][1] - 1){
            return true;
        }

        if (positions[5][0] == positions[1][0] - 1&& positions[5][1] == positions[1][1] + 1){
            return true;
        }
        if (positions[5][0] == positions[1][0] - 1&& positions[5][1] == positions[1][1] - 1){
            return true;
        }

        // TORTUGA & KRAKEN

        if (positions[5][0] == positions[2][0] + 1 && positions[5][1] == positions[2][1]){
            return true;
        }
        if (positions[5][0] == positions[2][0] - 1 && positions[5][1] == positions[2][1]){
            return true;
        }

        if (positions[5][0] == positions[2][0]&& positions[5][1] == positions[2][1] + 1){
            return true;
        }

        if (positions[5][0] == positions[2][0] && positions[5][1] == positions[2][1] - 1){
            return true;
        }


        jack = new Agent(agents.jack,positions[0]);
        Davy = new Agent(agents.Davy,positions[1]);
        Kraken = new Agent(agents.Kraken,positions[2]);
        Rock = new Agent(agents.Rock,positions[3]);
        Chest = new Agent(agents.Chest,positions[4]);
        Tortuga = new Agent(agents.Tortuga,positions[5]);

        return false;
    }

    /**
     * Function to convert input from String format to array format
     * @return array with positions
     */
    public static int[][] getPositionsAgents(String baseString) {
        int[][] result = new int[6][2];
        String[] firstSplitedString = baseString.split(" ");
        for (int i = 0; i < firstSplitedString.length; i++) {
            String current;
            current = firstSplitedString[i].replace("[", "");
            current = current.replace("]", "");

            String[] currentSplitted = current.split(",");

            result[i][0] = Integer.parseInt(currentSplitted[0]);
            result[i][1] = Integer.parseInt(currentSplitted[1]);
        }

        return result;
    }
}
