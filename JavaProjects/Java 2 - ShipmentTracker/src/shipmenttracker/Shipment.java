/**
 * Deemantha Silva
 * 991455124
 * Assignment 2
 * March 5, 2017
 */
package shipmenttracker;

public class Shipment {

    protected double weight = 0;
    protected String method;
    protected double shippingCost = 0;

    public Shipment(double weight, String method) {
        this.weight = weight;
        if (method.equalsIgnoreCase("air")) {
            this.method = "Air";
        } else if (method.equalsIgnoreCase("truck")) {
            this.method = "Truck";
        } else {
            this.method = "Mail";
        }

    }

    private void calculateShipCosts() {
        if (this.weight > 20) {
            if (this.method.equalsIgnoreCase("Air")) {
                this.shippingCost = this.weight * 2.50;
            } else if (this.method.equalsIgnoreCase("Truck")) {
                this.shippingCost = this.weight * 1.95;
            } else {
                this.shippingCost = this.weight * 1.55;
            }
        } else if (this.weight > 10) {
            if (this.method.equalsIgnoreCase("Air")) {
                this.shippingCost = this.weight * 3.00;
            } else if (this.method.equalsIgnoreCase("Truck")) {
                this.shippingCost = this.weight * 2.45;
            } else {
                this.shippingCost = this.weight * 1.75;
            }
        } else if (this.method.equalsIgnoreCase("Air")) {
            this.shippingCost = this.weight * 4.00;
        } else if (this.method.equalsIgnoreCase("Truck")) {
            this.shippingCost = this.weight * 3.00;
        } else {
            this.shippingCost = this.weight * 2.00;
        }
    }

    public double getCalculateShipCosts() {
        calculateShipCosts();
        return this.shippingCost;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getShippingMethod() {
        return this.method;
    }

}
