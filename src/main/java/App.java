import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.GradeModel;
import view.GradePresenter;
import view.GradeView;

public class App extends Application {
    @Override
    public void start( Stage primaryStage ) throws Exception {

        var model = new GradeModel();

        var view = new GradeView();

        Scene scene = new Scene( view );

        var presenter = new GradePresenter( view, model );

        primaryStage.setScene( scene );
        primaryStage.show();

    }

    public static void main( String[] args ) {
        App.launch( args );
    }
}
