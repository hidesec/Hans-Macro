package com.hidesec;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

class HansMacro extends JFrame implements ActionListener
{
    private JLabel label;
    private Looper looper;

    public HansMacro() throws AWTException {
        super("HansMacro by Raihan H. Q. (@hidesec)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 90));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13) );
        setLayout(new FlowLayout());
        JButton btn = new JButton("START");
        btn.setActionCommand("startButton");
        btn.addActionListener(this);
        JButton btn2 = new JButton("STOP");
        btn2.setActionCommand("stopButton");
        btn2.addActionListener(this);
        label = new JLabel("Not Running!!");
        add(label);
        add(btn);
        add(btn2);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("startButton"))
        {
            label.setText("Running!!");
            if (looper == null) {
                try {
                    looper = new Looper();
                } catch (AWTException awtException) {
                    awtException.printStackTrace();
                }
                Thread t = new Thread(looper);
                t.start();
            }
        }else if(e.getActionCommand().equals("stopButton")){
            looper.stop();
            looper = null;
            label.setText("Not Running!!");
        }
    }
    public static void main(String[] args) throws AWTException {
        final HansMacro hansMacro = new HansMacro();
    }
}