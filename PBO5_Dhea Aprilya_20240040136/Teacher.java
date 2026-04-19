public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = {};

    public Teacher(String name, String address) {
        super(name, address);
        this.courses = new String[50];
    }

    public boolean addCourse(String course) {
        // Return false if the course already existed
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                System.out.println("Gagal: Mata kuliah \"" + course + "\" sudah ada dalam daftar.");
                return false;
            }
        }
        courses[numCourses] = course;
        numCourses++;
        System.out.println("Mata kuliah \"" + course + "\" berhasil ditambahkan.");
        return true;
    }

    public boolean removeCourse(String course) {
        // Return false if the course does not exist
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                // Shift remaining elements left
                for (int j = i; j < numCourses - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[numCourses - 1] = null;
                numCourses--;
                System.out.println("Mata kuliah \"" + course + "\" berhasil dihapus.");
                return true;
            }
        }
        System.out.println("Gagal: Mata kuliah \"" + course + "\" tidak ditemukan.");
        return false;
    }

    public String tpString() {
        if (numCourses == 0) return getName() + " belum mengampu mata kuliah apapun.";
        StringBuilder sb = new StringBuilder();
        sb.append("Mata kuliah yang diampu oleh ").append(getName()).append(":\n");
        for (int i = 0; i < numCourses; i++) {
            sb.append("  ").append(i + 1).append(". ").append(courses[i]).append("\n");
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return "Teacher: " + getName() + "(" + getAddress() + ")";
    }
}
