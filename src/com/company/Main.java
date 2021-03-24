package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userScore = 0;
        int pcScore = 0;
        String userOption;
        int userOptionInt;

        while ((userScore != 3) && (pcScore != 3)) {

            do {
                System.out.println("1) Rock 2) Paper 3) Scissors");
                System.out.println(">>> ");

                userOption = scanner.nextLine();

                if (!userOption.equals("1") && !userOption.equals("2") && !userOption.equals("3")) {
                    System.out.println("Invalid option");
                }
            } while (!userOption.equals("1") && !userOption.equals("2") && !userOption.equals("3"));

            int pcOption = random.nextInt(3) + 1;
            userOptionInt = Integer.parseInt(userOption);

            String result = whoIsWinner(userOptionInt, pcOption);

            if (!result.equals("INVALID")) {

                if (result.equals("USER")) {
                    userScore++;
                }
                if (result.equals("PC")) {
                    pcScore++;
                }

                printScore(userScore, pcScore);
                printInfoMessage(result, userOptionInt, pcOption);

            } else {
                System.out.println("Invalid Option");
            }
        }

        printFinalMessage(userScore, pcScore);
    }

    public static void printFinalMessage(int userScore, int pcScore) {
        if ((userScore < 0) || (pcScore < 0)) {
            System.out.println("Invalid Option");
        } else {
            if (userScore > pcScore) {
                System.out.println("The User has won the match!");
            } else if (pcScore > userScore) {
                System.out.println("The Computer has won the match!");
            } else {
                System.out.println("Equality!");
            }
        }
    }

    public static String intToStringOption(int option) {
        switch (option) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "INVALID";
        }
    }

    public static void printScore(int user, int pc) {
        System.out.println("************************");
        System.out.println("      SCORE");
        System.out.println("  " + user + "           " + pc);
    }

    public static void printInfoMessage(String result, int user, int pc) {
        System.out.println("USER: " + intToStringOption(user) + "   PC: " + intToStringOption(pc));

        switch (result) {
            case "USER":
                System.out.println("User has won the round!");
                break;
            case "PC":
                System.out.println("PC has won the round!");
                break;
            case "NONE":
                System.out.println("Same options!");
                break;
            default:
                System.out.println("Invalid Option.");
        }
        System.out.println("************************");
    }

    public static String whoIsWinner(int user, int pc) {
        if ((user <= 0) || (user >= 4) || (pc <= 0) || (pc >= 4)) {
            return "INVALID";
        }

        if (user == pc) {
            return "NONE";
        }

        if (user == 1) {
            if (pc == 2) {
                return "PC";
            } else {
                return "USER";
            }
        } else if (user == 2) {
            if (pc == 1) {
                return "USER";
            } else {
                return "PC";
            }
        } else {
            if (pc == 1) {
                return "PC";
            } else {
                return "USER";
            }
        }


    }
}
