
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.Console;
import java.sql.Connection;

public class Main {
  public static void main(String[] args) {
    var console = System.console();
    var user = "root";// new String(console.readLine("Username: "));
    var pass = "12345678";// new String(console.readLine("Password: "));
    List<Student> students;
    List<EnrollmentStudent> enrollmentStudents;

    String url = "jdbc:mysql://localhost:3306/school_mgmt?useSSL=false&serverTimezone=UTC";

    try (var conn = DriverManager.getConnection(url, user, pass)) {
      if (!conn.isClosed()) {
        System.out.println("Connected");
      }

      students = getStudents(conn);
      displayStudents(students);

      System.out.println(" ");
      enrollmentStudents = getEnrolledStudents(conn);
      displayEnrollmentStudents(enrollmentStudents);
      System.out.println(" ");

    } catch (Exception e) {
      System.out.println(e);
    }

  }

  public static List<Student> getStudents(Connection conn) throws SQLException {

    if (conn == null) {
      throw new SQLException();
    }
    List<Student> studentList = new ArrayList<Student>();
    String query = "Select * from Student";
    var stuPrep = conn.prepareStatement(query);
    var result = stuPrep.executeQuery();


    while (result.next()) {
      int sId = result.getInt("sId");
      String sName = result.getString("name");
      String sMajor = result.getString("major");
      studentList.add(new Student(sId, sName, sMajor));
    }
    stuPrep.close();
    return studentList;
  }

  public static void addEnrollment(Connection conn, Console console)
      throws SQLException, Exception {

    boolean valid = false;
    int sId = Integer.MAX_VALUE;
    do {
      String input = console.readLine("Student Id: ");
      try {
        sId = Integer.parseInt(input);
        valid = true; // parsed successfully
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      }
    } while (!valid); // repeat until valid input

    String query = "Insert Into Enrolled(sId) VALUES(?)";
    var insertEnrollment = conn.prepareStatement(query);
    insertEnrollment.setInt(2, sId);
    var insertQuery = insertEnrollment.executeQuery();

    System.out.println("Inserting new Student!");
    if (insertQuery == null) {
      throw new IllegalArgumentException("Could not inserted a new Student!");
    }
    insertEnrollment.close();

  }

  public static void addStudent(Connection conn, Console console) throws SQLException, Exception {

    if (conn == null) {
      throw new SQLException();
    }
    var sName = new String(console.readLine("Student Name: "));
    var sMajor = new String(console.readLine("Student Name: "));
    String query = "Insert Into Student(name,major) VALUES(?,?)";
    var insertStudent = conn.prepareStatement(query);
    insertStudent.setString(2, sName);
    insertStudent.setString(3, sMajor);
    var insertQuery = insertStudent.executeQuery();
    System.out.println("Inserting new Student!");
    if (insertQuery == null) {
      throw new IllegalArgumentException("Could not inserted a new Student!");
    }

    insertStudent.close();
  }

  public static List<EnrollmentStudent> getEnrolledStudents(Connection conn) throws SQLException {

    if (conn == null) {
      throw new SQLException();
    }
    List<EnrollmentStudent> studentList = new ArrayList<EnrollmentStudent>();
    String query = "Select name, cId from Student, Enrolled where Student.sId = Enrolled.sId";
    var stuPrep = conn.prepareStatement(query);
    var result = stuPrep.executeQuery();


    while (result.next()) {
      int cId = result.getInt("cId");
      String sName = result.getString("name");
      studentList.add(new EnrollmentStudent(cId, sName));
    }
    stuPrep.close();
    return studentList;
  }


  public static void displayEnrollmentStudents(List<EnrollmentStudent> enrollmentStudents) {
    if (enrollmentStudents == null || enrollmentStudents.isEmpty()) {
      System.out.println("No students found.");
      return;
    }

    System.out.println("CID\tName");
    System.out.println("--------------------------------");

    for (EnrollmentStudent s : enrollmentStudents) {
      System.out.println(s);
    }
  }

  public static void displayStudents(List<Student> students) {
    if (students == null || students.isEmpty()) {
      System.out.println("No students found.");
      return;
    }

    System.out.println("ID\tName\t\tMajor");
    System.out.println("--------------------------------");

    for (Student s : students) {
      System.out.println(s);
    }
  }

}
