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

package com.shredding;

        import java.util.*;

/**
 * Enumerator of Set Kraken of Delete Kraken
 * @autor Egor Zavrazhnov
 * @version 1.0
 */
enum SetDelete {
    set,
    delete
}

/**
 * class of Game logic
 * @autor Egor Zavrazhnov
 * @version 1.0
 */
public class Game {


    Agent[][] map = new Agent[9][9];
    Agent jack;
    Agent Davy;
    Agent Kraken;
    Agent Rock;
    Agent Chest;
    Agent Tortuga;

    int variant;
    private int[][] visibleZone;
    Stack<BacktrackingCell> pathToChest = new Stack<>();
    Stack<BacktrackingCell> pathToTortuga = new Stack<>();
    Stack<BacktrackingCell> pathToChestFromTortuga = new Stack<>();
    String resultBacktracking = "";


    ArrayList<Agent> pathFromJackToChestAStar = new ArrayList<>();
    ArrayList<Agent> pathFromJackToTortugaAStar = new ArrayList<>();
    ArrayList<Agent> pathFromTortugaToChestAStar = new ArrayList<>();
    String resultAstar = "";


    boolean isHitKrakenAns;
    boolean ViaTortuga = false;


    AStarCell[][] mapAStar = new AStarCell[9][9];

    BacktrackingCell[][] mapBacktraking = new BacktrackingCell[9][9];

