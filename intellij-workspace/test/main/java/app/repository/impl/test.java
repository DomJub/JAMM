package main.java.app.repository.impl;

import app.model.Oeuvre;
import app.repository.AbstractConnect;
import app.repository.impl.OeuvreRepositoyImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class test {

    @Test
    public void TestGetAll() {
        ObservableList<Oeuvre> items = FXCollections.observableArrayList();
        OeuvreRepositoyImpl repository = null;
        try {
            repository = new OeuvreRepositoyImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        items = repository.getAll();
        Assert.assertEquals(items.get(0).getOrigine(), "achat");
        Assert.assertEquals(items.get(0).getNote(), 5);
        Assert.assertEquals(items.get(0).getTitre(), "le meilleur des modes");

    }
}