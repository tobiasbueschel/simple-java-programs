package tutorial_3;

public class Robot1 {
  private double batteryCharge = 5.0; // instance variable

  public static void main(String[] args) {
    Robot1 r = new Robot1(); // start off with a well-charged battery
    r.move(11); // move around and use up the charge
    r.batteryReCharge(2.5); // get a new charge
    r.batteryReCharge(0.5); // add a bit more
    r.move(5); // move some more
  }

  // Instance Method #1 - Recharges the battery of the robot
  public void batteryReCharge(double c) {
    this.batteryCharge += c;
    System.out.println("Battery charge is: " + this.batteryCharge);
  }

  // Instance Method #2 - Moves the robot and prints out movement
  public void move(int distance) {
    for (int i = 1; i <= distance; i++) {
      if (this.batteryCharge >= 0.5) {
        System.out.print("[" + i + "] ");
        this.batteryCharge -= 0.5;
      } else {
        System.out.println("Out of power!");
      }
    }
  }
}
