package gui;

import core.*;
import core.BankException.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.List;

/**
 * JavaFX GUI. Every button click calls the SAME core classes (UsersStorage,
 * BankingService, Loan, AccountService, TransactionAlgorithms) used by the
 * terminal app - this class only builds widgets and shows Alerts/dialogs.
 */
public class BankApp extends Application {

    private final UsersStorage storage = new UsersStorage();
    private final BankingService bank = new BankingService(storage);
    private final Loan loanLogic = new Loan(storage);

    private Stage stage;
    private String currentUser;
    private String currentAccountType;

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Bank");
        stage.setScene(loginScene());
        stage.show();
    }

    // ---------------------------------------------------------------- LOGIN

    private Scene loginScene() {
        TextField userField = new TextField();
        PasswordField passField = new PasswordField();
        Label status = new Label();
        status.setStyle("-fx-text-fill: red;");

        Button loginBtn = new Button("Login");
        Button createBtn = new Button("Create account");
        Button forgotBtn = new Button("Change password");

        loginBtn.setOnAction(e -> {
            try {
                AuthService.Session s = AuthService.login(storage, userField.getText(), passField.getText());
                currentUser = s.username;
                currentAccountType = s.accountType;
                stage.setScene(dashboardScene());
            } catch (BankException ex) {
                status.setText(ex.getMessage());
            }
        });

        createBtn.setOnAction(e -> stage.setScene(createAccountScene()));
        forgotBtn.setOnAction(e -> stage.setScene(changePasswordScene()));

        VBox form = new VBox(10,
                title("Welcome to Bank"),
                new Label("Username:"), userField,
                new Label("Password:"), passField,
                loginBtn, status,
                new Separator(),
                createBtn, forgotBtn);
        form.setPadding(new Insets(30));
        form.setAlignment(Pos.CENTER);
        return new Scene(form, 340, 420);
    }

    // -------------------------------------------------------- CREATE ACCOUNT

    private Scene createAccountScene() {
        ToggleGroup group = new ToggleGroup();
        RadioButton personal = new RadioButton("Personal ($500 min deposit)");
        RadioButton savings = new RadioButton("Savings (no initial deposit)");
        personal.setToggleGroup(group);
        savings.setToggleGroup(group);
        personal.setSelected(true);

        TextField userField = new TextField();
        PasswordField passField = new PasswordField();
        TextField mobileField = new TextField();
        TextField depositField = new TextField();
        depositField.setPromptText("Initial deposit (personal only)");
        Label status = new Label();
        status.setStyle("-fx-text-fill: red;");

        Button createBtn = new Button("Create");
        Button backBtn = new Button("Back to login");

        createBtn.setOnAction(e -> {
            try {
                int type = personal.isSelected() ? AccountService.PERSONAL : AccountService.SAVINGS;
                double deposit = 0;
                if (type == AccountService.PERSONAL) {
                    deposit = Double.parseDouble(depositField.getText().isBlank() ? "0" : depositField.getText());
                }
                AccountService.createAccount(storage, userField.getText(), passField.getText(),
                        mobileField.getText(), type, deposit);
                new Alert(Alert.AlertType.INFORMATION, "Account created! You can log in now.").showAndWait();
                stage.setScene(loginScene());
            } catch (NumberFormatException ex) {
                status.setText("Deposit must be a number.");
            } catch (BankException ex) {
                status.setText(ex.getMessage());
            }
        });
        backBtn.setOnAction(e -> stage.setScene(loginScene()));

        VBox form = new VBox(10,
                title("Create Account"),
                personal, savings,
                new Label("Username:"), userField,
                new Label("Password:"), passField,
                new Label("Mobile:"), mobileField,
                depositField,
                createBtn, status, backBtn);
        form.setPadding(new Insets(30));
        return new Scene(form, 340, 500);
    }

    // ------------------------------------------------------ CHANGE PASSWORD

    private Scene changePasswordScene() {
        TextField userField = new TextField();
        TextField mobileField = new TextField();
        PasswordField newPassField = new PasswordField();
        Label status = new Label();

        Button submit = new Button("Change password");
        Button back = new Button("Back");

        submit.setOnAction(e -> {
            try {
                storage.changePassword(userField.getText(), mobileField.getText(), newPassField.getText());
                new Alert(Alert.AlertType.INFORMATION, "Password changed.").showAndWait();
                stage.setScene(loginScene());
            } catch (BankException ex) {
                status.setText(ex.getMessage());
                status.setStyle("-fx-text-fill: red;");
            }
        });
        back.setOnAction(e -> stage.setScene(loginScene()));

        VBox form = new VBox(10, title("Change Password"),
                new Label("Username:"), userField,
                new Label("Mobile:"), mobileField,
                new Label("New password:"), newPassField,
                submit, status, back);
        form.setPadding(new Insets(30));
        return new Scene(form, 340, 400);
    }

    // ----------------------------------------------------------- DASHBOARD

    private Label balanceLabel;
    private Label loanLabel;

    private Scene dashboardScene() {
        balanceLabel = new Label();
        loanLabel = new Label();
        refreshDashboardLabels();

        Button depositBtn = new Button("Deposit");
        Button withdrawBtn = new Button("Withdraw");
        Button transferBtn = new Button("Transfer");
        Button loanBtn = new Button("Take Loan");
        Button repayBtn = new Button("Repay Loan");
        Button historyBtn = new Button("Transaction History");
        Button logoutBtn = new Button("Log out");

        depositBtn.setOnAction(e -> amountDialog("Deposit", amount -> {
            bank.deposit(currentUser, amount);
            refreshDashboardLabels();
        }));

        withdrawBtn.setOnAction(e -> amountDialog("Withdraw", amount -> {
            bank.withdraw(currentUser, amount);
            refreshDashboardLabels();
        }));

        transferBtn.setOnAction(e -> transferDialog());

        loanBtn.setOnAction(e -> loanDialog());

        repayBtn.setOnAction(e -> repayDialog());

        historyBtn.setOnAction(e -> stage.setScene(historyScene()));

        logoutBtn.setOnAction(e -> {
            currentUser = null;
            stage.setScene(loginScene());
        });

        GridPane actions = new GridPane();
        actions.setHgap(10);
        actions.setVgap(10);
        actions.addRow(0, depositBtn, withdrawBtn, transferBtn);
        actions.addRow(1, loanBtn, repayBtn, historyBtn);

        VBox root = new VBox(15,
                title("Welcome, " + currentUser),
                new Label("Account type: " + currentAccountType),
                balanceLabel, loanLabel,
                actions, logoutBtn);
        root.setPadding(new Insets(30));
        return new Scene(root, 480, 380);
    }

    private void refreshDashboardLabels() {
        balanceLabel.setText(String.format("Balance: $%.2f", storage.balance(currentUser)));
        loanLabel.setText(String.format("Loan owed: $%.2f", storage.loan(currentUser)));
    }

    // ---- reusable "enter an amount, run action, show error on exception" dialog ----
    private interface AmountAction { void run(double amount); }

    private void amountDialog(String label, AmountAction action) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setHeaderText(label);
        dialog.setContentText("Amount:");
        dialog.showAndWait().ifPresent(text -> {
            try {
                double amount = Double.parseDouble(text);
                action.run(amount);
                refreshDashboardLabels();
            } catch (NumberFormatException ex) {
                showError("Numbers only.");
            } catch (BankException ex) {
                showError(ex.getMessage());
            }
        });
    }

    private void transferDialog() {
        TextInputDialog recipientDialog = new TextInputDialog();
        recipientDialog.setHeaderText("Transfer");
        recipientDialog.setContentText("Recipient username:");
        recipientDialog.showAndWait().ifPresent(recipient ->
                amountDialog("Transfer to " + recipient, amount -> bank.transfer(currentUser, recipient, amount)));
    }

    private void loanDialog() {
        TextInputDialog amountDialog = new TextInputDialog();
        amountDialog.setHeaderText("Take a loan");
        amountDialog.setContentText("Amount:");
        amountDialog.showAndWait().ifPresent(amtText -> {
            TextInputDialog monthsDialog = new TextInputDialog();
            monthsDialog.setHeaderText("Duration");
            monthsDialog.setContentText("Months (3, 6, 12, 24):");
            monthsDialog.showAndWait().ifPresent(monthsText -> {
                try {
                    double amount = Double.parseDouble(amtText);
                    int months = Integer.parseInt(monthsText);
                    loanLogic.takingLoan(currentUser, currentAccountType, amount, months);
                    refreshDashboardLabels();
                    new Alert(Alert.AlertType.INFORMATION, "Loan approved.").showAndWait();
                } catch (NumberFormatException ex) {
                    showError("Numbers only.");
                } catch (BankException ex) {
                    showError(ex.getMessage());
                }
            });
        });
    }

    private void repayDialog() {
        ChoiceDialog<String> method = new ChoiceDialog<>("From balance", "From balance", "Cash");
        method.setHeaderText("Repay loan");
        method.setContentText("Payment method:");
        method.showAndWait().ifPresent(choice -> {
            boolean fromBalance = choice.equals("From balance");
            amountDialog("Repay loan", amount -> loanLogic.repayingLoan(currentUser, amount, fromBalance));
        });
    }

    private void showError(String msg) {
        new Alert(Alert.AlertType.ERROR, msg).showAndWait();
    }

    // ------------------------------------------------------------- HISTORY

    private ObservableList<Transaction> historyRows;

    private Scene historyScene() {
        List<Transaction> raw = storage.getUser(currentUser).history;
        historyRows = FXCollections.observableArrayList(raw);

        TableView<Transaction> table = new TableView<>(historyRows);
        TableColumn<Transaction, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().type));
        TableColumn<Transaction, String> amountCol = new TableColumn<>("Amount");
        amountCol.setCellValueFactory(data -> new SimpleStringProperty(String.format("%.2f", data.getValue().amount)));
        TableColumn<Transaction, String> timeCol = new TableColumn<>("Time");
        timeCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().time.toString()));
        table.getColumns().add(typeCol);
        table.getColumns().add(amountCol);
        table.getColumns().add(timeCol);
        table.setPrefHeight(280);

        Button sortByAmount = new Button("Sort by amount");
        Button sortByDate = new Button("Sort by date");
        TextField searchAmount = new TextField();
        searchAmount.setPromptText("Exact amount");
        Button searchAmountBtn = new Button("Search amount (binary)");
        TextField searchType = new TextField();
        searchType.setPromptText("Type e.g. DEPOSIT");
        Button searchTypeBtn = new Button("Search type (linear)");
        Button resetBtn = new Button("Reset");
        Button backBtn = new Button("Back");

        sortByAmount.setOnAction(e -> historyRows.setAll(TransactionAlgorithms.mergeSortByAmount(raw)));
        sortByDate.setOnAction(e -> historyRows.setAll(TransactionAlgorithms.mergeSortByDate(raw)));
        searchAmountBtn.setOnAction(e -> {
            try {
                double amt = Double.parseDouble(searchAmount.getText());
                List<Transaction> sorted = TransactionAlgorithms.mergeSortByAmount(raw);
                historyRows.setAll(TransactionAlgorithms.binarySearchByAmount(sorted, amt));
            } catch (NumberFormatException ex) {
                showError("Enter a valid number.");
            }
        });
        searchTypeBtn.setOnAction(e ->
                historyRows.setAll(TransactionAlgorithms.linearSearchByType(raw, searchType.getText())));
        resetBtn.setOnAction(e -> historyRows.setAll(raw));
        backBtn.setOnAction(e -> stage.setScene(dashboardScene()));

        HBox controls1 = new HBox(10, sortByAmount, sortByDate, resetBtn);
        HBox controls2 = new HBox(10, searchAmount, searchAmountBtn);
        HBox controls3 = new HBox(10, searchType, searchTypeBtn);

        VBox root = new VBox(10, title("Transaction History"), table, controls1, controls2, controls3, backBtn);
        root.setPadding(new Insets(20));
        return new Scene(root, 560, 500);
    }

    private Label title(String text) {
        Label l = new Label(text);
        l.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        return l;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
