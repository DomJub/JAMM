package com.cesi.jamm;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Jub on 12/05/2017.
 */
public class MainTest {

    @Test
    public void should_exist_Oeuvre() {
        Livre livreTest = new Livre();
        Assert.assertThat(livreTest.auteur, is(""));
    }

    @Test
    public void should_exist_CRUDOeuvre(){
        Jeu jeuTest = new Jeu();
        jeuTest.seReferencer();
        Assert.assertThat(jeuTest.console, is(""));
    }
}
