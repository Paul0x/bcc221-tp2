/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcc221.tp2.projetoclinica.ui.utils;

import com.bcc221.tp2.projetoclinica.ui.MainScreen;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author paulo
 */
public class TabChangeListener implements ChangeListener {

    private Integer selectedIndex = 0;
    private MainScreen screen;

    public TabChangeListener(MainScreen screen) {
        this.screen = screen;
    }
    
    @Override
    public void stateChanged(ChangeEvent e) {
        JTabbedPane pane = (JTabbedPane) e.getSource();
        selectedIndex = pane.getSelectedIndex();
        screen.loadMainMenuIndex(selectedIndex);
    }

    public Integer getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(Integer selectedIndex) {
        this.selectedIndex = selectedIndex;
    }
    
    

}
