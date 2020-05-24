/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Honzik note
 */
public class Gui {

   
    public static void main(String[] args) {
        JFrame f = new JFrame("JavaGUI");
        JLabel lab = new JLabel("ucim se swing", JLabel.CENTER);
        
        JButton but1 = new JButton("Button 1");
        
       
        JButton but2 = new JButton("Button 2");
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(640, 480);
        p1.add(but1);
        p1.add(but2);
        p2.add(new JButton("Button 3"));
        f.setLayout(new FlowLayout());
        f.setResizable(false);
        f.setLayout(new BorderLayout());
     
        f.add(lab,BorderLayout.CENTER);        
        f.add(p1,BorderLayout.EAST);
       
        
    }
    
}
