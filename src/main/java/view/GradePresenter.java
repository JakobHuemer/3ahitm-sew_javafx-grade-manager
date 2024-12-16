package view;

import javafx.beans.binding.Bindings;
import javafx.event.EventType;
import model.GradeModel;


public class GradePresenter {

    private final GradeView view;
    private final GradeModel model;

    public GradePresenter( GradeView view, GradeModel model ) {
        this.view = view;
        this.model = model;
        attachEvents();
        bindViewToModel();
    }

    private void attachEvents() {
        view.getFeelingComboBox().setOnAction( e -> {
            System.out.println( view.getFeelingComboBox().valueProperty() );
            System.out.println( model.feelingProperty() );
            System.out.println("-------------------------");
        } );
    }

    private void bindViewToModel() {
        view.getIdLabel().textProperty().bind( model.idProperty().asString() );
        view.getSubjectField().textProperty().bindBidirectional( model.subjectProperty() );
        view.getTitleField().textProperty().bindBidirectional( model.titleProperty() );
        view.getPointsReachedField().textProperty().bind( model.pointsReachedProperty().asString() );
        view.getPointsMaxField().textProperty().bind( model.pointsMaxProperty().asString() );
        view.getDateOfTestPicker().valueProperty().bindBidirectional( model.dateOfTestProperty() );
        view.getFeelingComboBox().valueProperty().bindBidirectional( model.feelingProperty() );

    }
}
