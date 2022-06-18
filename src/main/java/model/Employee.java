package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Employee {
    private int employeeId;
    private String employeeName;
    private LocalDate employeeBirthday;
    private String employeeIdCard;
    private Double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private int positionId;
    private int educationDegreeId;
    private int divisionId;
    private String username;
}
