package com.nsbm.ems.payrollservice.constants;

/**
 * This class holds constant values used throughout the payroll service application.
 * It includes error and success messages used in various operations related to payroll.
 */
public class PayrollConstants {

    // Error messages

    /**
     * Error message when the base salary is null.
     */
    public static final String BASE_SALARY_NULL_ERROR = "Base salary cannot be null";

    /**
     * Error message when a payroll record is not found with the specified ID.
     */
    public static final String PAYROLL_NOT_FOUND = "Payroll not found with ID: ";

    // Success messages

    /**
     * Success message when a payroll record is saved successfully.
     */
    public static final String PAYROLL_SAVED_SUCCESS = "Payroll saved successfully.";

    /**
     * Success message when a payroll record is updated successfully.
     */
    public static final String PAYROLL_UPDATED_SUCCESS = "Payroll updated successfully.";

    /**
     * Success message when a payroll record is deleted successfully with the specified ID.
     */
    public static final String PAYROLL_DELETED_SUCCESS = "Payroll deleted successfully with ID: ";
}

