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
