import java.util.*;

class Student{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

//Complete the code
class CompareData implements Comparator<Student>{
    @Override
    public int compare(Student s1, Student s2) {
        // comparing 1st condition viz CGPA in desc order
        if (s1.getCgpa() != s2.getCgpa()){
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        } else {
            // comparing 2nd condition
            int nameComparison = s1.getFname().compareTo(s2.getFname());
            if (nameComparison != 0){
                return nameComparison;
            }
            //comparing 3rd condition
            return Integer.compare(s1.getId(), s2.getId());
        }

    }
}


public class JavaSort
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);
            testCases--;

        }
        // called Collections.sort method to sort the studentList and created the object of CompareData class.
        Collections.sort(studentList, new CompareData());
        for(Student st: studentList){
            System.out.println(st.getFname());
        }
        //closed the scanner.
        in.close();
    }
}