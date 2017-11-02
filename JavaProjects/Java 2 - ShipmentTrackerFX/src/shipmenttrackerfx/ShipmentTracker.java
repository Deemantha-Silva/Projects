/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shipmenttrackerfx;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Deemantha
 */
public class ShipmentTracker extends Application {

    private Label orderLabel = new Label("Please enter order number: ");
    private TextField tFieldOrder = new TextField();
    private HBox hBoxOrder = new HBox();

    private Label weightLabel = new Label("Please enter weight(kg): ");
    private TextField tFieldWeight = new TextField();
    private HBox hBoxWeight = new HBox();

    private Label methodLabel = new Label("Please enter the shipment method (Air, Truck, or Mail): ");
    private TextField tFieldMethod = new TextField();
    private HBox hBoxMethod = new HBox();

    private Label insuranceLabel = new Label("Please enter the insurance type (Regular or Basic): ");
    private TextField tFieldInsurance = new TextField();
    private HBox hBoxInsurance = new HBox();

    private GridPane pane = new GridPane();

    private Button btnSubmit = new Button("Enter Order");
    private Button btnOrders = new Button("Display Orders");

    public void start(Stage primaryStage) {

        hBoxOrder.getChildren().addAll(orderLabel, tFieldOrder);
        hBoxWeight.getChildren().addAll(weightLabel, tFieldWeight);
        hBoxMethod.getChildren().addAll(methodLabel, tFieldMethod);
        hBoxInsurance.getChildren().addAll(insuranceLabel, tFieldInsurance);

        pane.add(hBoxOrder, 1, 1);
        pane.add(hBoxWeight, 1, 2);
        pane.add(hBoxMethod, 1, 3);
        pane.add(hBoxInsurance, 1, 4);
        pane.add(btnSubmit, 1, 5);
        pane.add(btnOrders, 1, 6);

        ArrayList<ShipmentOrder> shipOrderList = new ArrayList<>();

        btnSubmit.setOnAction(e -> {
            int count = 0;
            int orderData = 0;
            double weightData = 0;
            if (!tFieldOrder.getText().isEmpty()) {
                orderData = Integer.parseInt(tFieldOrder.getText());
                if (orderData <= 0) {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setContentText("Please enter order numbers greater than zero");
                    dlgInformation.show();
                    tFieldOrder.clear();
                } else {
                    count++;
                }
            } else {
                Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                dlgInformation.setContentText("Please make sure to enter an order number!!");
                dlgInformation.show();
            }

            if (!tFieldWeight.getText().isEmpty()) {
                weightData = Double.parseDouble(tFieldWeight.getText());
                if (weightData <= 0) {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setContentText("Weight cannot be negative or zero!");
                    dlgInformation.show();
                    tFieldWeight.clear();
                } else {
                    count++;
                }
            } else {
                Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                dlgInformation.setContentText("Please make sure to enter a weight!");
                dlgInformation.show();
            }

            String methodData = tFieldMethod.getText();
            if (!tFieldMethod.getText().isEmpty()) {
                if (!methodData.matches("Air|Truck|Mail")) {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setContentText("Shipping Method can only be Air, Truck, or Mail");
                    dlgInformation.show();
                    tFieldMethod.clear();
                } else {
                    count++;
                }
            } else {
                Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                dlgInformation.setContentText("Please make sure to enter a shipping method!");
                dlgInformation.show();
            }

            String insuranceData = tFieldInsurance.getText();
            if (!tFieldInsurance.getText().isEmpty()) {
                if (!insuranceData.matches("Regular|Basic")) {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setContentText("Shipping Insurance can only be Regular or Basic");
                    dlgInformation.show();
                    tFieldInsurance.clear();
                } else {
                    count++;
                }
            } else {
                Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                dlgInformation.setContentText("Please make sure to enter a shipping insurance!");
                dlgInformation.show();
            }

            if (count == 4) {
                if (!tFieldOrder.getText().isEmpty() & !tFieldWeight.getText().isEmpty() & !tFieldMethod.getText().isEmpty() & !tFieldInsurance.getText().isEmpty()) {
                    ShipmentOrder one = new ShipmentOrder(weightData, methodData);
                    one.setOrderNumber(orderData);
                    one.setInsuranceType(insuranceData);
                    one.getCalculateShipCosts();
                    one.getCalculateInsuranceCost();
                    shipOrderList.add(one);

                    tFieldOrder.clear();
                    tFieldWeight.clear();
                    tFieldMethod.clear();
                    tFieldInsurance.clear();
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setContentText("Order Added!");
                    dlgInformation.show();
                }
            }
        });

        btnOrders.setOnAction(e -> {
            StageTwo stTwo = new StageTwo(shipOrderList);
            stTwo.show();
        });
        
        Scene scene = new Scene(pane, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Shipment Tracker- Deemantha Silva!");
        primaryStage.show();
    }

    public class StageTwo extends Stage {

        public StageTwo(ArrayList<ShipmentOrder> Shipment) {

            TextArea tAreaShipment = new TextArea();
            tAreaShipment.setMinHeight(600);
            Pane pane = new Pane();
            String order = new String();
            for (int i = 0; i < Shipment.size(); i++) {
                DecimalFormat df = new DecimalFormat("$#.00");
                DecimalFormat dfWeight = new DecimalFormat("#0.00kg");
                ShipmentOrder two = Shipment.get(i);

                order += ("Order Number: " + two.getOrderNum() + "\nWeight: "
                        + dfWeight.format(two.getWeight()) + "\nShipping Method: "
                        + two.getShippingMethod() + "\nInsurance Type: "
                        + two.getInsuranceType() + "\nShipping Costs: "
                        + df.format(two.getCalculateShipCosts())
                        + "\nInsurance Costs: "
                        + df.format(two.getCalculateInsuranceCost())
                        + "\nTotal Costs: " + df.format(two.getTotalCost())
                        + "\n" + "\n");

                tAreaShipment.setText(order);

            }
            pane.getChildren().add(tAreaShipment);
            Scene scene = new Scene(pane, 300, 800);
            setScene(scene);
            setTitle("Orders");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
