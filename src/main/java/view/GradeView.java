package view;

import com.sun.javafx.collections.ObservableListWrapper;
import com.sun.javafx.scene.control.IntegerField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;
import model.Feeling;
import model.GradeModel;
import model.Stat;
import org.w3c.dom.Text;

import java.util.Arrays;


public class GradeView extends VBox {

    // form Inputs
    private final TextField idField = new TextField();
    private final TextField subjectField = new TextField();
    private final TextField titleField = new TextField();
    private final TextField pointsReachedField = new TextField();
    private final TextField pointsMaxField = new TextField();
    private final DatePicker dateOfTestPicker = new DatePicker();
    private final ComboBox<Feeling> feelingComboBox = new ComboBox<>();

    // button
    private final Button saveButton = new Button( "Save" );

    // tables
    private final TableView<GradeModel> gradesTableView = new TableView<>();
    private final TableView<Stat> statsTableView = new TableView<>();

    public GradeView() {
        createViewForm();
    }

    private void createViewForm() {

        // setup NumberFields
        pointsReachedField.setTextFormatter( new TextFormatter<>( new NumberStringConverter() ) );
        pointsMaxField.setTextFormatter( new TextFormatter<>( new NumberStringConverter() ) );

        // combo box
        feelingComboBox.setItems(
                new ObservableListWrapper<>(
                        Arrays.stream( Feeling.values() ).toList()
                )
        );

        // setup tests table view
        gradesTableView.setPlaceholder( new Label( "Nothing here" ) );
        statsTableView.setPlaceholder( new Label( "Nothing here" ) );

        TableColumn<GradeModel, Integer> idColumn = new TableColumn<>( "ID" );
        idColumn.setCellValueFactory( new PropertyValueFactory<>( "id" ) );

        TableColumn<GradeModel, String> subjectColumn = new TableColumn<>( "Subject" );
        subjectColumn.setCellValueFactory( new PropertyValueFactory<>( "subject" ) );

        TableColumn<GradeModel, String> titleColumn = new TableColumn<>( "Title" );
        titleColumn.setCellValueFactory( new PropertyValueFactory<>( "title" ) );

        TableColumn<GradeModel, String> pointsColumn = new TableColumn<>( "Points" );
        pointsColumn.setCellValueFactory( new PropertyValueFactory<>( "pointsString" ) );

        TableColumn<GradeModel, String> percentageColumn = new TableColumn<>( "Percentage" );
        percentageColumn.setCellValueFactory( new PropertyValueFactory<>( "percentage" ) );

        TableColumn<GradeModel, String> dateOfTestColumn = new TableColumn<>( "Date" );
        dateOfTestColumn.setCellValueFactory( new PropertyValueFactory<>( "dateOfTest" ) );

        TableColumn<GradeModel, Feeling> feelingColumn = new TableColumn<>( "Feeling" );
        feelingColumn.setCellValueFactory( new PropertyValueFactory<>( "feeling" ) );

        gradesTableView.getColumns().addAll(
                idColumn,
                subjectColumn,
                titleColumn,
                pointsColumn,
                percentageColumn,
                dateOfTestColumn,
                feelingColumn
        );

        // form

        GridPane formGridPane = new GridPane();

        Label idLabelLabel = new Label( "ID:" );
        Label subjectLabel = new Label( "Subject:" );
        Label titleLable = new Label( "Title:" );
        Label pointsReachedLabel = new Label( "Points reached:" );
        Label pointsReachedOfLabel = new Label( " of " );
        Label dateOfTestLabel = new Label( "Date of test" );
        Label feelingLabel = new Label( "Feeling" );

        // points box
        HBox pointsBox = new HBox();
        pointsBox.getChildren().addAll( pointsReachedField, pointsReachedOfLabel, pointsMaxField );

        pointsBox.setPadding( new Insets( 8 ) );
        pointsBox.setAlignment( Pos.CENTER_LEFT );

        // adding items

        formGridPane.add( idLabelLabel, 0, 0 );
        formGridPane.add( idField, 1, 0 );
        formGridPane.add( subjectLabel, 0, 1 );
        formGridPane.add( subjectField, 1, 1 );
        formGridPane.add( titleLable, 0, 2 );
        formGridPane.add( titleField, 1, 2 );
        formGridPane.add( pointsReachedLabel, 0, 3 );
        formGridPane.add( pointsBox, 1, 3 );
        formGridPane.add( dateOfTestLabel, 0, 4 );
        formGridPane.add( dateOfTestPicker, 1, 4 );
        formGridPane.add( feelingLabel, 0, 5 );
        formGridPane.add( feelingComboBox, 1, 5 );


        this.getChildren().addAll( formGridPane, statsTableView, gradesTableView );
    }


    public TextField getIdLabel() {
        return idField;
    }

    public TextField getSubjectField() {
        return subjectField;
    }

    public TextField getTitleField() {
        return titleField;
    }

    public TextField getPointsReachedField() {
        return pointsReachedField;
    }

    public TextField getPointsMaxField() {
        return pointsMaxField;
    }

    public DatePicker getDateOfTestPicker() {
        return dateOfTestPicker;
    }

    public ComboBox<Feeling> getFeelingComboBox() {
        return feelingComboBox;
    }

    public TableView<GradeModel> getGradesTableView() {
        return gradesTableView;
    }

    public TableView<Stat> getStatsTableView() {
        return statsTableView;
    }
}
