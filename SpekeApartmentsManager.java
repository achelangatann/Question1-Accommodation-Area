/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spekeapartments;

import java.util.Scanner;
import java.util.InputMismatchException; 

public class SpekeApartmentsManager {

    private static AccommodationArea activeArea;
    // Instantiate your area objects here
    private static final GymArea gym = new GymArea();
    private static final SwimmingArea pool = new SwimmingArea();
    private static final Scanner scanner = new Scanner(System.in);

  
    public static void main(String[] args) {
        // Start with Gym as the default active area
        activeArea = gym;
        System.out.println("Welcome, Speke Apartments Estates Manager!");
        System.out.println("Active Area set to: " + activeArea.getName());

        boolean running = true;
        
        // The main menu loop
        while (running) { 
            displayMenu();
            System.out.print("Enter command: ");

            String command = "";
            if (scanner.hasNextLine()) {
                command = scanner.nextLine().toUpperCase().trim();
            }

            switch (command) {
                case "S":
                    selectArea();
                    break;
                case "W":
                    addOccupants();
                    break;
                case "X":
                    removeOccupants();
                    break;
                case "Y":
                    toggleLight(true); // Switch ON
                    break;
                case "Z":
                    toggleLight(false); // Switch OFF
                    break;
                case "R":
                    reportStatus();
                    break;
                case "Q":
                    running = false;
                    System.out.println("\nProgram terminated. Goodbye! ");
                    break;
                default:
                    System.out.println("❌ Invalid command. Please use S, W, X, Y, Z, R, or Q.");
            }
            System.out.println(); // Newline for clean output separation
        }

        scanner.close();
    }
    
   
    private static void displayMenu() {
        System.out.println("\n--- Main Menu (Active: " + activeArea.getName() + ") ---");
        System.out.println("S - Select active area (G=Gym, P=Swimming)");
        System.out.println("W - Add 'n' occupants to the active area");
        System.out.println("X - Remove 'n' occupants from the active area");
        System.out.println("Y - Switch ON a light (1-3) in the active area");
        System.out.println("Z - Switch OFF a light (1-3) in the active area");
        System.out.println("R - Report status (Area, Occupants, Lights)");
        System.out.println("Q - Quit the program");
        System.out.println("----------------------------------------------");
    }

    private static void selectArea() {
        System.out.print("Select Area (G for Gym, P for Swimming): ");
        String choice = "";
        if (scanner.hasNextLine()) {
            choice = scanner.nextLine().toUpperCase().trim();
        }

        switch (choice) {
            case "G":
                activeArea = gym;
                System.out.println("✅ Active Area switched to: " + activeArea.getName());
                break;
            case "P":
                activeArea = pool;
                System.out.println("✅ Active Area switched to: " + activeArea.getName());
                break;
            default:
                System.out.println("❌ Invalid selection. Active Area remains: " + activeArea.getName());
        }
    }

    /**
     * Repeatedly prompts the user for a valid non-negative integer.
     * @param prompt The message to display to the user.
     * @return The valid non-negative integer input.
     */
    private static int promptForInteger(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                int n = Integer.parseInt(line.trim());
                if (n < 0) {
                    System.out.println("❌ Input must be a non-negative integer.");
                    continue; // Re-prompt
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter an integer number.");
            }
        }
    }
    
    /**
     * Prompts the user specifically for a light number (1, 2, or 3).
     * @return The valid light number.
     */
    private static int promptForLightNumber() {
        while (true) {
            int lightNum = promptForInteger("Enter light number (1, 2, or 3): ");
            if (lightNum >= 1 && lightNum <= 3) {
                return lightNum;
            } else {
                System.out.println("❌ Invalid light number. Must be 1, 2, or 3.");
            }
        }
    }

    private static void addOccupants() {
        System.out.println("--- Add Occupants to " + activeArea.getName() + " ---");
        int n = promptForInteger("Enter number of occupants to add: ");
        activeArea.addOccupants(n);
    }

    private static void removeOccupants() {
        System.out.println("--- Remove Occupants from " + activeArea.getName() + " ---");
        int n = promptForInteger("Enter number of occupants to remove: ");
        activeArea.removeOccupants(n); 
    }

    private static void toggleLight(boolean on) {
        String action = on ? "ON" : "OFF";
        System.out.println("--- Switch Light " + action + " in " + activeArea.getName() + " ---");
        int lightNum = promptForLightNumber();
        activeArea.setLight(lightNum, on);
    }

    private static void reportStatus() {
        System.out.println(activeArea.getStatusReport());
    }
}
