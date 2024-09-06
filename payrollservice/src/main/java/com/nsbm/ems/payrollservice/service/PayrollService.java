package com.nsbm.ems.payrollservice.service;

import org.springframework.stereotype.Service;
import com.nsbm.ems.payrollservice.model.Payroll;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for Payroll operations.
 */

@Service
public interface PayrollService {

    /**
     * Saves a Payroll entry.
     *
     * @param payroll the Payroll to be saved
     * @return the saved Payroll entity
     */
    Payroll savePayroll(Payroll payroll);

    /**
     * Retrieves a Payroll entry by its ID.
     *
     * @param id the ID of the Payroll to retrieve
     * @return an Optional containing the Payroll if found, or empty if not
     */
    Optional<Payroll> getPayrollById(Long id);

    /**
     * Retrieves all Payroll entries.
     *
     * @return a list of all Payroll entities
     */
    List<Payroll> getAllPayrolls();

    /**
     * Deletes a Payroll entry by its ID.
     *
     * @param id the ID of the Payroll to delete
     */
    void deletePayroll(Long id);
}
