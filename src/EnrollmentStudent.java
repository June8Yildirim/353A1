
public class EnrollmentStudent {


  private String name;
  private int cId;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getcId() {
    return cId;
  }

  public void setcId(int cId) {
    this.cId = cId;
  }

  public EnrollmentStudent(int cId, String name) {
    this.name = name;
    this.cId = cId;
  }

  @Override
  public String toString() {
    return "EnrollmentStudent [name=" + name + ", cId=" + cId + "]";
  }



}
