package Str;

public class Patient {
    String name;
    int id;
    int age;
    String ailment;

    public Patient(String name, int id, int age, String ailment) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.ailment = ailment;
    }

    @Override
    public String toString() {
        return "Patient{" +
               "Name='" + name + '\'' +
               ", ID=" + id +
               ", Age=" + age +
               ", Ailment='" + ailment + '\'' +
               '}';
    }
}
