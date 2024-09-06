package com.nsbm.ems.payrollservice.controller;

import com.nsbm.ems.payrollservice.model.Payroll;
import com.nsbm.ems.payrollservice.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    private final PayrollService payrollService;

    @Autowired
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping
    public ResponseEntity<Payroll> createPayroll(@RequestBody Payroll payroll) {
        Payroll createdPayroll = payrollService.savePayroll(payroll);
        return new ResponseEntity<>(createdPayroll, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable Long id) {
        Optional<Payroll> payroll = payrollService.getPayrollById(id);
        return payroll.map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Payroll>> getAllPayrolls() {
        List<Payroll> payrolls = payrollService.getAllPayrolls();
        return new ResponseEntity<>(payrolls, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayroll(@PathVariable Long id) {
        Optional<Payroll> payroll = payrollService.getPayrollById(id);
        if (payroll.isPresent()) {
            payrollService.deletePayroll(id);
            return ResponseEntity.ok("Payroll entry with ID " + id + " has been deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Payroll entry with ID " + id + " not found.");
        }
    }


    /**
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable Long id) {
        payrollService.deletePayroll(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    **/
}
