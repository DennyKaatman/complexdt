package Assignment;

import java.util.Arrays;
import java.util.Random;

public class App {

    public static void main(String[] args){
        // Creating the tests
        System.out.println("Comparing multiple ways of searching in datastructures - Sequential VS Binair");
        System.out.println("-----------------------------------------------------------------------------");
        Linear linearSearch = new Linear();
        System.out.println("Linear, worse case");
        linearSearch.linearSearch("worse");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Linear, average case");
        linearSearch.linearSearch("average");
        System.out.println("");
        Binary binarySearch = new Binary();
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Binary, worse case");
        System.out.println("");
        binarySearch.binarySearch("worse");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Binary, average case");
        System.out.println("");
        binarySearch.binarySearch("average");
    }


    /**
     * @param amount of integers in the list
     * @return a list with random integers
     */
    public static int[] createRandomList(int amount){
        int [] list = new int [amount];
        Random rnd = new Random();

        for (int i = 0; i < amount; i++) {
            list[i] = rnd.nextInt(amount);
        }
        return list;
    }

    /**
     * @param amount of integers in the list
     * @return a list with sorted integers
     */
    public static int[] createSortedList(int amount){
        int [] list = new int [amount];

        for (int i = 0; i < amount; i++) {
            list[i] = i+1;
        }
        return list;
    }

    /**
     * @param averageTimeList is an array of the average times for all the runs
     * @return the average per list.
     */
    public static double calculateAverage(double[] averageTimeList){
        if(averageTimeList.length<=2){
            return Arrays.stream(averageTimeList).average().getAsDouble();
        }

        double max = Arrays.stream(averageTimeList).max().getAsDouble();
        double min = Arrays.stream(averageTimeList).min().getAsDouble();
        double sum = Arrays.stream(averageTimeList).sum() - max - min;
        return sum/(averageTimeList.length-2);
    }
}
