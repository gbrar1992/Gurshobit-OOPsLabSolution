package com.gurshobit.labapplicationone;

import com.gurshobit.labapplicationone.models.Employee;
import com.gurshobit.labapplicationone.services.CredentialService;

import java.util.Scanner;

public class MainClass {
    public static Employee employee;
    public static int userChoice = 0;
    public static Scanner scannerInput = new Scanner(System.in);
    public static CredentialService credentialService = new CredentialService();
    public static void main(String[] args) {
        String departmentName;
        String departmentDomainName;
        boolean canCreateEmployeeCredentials = true;

        System.out.println("-------------------------");
        System.out.println("Welcome to Gurshobit Inc.");
        System.out.println("-------------------------");
        System.out.println("Please Select the department Below:");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resources");
        System.out.println("4. Legal");
        userChoice = Integer.parseInt(scannerInput.nextLine());

        do {
            switch (userChoice){
                case 1:
                    departmentName = "Technical";
                    departmentDomainName = "tech";
                    break;
                case 2:
                    departmentName = "Administration";
                    departmentDomainName = "admin";
                    break;
                case 3:
                    departmentName = "Human Resources";
                    departmentDomainName = "hr";
                    break;
                case 4:
                    departmentName = "Legal";
                    departmentDomainName = "legal";
                    break;
                default:
                    departmentName = "Human Resources";
                    departmentDomainName = "hr";
                    canCreateEmployeeCredentials = false;

            }

            if(canCreateEmployeeCredentials){
                System.out.println("Please Enter Employee First Name: ");
                String employeeFirstName = scannerInput.nextLine();
                System.out.println("Please Enter Employee Last Name: ");
                String employeeLastName = scannerInput.nextLine();

                employee = new Employee(employeeFirstName,employeeLastName);
                employee.setDepartmentName(departmentName);
                String generatedEmailAddress = credentialService.generateEmailAddress(employee,departmentDomainName);
                String generatedPassword  = credentialService.generatePassword();
                employee.setEmail(generatedEmailAddress);
                employee.setPassword(generatedPassword);
                credentialService.showCredentials(employee);

            } else {
                System.out.println("Invalid Department");
            }
            userChoice = 0;

        } while (userChoice > 0 && userChoice < 5);
    }
}