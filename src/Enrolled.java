
public class Enrolled {
  private int cId;
  private int sId;

  public int getcId() {
    return cId;
  }

  public void setcId(int cId) {
    this.cId = cId;
  }

  public int getsId() {
    return sId;
  }

  public void setsId(int sId) {
    this.sId = sId;
  }

  public Enrolled(int sId) {
    this.cId = (int) Math.random();
    this.sId = sId;
  }

  public Enrolled(int cId, int sId) {
    this.cId = cId;
    this.sId = sId;
  }



}
