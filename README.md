# 🎓 Student Grade Manager

**Status:** ✅ Complete (v1.0)  
**Built:** June 2026  

A console-based Java application for managing student records and grades through a menu-driven interface. Supports adding, viewing, searching, updating, deleting, sorting, and analyzing student data for up to 10 students.

Built using Core Java with parallel arrays, bubble sort, and formatted console output.

---

## 🖥️ Sample Output

```
====================== Student Grade Manager ======================
1. Add a student
2. View all students
3. Search student by roll number
4. Update marks
5. Delete a student
6. Show class statistics
7. Show grade distribution
8. Sort student by marks
9. Exit
===================================================================

Enter your choice: 2

Name            Roll No.   Math     Science    Language  
-------------------------------------------------------
Aarav           101        85       90         88        
Priya           102        95       92         89        
Rahul           103        75       80         65

```
```
========== CLASS STATISTICS ==========
Total students: 3

Overall:
Class Average: 82.11
Highest Total: 276 (Priya Roll No. 102)
Lowest Total: 220 (Rahul Roll No. 103)

Subject-wise Average:
Math: 85.00
Science: 87.33
Language: 80.67

Topper of each subject:
Math: Priya (95)
Science: Priya (92)
Language: Priya (89)

```
---

## 🚀 Features

### Student Management
- Add multiple students (upt to 10)
- View all student records in a formatted table
- Search students by roll number
- Update marks for a specific subject
- Delete student records (with array shifting)

### Academic Analysis
- Calculate class average
- Find highest and lowest-scoring student
- Display subject-wise averages
- Identify toppers in each subject

### Grade System

Grade distribution based on average marks:

| Grade | Marks Range |
|-------|-------------|
| A+    | 90 - 100    |
| A     | 80 - 89     |
| B     | 70 - 79     |
| C     | 60 - 69     |
| D     | 50 - 59     |
| F     | Below 50    |

### Sorting
- Sort students by total marks (highest first)

### UX Touches
- Locked menu options (🔒) when database is empty — prevents user confusion
- Friendly error messages for invalid inputs
- Formatted table output using `printf`
- Input validation for marks (0-100 range)

---

## 🛠️ Built With

- **Java 17** (Core Java, no external libraries)
- **Standard library:** `Scanner` class for input handling

---

## 📋 Menu Options
```
1. Add a student
2. View all students
3. Search student by roll number
4. Update marks
5. Delete a student
6. Show class statistics
7. Show grade distribution
8. Sort students by marks
9. Exit
```

---

## 📂 Project Structure

```
StudentGradeManager.java   (single file, ~280 lines)
```

The project uses **parallel arrays** linked by index to store data:

```java
static String[] studentName = new String[10];
static int[] rollNumber = new int[10];
static int[][] marks = new int[10][3];  // 10 students × 3 subjects
static int studentCount = 0;             // tracks current number of students
```

**Why parallel arrays?** Parallel arrays simulate a database where `index i` represents the same student across all arrays.

**Limitaion:** Fixed size (max 10 students). This will be replace with `ArrayList<Students>` in v2.
---

## ▶️ How to Run

### Compile
```bash
javac StudentGradeManager.java
```

### Run
```bash
java StudentGradeManager
```

---

## 📚 Concepts Practiced

Through this project I practiced:
- Array manipulation (1D and 2D)
- Parallel array synchronization
- Method decomposition
- Conditional statements (if-else-if ladders)
- Loops (for, while, nested)
- Sorting algorithms (Bubble Sort)
- Searching (linear search)
- Champion comparison pattern (max/min finding)
- Input validation with loops
- Type casting for accurate division
- Formatted output with `printf`
- Menu-driven program design
- Defensive programming (empty state, full state, not-found cases)

---

## 🔮 Future Improvements

Possible improvements for future versions:
- Store data in files instead of memory
- Use ArrayList instead of fixed-size arrays
- Add student GPA calculation
- Generate report cards
- Improve user interface
- Build a GUI version using JavaFX or Swing
- Add exception handling for invalid inputs
- Use Object-Oriented Programming with a Student class
- Connect to a database (MySQL)

---

## 👨‍💻 Author

**Pradnya Jogi**  
Aspiring Software Developer | Java & Backend

- 💼 LinkedIn: [Pradnya Jogi]([https://linkedin.com/in/yourprofile](https://www.linkedin.com/in/pradnya-jogi-160a79251/))
