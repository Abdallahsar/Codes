package Str;

class AppointmentQueue {
    private static class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node front, rear;

    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        System.out.println("Patient added to appointment: " + patient);
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Appointment is empty.");
            return;
        }
        System.out.println("Patient processed from appointment: " + front.patient);
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }
}
