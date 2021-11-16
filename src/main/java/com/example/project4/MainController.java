package com.example.project4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.input.MouseEvent;

/**
 * This is a controller class for our main menu
 * @author Geon Yeong Kim, Henry Tao
 */
public class MainController {

    @FXML
    Order newOrder;

    @FXML
    StoreOrders orders = new StoreOrders();

    @FXML
    String chosenPizza;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button startButton;

    /**
     * This method will add unique customer's phone number to the system.
     * @param event event is where I press on the button.
     */
    @FXML
    void addNumber(ActionEvent event) {
        try{
            Long checkInt = Long.parseLong(phoneNumber.getText());
            if(orders.checkDuplicate(checkInt) == false){
                Alert alert = new Alert(Alert.AlertType.WARNING, "Your order has already been placed.");
                alert.show();
            }
            else if(phoneNumber.getLength() != 10){
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a 10 digit phone number");
                alert.show();
            }
            else{
                newOrder = new Order();
                String result = newOrder.setCustomerNumber(phoneNumber.getText());
                phoneNumber.setDisable(true);
                startButton.setDisable(true);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, result);
                alert.show();
            }
        }
        catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please enter a valid phone number.");
            alert.show();
        }
    }

    /**
     * This method will enable customers to edit their number for order.
     * @param event
     */
    @FXML
    void editNumber(ActionEvent event) {
        phoneNumber.setDisable(false);
        startButton.setDisable(false);
    }

    /**
     * resets all program. This method will be used everytime order is placed.
     */
    @FXML
    void resetAll(){
        phoneNumber.setDisable(false);
        startButton.setDisable(false);
        phoneNumber.clear();
    }

    /**
     * This method will open up a new window for deluxe pizza when the button is pressed
     * @param event button press
     * @throws IOException exception for IO
     */
    @FXML
    void deluxeButton(ActionEvent event) throws IOException {
        try{
            newOrder.getCustomerNumber().isEmpty();
            chosenPizza = "Deluxe";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custom-view.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Customize Pizza");
            CustomController controller = loader.getController();
            controller.initData(this);
            stage.show();
        }
        catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You must enter a phone number successfully.");
            alert.show();
        }
    }

    /**
     * This method will open up a new window for hawaiian pizza when the button is pressed
     * @param event button press
     * @throws IOException exception for IO
     */
    @FXML
    void hawaiianButton(ActionEvent event) throws IOException {
        try{
            newOrder.getCustomerNumber().isEmpty();
            chosenPizza = "Hawaiian";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custom-view.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Customize Pizza");
            CustomController controller = loader.getController();
            controller.initData(this);
            stage.show();
        }
        catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You must enter a phone number successfully.");
            alert.show();
        }
    }

    /**
     * Must initialize to use image buttons.
     * @param event mouse click.
     */
    @FXML
    void imagePicker(MouseEvent event) {

    }

    /**
     * This method will open up a new window for pepperoni pizza when the button is pressed
     * @param event button press
     * @throws IOException exception for IO
     */
    @FXML
    void pepperoniButton(ActionEvent event) throws IOException {
        try{
            newOrder.getCustomerNumber().isEmpty();
            chosenPizza = "Pepperoni";
            FXMLLoader loader = new FXMLLoader(getClass().getResource("custom-view.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Customize Pizza");
            CustomController controller = loader.getController();
            controller.initData(this);
            stage.show();
        }
        catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You must enter a phone number successfully.");
            alert.show();
        }
    }

    /**
     * Button to check list of current orders.
     * @param event button click
     */
    @FXML
    void currentButton(ActionEvent event) throws IOException {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("current-view.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Current Orders");
            CurrentController controller = loader.getController();
            controller.initData(this);
            stage.show();
        }
        catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You must enter a phone number successfully.");
            alert.show();
        }
    }

    /**
     * this method will allow us to press Store Orders button and open a new window.
     * @param event button click.
     */
    @FXML
    void storeButton(ActionEvent event) throws IOException{
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("store-view.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Store Orders");
            StoreController controller = loader.getController();
            controller.initData(this);
            stage.show();

        }
        catch(IndexOutOfBoundsException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Store order is empty.");
            alert.show();
        }

    }
}