    int[][] danger = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};


    /**
     * Constructor to store of all agents and variant
     * @param jack agent - jack
     * @param Davy agent - Davy
     * @param Kraken agent - Kraken
     * @param Rock agent - Rock
     * @param Chest agent - Chest
     * @param Tortuga agent - Tortuga
     * @param variant variant of Game
     */
    Game(Agent jack, Agent Davy, Agent Kraken, Agent Rock, Agent Chest, Agent Tortuga, int variant) {
        this.jack = jack;
        this.Davy = Davy;
        this.Kraken = Kraken;
        this.Rock = Rock;
        this.Chest = Chest;
        this.Tortuga = Tortuga;
        this.variant = variant;
        setVisibleZone();
        generateMap();

    }

    /**
     * Function for generating map with agents
     */
    public void generateMap() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = new Agent(agents.empty);
            }
        }

        this.map[jack.position[0]][jack.position[1]] = jack;
        this.map[Rock.position[0]][Rock.position[1]] = Rock;
        this.map[Chest.position[0]][Chest.position[1]] = Chest;
        this.map[Tortuga.position[0]][Tortuga.position[1]] = Tortuga;

        setDeleteKraken(SetDelete.set);
    }

    /**
     * Function for set Davy and his danger Zone on map
     */
    private void setDavy() {

        int DavyX = Davy.position[0];
        int DavyY = Davy.position[1];

        this.map[Davy.position[0]][Davy.position[1]] = Davy;

        for (int i = 0; i < 8; i++) {
            try {
                agents KrakenCheck = this.map[DavyX + danger[i][0]][DavyY + danger[i][1]].agent;
                if (KrakenCheck != agents.Rock && KrakenCheck != agents.Kraken) {
                    this.map[DavyX + danger[i][0]][DavyY + danger[i][1]] = new Agent(agents.danger, new int[]{DavyX + danger[i][0], DavyY + danger[i][1]});
                }
            } catch (Exception ignored) {
            }
        }

    }

    /**
     * Function for set Kraken on the map or delete kraken from the map
     * @param mode the set of Kraken or delete of Kraken
     */
    private void setDeleteKraken(SetDelete mode) {
        int KrakenX = Kraken.position[0];
        int KrakenY = Kraken.position[1];
        if (mode == SetDelete.set) {
            this.map[Kraken.position[0]][Kraken.position[1]] = Kraken;
        } else {
            this.map[Kraken.position[0]][Kraken.position[1]] = new Agent(agents.empty);
            if (KrakenX == this.Rock.position[0] && KrakenY == this.Rock.position[1]) {
                this.map[Kraken.position[0]][Kraken.position[1]] = new Agent(agents.Rock);
            }
        }

        for (int i = 0; i < 4; i++) {
            try {
                agents KrakenCheck = this.map[KrakenX + danger[i][0]][KrakenY + danger[i][1]].agent;
                if (KrakenCheck != agents.Rock) {
                    if (mode == SetDelete.set) {
                        this.map[KrakenX + danger[i][0]][KrakenY + danger[i][1]] = new Agent(agents.danger, new int[]{KrakenX + danger[i][0], KrakenY + danger[i][1]});
                    } else {
                        this.map[KrakenX + danger[i][0]][KrakenY + danger[i][1]] = new Agent(agents.empty);
                    }

                }
            } catch (Exception ignored) {
            }
        }

        setDavy();
    }

    /**
     * Function for set visible zon of first or second variant
     */
    private void setVisibleZone() {
        if (this.variant == 1) {
            this.visibleZone = new int[][]{
                    {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
            };

        } else {
            this.visibleZone = new int[][]{
                    {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {0, 2}, {0, -2}, {2, 0}, {-2, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1},
            };
        }
    }

    /**
     * Function to execute A star algorithm
     * @return the shortest path
     */
    public int AstarAlgorithm() {
        int pathFromJackToChest = aStarAlgorithmPrivate(jack.position, Chest.position, false);

        AStarCell nowCell = mapAStar[Chest.position[0]][Chest.position[1]];
        for (int i = 0; i < pathFromJackToChest; i++) {
            pathFromJackToChestAStar.add( new Agent(agents.jack, new int[]{nowCell.position[0],nowCell.position[1]}) );
            nowCell = nowCell.parentCell;
        }

        int pathFromJackToTortuga = aStarAlgorithmPrivate(jack.position, Tortuga.position, false);

        nowCell = mapAStar[Tortuga.position[0]][Tortuga.position[1]];
        for (int i = 0; i < pathFromJackToTortuga; i++) {
            pathFromJackToTortugaAStar.add(new Agent(agents.jack, new int[]{nowCell.position[0],nowCell.position[1]}));
            nowCell = nowCell.parentCell;
        }
        int pathFromTortugaToChest = aStarAlgorithmPrivate(Tortuga.position, Chest.position, true);

        nowCell = mapAStar[Chest.position[0]][Chest.position[1]];
        for (int i = 0; i < pathFromTortugaToChest; i++) {
            pathFromTortugaToChestAStar.add(new Agent(agents.jack, new int[]{nowCell.position[0],nowCell.position[1]}));
            nowCell = nowCell.parentCell;
        }

        int pathFromJackToTortugaToChest = -1;

        if (pathFromJackToTortuga != -1 && pathFromTortugaToChest != -1) {
            pathFromJackToTortugaToChest = pathFromJackToTortuga + pathFromTortugaToChest;
        }
        if (pathFromJackToTortugaToChest == -1 && pathFromJackToChest == -1) {
            return -1;
        }
        if (pathFromJackToTortugaToChest == -1) {
            return pathFromJackToChest;
        }
        if (pathFromJackToChest == -1) {
            return pathFromJackToTortugaToChest;
        }
        if (pathFromJackToTortugaToChest <pathFromJackToChest ){
            this.ViaTortuga = true;
        }

        return Integer.min(pathFromJackToTortugaToChest, pathFromJackToChest);

    }

    /**
     * Function to calculate path from first point to second point
     * @param startPosition the first point
     * @param finishPosition the second point
     * @return the shortest path
     */
    private int pathFunc(int[] startPosition, int[] finishPosition) {
        int[][] nearCellsSteps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int nearCellX = startPosition[0];
        int nearCellY = startPosition[1];

        int path = 0;
        if (nearCellX > -1 && nearCellY > -1 && nearCellX < 9 && nearCellY < 9) {
            while (!(nearCellX == finishPosition[0] && nearCellY == finishPosition[1])) {
                int chestX = finishPosition[0];
                int chestY = finishPosition[1];

                int[][] lens = new int[8][3];

                for (int j = 0; j < 8; j++) {
                    lens[j][0] = (int) Math.pow(chestX - (nearCellX + nearCellsSteps[j][0]), 2) + (int) Math.pow(chestY - (nearCellY + nearCellsSteps[j][1]), 2);
                    lens[j][1] = nearCellsSteps[j][0];
                    lens[j][2] = nearCellsSteps[j][1];
                }

                Arrays.sort(lens, Comparator.comparingInt(arr -> arr[0]));

                nearCellX += lens[0][1];
                nearCellY += lens[0][2];

                path++;

            }
        }
        return path;
    }

    /**
     * Function to execute A star algorithm
     * @param startPosition the start position of A star Algorithm
     * @param finishPosition the finish position of A star Algorithm
     * @param isTortuga has Jack tortuga or not
     * @return the shortest path
     */
    private int aStarAlgorithmPrivate ( int[] startPosition, int[] finishPosition, boolean isTortuga){

        PriorityQueue<AStarCell> pq = new PriorityQueue<>(); // Priority queue for storing cells where we want to go
        int startPositionX = startPosition[0];
        int startPositionY = startPosition[1];
        generateMap();
        // set A star map
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                mapAStar[i][j] = new AStarCell(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
                mapAStar[i][j].position = new int[]{i,j};
                mapAStar[i][j].path = pathFunc(new int[]{i,j}, finishPosition);
                mapAStar[i][j].isTortuga = isTortuga;
            }
        }

        int startPath = pathFunc(startPosition,finishPosition);
        mapAStar[startPositionX][startPositionY] = new AStarCell(startPath, 0, startPath);
        pq.add(new AStarCell(startPath, 0, startPath,startPosition));

        if (map[startPosition[0]][startPosition[1]].agent == agents.danger) {
            return -1;
        }



        while (!pq.isEmpty()) {
            AStarCell current_cell = pq.poll();

            int[] current_position = current_cell.position;
            int x_index = current_position[0];
            int y_index = current_position[1];

            if (x_index == finishPosition[0] && y_index == finishPosition[1]){
                setDeleteKraken(SetDelete.set);
                return mapAStar[finishPosition[0]][finishPosition[1]].cost;
            }
            if (map[x_index][y_index].agent == agents.danger) {
                return -1;
            }

            for (int i = -1; i < 2; i++) { // Check all adjacent cells
                for (int j = -1; j < 2; j++) {
                    int new_x = x_index + i;
                    int new_y = y_index + j;

                    if (isTortuga) {
                        for (int k = visibleZone.length - 4; k < visibleZone.length; k++) {
                            if (x_index + visibleZone[k][0] == this.Kraken.position[0] && y_index + visibleZone[k][1] == this.Kraken.position[1]) {
                                setDeleteKraken(SetDelete.delete);
                                break;
                            }
                        }
                    }

                    if (!(i == 0 && j == 0) && new_x >= 0 && new_x <= 8 && new_y >= 0 && new_y <= 8){ // Do not go to current cell
                        if (!isNotDanger(new int[]{new_x,new_y})){
                            continue;
                        }


                        int pathChild = pathFunc(new int[]{new_x,new_y},finishPosition);
                        AStarCell childCell  = mapAStar[new_x][new_y];

                        int step = current_cell.step + 1;
                        int cost = step + pathChild;


                        if (cost < childCell.cost){
                            childCell.parentCell = current_cell;
                            childCell.step = step;
                            childCell.cost = cost;
                            childCell.path = pathChild;
                            mapAStar[new_x][new_y] = childCell;
                            if (!childCell.isDiscovered){
                                pq.add(childCell);
                                mapAStar[new_x][new_y].isDiscovered = true;
                            }

                        }
                    }

                }
            }

        }
        setDeleteKraken(SetDelete.set);
        return -1;
    }

    /**
     * Function to create string for answer map
     * @param mode A star or backtracking
     * @return the string of answer map
     */
    public String  printAns ( int mode){
        StringBuilder result = new StringBuilder();
        generateMap();
        if (this.isHitKrakenAns) {
            setDeleteKraken(SetDelete.delete);
        }

        if (mode == 0) {
            if (this.ViaTortuga) {
                if (pathToTortuga != null) {
                    for (BacktrackingCell backtrackingCell : pathToTortuga) {
                        map[backtrackingCell.position[0]][backtrackingCell.position[1]].agent = agents.jack;
                        resultBacktracking += "[" + backtrackingCell.position[0] + "," + backtrackingCell.position[1]+ "] ";
                    }
                }

                pathToChestFromTortuga.remove(0);
                for (BacktrackingCell backtrackingCell : this.pathToChestFromTortuga) {
                    map[backtrackingCell.position[0]][backtrackingCell.position[1]].agent = agents.jack;
                    resultBacktracking += "[" + backtrackingCell.position[0] + "," + backtrackingCell.position[1]+ "] ";
                }
            } else {
                if (pathToChest != null) {
                    for (BacktrackingCell backtrackingCell : pathToChest) {
                        map[backtrackingCell.position[0]][backtrackingCell.position[1]].agent = agents.jack;
                        resultBacktracking += "[" + backtrackingCell.position[0] + "," + backtrackingCell.position[1]+ "] ";
                    }
                }
            }
        } else {
            if (this.ViaTortuga) {
                if (pathFromJackToTortugaAStar != null) {

                    Collections.reverse(pathFromJackToTortugaAStar);
                    resultAstar += "[0,0] ";

                    for (Agent backtrackingCell : pathFromJackToTortugaAStar) {
                        map[backtrackingCell.position[0]][backtrackingCell.position[1]].agent = agents.jack;
                        resultAstar += "[" + backtrackingCell.position[0] + "," + backtrackingCell.position[1]+ "] ";
                    }
                }
                Collections.reverse(pathFromTortugaToChestAStar);
                for (Agent backtrackingCell : this.pathFromTortugaToChestAStar) {
                    map[backtrackingCell.position[0]][backtrackingCell.position[1]].agent = agents.jack;
                    resultAstar += "[" + backtrackingCell.position[0] + "," + backtrackingCell.position[1]+ "] ";
                }
            } else {
                Collections.reverse(pathFromJackToChestAStar);
                for (Agent backtrackingCell : pathFromJackToChestAStar) {
                    map[backtrackingCell.position[0]][backtrackingCell.position[1]].agent = agents.jack;
                    resultAstar += "[" + backtrackingCell.position[0] + "," + backtrackingCell.position[1]+ "] ";
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j].agent == agents.danger) {
                    result.append("#\t");
                } else if (map[i][j].agent == agents.Kraken) {
                    result.append("K\t");
                } else if (map[i][j].agent == agents.Davy) {
                    result.append("D\t");
                } else if (map[i][j].agent == agents.Tortuga) {
                    result.append("T\t");
                } else if (map[i][j].agent == agents.Rock) {
                    result.append("R\t");
                } else if (map[i][j].agent == agents.Chest) {
                    result.append("C\t");
                } else if (map[i][j].agent == agents.empty) {
                    result.append(".\t");
                } else if (map[i][j].agent == agents.jack) {
                    result.append("J\t");
                }

            }
            result.append("\n");
        }

        return result.toString();
    }


    /**
     * Function to calculate the shortest path with backtracking
     * @return shortest path
     */
    public int backtracking (){
        generateMap();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                mapBacktraking[i][j] = new BacktrackingCell(new int[]{i, j});
            }
        }

        Stack<BacktrackingCell> path = new Stack<BacktrackingCell>();
        backtrackingRecursion(path, jack.position, Chest.position, 0, false, false);
        generateMap();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                mapBacktraking[i][j] = new BacktrackingCell(new int[]{i, j});
            }
        }
        path = new Stack<>();

        backtrackingRecursion(path, jack.position, Tortuga.position, 1, false, false);
        generateMap();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                mapBacktraking[i][j] = new BacktrackingCell(new int[]{i, j});
            }
        }
        path = new Stack<>();
        backtrackingRecursion(path, Tortuga.position, Chest.position, 2, true, false);

        int pathFromJackToChest = this.pathToChest.size() - 1;
        int pathFromJackToTortuga = this.pathToTortuga.size() - 1;
        int pathFromTortugaToChest = this.pathToChestFromTortuga.size() - 1;

        int pathFromJackToTortugaToChest = -1;

        if (pathFromJackToTortuga != -1 && pathFromTortugaToChest != -1) {
            pathFromJackToTortugaToChest = pathFromJackToTortuga + pathFromTortugaToChest;
        }
        if (pathFromJackToTortugaToChest == -1 && pathFromJackToChest == -1) {
            return -1;
        }
        if (pathFromJackToTortugaToChest == -1) {
            return pathFromJackToChest;
        }
        if (pathFromJackToChest == -1) {
            ViaTortuga = true;
            return pathFromJackToTortugaToChest;
        }
        return Integer.min(pathFromJackToTortugaToChest, pathFromJackToChest);
    }

    /**
     * Function to calculate the shortest path with backtracking recursion
     * @param path the current path
     * @param position the current position
     * @param finishPosition the finish position
     * @param mode the mode of path
     * @param isTortuga has tortoga?
     * @param isHitKraken hit kraken?
     */
    public void backtrackingRecursion (Stack < BacktrackingCell > path, int[] position, int[] finishPosition,
                                       int mode, boolean isTortuga, boolean isHitKraken){
        mapBacktraking[position[0]][position[1]].isVisitedCurrent = true;
        path.push(mapBacktraking[position[0]][position[1]]);


        if (!isTortuga && map[position[0]][position[1]].agent == agents.Tortuga) {
            isTortuga = true;
        }

        if (!isHitKraken) {
            setDeleteKraken(SetDelete.set);
        }

        if (isTortuga) {
            for (int i = visibleZone.length - 4; i < visibleZone.length; i++) {
                if (!isHitKraken && position[0] + visibleZone[i][0] == this.Kraken.position[0] && position[1] + visibleZone[i][1] == this.Kraken.position[1]) {
                    setDeleteKraken(SetDelete.delete);
                    isHitKraken = true;
                    break;
                }
            }
        }


        if (map[position[0]][position[1]].agent == agents.danger) {
            return;
        }

        if (!isTortuga) {
            if (mapBacktraking[position[0]][position[1]].minPath == -1) {
                mapBacktraking[position[0]][position[1]].minPath = path.size() - 1;
            }else if (mapBacktraking[position[0]][position[1]].minPath < path.size() - 1) {
                return;
            } else {
                mapBacktraking[position[0]][position[1]].minPath = path.size() - 1;
            }
        } else {
            if (mapBacktraking[position[0]][position[1]].minPathTortuga == -1) {
                mapBacktraking[position[0]][position[1]].minPathTortuga = path.size() - 1;
            } else if (mapBacktraking[position[0]][position[1]].minPathTortuga < path.size() - 1) {
                return;
            } else {
                mapBacktraking[position[0]][position[1]].minPathTortuga = path.size() - 1;
            }
        }

        if (mode == 0){
            if (path.size() > pathToChest.size() && pathToChest.size() != 0) {
                return;
            }
        }
        if (mode == 1){
            if (path.size() > pathToTortuga.size() && pathToTortuga.size() != 0) {
                return;
            }
        }
        if (mode == 2){
            if (path.size() > pathToChestFromTortuga.size() && pathToChestFromTortuga.size() != 0) {
                return;
            }
        }



        if (position[0] == finishPosition[0] && position[1] == finishPosition[1]) {
            if (mode == 0) {
                this.isHitKrakenAns = isHitKraken;
                this.pathToChest = (Stack<BacktrackingCell>) path.clone();
                return;
            } else if (mode == 1) {
                this.isHitKrakenAns = isHitKraken;
                this.pathToTortuga = (Stack<BacktrackingCell>) path.clone();
                return;
            } else if (mode == 2) {
                this.isHitKrakenAns = isHitKraken;
                this.pathToChestFromTortuga = (Stack<BacktrackingCell>) path.clone();
                return;
            }
        }

        // bottom left
        if (position[0] < 8 && position[1] > 0) {
            int[] newPosition = new int[]{position[0] + 1, position[1] - 1};
            if (!mapBacktraking[position[0] + 1][position[1] - 1].isVisitedCurrent && isNotDanger(newPosition)) {
                backtrackingRecursion(path, newPosition, finishPosition, mode, isTortuga, isHitKraken);
                mapBacktraking[newPosition[0]][newPosition[1]].isVisitedCurrent = false;
                path.pop();
            }


        }

        // top

        if (position[0] > 0) {
            int[] newPosition = new int[]{position[0] - 1, position[1]};
            if (!mapBacktraking[position[0] - 1][position[1]].isVisitedCurrent && isNotDanger(newPosition)) {
                backtrackingRecursion(path, newPosition, finishPosition, mode, isTortuga, isHitKraken);
                mapBacktraking[newPosition[0]][newPosition[1]].isVisitedCurrent = false;
                path.pop();
            }
        }

        // bottom

        if (position[0] < 8) {
            int[] newPosition = new int[]{position[0] + 1, position[1]};

            if (!mapBacktraking[position[0] + 1][position[1]].isVisitedCurrent && isNotDanger(newPosition)) {

                backtrackingRecursion(path, newPosition, finishPosition, mode, isTortuga, isHitKraken);
                mapBacktraking[newPosition[0]][newPosition[1]].isVisitedCurrent = false;
                path.pop();
            }
        }

        // left

        if (position[1] > 0) {
            int[] newPosition = new int[]{position[0], position[1] - 1};
            if (!mapBacktraking[position[0]][position[1] - 1].isVisitedCurrent && isNotDanger(newPosition)) {

                backtrackingRecursion(path, newPosition, finishPosition, mode, isTortuga, isHitKraken);
                mapBacktraking[newPosition[0]][newPosition[1]].isVisitedCurrent = false;
                path.pop();
            }
        }

        // right
        if (position[1] < 8) {
            int[] newPosition = new int[]{position[0], position[1] + 1};

            if (!mapBacktraking[position[0]][position[1] + 1].isVisitedCurrent && isNotDanger(newPosition)) {

                backtrackingRecursion(path, newPosition, finishPosition, mode, isTortuga, isHitKraken);
                mapBacktraking[newPosition[0]][newPosition[1]].isVisitedCurrent = false;
                path.pop();
            }


        }

        // top left

        if (position[0] > 0 && position[1] > 0) {
            int[] newPosition = new int[]{position[0] - 1, position[1] - 1};
            if (!mapBacktraking[position[0] - 1][position[1] - 1].isVisitedCurrent && isNotDanger(newPosition)) {

                backtrackingRecursion(path, newPosition, finishPosition, mode, isTortuga, isHitKraken);
                mapBacktraking[newPosition[0]][newPosition[1]].isVisitedCurrent = false;
                path.pop();
            }


        }

        // top right

        if (position[0] > 0 && position[1] < 8) {
            int[] newPosition = new int[]{position[0] - 1, position[1] + 1};
            if (!mapBacktraking[position[0] - 1][position[1] + 1].isVisitedCurrent && isNotDanger(newPosition)) {

                backtrackingRecursion(path, newPosition, finishPosition, mode, isTortuga, isHitKraken);
                mapBacktraking[newPosition[0]][newPosition[1]].isVisitedCurrent = false;
                path.pop();
            }


        }



        // bottom right
        if (position[0] < 8 && position[1] < 8) {
            int[] newPosition = new int[]{position[0] + 1, position[1] + 1};
            if (!mapBacktraking[position[0] + 1][position[1] + 1].isVisitedCurrent && isNotDanger(newPosition)) {
                backtrackingRecursion(path, newPosition, finishPosition, mode, isTortuga, isHitKraken);
                mapBacktraking[newPosition[0]][newPosition[1]].isVisitedCurrent = false;
                path.pop();
            }
        }
    }


    /**
     * Function to determine danger zone or not
     * @param position the position of cell
     * @return the True if not danger
     */
    private boolean isNotDanger ( int[] position){
        return map[position[0]][position[1]].agent == agents.empty || map[position[0]][position[1]].agent == agents.Chest || map[position[0]][position[1]].agent == agents.Tortuga;
    }
}

