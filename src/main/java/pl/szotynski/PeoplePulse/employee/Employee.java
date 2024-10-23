package pl.szotynski.PeoplePulse.employee;

import pl.szotynski.PeoplePulse.business.Department;
import pl.szotynski.PeoplePulse.employee.exceptions.EmployeeInvalidData;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private final String contactNumber;
    private final String personalEmail;
    private final String title;
    private final Department department;
    private final LocalDate startDate;

    abstract static class Builder<T extends Builder<T>> {
        private final String firstName;
        private final String lastName;
        private final String contactNumber;
        private String personalEmail;
        private String title;
        private Department department;
        private LocalDate startDate;

        public Builder(String firstName, String lastName, String contactNumber) {
            if (!firstName.isBlank()) {
                this.firstName = Objects.requireNonNull(firstName);
            } else {
                throw new EmployeeInvalidData("First name must contain value");
            }
            if (!lastName.isBlank()) {
                this.lastName = Objects.requireNonNull(lastName);
            } else {
                throw new EmployeeInvalidData("Last name must contain value");
            }
            if (!contactNumber.isBlank()) {
                this.contactNumber = Objects.requireNonNull(contactNumber);
            } else {
                throw new EmployeeInvalidData("Contact number must contain value");
            }
        }

        public T personalEmail(String email) {
            if (!email.isBlank()) {
                this.personalEmail = Objects.requireNonNull(email);
            } else {
                throw new EmployeeInvalidData("Email must contain value");
            }
            return self();
        }

        public T title(String title) {
            if (!title.isBlank()) {
                this.personalEmail = Objects.requireNonNull(title);
            } else {
                throw new EmployeeInvalidData("Title must contain value");
            }
            return self();
        }

        public T department(Department department) {
            this.department = Objects.requireNonNull(department);
            return self();
        }

        public T startDate(LocalDate startDate) {
            this.startDate = Objects.requireNonNull(startDate);
            return self();
        }

        protected abstract T self();

        public abstract Employee build();
    }

    protected Employee(Builder<?> builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contactNumber = builder.contactNumber;
        this.personalEmail = builder.personalEmail;
        this.title = builder.title;
        this.department = builder.department;
        this.startDate = builder.startDate;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }


}
