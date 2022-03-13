package com.gurshobit.labapplicationone.services;

import com.gurshobit.labapplicationone.helpers.RandomGeneratorHelper;
import com.gurshobit.labapplicationone.models.Employee;

import java.util.Locale;

public class CredentialService {
    RandomGeneratorHelper randomGeneratorHelper = new RandomGeneratorHelper();
    public String generatePassword(){
        return randomGeneratorHelper.passwordGenerator(8,true,true,true);
    }
    public String generateEmailAddress(Employee employee,String departmentDomain){
        final String companyDomainName = "gurshobit.com";
        return employee.getFirstName().toLowerCase(Locale.ROOT)+employee.getLastName().toLowerCase(Locale.ROOT)+"@"+departmentDomain+"."+companyDomainName;
    }

    public void showCredentials(Employee employee){
        System.out.println(employee.toString());
    }

}
