package Str;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientList patientList = new PatientList();
        AppointmentQueue appointmentQueue = new AppointmentQueue();
        DischargeStack dischargeStack = new DischargeStack();

        int choice;
        while (true) {
            System.out.println("\n--- Welcome to the Hospital Management System ---");
            System.out.println("\nPlease choose one of the options :");
            System.out.println("\n1. Register a patient");
            System.out.println("2. Discharge a patient");
            System.out.println("3. Add patient to appointment");
            System.out.println("4. Process next appointment");
            System.out.println("5. Temporarily discharge a patient");
            System.out.println("6. Re-admit a patient");
            System.out.println("7. Exit the system");
            System.out.println("8. Display all active patients");
            System.out.println("9. Sort patients");
            System.out.print("\nEnter your choice please: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter patient illness: ");
                    String ailment = scanner.nextLine();
                    patientList.registerPatient(new Patient(name, id, age, ailment));
                    break;
                case 2:
                    System.out.print("Enter patient ID to discharge: ");
                    int dischargeId = scanner.nextInt();
                    patientList.dischargePatient(dischargeId);
                    break;
                case 3:
                    System.out.print("Enter patient ID for appointment: ");
                    int appId = scanner.nextInt();
                    Patient patientForQueue = patientList.findPatientById(appId);
                    if (patientForQueue != null) {
                        appointmentQueue.enqueue(patientForQueue);
                    } else {
                        System.out.println("No patient found with this ID: " + appId);
                    }
                    break;
                case 4:
                    appointmentQueue.dequeue();
                    break;
                case 5:
                    System.out.print("Enter patient ID for temporary discharge: ");
                    int tempDischargeId = scanner.nextInt();
                    Patient patientForStack = patientList.findPatientById(tempDischargeId);
                    if (patientForStack != null) {
                        dischargeStack.push(patientForStack);
                    } else {
                        System.out.println("No patient found with ID: " + tempDischargeId);
                    }
                    break;
                case 6:
                    dischargeStack.pop();
                    break;
                case 7:
                    System.out.println("Exiting system.....");
                    scanner.close();
                    return;
                case 8:
                    System.out.println("Active Patients:");
                    patientList.printAllPatients();
                    break;
                case 9:
                    System.out.println("Choose sorting method:");
                    System.out.println("1. Sort by ID");
                    System.out.println("2. Sort by Age");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) {
                        patientList.bubbleSortById();
                    } else if (sortChoice == 2) {
                        patientList.insertionSortByAge();
                    } else {
                        System.out.println("Invalid sorting option.");
                    }
                    break;
                default:
                    System.out.println("Sorry, Invalid option please try again");
            }
        }
    }
}
