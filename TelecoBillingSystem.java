/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.telcome.billing;

public class TelecoBillingSystem {

   
    private static final double LOAD_AMOUNT_UGX = 10000.0;
    private static final double TAX_RATE = 0.10; // 10%
    private static final int CHARGE_PER_SECOND_UGX = 200;
    private static final int CALL_DURATION_MINUTES = 5;

  
    public static void calculateBalance() {
        // 1. Calculate Tax Charged
        double taxCharged = LOAD_AMOUNT_UGX * TAX_RATE;
        
        // 2. Calculate Net Balance after Tax
        double netBalance = LOAD_AMOUNT_UGX - taxCharged;
        
        // 3. Convert call duration from minutes to seconds
        int callDurationSeconds = CALL_DURATION_MINUTES * 60;

        double totalCallCost = callDurationSeconds * CHARGE_PER_SECOND_UGX;
        
  
        double finalBalance = netBalance - totalCallCost;

        // --- Output Report ---
        System.out.println("--- Telecom Billing Report ---");
        System.out.printf("Initial Load Amount:  UGX %,.2f\n", LOAD_AMOUNT_UGX);
        System.out.printf("Tax Deducted (10%%):  UGX %,.2f\n", taxCharged);
        System.out.printf("Net Usable Balance:   UGX %,.2f\n", netBalance);
        System.out.println("------------------------------");
        System.out.printf("Call Duration:        %d minutes (%d seconds)\n", CALL_DURATION_MINUTES, callDurationSeconds);
        System.out.printf("Call Cost (UGX200/s): UGX %,.2f\n", totalCallCost);
        System.out.println("------------------------------");
        System.out.printf("Final Remaining Balance: UGX %,.2f\n", finalBalance);
    }

    public static void main(String[] args) {
        calculateBalance();
    }
}
