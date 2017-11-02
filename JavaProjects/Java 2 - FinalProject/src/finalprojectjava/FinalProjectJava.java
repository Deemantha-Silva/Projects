/*
 * By: Deemantha Silva
 * Java 2: Final Project
 * Due: April 12, 2017
 */
package finalprojectjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FinalProjectJava extends Application {

    //main labels for form
    private Label labelID = new Label("Console ID:");
    private Label labelCompany = new Label("Console Make:");
    private Label labelName = new Label("Console Name:");
    private Label labelGameType = new Label("Console Cartridge Type: ");
    private Label labelYear = new Label("Year of Production: ");
    private Label labelPrice = new Label("Console Price ($): ");
    private Label labelGameLibrary = new Label("Games in Console Library: ");

    //textfields to display data and to modify
    private TextField textID = new TextField();
    private TextField textCompany = new TextField();
    private TextField textName = new TextField();
    private TextField textGameType = new TextField();
    private TextField textYear = new TextField();
    private TextField textPrice = new TextField();
    private TextField textGameLibrary = new TextField();

    private VBox vBLabels = new VBox(labelID, labelCompany, labelName, labelGameType, labelYear, labelPrice, labelGameLibrary);
    private VBox vBTxtFields = new VBox(textID, textCompany, textName, textGameType, textYear, textPrice, textGameLibrary);
    private HBox hBForm = new HBox(vBLabels, vBTxtFields);

    //buttons to move through records
    private Button btnFirst = new Button("First Record");
    private Button btnPrevious = new Button("Previous Record");
    private Button btnNext = new Button("Next Record");
    private Button btnLast = new Button("Last Record");

    private HBox hBButtons = new HBox(btnFirst, btnPrevious, btnNext, btnLast);

    //buttons to modify records
    private Button btnSave = new Button("Save Changes");
    private Button btnRemove = new Button("Remove Record");
    private Button btnAdd = new Button("Add Record");
    private Button btnImg = new Button("See Image");

    private HBox hBModify = new HBox(btnSave, btnRemove, btnAdd, btnImg);

    //search option setup
    private Label labelSearch = new Label("Search for a record here: ");
    private TextField textSearch = new TextField();
    private Button btnSearch = new Button("Search");
    private HBox hBSearch = new HBox(labelSearch, textSearch, btnSearch);

    private TextArea txtDisplay = new TextArea();

    private GridPane pane = new GridPane();

    private int position = 0;

    private LinkedList<Console> consoleList = new LinkedList<>();

    private DecimalFormat dfPrice = new DecimalFormat("$#.00");
    private DecimalFormat dfDisplay = new DecimalFormat("#.00");

    private String oldLine = new String();

    private FileReader fr;
    private BufferedReader br;

    private FileWriter fw;
    private BufferedWriter bw;

    @Override
    public void start(Stage primaryStage) {
        //stores data from console.dat into linkedlist
        try {

            fr = new FileReader("console.dat");
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                Console one = new Console(st.nextToken());
                one.setCompany(st.nextToken());
                one.setName(st.nextToken());
                one.setGameType(st.nextToken());
                one.setYear(Integer.parseInt(st.nextToken()));
                one.setPrice(Double.parseDouble(st.nextToken()));
                one.setGameLibrary(Integer.parseInt(st.nextToken()));
                consoleList.add(one);
                line = br.readLine();
            }
            fr.close();
            br.close();

            //first console object is initially displayed on screen
            Console firstConsole = consoleList.get(0);
            String startupRecord = new String();
            String startConsole = firstConsole.getConsole();
            String startMake = firstConsole.getCompany();
            String startName = firstConsole.getName();
            String startgGameCatridge = firstConsole.getGameType();
            String startYear = Integer.toString(firstConsole.getYear());
            String startPrice = dfDisplay.format(firstConsole.getPrice());
            String startGameLibrary = Integer.toString(firstConsole.getGameLibrary());
            startupRecord = ("Console ID: " + startConsole
                    + "\nConsole Make: " + startMake
                    + "\nConsole Name: " + startName
                    + "\nConsole Game Cartridge Type: " + startgGameCatridge
                    + "\nConsole Production Year: " + startYear
                    + "\nConsole Price: " + dfPrice.format(firstConsole.getPrice())
                    + "\nConsole Game Library: " + startGameLibrary + " games");
            textID.setText(startConsole);
            textCompany.setText(startMake);
            textName.setText(startName);
            textGameType.setText(startgGameCatridge);
            textYear.setText(startYear);
            textPrice.setText(startPrice);
            textGameLibrary.setText(startGameLibrary);
            txtDisplay.setText(startupRecord);

            //string captures data of initial object for later use (file writing)
            oldLine = (textID.getText() + "," + textCompany.getText()
                    + "," + textName.getText() + "," + textGameType.getText()
                    + "," + textYear.getText() + "," + textPrice.getText()
                    + "," + textGameLibrary.getText());

            //button to go to first object in linkedlist, sets position variable to 0
            btnFirst.setOnAction(e -> {
                Console first = consoleList.get(0);
                String firstRecord = new String();
                String console = first.getConsole();
                String make = first.getCompany();
                String name = first.getName();
                String gameCatridge = first.getGameType();
                String year = Integer.toString(first.getYear());
                String price = dfDisplay.format(first.getPrice());
                String gameLibrary = Integer.toString(first.getGameLibrary());
                firstRecord = ("Console ID: " + console
                        + "\nConsole Make: " + make
                        + "\nConsole Name: " + name
                        + "\nConsole Game Cartridge Type: " + gameCatridge
                        + "\nConsole Production Year: " + year
                        + "\nConsole Price: " + dfPrice.format(first.getPrice())
                        + "\nConsole Game Library: " + gameLibrary + " games");
                textID.setText(console);
                textCompany.setText(make);
                textName.setText(name);
                textGameType.setText(gameCatridge);
                textYear.setText(year);
                textPrice.setText(price);
                textGameLibrary.setText(gameLibrary);
                txtDisplay.clear();
                txtDisplay.setText(firstRecord);
                position = 0;

                oldLine = (textID.getText() + "," + textCompany.getText()
                        + "," + textName.getText() + "," + textGameType.getText()
                        + "," + textYear.getText() + "," + textPrice.getText()
                        + "," + textGameLibrary.getText());

            });

            //button to go to last variable, sets position to list size -1
            btnLast.setOnAction(e -> {
                Console last = consoleList.get(consoleList.size() - 1);
                String lastRecord = new String();
                String console = last.getConsole();
                String make = last.getCompany();
                String name = last.getName();
                String gameCatridge = last.getGameType();
                String year = Integer.toString(last.getYear());
                String price = dfDisplay.format(last.getPrice());
                String gameLibrary = Integer.toString(last.getGameLibrary());
                lastRecord = ("Console ID: " + console
                        + "\nConsole Make: " + make
                        + "\nConsole Name: " + name
                        + "\nConsole Game Cartridge Type: " + gameCatridge
                        + "\nConsole Production Year: " + year
                        + "\nConsole Price: " + dfPrice.format(last.getPrice())
                        + "\nConsole Game Library: " + gameLibrary + " games");
                textID.setText(console);
                textCompany.setText(make);
                textName.setText(name);
                textGameType.setText(gameCatridge);
                textYear.setText(year);
                textPrice.setText(price);
                textGameLibrary.setText(gameLibrary);
                txtDisplay.clear();
                txtDisplay.setText(lastRecord);
                position = consoleList.size() - 1;

                oldLine = (textID.getText() + "," + textCompany.getText()
                        + "," + textName.getText() + "," + textGameType.getText()
                        + "," + textYear.getText() + "," + textPrice.getText()
                        + "," + textGameLibrary.getText());
            });

            //button to go to next record, uses position and list size
            btnNext.setOnAction(e -> {
                if (position == consoleList.size() - 1) {
                    position = 0;
                } else {
                    position = position;
                    position++;
                }
                Console next = consoleList.get(position);
                String nextRecord = new String();
                String console = next.getConsole();
                String make = next.getCompany();
                String name = next.getName();
                String gameCatridge = next.getGameType();
                String year = Integer.toString(next.getYear());
                String price = dfDisplay.format(next.getPrice());
                String gameLibrary = Integer.toString(next.getGameLibrary());
                nextRecord = ("Console ID: " + console
                        + "\nConsole Make: " + make
                        + "\nConsole Name: " + name
                        + "\nConsole Game Cartridge Type: " + gameCatridge
                        + "\nConsole Production Year: " + year
                        + "\nConsole Price: " + dfPrice.format(next.getPrice())
                        + "\nConsole Game Library: " + gameLibrary + " games");
                textID.setText(console);
                textCompany.setText(make);
                textName.setText(name);
                textGameType.setText(gameCatridge);
                textYear.setText(year);
                textPrice.setText(price);
                textGameLibrary.setText(gameLibrary);
                txtDisplay.clear();
                txtDisplay.setText(nextRecord);

                oldLine = (textID.getText() + "," + textCompany.getText()
                        + "," + textName.getText() + "," + textGameType.getText()
                        + "," + textYear.getText() + "," + textPrice.getText()
                        + "," + textGameLibrary.getText());

            });

            //button to go previous item uses position and list size
            btnPrevious.setOnAction(e -> {
                if (position == 0) {
                    position = consoleList.size() - 1;
                } else {
                    position = position;
                    position--;
                }
                Console previous = consoleList.get(position);
                String previousRecord = new String();
                String console = previous.getConsole();
                String make = previous.getCompany();
                String name = previous.getName();
                String gameCatridge = previous.getGameType();
                String year = Integer.toString(previous.getYear());
                String price = dfDisplay.format(previous.getPrice());
                String gameLibrary = Integer.toString(previous.getGameLibrary());
                previousRecord = ("Console ID: " + console
                        + "\nConsole Make: " + make
                        + "\nConsole Name: " + name
                        + "\nConsole Game Cartridge Type: " + gameCatridge
                        + "\nConsole Production Year: " + year
                        + "\nConsole Price: " + dfPrice.format(previous.getPrice())
                        + "\nConsole Game Library: " + gameLibrary + " games");
                textID.setText(console);
                textCompany.setText(make);
                textName.setText(name);
                textGameType.setText(gameCatridge);
                textYear.setText(year);
                textPrice.setText(price);
                textGameLibrary.setText(gameLibrary);
                txtDisplay.clear();
                txtDisplay.setText(previousRecord);

                oldLine = (textID.getText() + "," + textCompany.getText()
                        + "," + textName.getText() + "," + textGameType.getText()
                        + "," + textYear.getText() + "," + textPrice.getText()
                        + "," + textGameLibrary.getText());
            });

            //saves modifications to current record, writes to file with each instance
            btnSave.setOnAction((ActionEvent e) -> {
                String console = new String();
                String make = new String();
                String name = new String();
                String gameCatridge = new String();
                int year = 0;
                double price = 0;
                int gameLibrary = 0;

                String message = new String();
                //boolean used to make validations to ultimately add data
                boolean allCheck = true;

                if (!textCompany.getText().isEmpty()) {
                    make = textCompany.getText();
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Missing Information");
                    dlgInformation.setContentText("Please make sure to enter a make");
                    dlgInformation.show();
                    allCheck = false;
                }
                if (!textName.getText().isEmpty()) {
                    name = textName.getText();
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Missing Information");
                    dlgInformation.setContentText("Please make sure to enter a console name");
                    dlgInformation.show();
                    allCheck = false;
                }
                if (!textGameType.getText().isEmpty()) {
                    gameCatridge = textGameType.getText();
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Missing Information");
                    dlgInformation.setContentText("Please make sure to enter a console cartriddge type");
                    dlgInformation.show();
                    allCheck = false;
                }
                if (!textYear.getText().isEmpty()) {
                    if (textYear.getText().matches("[a-zA-Z]")) {
                        Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                        dlgInformation.setHeaderText("Incorrect Input");
                        dlgInformation.setContentText("Year must be a number!");
                        dlgInformation.show();
                        textYear.clear();
                        allCheck = false;
                    } else {
                        year = Integer.parseInt(textYear.getText());
                        if (year <= 0) {
                            Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                            dlgInformation.setHeaderText("Incorrect Input");
                            dlgInformation.setContentText("Year cannot be negative or zero!");
                            dlgInformation.show();
                            textYear.clear();
                            allCheck = false;
                        }
                    }
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Missing Information");
                    dlgInformation.setContentText("Please make sure to enter a production year");
                    dlgInformation.show();
                    allCheck = false;
                }
                if (!textPrice.getText().isEmpty()) {
                    if (textPrice.getText().matches("[a-zA-Z]")) {
                        Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                        dlgInformation.setHeaderText("Incorrect Input");
                        dlgInformation.setContentText("Price must be a number!");
                        dlgInformation.show();
                        textPrice.clear();
                        allCheck = false;
                    } else {
                        price = Double.parseDouble(textPrice.getText());
                        if (price <= 0) {
                            Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                            dlgInformation.setHeaderText("Incorrect Input");
                            dlgInformation.setContentText("Price cannot be negative or zero!");
                            dlgInformation.show();
                            textPrice.clear();
                            allCheck = false;
                        }
                    }
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Missing Information");
                    dlgInformation.setContentText("Please make sure to enter a console price");
                    dlgInformation.show();
                    allCheck = false;
                }
                if (!textGameLibrary.getText().isEmpty()) {
                    if (textGameLibrary.getText().matches("[a-zA-Z]")) {
                        Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                        dlgInformation.setHeaderText("Incorrect Input");
                        dlgInformation.setContentText("Game Library must be a number!");
                        dlgInformation.show();
                        textGameLibrary.clear();
                        allCheck = false;
                    } else {
                        gameLibrary = Integer.parseInt(textGameLibrary.getText());
                        if (gameLibrary <= 0) {
                            Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                            dlgInformation.setHeaderText("Incorrect Input");
                            dlgInformation.setContentText("Game Library cannot be negative or zero!");
                            dlgInformation.show();
                            textGameLibrary.clear();
                            allCheck = false;
                        }
                    }
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Missing Information");
                    dlgInformation.setContentText("Please make sure to enter a console game library");
                    dlgInformation.show();
                    allCheck = false;
                }
                //if validations are true, old data is overwritten
                if (allCheck == true) {
                    try {
                        File filetmp = new File("tmp.dat");
                        br = new BufferedReader(new FileReader("console.dat"));
                        bw = new BufferedWriter(new FileWriter("tmp.dat"));

                        Alert dlgConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
                        dlgConfirmation.setHeaderText("Record Modification");
                        dlgConfirmation.setContentText("Save Changes?");
                        Optional<ButtonType> result = dlgConfirmation.showAndWait();

                        if (result.get() == ButtonType.OK) {
                            Console saveConsole = new Console(textID.getText());
                            saveConsole.setCompany(make);
                            saveConsole.setName(name);
                            saveConsole.setGameType(gameCatridge);
                            saveConsole.setYear(year);
                            saveConsole.setPrice(price);
                            saveConsole.setGameLibrary(gameLibrary);
                            consoleList.remove(position);
                            consoleList.add(position, saveConsole);

                            String saveRecord = ("Console ID: " + saveConsole.getConsole()
                                    + "\nConsole Make: " + saveConsole.getCompany()
                                    + "\nConsole Name: " + saveConsole.getName()
                                    + "\nConsole Game Cartridge Type: " + saveConsole.getGameType()
                                    + "\nConsole Production Year: " + saveConsole.getYear()
                                    + "\nConsole Price: " + dfPrice.format(saveConsole.getPrice())
                                    + "\nConsole Game Library: " + saveConsole.getGameLibrary() + " games");

                            String newerLine = (textID.getText() + "," + textCompany.getText()
                                    + "," + textName.getText() + "," + textGameType.getText()
                                    + "," + textYear.getText() + "," + textPrice.getText()
                                    + "," + textGameLibrary.getText());

                            //code block used to overwrite original data with new modified data
                            //old line is used to compare currently read line with what it originally was
                            String tmpLine = br.readLine();
                            while (tmpLine != null) {
                                if (tmpLine.contains(oldLine)) {
                                    if (tmpLine.contains("C001")) {
                                        bw.write(newerLine);
                                    } else if (tmpLine.contains(consoleList.get(position).getConsole())) {
                                        bw.write(newerLine);

                                    } else {
                                        bw.newLine();
                                        bw.write(newerLine);
                                    }
                                } else if (tmpLine.contains("C001")) {
                                    bw.write(tmpLine);
                                } else {
                                    bw.newLine();
                                    bw.write(tmpLine);
                                }
                                tmpLine = br.readLine();
                            }
                            bw.flush();
                            bw.close();
                            br.close();

                            txtDisplay.setText(saveRecord);

                            //use a temporary file to contain the new data, delete the old, and rename the temporary
                            File oldFile = new File("console.dat");
                            oldFile.delete();
                            filetmp.renameTo(oldFile);

                            message = "Record Modified";
                        } else {
                            message = "Record Changes Cancelled";
                        }
                        Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                        dlgInformation.setHeaderText("Record modification");
                        dlgInformation.setContentText(message);
                        dlgInformation.show();
                        //oldLine now grabs the new data to compare if the user wants to modify the same file again
                        oldLine = (textID.getText() + "," + textCompany.getText()
                                + "," + textName.getText() + "," + textGameType.getText()
                                + "," + textYear.getText() + "," + textPrice.getText()
                                + "," + textGameLibrary.getText());
                    } catch (IOException e1) {
                        Alert dlgError = new Alert(Alert.AlertType.ERROR);
                        dlgError.setHeaderText("Error!");
                        dlgError.setContentText("Error - File Not Found!");
                        dlgError.show();
                    }
                }
            });

            //button remove a file from the records and from the dat file
            btnRemove.setOnAction(e -> {
                String message = new String();
                ListIterator<Console> liT = consoleList.listIterator();
                Console remove = consoleList.get(position);
                String IDCheck = remove.getConsole();
                Boolean allCheck = true;
                
                //boolean to prevent confirmation button block from activating
                if (consoleList.size() == 1) {
                    Alert dlgWarning = new Alert(Alert.AlertType.WARNING);
                    dlgWarning.setHeaderText("Warning!");
                    dlgWarning.setContentText("At least one record must be in database at all times!");
                    dlgWarning.show();
                    btnRemove.setDisable(true);
                    btnFirst.setDisable(true);
                    btnPrevious.setDisable(true);
                    btnNext.setDisable(true);
                    btnLast.setDisable(true);
                    btnSearch.setDisable(true);
                    allCheck = false;
                    //code block that disables remove and other features once list is at 1 object
                } else {
                    allCheck = true;
                }

                if (allCheck == true) {
                    Alert dlgConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
                    dlgConfirmation.setHeaderText("Record Deletion");
                    dlgConfirmation.setContentText("Permanently Delete Record?");
                    Optional<ButtonType> result = dlgConfirmation.showAndWait();

                    if (result.get() == ButtonType.OK) {
                        while (liT.hasNext()) {
                            if (liT.next().getConsole().equalsIgnoreCase(IDCheck)) {
                                if (position > 0 & consoleList.size() == 2) {
                                    liT.remove();
                                    position = 0;
                                } else {
                                    liT.remove();
                                    textID.clear();
                                    textCompany.clear();
                                    textName.clear();
                                    textGameType.clear();
                                    textYear.clear();
                                    textPrice.clear();
                                    textGameLibrary.clear();
                                    txtDisplay.clear();
                                }
                            }
                        }
                        Console next = consoleList.get(position);
                        String nextRecord = new String();
                        String console = next.getConsole();
                        String make = next.getCompany();
                        String name = next.getName();
                        String gameCatridge = next.getGameType();
                        String year = Integer.toString(next.getYear());
                        String price = dfDisplay.format(next.getPrice());

                        String gameLibrary = Integer.toString(next.getGameLibrary());
                        nextRecord = ("Console ID: " + console
                                + "\nConsole Make: " + make
                                + "\nConsole Name: " + name
                                + "\nConsole Game Cartridge Type: " + gameCatridge
                                + "\nConsole Production Year: " + year
                                + "\nConsole Price: " + price
                                + "\nConsole Game Library: " + gameLibrary + " games");
                        textID.setText(console);
                        textCompany.setText(make);
                        textName.setText(name);
                        textGameType.setText(gameCatridge);
                        textYear.setText(year);
                        textPrice.setText(price);
                        textGameLibrary.setText(gameLibrary);
                        txtDisplay.clear();
                        txtDisplay.setText(nextRecord);

                        oldLine = (textID.getText() + "," + textCompany.getText()
                                + "," + textName.getText() + "," + textGameType.getText()
                                + "," + textYear.getText() + "," + textPrice.getText()
                                + "," + textGameLibrary.getText());
                        //oldLine needed to for validations to write to console.dat once a removal has occured
                        
                        message = ("Current Record Deleted!"
                                + "\nDisplaying Next Record!"
                                + "\nNumber of records left: " + consoleList.size());
                    } else {
                        message = "Record Deletion cancelled";
                    }
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Record Deletion");
                    dlgInformation.setContentText(message);
                    dlgInformation.show();

                    //code block to modify dat file to show changes (data removal)
                    try {
                        File filetmp = new File("tmp2.dat");
                        bw = new BufferedWriter(new FileWriter("tmp2.dat"));
                        DecimalFormat dfAdjust = new DecimalFormat("#.00");
                        String tmpLine = new String();
                        for (int i = 0; i < consoleList.size(); i++) {
                            Console placeholder = consoleList.get(i);
                            tmpLine = placeholder.getConsole() + "," + placeholder.getCompany() + ","
                                    + placeholder.getName() + "," + placeholder.getGameType() + ","
                                    + placeholder.getYear() + "," + dfAdjust.format(placeholder.getPrice()) + ","
                                    + placeholder.getGameLibrary();
                            if (i == consoleList.size() - 1) {
                                bw.write(tmpLine);
                            } else {

                                bw.write(tmpLine);
                                bw.newLine();
                            }
                        }
                        bw.flush();
                        bw.close();
                        br.close();

                        //once again a new temp file replaces the original
                        File oldFile = new File("console.dat");
                        oldFile.delete();
                        filetmp.renameTo(oldFile);
                    } catch (IOException e2) {
                        Alert dlgError = new Alert(Alert.AlertType.ERROR);
                        dlgError.setHeaderText("Error!");
                        dlgError.setContentText("Error - File Not Found!");
                        dlgError.show();
                    }
                }
            });

            //button to add a new console record uses another stage
            btnAdd.setOnAction(e -> {
                StageTwo stTwo = new StageTwo();
                stTwo.show();
            });

            //button to see an image of the currently dislayed console
            btnImg.setOnAction(e -> {
                StageThree stThree = new StageThree();
                stThree.show();
            });

            //button to search for any console, will search through all text fields
            btnSearch.setOnAction(e -> {
                //search counter to determine how many objects the iterator will go through
                //a placeholder console object that will be added to a copy of the consoleList
                //this will add one more console object, allowing the iterator to go to the last actual object
                //without crashing
                int searchCount = 0;
                if (textSearch.getText().isEmpty() || textSearch.getText() == null) {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Record Search");
                    dlgInformation.setContentText("Search Information Missing");
                    dlgInformation.show();
                } else {
                    Console placeholder = new Console("Placeholder");
                    LinkedList<Console> consoleListCopy = new LinkedList<>();
                    for (int i = 0; i < consoleList.size(); i++) {
                        consoleListCopy.add(consoleList.get(i));
                    }
                    consoleListCopy.add(placeholder);
                    String sSearch = textSearch.getText();
                    Iterator<Console> itSearch = consoleListCopy.iterator();
                    Alert dlgSearch = new Alert(Alert.AlertType.INFORMATION);
                    dlgSearch.setHeaderText("Record Search");
                    dlgSearch.setContentText("Record Found" + "\nDisplaying Record");

                    Alert dlgSearchWarning = new Alert(Alert.AlertType.WARNING);
                    dlgSearchWarning.setContentText("Record Not Found or Doesn't Exist\nPlease Try Again!");
                    while (itSearch.hasNext()) {
                        Console three = itSearch.next();
                        if (three.getConsole().equalsIgnoreCase(sSearch)) {
                            dlgSearch.show();
                            break;
                        } else if (three.getCompany().equalsIgnoreCase(sSearch)) {
                            dlgSearch.show();
                            break;
                        } else if (three.getName().equalsIgnoreCase(sSearch)) {
                            dlgSearch.show();
                            break;
                        } else if (three.getGameType().equalsIgnoreCase(sSearch)) {
                            dlgSearch.show();
                            break;
                        } else if (Integer.toString(three.getYear()).equals((sSearch))) {
                            dlgSearch.show();
                            break;
                        } else if (Double.toString(three.getPrice()).equals(sSearch)) {
                            dlgSearch.show();
                            break;
                        } else if (Integer.toString(three.getGameLibrary()).equals((sSearch))) {
                            dlgSearch.show();
                            break;
                        } else if (searchCount == consoleListCopy.size() - 1) {
                            dlgSearchWarning.show();
                            textSearch.clear();
                            searchCount = 0;
                            break;
                        } else {
                            searchCount++;
                        }
                    }
                    position = searchCount;
                    Console search = consoleList.get(position);
                    String searchResults = new String();
                    String console = search.getConsole();
                    String make = search.getCompany();
                    String name = search.getName();
                    String gameCatridge = search.getGameType();
                    String year = Integer.toString(search.getYear());
                    String price = dfDisplay.format(search.getPrice());
                    String gameLibrary = Integer.toString(search.getGameLibrary());
                    searchResults = ("Console ID: " + console
                            + "\nConsole Make: " + make
                            + "\nConsole Name: " + name
                            + "\nConsole Game Cartridge Type: " + gameCatridge
                            + "\nConsole Production Year: " + year
                            + "\nConsole Price: " + dfPrice.format(search.getPrice())
                            + "\nConsole Game Library: " + gameLibrary + " games");
                    textID.setText(console);
                    textCompany.setText(make);
                    textName.setText(name);
                    textGameType.setText(gameCatridge);
                    textYear.setText(year);
                    textPrice.setText(price);
                    textGameLibrary.setText(gameLibrary);
                    txtDisplay.clear();
                    txtDisplay.setText(searchResults);

                }
                textSearch.clear();
            });

        } catch (FileNotFoundException e) {
            Alert dlgError = new Alert(Alert.AlertType.ERROR);
            dlgError.setHeaderText("Error!");
            dlgError.setContentText("Error - File Not Found!");
            dlgError.show();
        } catch (IOException e) {
            Alert dlgError = new Alert(Alert.AlertType.ERROR);
            dlgError.setHeaderText("Error!");
            dlgError.setContentText("Error in Input/Output");
            dlgError.show();
        } catch (IndexOutOfBoundsException e) {
            Alert dlgError = new Alert(Alert.AlertType.ERROR);
            dlgError.setHeaderText("Error!");
            dlgError.setContentText("Error - Record Does not Exist!");
            dlgError.show();

        }

        textSearch.requestFocus();
        textID.setEditable(false);
        txtDisplay.setEditable(false);
        txtDisplay.setMaxHeight(175);
        txtDisplay.setMaxWidth(355);
        vBLabels.setMaxWidth(200);

        hBButtons.getStyleClass().add("btn");
        hBModify.getStyleClass().add("btn");

        vBLabels.getStyleClass().add("vb");
        vBTxtFields.getStyleClass().add("vb");

        pane.add(hBSearch, 1, 0);
        pane.add(hBForm, 0, 1);
        pane.add(txtDisplay, 1, 1);
        pane.add(hBButtons, 1, 2);
        pane.add(hBModify, 0, 2);
        Scene scene = new Scene(pane, 718, 230);
        scene.getStylesheets().add("/css/TheStyle.css");
        primaryStage.setTitle("Console Database");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public class StageTwo extends Stage {

        //this stage contains all the features associated with the add button
        private boolean confirmAdd = true;
        private String ID = new String();
        private int index = consoleList.size() + 1;

        public StageTwo() {

            Label labelIDAdd = new Label("Enter a Console ID:");
            Label labelCompanyAdd = new Label("Enter the Console Make:");
            Label labelNameAdd = new Label("Enter the Console Name:");
            Label labelGameTypeAdd = new Label("Enter the Console Cartridge/Game Type: ");
            Label labelYearAdd = new Label("Enter the Console Year of Production: ");
            Label labelPriceAdd = new Label("Enter the Console Price ($): ");
            Label labelGameLibraryAdd = new Label("Enter the Console's Library: ");

            TextField textIDAdd = new TextField();
            TextField textCompanyAdd = new TextField();
            TextField textNameAdd = new TextField();
            TextField textGameTypeAdd = new TextField();
            TextField textYearAdd = new TextField();
            TextField textPriceAdd = new TextField();
            TextField textGameLibraryAdd = new TextField();

            VBox vBLabels2 = new VBox(labelIDAdd, labelCompanyAdd, labelNameAdd, labelGameTypeAdd, labelYearAdd, labelPriceAdd, labelGameLibraryAdd);
            VBox vBForms2 = new VBox(textIDAdd, textCompanyAdd, textNameAdd, textGameTypeAdd, textYearAdd, textPriceAdd, textGameLibraryAdd);

            Button btnSubmit = new Button("Add");
            HBox hBSubmit = new HBox(btnSubmit);

            GridPane paneAdd = new GridPane();
            paneAdd.add(vBLabels2, 0, 0);
            paneAdd.add(vBForms2, 1, 0);
            paneAdd.add(hBSubmit, 1, 1);

            //this code block will assign a console ID
            if (consoleList.size() > 9) {
                ID = "C0" + index;
            } else {
                ID = "C00" + index;
            }
            textIDAdd.setText(ID);
            textIDAdd.setEditable(false);

            Iterator<Console> itConsole = consoleList.iterator();
            btnSubmit.setOnAction(e -> {
                String message = new String();
                String make = new String();
                String name = new String();
                String gameCatridge = new String();
                int year = 0;
                double price = 0;
                int gameLibrary = 0;
                boolean idCheck = false;
                boolean nameCheck = false;

                if (!textCompanyAdd.getText().isEmpty()) {
                    make = textCompanyAdd.getText();

                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Information Missing");
                    dlgInformation.setContentText("Please make sure to enter a make");
                    dlgInformation.show();
                    confirmAdd = false;
                }
                if (!textNameAdd.getText().isEmpty()) {
                    while (itConsole.hasNext()) {
                        if (itConsole.next().getName().equalsIgnoreCase(textNameAdd.getText())) {
                            Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                            dlgInformation.setHeaderText("Already In Use");
                            dlgInformation.setContentText("This console is already listed, please delete previous entry or enter another console");
                            dlgInformation.show();
                            textNameAdd.clear();
                            nameCheck = true;
                            break;
                        } else {
                            nameCheck = false;
                        }
                    }
                    if (nameCheck == false) {
                        name = textNameAdd.getText();
                    }
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Information Missing");
                    dlgInformation.setContentText("Please make sure to enter a console name");
                    dlgInformation.show();
                    confirmAdd = false;
                }
                if (!textGameTypeAdd.getText().isEmpty()) {
                    gameCatridge = textGameTypeAdd.getText();
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Information Missing");
                    dlgInformation.setContentText("Please make sure to enter a console cartriddge type");
                    dlgInformation.show();
                    confirmAdd = false;
                }
                if (!textYearAdd.getText().isEmpty()) {
                    if (textYearAdd.getText().matches("[a-zA-Z]")) {
                        Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                        dlgInformation.setHeaderText("Incorrect Input");
                        dlgInformation.setContentText("Year must be a number!");
                        dlgInformation.show();
                        confirmAdd = false;
                    } else {
                        year = Integer.parseInt(textYearAdd.getText());

                        if (year <= 0) {
                            Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                            dlgInformation.setHeaderText("Incorrect Input");
                            dlgInformation.setContentText("Year cannot be negative or zero!");
                            dlgInformation.show();
                            textYearAdd.clear();
                            confirmAdd = false;
                        }
                    }
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Information Missing");
                    dlgInformation.setContentText("Please make sure to enter a production year");
                    dlgInformation.show();
                    confirmAdd = false;
                }
                if (!textPriceAdd.getText().isEmpty()) {
                    if (textPriceAdd.getText().matches("[a-zA-Z]")) {
                        Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                        dlgInformation.setHeaderText("Incorrect Input");
                        dlgInformation.setContentText("Price must be a number!");
                        dlgInformation.show();
                        confirmAdd = false;
                    } else {
                        price = Double.parseDouble(textPriceAdd.getText());

                        if (price <= 0) {
                            Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                            dlgInformation.setHeaderText("Incorrect Input");
                            dlgInformation.setContentText("Price cannot be negative or zero!");
                            dlgInformation.show();
                            textPriceAdd.clear();
                            confirmAdd = false;
                        }
                    }
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Information Missing");
                    dlgInformation.setContentText("Please make sure to enter a console price");
                    dlgInformation.show();
                    confirmAdd = false;
                }
                if (!textGameLibraryAdd.getText().isEmpty()) {
                    if (textGameLibraryAdd.getText().matches("[a-zA-Z]")) {
                        Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                        dlgInformation.setHeaderText("Incorrect Input");
                        dlgInformation.setContentText("Game Library must be a number!");
                        dlgInformation.show();
                        confirmAdd = false;
                    } else {
                        gameLibrary = Integer.parseInt(textGameLibraryAdd.getText());
                        if (gameLibrary <= 0) {
                            Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                            dlgInformation.setHeaderText("Incorrect Input");
                            dlgInformation.setContentText("Game Library cannot be negative or zero!");
                            dlgInformation.show();
                            textGameLibraryAdd.clear();
                            confirmAdd = false;
                        }
                    }
                } else {
                    Alert dlgInformation = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformation.setHeaderText("Information Missing");
                    dlgInformation.setContentText("Please make sure to enter a console game library");
                    dlgInformation.show();
                    confirmAdd = false;
                }
                if (confirmAdd == true) {
                    Alert dlgConfirmation = new Alert(Alert.AlertType.CONFIRMATION);
                    dlgConfirmation.setHeaderText("Record Addition");
                    dlgConfirmation.setContentText("Add Record?");
                    Optional<ButtonType> result = dlgConfirmation.showAndWait();
                    if (result.get() == ButtonType.OK) {

                        Console addConsole = new Console(ID);
                        addConsole.setCompany(make);
                        addConsole.setName(name);
                        addConsole.setGameType(gameCatridge);
                        addConsole.setYear(year);
                        addConsole.setPrice(price);
                        addConsole.setGameLibrary(gameLibrary);
                        consoleList.add(addConsole);

                        message = ("New Console Record Added!");

                        DecimalFormat dfAdjust = new DecimalFormat("#.00");
                        double priceAdjust = Double.parseDouble(textPriceAdd.getText());
                        String priceAdjusted = dfAdjust.format(priceAdjust);

                        String newLine = (ID + "," + textCompanyAdd.getText()
                                + "," + textNameAdd.getText() + "," + textGameTypeAdd.getText()
                                + "," + textYearAdd.getText() + "," + priceAdjusted
                                + "," + textGameLibraryAdd.getText());

                        //code block to append/add new record to end of dat file
                        try {
                            fw = new FileWriter("console.dat", true);
                            bw = new BufferedWriter(fw);
                            bw.newLine();
                            bw.write(newLine);
                            bw.flush();
                            bw.close();
                        } catch (IOException ex) {
                            Alert dlgError = new Alert(Alert.AlertType.ERROR);
                            dlgError.setHeaderText("Error!");
                            dlgError.setContentText("Error in Input/Output");
                            dlgError.show();
                        }
                        textCompanyAdd.clear();
                        textNameAdd.clear();
                        textGameTypeAdd.clear();
                        textYearAdd.clear();
                        textPriceAdd.clear();
                        textGameLibraryAdd.clear();

                        close();

                    } else {
                        message = "Cancelled";
                        close();
                    }
                    Alert dlgInformationAdd = new Alert(Alert.AlertType.INFORMATION);
                    dlgInformationAdd.setHeaderText("Record Addition");
                    dlgInformationAdd.setContentText(message);
                    dlgInformationAdd.show();
                }
                confirmAdd = true;
                btnRemove.setDisable(false);
                btnFirst.setDisable(false);
                btnPrevious.setDisable(false);
                btnNext.setDisable(false);
                btnLast.setDisable(false);
                btnSearch.setDisable(false);
                //this block of code re-enables buttons (useful when remove is used)
            });
            Scene scene = new Scene(paneAdd, 400, 210);
            setScene(scene);
            hBSubmit.getStyleClass().add("hbsubmit");
            scene.getStylesheets().add("/css/TheStyle2.css");
            setTitle("Add a new Record!");
        }
    }

    public class StageThree extends Stage {

        //this stage contains all the code for the image button
        private Image atari5200 = new Image("images/atari5200.jpg");
        private Image NES = new Image("images/NES.jpg");
        private Image genesis = new Image("images/genesis.jpg");
        private Image neoGeo = new Image("images/neoGeo.jpg");
        private Image SNES = new Image("images/SNES.jpg");
        private Image PS = new Image("images/playstation.jpg");
        private Image N64 = new Image("images/N64.jpg");
        private Image PS2 = new Image("images/ps2.jpg");
        private Image xbox = new Image("images/xbox.jpg");
        private Image gameCube = new Image("images/gamecube.jpg");
        private Image noImg = new Image("images/nope.gif");

        public StageThree() {
            String consoleName = consoleList.get(position).getName();
            Image displayImg;
            ImageView consoleImg;

            //switch statement to determine which console image to show
            switch (consoleName) {
                case "Atari 5200 SuperSystem":
                    displayImg = atari5200;
                    break;
                case "NES":
                    displayImg = NES;
                    break;
                case "Sega Genesis":
                    displayImg = genesis;
                    break;
                case "Neo Geo":
                    displayImg = neoGeo;
                    break;
                case "SNES":
                    displayImg = SNES;
                    break;
                case "PlayStation":
                    displayImg = PS;
                    break;
                case "Nintendo 64":
                    displayImg = N64;
                    break;
                case "PlayStation 2":
                    displayImg = PS2;
                    break;
                case "Xbox":
                    displayImg = xbox;
                    break;
                case "GameCube":
                    displayImg = gameCube;
                    break;
                default:
                    displayImg = noImg;
                    break;
            }
            consoleImg = new ImageView(displayImg);
            Pane pane = new Pane(consoleImg);
            Scene scene = new Scene(pane, 500, 500);
            setScene(scene);
            setTitle(consoleName + "");
            setResizable(false);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
