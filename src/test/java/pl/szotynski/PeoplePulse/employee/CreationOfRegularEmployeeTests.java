package pl.szotynski.PeoplePulse.employee;

import org.junit.jupiter.api.Test;
import pl.szotynski.PeoplePulse.business.Department;
import pl.szotynski.PeoplePulse.employee.exceptions.EmployeeInvalidData;

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
        Employee regularEmployee = new RegularEmployee.RegularEmployeeBuilder(firstName, lastName, contactNumber, personalEmail)
                .title(title)
                .department(department)
                .startDate(startDate)
                .build();

        Employee regularEmployee2 = new RegularEmployee.RegularEmployeeBuilder(firstName, lastName, contactNumber, personalEmail)
                .title(title)
                .department(department)
                .startDate(startDate)
                .build();

        assertAll(() -> {
            assertEquals(regularEmployee.getFullName(), String.format("%s %s", firstName, lastName));
            assertEquals(regularEmployee, regularEmployee2);
        });
    }

    @Test
    void nullFirstNameNullPointerException() {
        assertThrows(EmployeeInvalidData.class,
                () -> new RegularEmployee.RegularEmployeeBuilder(null, lastName, contactNumber, personalEmail)
                        .build());
    }

    @Test
    void emptyFirstNameEmployeeInvalidData() {
        assertThrows(EmployeeInvalidData.class,
                () -> new RegularEmployee.RegularEmployeeBuilder("", lastName, contactNumber, personalEmail)
                        .build());
    }

    @Test
    void nullLastNameNullPointerException() {
        assertThrows(EmployeeInvalidData.class,
                () -> new RegularEmployee.RegularEmployeeBuilder(firstName, null, contactNumber, personalEmail)
                        .build());
    }
}
