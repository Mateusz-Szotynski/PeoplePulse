package pl.szotynski.PeoplePulse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.szotynski.PeoplePulse.business.Department;
import pl.szotynski.PeoplePulse.employee.Employee;
import pl.szotynski.PeoplePulse.employee.RegularEmployee;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CreationOfRegularEmployeeTests {

    private static final String firstName = "testFirstName";
    private static final String lastName = "testLastName";
    private static final String contactNumber = "111222333";
    private static final String personalEmail = "testemail@example.com";
    private static final String title = "Human Resources";
    private static final Department department = Department.HR;
    private static final LocalDate startDate = LocalDate.of(2018, 10, 12);

    @Test
    void createsRegularEmployee() {
        Employee regularEmployee = new RegularEmployee.RegularEmployeeBuilder(firstName, lastName, contactNumber)
                .personalEmail(personalEmail)
                .title(title)
                .department(department)
                .startDate(startDate)
                .build();

        assertAll(() -> {
            regularEmployee.getFullName().equals(String.format("%s %s", firstName, lastName));
        });
    }
}
