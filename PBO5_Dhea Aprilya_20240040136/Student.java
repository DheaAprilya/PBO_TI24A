public class Student extends Person {
    private int numCourses = 0;
    private String[] courses = {};
    private int[] grades = {};

    public Student(String name, String address) {
        super(name, address);
        this.courses = new String[50];
        this.grades = new int[50];
    }

    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses++;
        System.out.println("Mata kuliah \"" + course + "\" dengan nilai " + grade + " berhasil ditambahkan.");
    }

    public void printGrades() {
        if (numCourses == 0) {
            System.out.println("Tidak ada mata kuliah yang terdaftar.");
            return;
        }
        System.out.println("Daftar Nilai " + getName() + ":");
        System.out.println("----------------------------------");
        for (int i = 0; i < numCourses; i++) {
            System.out.printf("  %-25s : %d%n", courses[i], grades[i]);
        }
        System.out.println("----------------------------------");
    }

    public double getAverageGrade() {
        if (numCourses == 0) return 0.0;
        int total = 0;
        for (int i = 0; i < numCourses; i++) {
            total += grades[i];
        }
        return (double) total / numCourses;
    }

    @Override
    public String toString() {
        return "Student: " + getName() + "(" + getAddress() + ")";
    }
}
