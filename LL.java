package Str;

class PatientList {
    private Node head;

    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    public void registerPatient(Patient patient) {
        Node newNode = new Node(patient);
        newNode.next = head;
        head = newNode;
        System.out.println("Patient registered: " + patient);
    }

    public void dischargePatient(int id) {
        if (head == null) {
            System.out.println("No patients in the list.");
            return;
        }

        Node temp = head;
        Node prev = null;

        if (temp != null && temp.patient.id == id) {
            head = temp.next; // Removed head
            System.out.println("Patient discharged: " + temp.patient);
            return;
        }

        while (temp != null && temp.patient.id != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Patient with ID " + id + " not found.");
            return;
        }

        prev.next = temp.next;
        System.out.println("Patient discharged: " + temp.patient);
    }

    public void printAllPatients() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.patient);
            temp = temp.next;
        }
    }

    public Patient findPatientById(int id) {
        Node current = head;
        while (current != null) {
            if (current.patient.id == id) {
                return current.patient;
            }
            current = current.next;
        }
        return null; 
    }

    public void bubbleSortById() {
        long startTime = System.nanoTime(); 
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current != null && current.next != null) {
                if (current.patient.id > current.next.patient.id) {
                    Patient temp = current.patient;
                    current.patient = current.next.patient;
                    current.next.patient = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        long endTime = System.nanoTime();
        System.out.println("Patients sorted by ID using Bubble Sort:");
        printAllPatients();
        System.out.println("Time taken (nanoseconds): " + (endTime - startTime));
    }

    public void insertionSortByAge() {
        long startTime = System.nanoTime(); 
        Node sorted = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (sorted == null || sorted.patient.age >= current.patient.age) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.patient.age < current.patient.age) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        head = sorted;
        long endTime = System.nanoTime();
        System.out.println("Patients sorted by Age using Insertion Sort:");
        printAllPatients();
        System.out.println("Time taken (nanoseconds): " + (endTime - startTime));
    }
}
