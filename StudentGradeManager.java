import java.util.Scanner;

public class StudentGradeManager {
    // the data structure 
    static String[] studentName = new String[10];
    static int[] rollNumber = new int[10];
    static int[][] marks = new int[10][3];
    static int studentCount = 0; // tracking current student count, used as array pointer
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int userChoice = 0;
        while (true) {
            menu();
            System.out.println("Enter your choice: ");
            userChoice = sc.nextInt();
            sc.nextLine();
            // checking whether the databse if empty before use is navigated to it's choice of method
            if (userChoice >= 2 && userChoice <= 8 && studentCount == 0) {
                System.out.println("\nDatabase is empty. Please add a student first (Option 1).\n");
                continue;
            }
            switch (userChoice) {
                case 1:
                    System.out.println("\n");
                    addStudent();
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("\n");
                    viewStudents();
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("\n");
                    searchByRollNo();
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("\n");
                    updateMarks();
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("\n");
                    deleteStudent();
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("\n");
                    classStatistics();
                    System.out.println("\n");
                    break;
                case 7:
                    System.out.println("\n");
                    gradeDistribution();
                    System.out.println("\n");
                    break;
                case 8:
                    System.out.println("\n");
                    sortByMarks();
                    System.out.println("\n");
                    break;
                case 9:
                    System.out.println("\n");
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1-9.");
            }
        }
    }

    public static void menu() {
        System.out.println("====================== Student Grade Manager ======================");
        System.out.println("1. Add a student");
        if (studentCount == 0) {
            System.out.println("2. View all students           (Add a student first)");
            System.out.println("3. Search student by roll no");
            System.out.println("4. Update marks");
            System.out.println("5. Delete a student");
            System.out.println("6. Show class statistics");
            System.out.println("7. Show grade distribution");
            System.out.println("8. Sort student by marks");
        } else {
            System.out.println("2. View all students");
            System.out.println("3. Search student by roll number");
            System.out.println("4. Update marks");
            System.out.println("5. Delete a student");
            System.out.println("6. Show class statistics");
            System.out.println("7. Show grade distribution");
            System.out.println("8. Sort student by marks");
        }
        System.out.println("9. Exit");
        System.out.println("===================================================================\n\n");
    }

    public static void addStudent() {
        if (studentCount >= 10) {
            System.out.println("Database full, sorry for the inconvenience.");
            return;
        }
        // user choice for how many students data user wants to add
        System.out.println("How many students data you want to add?");
        System.out.println("You can add " + (10 - studentCount) + " more students at most.");
        int numberOfStudents = sc.nextInt();
        sc.nextLine();

        int availableSpace = 10 - studentCount;
        // checking whether user choice exceeds the available database storage
        if (availableSpace < numberOfStudents) {
            System.out.println(
                    "Only " + availableSpace + " slots are available. Adding " + availableSpace + " students.");
            numberOfStudents = availableSpace;
        }

        int target = studentCount + numberOfStudents;
        // collecting student data
        for (int i = studentCount; i < target; i++) {
            System.out.println("\nEnter student name: ");
            studentName[i] = sc.nextLine();

            System.out.println("\nEnter student roll number: ");
            rollNumber[i] = sc.nextInt();
            sc.nextLine();

            System.out.println("\nEnter Student marks for Maths: ");
            marks[i][0] = sc.nextInt();
            sc.nextLine();
            // putting validation on the input by limiting the input range
            while (marks[i][0] < 0 || marks[i][0] > 100) {
                System.out.println("Enter Student marks for Maths again [0-100]: ");
                marks[i][0] = sc.nextInt();
                sc.nextLine();
            }

            System.out.println("\nEnter student marks for Science: ");
            marks[i][1] = sc.nextInt();
            sc.nextLine();
            while (marks[i][1] < 0 || marks[i][1] > 100) {
                System.out.println("Enter Student marks for Science again [0-100]: ");
                marks[i][1] = sc.nextInt();
                sc.nextLine();
            }

            System.out.println("\nEnter student marks for Language:");
            marks[i][2] = sc.nextInt();
            sc.nextLine();
            while (marks[i][2] < 0 || marks[i][2] > 100) {
                System.out.println("Enter Student marks for Language again [0-100]: ");
                marks[i][2] = sc.nextInt();
                sc.nextLine();
            }
        }
        studentCount += numberOfStudents;
        System.out.println(numberOfStudents + " student(s) added successfully!");
    }

    public static void viewStudents() {
        System.out.printf("%-15s %-10s %-8s %-10s %-10s%n", "Name", "Roll No.", "Math", "Science", "Language");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%-15s %-10d %-8d %-10d %-10d%n", studentName[i], rollNumber[i], marks[i][0],
                    marks[i][1],
                    marks[i][2]);
        }
    }

    public static void searchByRollNo() {
        System.out.println("Enter the roll number of the student you want to search: ");
        int searchRollNo = sc.nextInt();
        sc.nextLine();
        // displaying student information when provided roll number matches that in the databse
        for (int i = 0; i < studentCount; i++) {
            if (searchRollNo == rollNumber[i]) {
                System.out.printf("%-15s %-10s %-8s %-10s %-10s%n", "Name", "Roll No.", "Math", "Science",
                        "Language");
                System.out.println("-------------------------------------------------------");
                System.out.printf("%-15s %-10d %-8d %-10d %-10d%n", studentName[i], rollNumber[i], marks[i][0],
                        marks[i][1], marks[i][2]);
                return;
            }
        }
        // when provided roll number isn't present in the database
        System.out.println("Student with roll number " + searchRollNo + " doesn't exist.");
    }

    public static void updateMarks() {
        // students can have same marks, thus searching by name to update the marks
        System.out.println("Enter name of the student, whos' marks you want to change: ");
        String name = sc.nextLine();
        int studentIndex = -1;
        // Checking whether the student exists or not
        for (int i = 0; i < studentCount; i++) {
            if (name.equalsIgnoreCase(studentName[i])) {
                studentIndex = i;
                break;
            }
        }
        if (studentIndex == -1) {
            System.out.println("Student " + name + " not found.");
            return;
        }

        System.out.println("Which subject marks you want to change Math, Science, Language?: ");
        String subject = sc.nextLine();
        int subjectIndex;
        if (subject.equalsIgnoreCase("Math")) {
            subjectIndex = 0;
        } else if (subject.equalsIgnoreCase("Science")) {
            subjectIndex = 1;
        } else if (subject.equalsIgnoreCase("Language")) {
            subjectIndex = 2;
        } else {
            System.out.println("Invalid Subject. Choose between Math, Science, or Language");
            return;
        }

        System.out.println("Current marks: " + marks[studentIndex][subjectIndex]);
        System.out.println("Enter new marks [0-100]: ");
        int newMarks = sc.nextInt();
        sc.nextLine();
        while (newMarks < 0 || newMarks > 100) {
            System.out.println("Invalid! Enter marks [0-100]: ");
            newMarks = sc.nextInt();
            sc.nextLine();
        }
        // replacing the existing marks with the user provided marks
        marks[studentIndex][subjectIndex] = newMarks;
        System.out.println("Marks updated successfully!");
    }

    public static void deleteStudent() {
        // searching the student name which user wants to delete
        System.out.println("Enter the name of the student you want to remove: ");
        String name = sc.nextLine();
        int studentIndex = -1;
        for (int i = 0; i < studentCount; i++) {
            if (name.equalsIgnoreCase(studentName[i])) {
                studentIndex = i;
                break;
            }
        }

        if (studentIndex == -1) {
            System.out.println("Student " + name + " not found.");
            return;
        } else {
            for (int i = studentIndex; i < studentCount - 1; i++) {
                studentName[i] = studentName[i + 1];
                rollNumber[i] = rollNumber[i + 1];
                marks[i][0] = marks[i + 1][0];
                marks[i][1] = marks[i + 1][1];
                marks[i][2] = marks[i + 1][2];
            }
        }
        // updating the student count after deleting the student information 
        studentCount--;
        System.out.println("Student " + name + " deleted successfully!");
    }

    public static void classStatistics() {
        System.out.println("Total students: " + studentCount);
        int totalMarks = 0;
        for (int i = 0; i < studentCount; i++) {
            totalMarks += marks[i][0] + marks[i][1] + marks[i][2];
        }
        double classAverage = (double) totalMarks / (studentCount * 3);
        int highestTotal = -1;
        int highestIndex = 0;
        int lowestTotal = Integer.MAX_VALUE;
        int lowestIndex = 0;
        for (int i = 0; i < studentCount; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            if (total > highestTotal) {
                highestTotal = total;
                highestIndex = i;
            }
            if (total < lowestTotal) {
                lowestTotal = total;
                lowestIndex = i;
            }
        }
        // displaying the overall students statistics
        System.out.println("\nOverall:");
        System.out.printf("Class Average: %.2f%n", classAverage);
        System.out.println("Highest Total: " + highestTotal + " (" + studentName[highestIndex] + " Roll No. "
                + rollNumber[highestIndex] + ")");
        System.out.println("Lowest Total: " + lowestTotal + " (" + studentName[lowestIndex] + " Roll No. "
                + rollNumber[lowestIndex] + ")");

        // calculating statistics Subject-wise averages
        int mathMarks = 0;
        int scienceMarks = 0;
        int languageMarks = 0;
        for (int i = 0; i < studentCount; i++) {
            mathMarks += marks[i][0];
            scienceMarks += marks[i][1];
            languageMarks += marks[i][2];
        }
        // explicit type-casting for calculations
        double mathAverage = (double) mathMarks / studentCount;
        double scienceAverage = (double) scienceMarks / studentCount;
        double languageAverage = (double) languageMarks / studentCount;
        // displaying subject wise statistics
        System.out.println("\nSubject-wise Average:");
        System.out.printf("Math: %.2f%n", mathAverage);
        System.out.printf("Science: %.2f%n", scienceAverage);
        System.out.printf("Language: %.2f", languageAverage);

        // Topper of each subject
        int mathTopper = marks[0][0];
        int mathIndex = 0;
        int scienceTopper = marks[0][1];
        int scienceIndex = 0;
        int languageTopper = marks[0][2];
        int languageIndex = 0;
        for (int i = 1; i < studentCount; i++) {
            if (marks[i][0] > mathTopper) {
                mathTopper = marks[i][0];
                mathIndex = i;
            }
            if (marks[i][1] > scienceTopper) {
                scienceTopper = marks[i][1];
                scienceIndex = i;
            }
            if (marks[i][2] > languageTopper) {
                languageTopper = marks[i][2];
                languageIndex = i;
            }
        }
        System.out.println("\n\nTopper of each subject:");
        System.out.println("Math: " + studentName[mathIndex] + " (" + mathTopper + ")");
        System.out.println("Science: " + studentName[scienceIndex] + " (" + scienceTopper + ")");
        System.out.println("Language: " + studentName[languageIndex] + " (" + languageTopper + ")");
    }

    public static void gradeDistribution() {
        System.out.println("===================== GRADE DISTRIBUTION =====================");
        int gradeAP = 0;
        int gradeA = 0;
        int gradeB = 0;
        int gradeC = 0;
        int gradeD = 0;
        int gradeFail = 0;
        for (int i = 0; i < studentCount; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = (double) total / 3;
            if (average >= 90 && average <= 100) {
                ++gradeAP;
            } else if (average >= 80 && average <= 89) {
                ++gradeA;
            } else if (average >= 70 && average <= 79) {
                ++gradeB;
            } else if (average >= 60 && average <= 69) {
                ++gradeC;
            } else if (average >= 50 && average <= 59) {
                ++gradeD;
            } else {
                ++gradeFail;
            }
        }
        System.out.println("Grade A+ (90-100): " + gradeAP +
                "\nGrade A  (80-89):  " + gradeA +
                "\nGrade B  (70-79):  " + gradeB +
                "\nGrade C  (60-69):  " + gradeC +
                "\nGrade D  (50-59):  " + gradeD +
                "\nFail  F  (00-49):  " + gradeFail);
        System.out.println("==============================================================");
    }

    public static void sortByMarks() {
        System.out.println("Student data sorted according to average marks per student.");
        boolean swaped;
        // using bubble sort to sort the entire database
        for (int i = 0; i < studentCount - 1; i++) {
            swaped = false;
            for (int j = 0; j < studentCount - 1 - i; j++) {
                int totalOne = marks[j][0] + marks[j][1] + marks[j][2];
                int totalNext = marks[j + 1][0] + marks[j + 1][1] + marks[j + 1][2];
                if (totalNext > totalOne) {
                    String tempString = studentName[j];
                    studentName[j] = studentName[j + 1];
                    studentName[j + 1] = tempString;

                    int tempRollNo = rollNumber[j];
                    rollNumber[j] = rollNumber[j + 1];
                    rollNumber[j + 1] = tempRollNo;

                    int tempMath = marks[j][0];
                    marks[j][0] = marks[j + 1][0];
                    marks[j + 1][0] = tempMath;

                    int tempScience = marks[j][1];
                    marks[j][1] = marks[j + 1][1];
                    marks[j + 1][1] = tempScience;

                    int tempLanguage = marks[j][2];
                    marks[j][2] = marks[j + 1][2];
                    marks[j + 1][2] = tempLanguage;

                    swaped = true;
                }
            }
            if (!swaped)
                break;
        }
        System.out.println("Students sorted by total marks (highest first):");
        viewStudents();
    }

}
