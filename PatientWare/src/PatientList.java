import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientList {
    private ArrayList<Patient> patientList;
    private String filename;
    private Scanner filescanner;

    public PatientList(String filename) {
        this.filename = filename;
        patientList = new ArrayList<>();
    }

    public void loadFromFile() {
        // Your code here
        File myfile = new File("patients.csv");
        try{
        filescanner = new Scanner(myfile);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        while(filescanner.hasNextLine()){
            String[] s = filescanner.nextLine().split(",");

            String firstname = s[0];
            String lastname = s[1];
            String id = s[2];
            String address = s[3];
            int age = Integer.parseInt(s[4]);

            Patient p = new Patient(firstname,lastname,id,address,age);
            patientList.add(p);
        }
    }

    public void writeToFile() {
        // Your code here // copy paste
        try {
            FileWriter myWriter = new FileWriter("patient_output.csv");
            //            myWriter.write(patientList.toString());


            for (Patient p: patientList){
                myWriter.write(p.toCSV());
                myWriter.write("\n");
                // update here!
                p.updateChart();
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void append(Patient p) {
        // Your code here
        patientList.add(p);

    }

    public Patient findByName(String firstName, String lastName) {
        Patient p = null;
        // Your code here
        for(Patient pat:patientList){
            if(pat.getFirstName().equals(firstName) && pat.getLastName().equals(lastName)){
                return pat;
            }
        }
        return p;
    }

    public Patient findByID(String id) {
        Patient p = null;
        // Your code here
        for(Patient pat:patientList){
            if(pat.getId().equals(id)){
                return pat;
            }
        }

        return p;
    }

    public void display() {
        if (patientList.size() == 0) {
            System.out.println("Patient list is empty");
            return;
        }
        System.out.printf("%10s %10s %5s %20s %3s\n", "First Name", "Last Name", "ID", "Address", "Age");
        // Your code here
        for(Patient p:patientList){
            System.out.println(p.toString( ));
        }
    }
}
