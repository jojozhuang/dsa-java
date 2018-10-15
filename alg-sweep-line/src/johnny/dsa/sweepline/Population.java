package johnny.dsa.sweepline;

import java.util.Arrays;

public class Population {
    // brute force, 
    // time: O(n*y), n is the number of persons, y is the year range.
    // space: O(y)
    public int getMostPopulationBruteForce(int[][] persons) {
        if (persons == null || persons.length == 0) {
            return 0;
        }
        
        // find the first year(birth) and the last year(death) of the given persons
        int yearStart = Integer.MAX_VALUE, yearEnd = Integer.MIN_VALUE;
        for (int[] person : persons) {
            yearStart = Math.min(yearStart, person[0]);
            yearEnd = Math.max(yearEnd, person[1]);
        }
        
        // calculate the population for each year 
        int max = 0;
        int[] years = new int[yearEnd - yearStart + 1];
        for (int i = 0; i < years.length; i++) {
            for (int j = 0; j < persons.length; j++) {
                if ((persons[j][0] <= i + yearStart) && 
                    (persons[j][1] > i + yearStart)) {
                    years[i]++;
                }
            }
            max = Math.max(max, years[i]);
        }

        return max;
    }
    
    // timeline, add 1 if born, minus 1 if dead, count the maximum of the timeline. 
    // time: O(p+p+y), n is the number of persons, y is the year range.
    // space: O(y)
    public int getMostPopulationTimeLine(int[][] persons) {
        if (persons == null || persons.length == 0) {
            return 0;
        }
        
        // find the first year(birth) and the last year(death) of the given persons
        int yearStart = Integer.MAX_VALUE, yearEnd = Integer.MIN_VALUE;
        for (int[] person : persons) {
            yearStart = Math.min(yearStart, person[0]);
            yearEnd = Math.max(yearEnd, person[1]);
        }
        
        // increment if born, decrement if dead
        int[] years = new int[yearEnd - yearStart + 1];
        for (int i = 0; i < persons.length; i++) {
            years[persons[i][0] - yearStart]++;
            years[persons[i][1] - yearStart]--;
        }
        
        System.out.println(Arrays.toString(years));
        
        // go through and find the maximum
        int max = 0;
        int count = 0;
        for (int i = 0; i < years.length; i++) {
            count += years[i];
            max = Math.max(max, count);
        }
        
        return max;
    }
}