package com.shredding;

        import java.io.File;
        import java.io.FileWriter;
        import java.util.Scanner;

/**
 * Main class
 * @autor Egor Zavrazhnov
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scannerInputs = new Scanner(System.in);
        int variantInput;
        System.out.println("Choose the variant of input: \n[+] From File: 0\n[+] From Standard Input: 1\n[+] Statistical Analysis: 2");
        variantInput = scannerInputs.nextInt();

        int variant;
        int[][] positions;
        if (variantInput == 0) {
            Scanner scannerFile = new Scanner(new File("input.txt"));
            String firstString = scannerFile.nextLine();
            variant = scannerFile.nextInt();
            positions = Input.getPositionsAgents(firstString);

            Input inputs = new Input(positions, variant);

            if (inputs.isNonInvalidInput()) {
                System.out.println("[-] Invalid Input\n");
                return;
            }

            Game game = new Game(inputs.jack, inputs.Davy, inputs.Kraken, inputs.Rock, inputs.Chest, inputs.Tortuga, inputs.variant);

            long time = System.currentTimeMillis();

            int Astar = game.AstarAlgorithm();
            long AstarTime = System.currentTimeMillis() - time;

            time = System.currentTimeMillis();
            int Back = game.backtracking();
            long backTime = System.currentTimeMillis() - time;

            FileWriter writerAstar = new FileWriter("outputAStar.txt");
            FileWriter writerBack = new FileWriter("outputBacktracking.txt");

            if (Astar != -1){
                String AstarTable= game.printAns(1);
                String backTable =  game.printAns(0);
                writerAstar.write("Win\n");
                writerBack.write("Win\n");

                writerAstar.write("The shortest path length: " + (Astar) + "\n");
                writerBack.write("The shortest path length: " + (Back) + "\n");
                writerAstar.write("The shortest path sequence: " + game.resultAstar + "\n");
                writerBack.write("The shortest path sequence: " + game.resultBacktracking + "\n");

                writerAstar.write(AstarTable);
                writerBack.write(backTable);

                writerAstar.write("Time taken: " + AstarTime);
                writerBack.write("Time taken: " + backTime);

                writerAstar.close();
                writerBack.close();

            }else{
                writerAstar.write("Lose\n");
                writerBack.write("Lose\n");
                writerAstar.close();
                writerBack.close();
            }


        } else if (variantInput == 1) {
            System.out.println("[+] Enter the data in this form:\n[0,0] [4,6] [1,6] [6,7] [0,8] [2,5]\n1\n");

            Scanner scannerStd = new Scanner(System.in);

            String firstString = scannerStd.nextLine();
            variant = scannerStd.nextInt();
            positions = Input.getPositionsAgents(firstString);

            Input inputs = new Input(positions, variant);

            while (inputs.isNonInvalidInput()) {
                System.out.println("[-] Invalid Input\n");
                System.out.println("[+] Enter the data in this form:\n[0,0] [4,6] [1,6] [6,7] [0,8] [2,5]\n1\n");
            }


            Game game = new Game(inputs.jack, inputs.Davy, inputs.Kraken, inputs.Rock, inputs.Chest, inputs.Tortuga, inputs.variant);

            long time = System.currentTimeMillis();

            int Astar = game.AstarAlgorithm();
            long AstarTime = System.currentTimeMillis() - time;

            time = System.currentTimeMillis();
            int Back = game.backtracking();
            long backTime = System.currentTimeMillis() - time;

            FileWriter writerAstar = new FileWriter("outputAStar.txt");
            FileWriter writerBack = new FileWriter("outputBacktracking.txt");

            if (Astar != -1){
                String AstarTable= game.printAns(1);
                String backTable =  game.printAns(0);
                writerAstar.write("Win\n");
                writerBack.write("Win\n");

                writerAstar.write("The shortest path length: " + (Astar) + "\n");
                writerBack.write("The shortest path length: " + (Back) + "\n");
                writerAstar.write("The shortest path sequence: " + game.resultAstar + "\n");
                writerBack.write("The shortest path sequence: " + game.resultBacktracking + "\n");

                writerAstar.write(AstarTable);
                writerBack.write(backTable);

                writerAstar.write("Time taken: " + AstarTime);
                writerBack.write("Time taken: " + backTime);

                writerAstar.close();
                writerBack.close();

            }else{
                writerAstar.write("Lose\n");
                writerBack.write("Lose\n");
                writerAstar.close();
                writerBack.close();
            }

        } else if (variantInput == 2) {
            System.out.println("[+] Enter the number of Tests");
            Scanner scannerStd = new Scanner(System.in);

            int numberTests = scannerStd.nextInt();

            Input[] genericArr = new Input[numberTests];

            for (int i = 0; i < numberTests; i++) {
                Input generic = new Input();
                while (generic.isNonInvalidInput()) {
                    generic.generate();
                }

                genericArr[i] = generic;
            }

            int numberOfWinsAstar1 = 0;
            int numberOfWinsAstar2 = 0;
            int numberOfWinsBacktracking1 = 0;
            int numberOfWinsBacktracking2 = 0;

            double sumOfTimeExecutionAstar1 = 0;
            double sumOfTimeExecutionAstar2 = 0;

            double sumOfTimeExecutionBacktracking1 = 0;
            double sumOfTimeExecutionBacktracking2 = 0;

            for (int i = 0; i < numberTests; i++) {

                Game game = new Game(genericArr[i].jack, genericArr[i].Davy, genericArr[i].Kraken, genericArr[i].Rock, genericArr[i].Chest, genericArr[i].Tortuga, 1);
                Game game2 = new Game(genericArr[i].jack, genericArr[i].Davy, genericArr[i].Kraken, genericArr[i].Rock, genericArr[i].Chest, genericArr[i].Tortuga, 2);

                // variant 1
                long time = System.currentTimeMillis();
                int Astar1 = game.AstarAlgorithm();
                if (Astar1 != -1){
                    sumOfTimeExecutionAstar1 += System.currentTimeMillis() - time;
                    numberOfWinsAstar1+=1;
                }
                time = System.currentTimeMillis();
                int back1 = game.backtracking();
                if (back1 != -1){
                    sumOfTimeExecutionBacktracking1 += System.currentTimeMillis() - time;
                    numberOfWinsBacktracking1+=1;
                }

                // variant 2
                time = System.currentTimeMillis();
                int Astar2 = game2.AstarAlgorithm();
                if (Astar2 != -1){
                    sumOfTimeExecutionAstar2 += System.currentTimeMillis() - time;
                    numberOfWinsAstar2+=1;
                }
                time = System.currentTimeMillis();
                int back2 = game2.backtracking();
                if (back2 != -1){
                    sumOfTimeExecutionBacktracking2 += System.currentTimeMillis() - time;
                    numberOfWinsBacktracking2+=1;
                }
            }
            System.out.println(sumOfTimeExecutionAstar1);
            System.out.println("Astar 1");
            System.out.println("Number of wins: " + numberOfWinsAstar1);
            System.out.println("Mean execution time: " + sumOfTimeExecutionAstar1 / (double) numberOfWinsAstar1 + " ms\n");

            System.out.println("Backtracking 1");
            System.out.println("Number of wins: " + numberOfWinsBacktracking1);
            System.out.println("Mean execution time: " + sumOfTimeExecutionBacktracking1 /(double) numberOfWinsBacktracking1 + " ms\n");

            System.out.println("Astar 2");
            System.out.println("Number of wins: " + numberOfWinsAstar2);
            System.out.println("Mean execution time: " + sumOfTimeExecutionAstar2 /(double) numberOfWinsAstar2 + " ms\n");

            System.out.println("Backtracking 2");
            System.out.println("Number of wins: " + numberOfWinsBacktracking2);
            System.out.println("Mean execution time: " + sumOfTimeExecutionBacktracking2 / (double)numberOfWinsBacktracking2 + " ms\n");
        }
    }
}