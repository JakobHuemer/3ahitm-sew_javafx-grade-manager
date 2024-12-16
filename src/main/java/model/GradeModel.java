package model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class GradeModel {

    private static int idSequence = 0;

    private final ReadOnlyIntegerWrapper id = new ReadOnlyIntegerWrapper();
    private final StringProperty subject = new SimpleStringProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final IntegerProperty pointsReached = new SimpleIntegerProperty();
    private final IntegerProperty pointsMax = new SimpleIntegerProperty();
    private final ObjectProperty<LocalDate> dateOfTest = new SimpleObjectProperty<>();
    private final ObjectProperty<Feeling> feeling = new SimpleObjectProperty<>();


    public GradeModel() {
        this.id.set( nextId() );
    }


    // copy constructor
    public GradeModel( GradeModel otherModel ) {
        this();
        id.set( otherModel.getId() );
        subject.set( otherModel.getSubject() );
        title.set( otherModel.getTitle() );
        pointsReached.set( otherModel.getPointsReached() );
        pointsMax.set( otherModel.getPointsMax() );
        dateOfTest.set( otherModel.getDateOfTest() );
        feeling.set( otherModel.getFeeling() );
    }

    private static int nextId() {
        return ++idSequence;
    }

    // region getter and properties

    public int getId() {
        return id.get();
    }

    public ReadOnlyIntegerProperty idProperty() {
        return id.getReadOnlyProperty();
    }

    public String getSubject() {
        return subject.get();
    }

    public StringProperty subjectProperty() {
        return subject;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public int getPointsReached() {
        return pointsReached.get();
    }

    public IntegerProperty pointsReachedProperty() {
        return pointsReached;
    }

    public int getPointsMax() {
        return pointsMax.get();
    }

    public IntegerProperty pointsMaxProperty() {
        return pointsMax;
    }

    public LocalDate getDateOfTest() {
        return dateOfTest.get();
    }

    public ObjectProperty<LocalDate> dateOfTestProperty() {
        return dateOfTest;
    }

    public Feeling getFeeling() {
        return feeling.get();
    }

    public ObjectProperty<Feeling> feelingProperty() {
        return feeling;
    }

    // endregion

    // region custom getters

    public String getPointsString() {
        return String.format( "%d / %d", getPointsReached(), getPointsMax() );
    }

    public String getPercentage() {
        return String.format( "%3.0f%%", (double) getPointsReached() / (double) getPointsMax() * 100 );
    }

    // endregion

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", subject=" + subject +
                ", title=" + title +
                ", pointsReached=" + pointsReached +
                ", pointsMax=" + pointsMax +
                ", dateOfTest=" + dateOfTest +
                ", feeling=" + feeling +
                '}';
    }
}
