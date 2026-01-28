
public class Student {
  private int sId;

  @Override
  public String toString() {
    return "Student sId=" + sId + ", name=" + name + ", major=" + major;
  }

  private String name;
  private String major;



  public Student(String name, String major) {
    this.sId = (int) Math.random();
    this.name = name;
    this.major = major;
  }

  public Student(int sId, String name, String major) {
    this.sId = sId;
    this.name = name;
    this.major = major;
  }

  public int getsId() {
    return sId;
  }

  public String getName() {
    return name;
  }

  public String getMajor() {
    return major;
  }

  public void setsId(int sId) {
    this.sId = sId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMajor(String major) {
    this.major = major;
  }



}

