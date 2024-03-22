/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phoenix.util;

import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Kanishka
 */
public class FrameSetUp {
    public static void setup(JFrame jFrame){
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.addMouseMotionListener(new Mouse(jFrame));
        jFrame.addKeyListener(new Mouse(jFrame));
    } 
    public static void setupDialog(JDialog jDialog){
        jDialog.setLocationRelativeTo(null);
        jDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jDialog.addMouseMotionListener(new Mouse(jDialog));
    }
}
