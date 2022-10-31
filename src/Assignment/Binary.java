package Assignment;

import java.time.Duration;
import java.time.Instant;

public class Binary implements Framework {
    /**
     * Trying a binary search to find a target
     * @param scenario, in worse case use -1
     *                  give back a duration
     */
    public void binarySearch(String scenario) {
        for (int listSize : ListSizeB) {
            int[] array = App.createSortedList(listSize);
            double[] averageTimeList = new double[testRounds];
            int target = 1;


            if (!scenario.equals("worse")) {
                target = listSize;
            }

            for (int i = 0; i < testRounds; i++) {

                int index = 0;
                int left = 0;
                int right = array.length - 1;

                boolean targetFound = false;

                Instant instant1 = Instant.now();

                while (left <= right) {
                    int mid = left + ((right - left) / 2);
                    if (array[mid] == target) {
                        targetFound = true;
                        break;
                    } else if (target < array[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                Instant instant2 = Instant.now();

                averageTimeList[i] = Duration.between(instant1, instant2).toMillis();
            }

            double averageDuration = App.calculateAverage(averageTimeList);
            System.out.println(" - Execution Time: " + averageDuration + "ms" + " [" + listSize + "]" + target);
        }

    }
}
