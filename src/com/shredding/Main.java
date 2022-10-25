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