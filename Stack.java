package Str;

class DischargeStack {
    private Node top;

    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
        }
    }

    public void push(Patient patient) {
        Node newNode = new Node(patient);
        newNode.next = top;
        top = newNode;
        System.out.println("Patient temporarily discharged: " + patient);
    }

    public void pop() {
        if (top == null) {
            System.out.println("No patients temporarily discharged.");
            return;
        }
        System.out.println("Patient re-admitted: " + top.patient);
        top = top.next;
    }
}
