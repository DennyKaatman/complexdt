package Assignment;

import java.time.Duration;
import java.time.Instant;

public class Linear implements Framework{

    /**
     * Trying a linear search to find a target
     * @param scenario, in worse case use -1
     *                  give back a duration
     */
    public void linearSearch(String scenario) {
        for (int listSize : ListSize) {
            int[] array = App.createSortedList(listSize);
            double[] averageTimeList = new double[testRounds];
            int target = -1;

            if (!scenario.equals("worse")) {
                target = listSize / 2;
            }
            for (int i = 0; i < testRounds; i++) {

                int index = 0;
                boolean targetFound = false;

                Instant instant1 = Instant.now();

                while (!targetFound && index < array.length) {
                    if (array[index] == target) {
                        targetFound = true;
                    }
                    index++;
                }

                Instant instant2 = Instant.now();


                averageTimeList[i] = Duration.between(instant1, instant2).toMillis();

            }

            double averageDuration = App.calculateAverage(averageTimeList);
            System.out.println(" - Execution Time: " + averageDuration + "ms" + " [" + listSize + "]" + target);
        }
    }
}
