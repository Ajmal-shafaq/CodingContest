module contestexample.codingcontest {
    requires javafx.controls;
    requires javafx.fxml;


    opens contestexample.codingcontest to javafx.fxml;
    exports contestexample.codingcontest;
}