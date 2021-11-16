package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;

/**
 * This class is the controller class for current orders.
 * @author Geon Yeong Kim, Henry Tao
 */

public class CurrentController {

    @FXML
    private MainController mainController;

    @FXML
    private TextField taxTotal;

    @FXML
    private TextField totalPrice;

    @FXML
    private ListView<Pizza> totalOrders;

    static final double TAX_RATE = 0.06625;

    double taxPrice;

    double pizzaPrice;

    /**
     * initialize method with no input
     */
    @FXML
    void initialize() {
    }

    /**
     * initial data that will begin once the window is open.
     * @param controller controller holds the controller of MainController.
     */
    @FXML
    void initData(MainController controller) {
        mainController = controller;
        ObservableList<Pizza> names = FXCollections.observableArrayList(mainController.newOrder.getPizzaOrders());
        totalOrders.setItems(names);
        taxPrice = mainController.newOrder.getTotalPrice() * TAX_RATE;
        pizzaPrice = mainController.newOrder.getTotalPrice();
        taxTotal.setText(String.format("%.2f",taxPrice));
        totalPrice.setText(String.format("%.2f",pizzaPrice + taxPrice));
    }

    /**
     * this method will place order and place the order object into store order array.
     * @param event button click.
     */
    @FXML
    void placeOrder(ActionEvent event) {
        try{
            if(mainController.newOrder.getSize() == 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "The order is empty. ");
                alert.show();
            }
            else{
                mainController.orders.addOrder(mainController.newOrder);
                totalOrders.getItems().clear();
                taxTotal.setText("00.00");
                totalPrice.setText("00.00");
                mainController.resetAll();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Order has been placed. :)");
                alert.show();
            }
        }
        catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please exit after placing the order ㅡ,.ㅡ");
            alert.show();
        }

    }

    /**
     * this method will remove pizza from the list.
     * @param event button click
     */
    @FXML
    void removePizza(ActionEvent event) {
        try{
            if(mainController.newOrder.getSize() == 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Everything's removed already. ㅡ,.ㅡ");
                alert.show();
            }
            else{
                Pizza selected;
                selected = totalOrders.getSelectionModel().getSelectedItem();
                mainController.newOrder.removePizza(selected);
                totalOrders.getItems().remove(selected);
                taxPrice = mainController.newOrder.getTotalPrice() * TAX_RATE;
                pizzaPrice = mainController.newOrder.getTotalPrice();
                taxTotal.setText(String.format("%.2f",taxPrice));
                totalPrice.setText(String.format("%.2f",pizzaPrice + taxPrice));
            }
        }
        catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please exit after placing the order ㅡ,.ㅡ");
            alert.show();
        }

    }
}
