package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;

public class StoreController {

    @FXML
    private MainController mainController;

    @FXML
    private ComboBox<String> orderList;

    @FXML
    private ListView<Pizza> printList;

    @FXML
    private TextField printTotal;

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
        ArrayList<String> orderLists = mainController.orders.getAllNumbers();
        orderList.getItems().addAll(orderLists);
        orderList.setValue(orderLists.get(0));
        ArrayList<Order> tempOrder = mainController.orders.getOrdersList();
        ObservableList<Pizza> names = FXCollections.observableArrayList(tempOrder.get(0).getPizzaOrders());
        printList.setItems(names);
        printTotal.setText(String.valueOf(tempOrder.get(0).getTotalPrice()));
    }

    /**
     * method to let the user choose a phone number for the orders.
     * @param event button click.
     */
    @FXML
    void chooseNumber(ActionEvent event) {
        String selected;
        selected = orderList.getSelectionModel().getSelectedItem();
        Order tempOrder;
        tempOrder = mainController.orders.getOrdersList().get(mainController.orders.printStore(selected));
        ObservableList<Pizza> names = FXCollections.observableArrayList(tempOrder.getPizzaOrders());
        printList.setItems(names);
        printTotal.setText(String.valueOf(tempOrder.getTotalPrice()));
    }

    /**
     * cancels an order at the store order menu.
     * @param event button click.
     */
    @FXML
    void cancelButton(ActionEvent event) {
        String selected;
        selected = orderList.getSelectionModel().getSelectedItem();
        Order tempOrder;
        orderList.getItems().remove(selected);
        printTotal.clear();
        printList.getItems().clear();
        tempOrder = mainController.orders.getOrdersList().get(mainController.orders.printStore(selected));
        mainController.orders.deleteOrder(tempOrder);
    }

    @FXML
    void exportOrder(ActionEvent event) throws IOException{
        mainController.orders.export();

    }
}
