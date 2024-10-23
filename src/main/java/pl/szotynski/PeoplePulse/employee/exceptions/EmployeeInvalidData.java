package pl.szotynski.PeoplePulse.employee.exceptions;

public class EmployeeInvalidData extends RuntimeException {
  public EmployeeInvalidData(String message) {
    super(message);
  }
}
