package se.lexicon.jonst;

import java.util.Arrays;


import java.util.Scanner;

public class App {

    public static Scanner inputReader;

    public static void main(String[] args) {
        inputReader = new Scanner(System.in);


        //writeFirstArray(getNumArray());

        //System.out.println(indexOf(writeFirstArray(getNumArray()), 5));

        //String[] cityArray = {"Tokyo", "New York", "Stockholm"};
        //sortStringArray(cityArray);

        //copyArray(getNumArray());
        //twoDee();
        //averageArray();
        //oddOnesOut();
        //removeDuplicates(new int[]{20, 20, 40, 20, 30, 40, 50, 60, 50});
        //addElementToArray(new int[]{20, 20, 40, 20, 30, 40, 50, 60, 50}, 15);
        //multiplicationTable();
        //askForNumber();
        //diagonalValues();
        sortArrayEvensOrOdds(new int[]{56,23,16,78,99,43,20});



        inputReader.close();
    }

    public static int[] getNumArray() {
        int[] numArray = {1, 1, 2, 3, 5, 8, 13, 21};

        return numArray;

    }

    public static String askUserFor(String term) {     //Multi-use method for getting strings
        System.out.println(term + "?");
        return inputReader.nextLine();
    }

    public static int[] reverseArray(int[] theArray) {
        int tempValue = 0;

        for (int i = 0; i < theArray.length / 2; i++) {

            tempValue = theArray[theArray.length - 1 - i];    //Safe-store the number opposite the current one

            theArray[theArray.length - 1 - i] = theArray[i];  //Put the current one in opposite spot

            theArray[i] = tempValue;    //Put safe-stored number in current one
        }


        return theArray;
    }


    public static int[] writeFirstArray(int[] numArray) {

        for (int number : numArray)
            System.out.print(number + ", ");
        return numArray;

    }

    public static String indexOf(int[] numArray, int chosenNumber) {
        return "Index position of number " + chosenNumber + " is: " + Arrays.binarySearch(numArray, chosenNumber);
    }

    public static void sortStringArray(String[] strings) {
        Arrays.sort(strings);

        System.out.println(Arrays.toString(strings));
    }

    public static void copyArray(int[] firstArray) {

        System.out.println("First array: " + Arrays.toString(firstArray));
        int[] secondArray = Arrays.copyOf(firstArray, firstArray.length);
        System.out.println("Second array: " + Arrays.toString(secondArray));
    }

    public static void twoDee() {
        String[][] countryInfo = new String[2][2];

        countryInfo[0][0] = "France";
        countryInfo[0][1] = "Paris";
        countryInfo[1][0] = "Sweden";
        countryInfo[1][1] = "Stockholm";

        for (String[] row : countryInfo)
            System.out.println(Arrays.toString(row));
    }

    public static void averageArray() {
        int[] numArray = {43, 5, 23, 17, 2, 14};

        double sum = 0;
        for (int number : numArray)
            sum += number;

        double avg = (sum / numArray.length);

        System.out.println("Average is: " + avg);
    }

    public static void oddOnesOut() {
        int[] numArray = {1, 2, 4, 7, 9, 12};

        System.out.print("Odd Array:");
        for (int num : numArray)
            if ((num % 2) == 1)
                System.out.print(" " + num);

    }

    public static void removeDuplicates(int[] dupArray) {

        int[] nonDupArray = new int[dupArray.length];       //Make empty array to fill

        int realLength = 0;     //Track how many ACTUAL numbers we've put in the array, since the others will be empty; also track ACTUAL length
        boolean isDupe;

        for (int i = 0; i < dupArray.length - 1; i++) {     //Nested for loops so we can compare all values

            isDupe = false;         //Assume we haven't dound a dupe yet

            for (int j = 0; j < dupArray.length - 1; j++) {

                if (dupArray[i] == nonDupArray[j]) {
                    isDupe = true;          //If the number we're checking is already in the non-dupe array, note that we're dealing with a dupe number
                }
            }
            if (!isDupe) {                  //If we haven't found any signs of dupe, go on and add it to the non-dupe array
                nonDupArray[realLength] = dupArray[i];      //realLength allows us to know which spot is next.
                realLength++;                       //Increase realLength so we'll put the next number in the next spot
            }
        }

        for (int i = 0; i < realLength; i++)
            System.out.print(nonDupArray[i] + " ");
    }

    public static void addElementToArray(int[] numArray, int addition) {
        System.out.println("Before: " + Arrays.toString(numArray));

        numArray = Arrays.copyOf(numArray, numArray.length + 1);

        numArray[numArray.length - 1] = addition;

        System.out.println("After: " + Arrays.toString(numArray));
    }

    public static void multiplicationTable() {
        int[][] baseNumbers = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};

        for (int i = 0; i < baseNumbers[0].length; i++) {

            for (int j = 0; j < baseNumbers[1].length; j++) {
                System.out.print((baseNumbers[0][i] * baseNumbers[1][j]) + "\t");

            }
            System.out.println("\n");
        }
    }


    public static void askForNumber() {
        final int SPECIFICVALUE = 42;
        int guessedNumber = 0;
        int[] numbersCollection = new int[0];

        while (true) {
            guessedNumber = Integer.parseInt(askUserFor("What's your guess"));

            numbersCollection = Arrays.copyOf(numbersCollection, numbersCollection.length + 1);   //Extend array by one

            numbersCollection[numbersCollection.length - 1] = guessedNumber;  //Put guessedNumber into array

            if (guessedNumber == SPECIFICVALUE) {
                System.out.println("You guessed right!");
                break;
            } else
                System.out.println("Wrong!");
        }

        System.out.println("Guesses: " + Arrays.toString(numbersCollection));

        System.out.println("Reverse guesses: " + Arrays.toString(reverseArray(numbersCollection)));

    }

    public static void diagonalValues() {
        int[][] twoDee = {{56, 47, 34, 15}, {78, 39, 11, 23}, {90, 21, 37, 63}, {12, 52, 98, 76}};

        for (int[] row : twoDee)
            System.out.println(Arrays.toString(row));

        System.out.print("Diagonal values:");

        for(int i = 0; i<twoDee.length; i++)
            System.out.print(" "+ twoDee[i][i]);
    }

    public static void sortArrayEvensOrOdds(int[] startArray){
        int foundEvens = 0;
        int foundOdds = 0;
        int[] finishedArray = new int[startArray.length];

        System.out.println("Unsorted array: " +Arrays.toString(startArray));


        for (int i = 0; i < startArray.length; i++) {
            if(startArray[i]%2 == 1){   //Is odd number
                finishedArray[foundOdds] = startArray[i];
                foundOdds++;
            }
            else{                       //Is even number
                finishedArray[finishedArray.length- foundEvens -1] = startArray[i];
                foundEvens++;
            }
        }
        System.out.println("Sorted array: " +Arrays.toString(finishedArray));

    }


}


