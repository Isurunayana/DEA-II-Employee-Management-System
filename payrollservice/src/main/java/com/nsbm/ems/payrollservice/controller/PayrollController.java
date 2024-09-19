package com.nsbm.ems.payrollservice.controller;

import com.nsbm.ems.payrollservice.model.Payroll;
import com.nsbm.ems.payrollservice.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * PayrollController handles HTTP requests for managing payroll data.
 * It provides endpoints to create, retrieve, and delete payroll records.
 */

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    private final PayrollService payrollService;

    @Autowired
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    /**
     * Creates a new payroll record.
     *
     * @param payroll the payroll data to be created
     * @return a ResponseEntity containing a success message and the created payroll data, or an error message
     */

    @PostMapping
    public ResponseEntity<Object> createPayroll(@RequestBody Payroll payroll) {
        try {
            Payroll createdPayroll = payrollService.savePayroll(payroll);
            // Success response with message and created payroll data
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Payroll created successfully");
            response.put("payroll", createdPayroll);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Failure response with error message
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());

            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // General error handling
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "An unexpected error occurred: " + e.getMessage());

            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves a payroll record by its ID.
     *
     * @param id the ID of the payroll record to retrieve
     * @return a ResponseEntity containing the payroll data if found, or a 404 Not Found status if not found
     */

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


    /**
     * Deletes a payroll record by its ID.
     *
     * @param id the ID of the payroll record to delete
     * @return a ResponseEntity containing a success message if deleted, or a 404 Not Found status if not found
     */

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


}
