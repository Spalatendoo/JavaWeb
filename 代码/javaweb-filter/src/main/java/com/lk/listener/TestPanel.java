package com.lk.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("中秋快乐"); //新建一个窗体
        Panel panel = new Panel(null); //面板
        frame.setLayout(null);  //设置窗体布局

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(0,0,255)); //设置背景颜色

        panel.setBounds(50,50,300,300);
        panel.setBackground(new Color(0,255,0));  //设置背景颜色

        frame.add(panel);
        frame.setVisible(true);

        //监听事件，监听关闭事件
 /*       frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("打开");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭Ing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("关闭ed");

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("激活");

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("未激活");

            }
        });*/
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

            }
        });



    }
}
