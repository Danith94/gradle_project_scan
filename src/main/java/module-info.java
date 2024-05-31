module com.example.sample_gradle_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sample_gradle_project to javafx.fxml;
    exports com.example.sample_gradle_project;
}