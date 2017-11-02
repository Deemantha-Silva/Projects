/**
 * Deemantha Silva
 * 991455124
 * Assignment 2
 * March 5, 2017
 */
package shipmenttracker;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner k = new Scanner(System.in);

        String repeat = "yes";
        ArrayList<ShipmentOrder> shipOrderList = new ArrayList<>();

        while (repeat.equalsIgnoreCase("yes")) {

            System.out.println("Please type in a shipment order number: ");
            int num = k.nextInt();
            while (num < 0) {
                System.out.println("Shipment Order cannot be negative, please try again: ");
                num = k.nextInt();
            }

            System.out.println("Please type in a shipment weight(kg): ");
            double weight = k.nextDouble();
            while (weight <= 0) {
                System.out.println("Shipment weight cannot be zero or negative, please try again: ");
                weight = k.nextDouble();
            }

            System.out.println("Please type in a shipment order type (Air, Truck, or anyting else for Mail): ");
            String order = k.next();

            System.out.println("Please type in a shipment insurance type (Regular or anyting else for Basic): ");
            String insurType = k.next();

            ShipmentOrder one = new ShipmentOrder(weight, order);
            one.setOrderNumber(num);
            one.setInsuranceType(insurType);
            one.getCalculateShipCosts();
            one.getCalculateInsuranceCost();
            shipOrderList.add(one);

            System.out.println("Would you like to continue (yes to continue/anything else to cancel): ");
            repeat = k.next();
        }

        for (int i = 0; i < shipOrderList.size(); i++) {
            DecimalFormat df = new DecimalFormat("$#.00");
            DecimalFormat dfWeight = new DecimalFormat("#0.00kg");
            ShipmentOrder two = shipOrderList.get(i);
            System.out.println("\nOrder Number: " + two.getOrderNum() + "\nWeight: " + dfWeight.format(two.getWeight()) + "\nShipping Method: "
                    + two.getShippingMethod() + "\nInsurance Type: " + two.getInsuranceType() + "\nShipping Costs: "
                    + df.format(two.getCalculateShipCosts()) + "\nInsurance Costs: " + df.format(two.getCalculateInsuranceCost())
                    + "\nTotal Costs: " + df.format(two.getTotalCost()));

        }

    }

}
