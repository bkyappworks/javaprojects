import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Chart {
    private ArrayList<HealthItem> chart = new ArrayList();
    private String id;
    private String filename;
    //
    public static Scanner fileScanner;

    public Chart(String id) {
        // Your code here
        this.id = id;
        this.filename = filename.format("HI"+id+".csv");
        this.chart = new ArrayList<>();
    }

    public void loadFromFile() {
        // Your code here
        File file = new File(filename);
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            //
        }
        while (fileScanner.hasNextLine()) {
            String[] s = fileScanner.nextLine().split(","); //firstName, lastName, id, address
            String id = s[0];
            String testName = s[1];
            String date = s[2];
            String value = s[3];

            HealthItem healthItem = new HealthItem(id, testName, date, value);
            chart.add(healthItem);
        }
    }

    public void append(HealthItem healthItem) {
        // Your code here
        chart.add(healthItem);
    }

    public void display() {
        if (chart.size() == 0 ) {
            System.out.println("No chart for this patient");
            return;
        }
        System.out.printf("%5s %20s %12s %5s\n", "ID", "Test Name", "Date", "Value");
        for (HealthItem h : chart) {
            System.out.println(h.toString());
       }
    }

    public void writeToFile() {
        // Your code here
        //write a HealthItem to file
        try {
            FileWriter myWriter = new FileWriter("HI"+id+".csv");
            for (HealthItem h : chart){
                myWriter.write(h.toCSV());
                myWriter.write("\n");
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
