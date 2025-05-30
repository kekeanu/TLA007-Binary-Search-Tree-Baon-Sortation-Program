


// Mark Gieo M. Navales and Keanu John P. Lumando

package com.mycompany.binarytree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
public class lumando_Tree {

   public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryTree baonTree = new BinaryTree();
        LinkedList<Integer> baonList = new LinkedList<>(); // Additional list to store values

        for (String arg : args) {
            try {
                int amount = Integer.parseInt(arg);
                baonTree.insert(amount);
                baonList.add(amount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input in args: " + arg);
            }
        }

        while (true) {
            System.out.println("\nManage Baon");
            System.out.println("1. Display Student's Baon");
            System.out.println("2. Add Student's Baon");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scan.nextLine();

            switch (choice) {
                case "1":
                    viewBaon(baonTree, baonList);
                    break;
                case "2":
                    addBaon(scan, baonTree, baonList);
                    break;
                case "3":
                    System.out.println("Exiting. Goodbye!");
                    scan.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void viewBaon(BinaryTree baonTree, LinkedList<Integer> baonList) {
        if (baonList.isEmpty()) {
            System.out.println("There is no baon amount added.");
        } else {

            System.out.println("\nAscending order (from BinaryTree):");
            baonTree.inorder();

            // Create descending order by sorting the list
            LinkedList<Integer> descendingList = new LinkedList<>(baonList);
            Collections.sort(descendingList, Collections.reverseOrder());

            System.out.println("\nStudent's Baon (from largest to smallest):");
            for (int i = 0; i < descendingList.size(); i++) {
                System.out.println((i + 1) + ". " + descendingList.get(i));
            }
        }
    }

    private static void addBaon(Scanner scan, BinaryTree baonTree, LinkedList<Integer> baonList) {
        System.out.println("Enter baon amounts one by one. Type 'done' to finish.");

        while (true) {
            System.out.print("Baon amount: ");
            String input = scan.nextLine().trim();

            if (input.equalsIgnoreCase("done")) {
                System.out.println("Finished adding baon amounts.");
                break;
            }

            if (input.isEmpty()) {
                System.out.println("Baon amount cannot be empty.");
                continue;
            }

            try {
                int amount = Integer.parseInt(input);
                baonTree.insert(amount);
                baonList.add(amount);
                System.out.println("Baon added.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer or type 'done'.");
            }
        }
    }
}