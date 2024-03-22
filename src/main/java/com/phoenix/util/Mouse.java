/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phoenix.util;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Kanishka
 */
public class Mouse extends MouseAdapter implements MouseMotionListener, KeyListener {

    private int mouseX;
    private int mouseY;
    private JFrame jFrame;
    private JDialog jDialog;

    public Mouse(JFrame jFrame) {
        this.jFrame = jFrame;
        this.jFrame.addMouseListener(this);
    }

    public Mouse(JDialog jDialog) {
        this.jDialog = jDialog;
        this.jDialog.addMouseListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int realPosX = e.getXOnScreen() - mouseX;
        int realPosY = e.getYOnScreen() - mouseY;
        if (jDialog != null) {
            jDialog.setLocation(realPosX, realPosY);
        }
        if (jFrame != null) {
            jFrame.setLocation(realPosX, realPosY);
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed. See the class description for
     * {@link KeyEvent} for a definition of a key pressed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
       
    }

    /**
     * Invoked when a key has been released. See the class description for
     * {@link KeyEvent} for a definition of a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

}
