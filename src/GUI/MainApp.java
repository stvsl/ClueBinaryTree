package GUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("线索二叉树演示");
        //加载fxml
        Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
        Scene scene = new Scene(root);
        //加载样式表
        scene.getStylesheets().add(getClass().getResource("ui.css").toExternalForm());
        primaryStage.setScene(scene);;
        primaryStage.show();
    }
   
    public static void main(String[] args) {
        MainApp.launch(args);
    }
}
