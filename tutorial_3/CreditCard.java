package tutorial_3;

import java.util.Calendar;

public class CreditCard {

  // declare objects
  Calendar now = Calendar.getInstance();

  // Instance variables
  private int expiryMonth;
  private int expiryYear;
  private String firstName;
  private String lastName;
  private String ccNumber;

  // Constructor
  public CreditCard(int expiryMonth, int expiryYear,
                    String firstName, String lastName, String ccNumber) {

    this.expiryMonth = expiryMonth;
    this.expiryYear = expiryYear;
    this.firstName = firstName;
    this.lastName = lastName;
    this.ccNumber = ccNumber;
  }

  // INSTANCE METHODS
  // formats expiryDate
  public String formatExpiryDate() {
    String formDate = Integer.toString(expiryMonth) + "/" + Integer.toString(expiryYear)
      .substring(2, 4);
    return formDate;
  }

  // formats full name
  public String formatFullName() {
    String fullName = Character.toString(firstName.charAt(0))
      .toUpperCase() + firstName.substring(1);
    fullName += " " + Character.toString(lastName.charAt(0))
      .toUpperCase() + lastName.substring(1);
    return fullName;
  }

  // formats CC Number
  public String formatCCNumber() {
    StringBuilder sb = new StringBuilder();
    sb.append(ccNumber);
    int offset = 4;
    while (offset <= sb.length()) {
      sb.insert(offset, " ");
      offset += 5;
    }
    return sb.toString();
  }

  // returns true of expiryDate is later than the current value
  public boolean isValid() {
    int curMonth = now.get(Calendar.MONTH);
    int curYear = now.get(Calendar.YEAR);
    boolean valid = false;

    if (curYear <= this.expiryYear && curMonth <= this.expiryMonth) {
      valid = true;
    }
    return valid;
  }

  // prints out account details
  public String toString() {
    return "Number: " + formatCCNumber() + "Expiry Date: " + formatExpiryDate() + " Account holder: " + formatFullName() + "Is valid: " + isValid();
  }
}
