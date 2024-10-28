package pl.szotynski.PeoplePulse.employee;


public final class RegularEmployee extends Employee {

    public static class RegularEmployeeBuilder extends Builder<RegularEmployeeBuilder> {
        public RegularEmployeeBuilder(String firstName, String lastName, String contactNumber, String personalEmail) {
            super(firstName, lastName, contactNumber, personalEmail);
        }

        @Override
        protected RegularEmployeeBuilder self() {
            return this;
        }

        @Override
        public Employee build() {
            return new RegularEmployee(this);
        }
    }

    private RegularEmployee(RegularEmployeeBuilder builder) {
        super(builder);
    }
}
