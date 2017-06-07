package app.model;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.function.Supplier;

/**
 * Created by Philippe on 07/06/2017.
 */
public class SimpleStringProperty implements ObservableValue<String> {


    private final Supplier<String> supplier;

    public SimpleStringProperty(Supplier<String> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void addListener(ChangeListener<? super String> listener) {

    }

    @Override
    public void removeListener(ChangeListener<? super String> listener) {

    }

    @Override
    public String getValue() {
        return supplier.get();
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}
