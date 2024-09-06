package com.nsbm.ems.payrollservice.service.impl;

import com.nsbm.ems.payrollservice.model.Payroll;
import com.nsbm.ems.payrollservice.repository.PayrollRepository;
import com.nsbm.ems.payrollservice.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of PayrollService interface for managing Payrolls.
 */
@Service
public class PayrollServiceImpl implements PayrollService {

    private final PayrollRepository payrollRepository;

    @Autowired
    public PayrollServiceImpl(PayrollRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }

    @Override
    public Payroll savePayroll(Payroll payroll) {
        if (payroll.getBaseSalary() == null) {
            throw new IllegalArgumentException("Base salary cannot be null");
        }

        return payrollRepository.save(payroll);
    }

    @Override
    public Optional<Payroll> getPayrollById(Long id) {
        return payrollRepository.findById(id);
    }

    @Override
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    @Override
    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }
}
