import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start( Stage primaryStage ) throws Exception {

        Scene scene = new Scene( new StackPane( new Text( "hello world" ) ), 400, 400 );

        primaryStage.setScene( scene );
        primaryStage.show();

    }

    public static void main( String[] args ) {
        App.launch( args );
    }
}
