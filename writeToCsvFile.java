package testjava;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class writeToCsvFile {
    public static void main(String[] args) {
        String filePath = "D:\\eclipse-workspace\\filename.csv";
        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            List<String[]> data = new ArrayList<String[]>();
            
            String[] header = { "fabric", "fabricweight", "fabriccolour", "fabricquantity" };
            writer.writeNext(header);
            System.out.println("___HARSHABBI TEXTILES___");
            System.out.println("Textile inputs.....");
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Choose an option:");
                System.out.println("1. Enter fabric data");
                System.out.println("2. Display existing data");
                System.out.println("0. Exit");
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        String[] inputdata = new String[4];
                        System.out.print("Enter fabric: ");
                        inputdata[0] = sc.nextLine();
                        System.out.print("Enter fabricweight: ");
                        inputdata[1] = sc.nextLine();
                        System.out.print("Enter fabriccolour: ");
                        inputdata[2] = sc.nextLine();
                        System.out.print("Enter fabricquantity: ");
                        inputdata[3] = sc.nextLine();
                        writer.writeNext(inputdata);
                        data.add(inputdata);
                        break;
                    case 2:
                        displayData(data);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } while (choice != 0);

            sc.close();
            writer.close();
            System.out.print("Data Saved Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayData(List<String[]> data) 
    {
        if (data.isEmpty()) 
        {
            System.out.println("No data available.");
        } 
        else 
        {
            for (String[] row : data) 
            {
                for (String cell : row)
                {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        }
    }
}


