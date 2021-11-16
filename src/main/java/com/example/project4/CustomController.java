package com.example.project4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class is a controller for customized pizza window.
 * @author Geon Yeong Kim, Henry Tao
 */
public class CustomController {

    @FXML
    private MainController mainController;

    @FXML
    private Label chosenPizzaName;

    @FXML
    private ImageView selectionView;

    @FXML
    private ComboBox<Size> sizeBox;

    @FXML
    private ListView<Topping> addedTopping;

    @FXML
    private ListView<Topping> menuTopping;

    @FXML
    private TextField pizzaPrice;

    /**
     * initialize method with no input
     */
    @FXML
    void initialize() {
    }

    Pizza newPizza;

    /**
     * initial data that will begin once the window is open.
     * @param controller controller holds the controller of MainController.
     */
    @FXML
    void initData(MainController controller){
        try{
            mainController = controller;
            sizeBox.getItems().addAll(Size.SMALL, Size.MEDIUM, Size.LARGE);
            sizeBox.setValue(Size.SMALL);
            newPizza = PizzaMaker.createPizza(mainController.chosenPizza);
            newPizza.size = Size.SMALL;
            ObservableList<Topping> names = FXCollections.observableArrayList(newPizza.toppings);
            addedTopping.setItems(names);
            pizzaPrice.setText(String.format("%.2f",newPizza.price()));
            if(mainController.chosenPizza == "Hawaiian") {
                Image image = new Image("file:///Users/geonyeongkim/Desktop/project4/src/main/resources/com/example/project4/images-1.jpg");
                selectionView.setImage(image);
                chosenPizzaName.setText("Hawaiian Pizza");
                ObservableList<Topping> toppingChoice = FXCollections.observableArrayList(Topping.OLIVES, Topping.BLACKOLIVES, Topping.ONION
                , Topping.PEPPERONI, Topping.MUSHROOM, Topping.EXTRACHEESE, Topping.FRESHGARLIC, Topping.GREENPEPPER);
                menuTopping.setItems(toppingChoice);
            }
            else if(mainController.chosenPizza == "Deluxe") {
                Image image = new Image("file:///Users/geonyeongkim/Desktop/project4/src/main/resources/com/example/project4/images.jpg");
                selectionView.setImage(image);
                chosenPizzaName.setText("Deluxe Pizza");
                ObservableList<Topping> toppingChoice = FXCollections.observableArrayList(Topping.OLIVES,
                        Topping.EXTRACHEESE, Topping.FRESHGARLIC, Topping.GREENPEPPER, Topping.HAM);
                menuTopping.setItems(toppingChoice);
            }
            else if(mainController.chosenPizza == "Pepperoni") {
                Image image = new Image("file:///Users/geonyeongkim/Desktop/project4/src/main/resources/com/example/project4/download-2.jpg");
                selectionView.setImage(image);
                chosenPizzaName.setText("Pepperoni Pizza");
                ObservableList<Topping> toppingChoice = FXCollections.observableArrayList(Topping.OLIVES, Topping.BLACKOLIVES, Topping.ONION
                        , Topping.HAM, Topping.MUSHROOM, Topping.EXTRACHEESE, Topping.FRESHGARLIC, Topping.GREENPEPPER, Topping.PINEAPPLE);
                menuTopping.setItems(toppingChoice);
            }
        }
        catch(NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "???");
            alert.show();
        }
    }

    /**
     * This method is to add pizza to my order.
     * @param event press button
     */
    @FXML
    void addOrder(ActionEvent event) {
        Pizza tempPizza = PizzaMaker.createPizza(mainController.chosenPizza);
        tempPizza.size = newPizza.size;
        tempPizza.toppings = newPizza.toppings;
        mainController.newOrder.addPizza(tempPizza);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "The pizza has been added successfully.");
        alert.show();
    }

    /**
     * This method will add toppings to customized pizza.
     * @param event button click.
     */
    @FXML
    void addTopping(ActionEvent event) {
        Topping selected;
        selected = menuTopping.getSelectionModel().getSelectedItem();
        if(newPizza.toppings.size() > 7) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You have reached the maximum number of toppings.");
            alert.show();
        }
        else if(selected == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You must select a topping to add.");
            alert.show();
        }
        else{
            addedTopping.getItems().add(selected);
            menuTopping.getItems().remove(selected);
            newPizza.toppings.add(selected);
            pizzaPrice.setText(String.format("%.2f",newPizza.price()));
        }
    }

    /**
     * This method will remove toppings from the customized pizza.
     * @param event button click.
     */
    @FXML
    void removeTopping(ActionEvent event) {
        Topping selected;
        selected = addedTopping.getSelectionModel().getSelectedItem();
        if(newPizza.toppings.size() == 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You've already removed all your toppings.");
            alert.show();
        }
        else if(selected == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You must choose a topping to remove.");
            alert.show();
        }
        else{
            addedTopping.getItems().remove(selected);
            menuTopping.getItems().add(selected);
            newPizza.toppings.remove(selected);
            pizzaPrice.setText(String.format("%.2f",newPizza.price()));
        }
    }

    /**
     * This method will select the size of our pizza through combo box
     * @param event button click
     */
    @FXML
    void selectSize(ActionEvent event) {
        Size selected;
        selected = sizeBox.getSelectionModel().getSelectedItem();
        if(selected.equals(Size.SMALL)){
            newPizza.size = Size.SMALL;
        }
        else if(selected.equals(Size.MEDIUM)){
            newPizza.size = Size.MEDIUM;
        }
        else if(selected.equals(Size.LARGE)){
            newPizza.size = Size.LARGE;
        }
        pizzaPrice.setText(String.format("%.2f",newPizza.price()));
    }
}
