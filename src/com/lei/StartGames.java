package com.lei;


import javax.swing.*;
import java.awt.*;

public class StartGames {
    public static void main(String[] args) {
        JFrame frame=new JFrame("贪吃蛇小游戏");
        frame.setBounds(10,10,900,720);
        frame.setResizable(false);//窗口大小固定
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口 程序结束

        frame.setVisible(true);//展示

    }
}
