/**
 * Deemantha Silva
 * 991455124
 * Assignment 3
 * November 5, 2016
 */
package paytime;

import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

public class PayTime {

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);

        int empNum[] = {101, 103, 106, 109, 110, 113, 116, 118, 120};
        //introduce array
        
        System.out.println("Enter Y to process an Employee or any other key to end program: ");
        String input = k.next();
        //ask user to input a 'Y' to continue or any other letter to cancel
        int empProcess = 0;
        //introduce counter
        while (input.equalsIgnoreCase("Y")) { 
        //use a while loop to keep programming going if user enters a Y    
            System.out.print("Please enter your Employee Number: ");
            int employeeNum = k.nextInt();
            //ask user for employee number
            int search = Arrays.binarySearch(empNum, employeeNum);
            //introduce int search that takes user employee input and searches array for that number
            while (search < 0) {
            //use while loop to keep prompting user to enter valid employee number
                System.out.print("Invalid, enter proper employee number: ");
                employeeNum = k.nextInt();
                search = Arrays.binarySearch(empNum, employeeNum);
            }

            System.out.print("Please enter your first name: ");
            String fName = k.next();
            String firstName = fName.substring(0, 1).toUpperCase() + fName.substring(1);
            //Asks user for first name, capitlizes first letter
            System.out.print("Please enter your last name: ");
            String lName = k.next();
            String lastName = lName.substring(0, 1).toUpperCase() + lName.substring(1);
            //Asks user for last, name, capitlizaes first letter
            System.out.print("Please enter the number of hours worked (hours only): ");
            int hours = k.nextInt();
            while (hours < 0) {
            //while loop keeps prompting user for valid hours worked if less than zero    
                System.out.print("Invalid, hours worked cannot be negative, please try again: ");
                hours = k.nextInt();
                
            }

            System.out.print("Please enter your hourly wage (dollars only): $");
            double wage = k.nextDouble();
            while (wage <= 0) {
            //while loop, keeps prompting user for valid wage if less than zero
                System.out.print("Invalid, wage cannot be negative, please try again: ");
                wage = k.nextInt();
            }

            if (hours <= 40) {
            //if statement takes calculates income tax based on wage and if hours worked are less than 40
                double weekPay = (wage * hours);
                double incomeTax = 0;
                if (weekPay > 0) {
                    incomeTax = (weekPay * 0.10);
                } else if (weekPay >= 300.01) {
                    incomeTax = (weekPay * 0.12);
                } else if (weekPay >= 400.01) {
                    incomeTax = (weekPay * 0.15);
                } else {
                    incomeTax = (weekPay * 0.20);
                }
                double netPay = (weekPay - incomeTax);

                DecimalFormat d = new DecimalFormat("$#0.00");
                String pay = d.format(weekPay);
                String income = d.format(incomeTax);
                String total = d.format(netPay);
                //decimal format converts weekly pay, net pay, and income tax to proper monetary format
                System.out.println("\nWorker " + employeeNum + " Paycheck Information:");
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Weekly Pay: " + pay);
                System.out.println("Income Taxes are: " + income);
                System.out.println("Net Pay is: " + total);
                empProcess++;
                //counter increases by 1
            } else {
                int overtime = (hours - 40);
                double overtimeWage = (wage * 1.5);
                double overtimePay = (overtime * overtimeWage);
                double overtimeTaxes = (overtimePay * 0.25);
                double overtimeNetPay = (overtimePay - overtimeTaxes);
                //if employee works over 40 hours, overtime wages are calculated as well
                double weekPay = (wage * hours);
                double incomeTax = 0;
                if (weekPay > 0) {
                    incomeTax = (weekPay * 0.10);
                } else if (weekPay >= 300.01) {
                    incomeTax = (weekPay * 0.12);
                } else if (weekPay >= 400.01) {
                    incomeTax = (weekPay * 0.15);
                } else {
                    incomeTax = (weekPay * 0.20);
                }
                double netPay = (weekPay - incomeTax);
                double totalNetPay = (netPay + overtimeNetPay);

                DecimalFormat d = new DecimalFormat("$#0.00");
                String pay = d.format(weekPay);
                String income = d.format(incomeTax);
                String total = d.format(netPay);
                String overPay = d.format(overtimePay);
                String overTaxes = d.format(overtimeTaxes);
                String overNetPay = d.format(overtimeNetPay);
                String overTotal = d.format(totalNetPay);
                //more use of decimal format to format double answers into strings
                System.out.println("\nWorker " + employeeNum + " Paycheck Information:");
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Weekly Pay: " + pay);
                System.out.println("Income Taxes are: " + income);
                System.out.println("Net Pay is: " + total);

                System.out.println("\nWorker " + employeeNum + " Overtime Information:");
                System.out.println("Overtime Pay is: " + overPay);
                System.out.println("Overtime Taxes are: " + overTaxes);
                System.out.println("Overtime Net Pay is: " + overtimeNetPay);
                System.out.println("Total Net Pay is: " + totalNetPay);

                empProcess++;
            }
            System.out.println("\nNumber of employess Processed: " + empProcess);
            System.out.println("\nEnter Y to process another employee or any other key to end program: ");
            input = k.next();
            //total number of employess processed is displayed, and user is prompted whether to continue program or not
        }

        System.out.println("End Program");
        System.out.println("Number of employees processed: " + empProcess);

    }

}
