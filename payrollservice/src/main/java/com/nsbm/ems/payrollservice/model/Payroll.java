package com.nsbm.ems.payrollservice.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

/**
 * Represents the Payroll entity.
 */

@Entity
@Table(name = "Payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Getter
    @Column(name = "base_salary", nullable = false)
    private Double baseSalary;

    @Getter
    @Column(name = "gross_salary")
    private Double grossSalary;

    @Getter
    @Column(name = "net_salary")
    private Double netSalary;

    @Getter
    @Column(name = "pay_date")
    @Temporal(TemporalType.DATE)
    private Date payDate;

    @Getter
    @Column(name = "tax_deduction")
    private Double taxDeduction;

    @Getter
    @Column(name = "insurance_deduction")
    private Double insuranceDeduction;

    @Getter
    @Column(name = "performance_bonus")
    private Double performanceBonus;

    @Getter
    @Column(name = "holiday_bonus")
    private Double holidayBonus;

    @Getter
    @Column(name = "pay_period")
    private String payPeriod;

    @Getter
    @Column(name = "tax_rate")
    private Double taxRate;

    @Getter
    @Column(name = "bonus_percentage")
    private Double bonusPercentage;

}
