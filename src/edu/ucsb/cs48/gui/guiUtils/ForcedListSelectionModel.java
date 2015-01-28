package edu.ucsb.cs48.gui.guiUtils;

import javax.swing.*;


/**
 * This is a gui util for JTable which disallows multi row selection
 */
public class ForcedListSelectionModel extends DefaultListSelectionModel{
    public ForcedListSelectionModel(){
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    @Override
    public void clearSelection(){
    }
    @Override
    public void removeSelectionInterval(int index0, int index1){

    }
}
