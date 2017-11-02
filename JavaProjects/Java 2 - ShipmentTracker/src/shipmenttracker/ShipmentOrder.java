/**
 * Deemantha Silva
 * 991455124
 * Assignment 2
 * March 5, 2017
 */
package shipmenttracker;

public class ShipmentOrder extends Shipment {

    private int orderNumber = 0;
    private double insuranceCost = 0;
    private int totalCost = 0;
    protected String insuranceType;

    public ShipmentOrder(double weightSO, String methodSO) {
        super(weightSO, methodSO);
    }

    public void setInsuranceType(String insurType) {
        if (insurType.equalsIgnoreCase("regular")) {
            this.insuranceType = "Regular";
        } else {
            this.insuranceType = "Basic";
        }
    }

    public String getInsuranceType() {
        return this.insuranceType;
    }

    private void calculateInsuranceCost() {
        if (super.shippingCost > 30.01) {
            if (insuranceType.equalsIgnoreCase("regular")) {
                this.insuranceCost = 5.55;
            } else {
                this.insuranceCost = 2.50;
            }
        } else if (super.shippingCost > 10.01) {
            if (insuranceType.equalsIgnoreCase("regular")) {
                this.insuranceCost = 3.95;
            } else {
                this.insuranceCost = 1.50;
            }
        } else if (insuranceType.equalsIgnoreCase("regular")) {
            this.insuranceCost = 2.45;
        } else {
            this.insuranceCost = 0.50;
        }
    }

    public double getCalculateInsuranceCost() {
        calculateInsuranceCost();
        return this.insuranceCost;
    }

    public void setOrderNumber(int orderNum) {
        this.orderNumber = orderNum;
    }

    public int getOrderNum() {
        return this.orderNumber;
    }

    public double getTotalCost() {
        return (super.shippingCost + insuranceCost);
    }
}
