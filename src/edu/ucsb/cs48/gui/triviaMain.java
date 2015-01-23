package edu.ucsb.cs48.gui;

import javax.swing.*;

/**
 * Class the starts it all
 * This class is the one that first intiliazes the JFrame and is updated with a new panel each time
 *
 */
public class triviaMain {

    /**
     * Java GUI components
     */
    JFrame mainFrame;
    triviaLogin loginPopup;

    /**
     * main is used for testing purposes and should not be called in other classes
     * @param args
     */
    public static void main(String[] args) {
	    triviaMain mainWindow = new triviaMain();
        mainWindow.createWindow();
    }

    public void createWindow(){

    }
}
