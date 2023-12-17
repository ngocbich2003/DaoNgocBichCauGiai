import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(Student other) {
        // Compare by CGPA in descending order
        if (Double.compare(other.getCGPA(), this.getCGPA()) != 0) {
            return Double.compare(other.getCGPA(), this.getCGPA());
        }

        // Compare by name in ascending order
        if (!other.getName().equals(this.getName())) {
            return this.getName().compareTo(other.getName());
        }

        // Compare by ID in ascending order
        return Integer.compare(this.getId(), other.getId());
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();

        for (String event : events) {
            String[] parts = event.split(" ");

            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                Student student = new Student(id, name, cgpa);
                priorityQueue.add(student);
            } else if (parts[0].equals("SERVED")) {
                priorityQueue.poll(); // Remove the student with the highest priority
            }
        }

        List<Student> remainingStudents = new ArrayList<>(priorityQueue);
        remainingStudents.sort(null); // Sort the remaining students
        return remainingStudents;
    }
}