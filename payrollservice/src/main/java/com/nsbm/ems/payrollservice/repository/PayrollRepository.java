package com.nsbm.ems.payrollservice.repository;

import com.nsbm.ems.payrollservice.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing Payroll data.
 */

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

    /**
     * Finds Payrolls by the employee's ID.
     *
     * @param employeeId the ID of the employee
     * @return a list of Payrolls associated with the employee
     */
    List<Payroll> findByEmployeeId(Long employeeId);

}
