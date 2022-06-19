package hw7;
/**
 * ID: 113923920
 * CSE 214 Homework 7
 * @author Yuqing Wang
 * R02
 */
import java.util.Comparator;
import java.util.Scanner;

public class NeoViewer {
    public static void main(String[] args) throws Exception {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Welcome to NEO Viewer!");
        System.out.println();
        System.out.println("Option Menu:");
        System.out.println("  A) Add a page to the database");
        System.out.println("  S) Sort the database ");
        System.out.println("  P) Print the database as a table.");
        System.out.println("  Q) Quit");
        System.out.println();
        NeoDatabase database = new NeoDatabase();
        while (true) {
            System.out.print("Select a menu option: ");
            String input = stdin.next();
            char option = input.toUpperCase().charAt(0);
            System.out.println();
            if (option == 'A') {
                System.out.print("Enter the page to load: ");
                int page = Integer.parseInt(stdin.next());
                while (page > 715 || page < 0) {
                    System.out.println("Your input is illegal. Please enter again.");
                    System.out.print("Enter the page to load: ");
                    page = Integer.parseInt(stdin.next());
                }
                String queryURL = database.buildQueryURL(page);
                database.addAll(queryURL);
                System.out.println("Page loaded successfully!");
            } else if (option == 'S') {
                System.out.println("R) Sort by referenceID ");
                System.out.println("D) Sort by diameter");
                System.out.println("A) Sort by approach date");
                System.out.println("M) Sort by miss distance");
                while(true) {
	                System.out.print("Select a menu option: ");
	                stdin.nextLine();
	                char sortOption = stdin.next().toUpperCase().charAt(0);
	                Comparator<NearEarthObject> comp;
	                if (sortOption == 'R') {
	                    comp = new ReferenceIDComparator();
	                    database.sort(comp);
	                    System.out.println("Table sorted on reference ID. "); 
	                    System.out.println(); break;
	                } else if (sortOption == 'D') {
	                    comp = new DiameterComparator();
	                    database.sort(comp);
	                    System.out.println("Table sorted on diameter. "); 
	                    System.out.println(); break;
	                } else if (sortOption == 'A') {
	                    comp = new ApproachDateComparator();
	                    database.sort(comp);
	                    System.out.println("Table sorted on approach date. "); 
	                    System.out.println(); break;
	                } else if (sortOption == 'M') {
	                    comp = new MissDistanceComparator();
	                    database.sort(comp);
	                    System.out.println("Table sorted on miss distance. "); 
	                    System.out.println(); break;
	                }
	                else {
	                	System.out.println("Your input is illegal. Please enter again. ");
	                	continue;
	                }
                }
                
            } else if (option == 'P') {
                database.printTable();
            } else if (option == 'Q') {
                break;
            }
        }
        System.out.println("Program terminating normally...");
        stdin.close();
    }
}