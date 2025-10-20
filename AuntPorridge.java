/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.porridge.auntporridge;


import java.util.concurrent.TimeUnit;

public class AuntPorridge {

    // ====================================================================
    // PART A: Baby Feeding Scheduler
    // ====================================================================

    /**
     * Calculates the time required to finish all porridge and milk feedings.
     * The calculation assumes the feedings happen sequentially, one after the other.
     */
    static class BabyFeedingScheduler {
        
        // Constants
        private static final double TOTAL_PORRIDGE_LITERS = 2.0;
        private static final double PORRIDGE_SERVING_LITERS = 0.25; // Half of 0.5L cup
        private static final int PORRIDGE_FEEDING_TIME_MIN = 45;

        private static final double TOTAL_MILK_LITERS = 2.0;
        private static final double MILK_SERVING_LITERS = 0.5; // Full 0.5L cup
        private static final int MILK_FEEDING_TIME_MIN = 30;

        public static void calculateTotalFeedingTime() {
            // 1. Calculate number of servings
            int porridgeServings = (int) (TOTAL_PORRIDGE_LITERS / PORRIDGE_SERVING_LITERS);
            int milkServings = (int) (TOTAL_MILK_LITERS / MILK_SERVING_LITERS);

            // 2. Calculate time spent on each food type
            int totalPorridgeTime = porridgeServings * PORRIDGE_FEEDING_TIME_MIN;
            int totalMilkTime = milkServings * MILK_FEEDING_TIME_MIN;
            
            // 3. Calculate total time
            int totalMinutes = totalPorridgeTime + totalMilkTime;

            // 4. Convert total minutes to hours and minutes
            long hours = TimeUnit.MINUTES.toHours(totalMinutes);
            long minutes = totalMinutes % 60;

            System.out.println("--- Baby Feeding Scheduler ---");
            System.out.printf("Porridge Servings (2L / 0.25L): %d servings\n", porridgeServings);
            System.out.printf("Milk Servings (2L / 0.5L):      %d servings\n", milkServings);
            System.out.printf("Total Porridge Time: %d minutes (%d servings * 45 min)\n", totalPorridgeTime, porridgeServings);
            System.out.printf("Total Milk Time:     %d minutes (%d servings * 30 min)\n", totalMilkTime, milkServings);
            
            System.out.println("------------------------------");
            System.out.printf("Total time required: %d minutes\n", totalMinutes);
            System.out.printf("Which is: %d hours and %d minutes\n", hours, minutes);
        }
    }}

    // ====================