import java.util.Scanner;

public class HW1Driver {

    // Use this for all keyboard input
    public static Scanner scanner = new Scanner(System.in);
    public static int choice = 0;

    public static int menu() {
//       int choice = 0; // change given code
       // Your code here
        System.out.println("1. List all patients");
        System.out.println("2. Add a new patient");
        System.out.println("3. Search by name");
        System.out.println("4. Search by Patient ID");
        System.out.println("5. Add a new Health Item");
        System.out.println("0. Quit");
        System.out.println("Enter Your Choice: ");

        try {
            choice = Integer.parseInt(scanner.nextLine());

            if(choice < 0 ||choice > 5){
                choice = 0;
            }
        }
        catch(NumberFormatException e) {
            choice = 0;
            System.out.println("Your Choice is: " + choice);
        }

        System.out.println("Your Choice is: " + choice);

       return choice;
    }

    public static void main(String[] args) {
        // Your code here

        //
        PatientList patientList = new PatientList("patients.csv");
        Patient p = new Patient();
        patientList.loadFromFile();
        String currentPatient = null;

        do{
            menu();
            if (choice == 1){
                patientList.display();

            }
            else if (choice == 2){
                System.out.println("Enter patient first name: ");
                String firstname = scanner.nextLine();

                System.out.println("Enter patient last name: ");
                String lastname = scanner.nextLine();

                System.out.println("Enter patient ID: ");
                String id = scanner.nextLine();

                System.out.println("Enter patient address: ");
                String address = scanner.nextLine();

                System.out.println("Enter patient age: ");
                int age = Integer.parseInt(scanner.nextLine());

                p = new Patient(firstname,lastname,id,address,age);
                patientList.append(p);

            }
            else if (choice == 3){
                System.out.println("Enter patient first name: ");
                String firstname = scanner.nextLine();

                System.out.println("Enter patient last name: ");
                String lastname = scanner.nextLine();

                //print this patient's data
                if(patientList.findByName(firstname,lastname) == null){
                    System.out.println("Not Found");
                }else{
                    System.out.printf("%10s %10s %5s %20s %3s\n", "First Name", "Last Name", "ID", "Address", "Age");
                    p = patientList.findByName(firstname,lastname);
                    System.out.println(p.toString());

                    //print this patient's chart
                    System.out.println("Chart: ");
                    // both way works
/*                    Chart chart = p.getChart(); // get a chart object
                    chart.display(); // why load?*/
                    p.getChart().display();
                }

            }
            else if (choice == 4){
                System.out.println("Enter patient ID: ");
                String id = scanner.nextLine();

                p = patientList.findByID(id);

                if(p == null){
                    System.out.println("Not Found");
                }else{
                    // print data
                    System.out.printf("%10s %10s %5s %20s %3s\n", "First Name", "Last Name", "ID", "Address", "Age");
                    System.out.println(p.toString());
                    System.out.println("Chart: ");
                    p.showChart();
                    currentPatient = id;

                }

            }
            else if (choice == 5){
                // get id for current patient
                String id = currentPatient;
                System.out.println("For patient ID "+id);

                //print to get input
                System.out.println("Enter test name of the Health Item or Quit to cancel: ");
                String testName = scanner.nextLine();

                System.out.println("Enter test date: ");
                String date = scanner.nextLine();

                System.out.println("Enter test value: ");
                String value = scanner.nextLine();

                System.out.println(testName+" added to "+id+" record");
                HealthItem h = new HealthItem(id, testName, date, value);

                p = patientList.findByID(id);
                p.appendHealthItem(h);

            }

        }while(choice != 0);
        patientList.writeToFile( );
        System.out.println("Thank you for using PatientWare.");
    }
}
