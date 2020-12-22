package com;

import com.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

    int lenth;
    int[] snakeX=new int[600];
    int[] snakeY=new int[600];
    String fx;//方向
    boolean isStart=false;
    Timer timer=new Timer(100,this);//监听时间


    public void init(){
        lenth=3;//初始长度
        //初始的三个坐标
        snakeX[0]=100;snakeY[0]=100;
        snakeX[1]=75;snakeY[1]=100;
        snakeX[2]=50;snakeY[2]=100;
        fx="R";
    }

    //构造器
    public GamePanel(){
        init();
        //获取键盘的监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();
    }

    //g是画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.BLACK);

        Data.header.paintIcon(this,g,25,11);

        g.fillRect(25,75,850,600);

        //方向控制
        if(fx.equals("R"))
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        else if(fx.equals("L"))
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        else if(fx.equals("U"))
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        else if(fx.equals("D"))
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);

       for(int i=1;i<lenth;i++)
       {
           Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
       }

       if(isStart==false)
       {
           //画一个文字
           g.setColor(Color.CYAN);
           g.setFont(new Font("微软雅黑",Font.BOLD,40));
           g.drawString("按下空格开始游戏",300,300);

       }

    }
    //接受键盘的输入
    //按下
    @Override
    public void keyTyped(KeyEvent e) {

    }
    //释放
    @Override
    public void keyReleased(KeyEvent e) {
    }
    //按下不释放
    @Override
    public void keyPressed(KeyEvent e) {
        //获取按下的键盘是哪个键
        int keyCode=e.getKeyCode();

        if(keyCode==KeyEvent.VK_SPACE)
        {
            isStart=!isStart;
            repaint();//刷新
        }
        if(keyCode==KeyEvent.VK_RIGHT)
            fx="R";
        else if(keyCode==KeyEvent.VK_LEFT)
            fx="L";
        else if(keyCode==KeyEvent.VK_UP)
            fx="U";
        else if(keyCode==KeyEvent.VK_DOWN)
            fx="D";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏开始状态
        if (isStart){
            for(int i=lenth-1;i>0;i--)
            {
                snakeX[i]=snakeX[i-1];
                snakeY[i]=snakeY[i-1];
            }
            //控制方向让头部移动
            if(fx.equals("R")) {
                snakeX[0] = snakeX[0] + 25;
                //边界判断
                if (snakeX[0] > 850)
                    snakeX[0] = 25;
            }
            else if(fx.equals("L")){
                snakeX[0]=snakeX[0]-25;
                if(snakeX[0]<25)
                    snakeX[0]=850;
            }
            else if(fx.equals("U"))
            {
                snakeY[0]-=25;
                if(snakeY[0]<75) snakeY[0]=650;

            }
            else if(fx.equals("D"))
            {
                snakeY[0]+=25;
                if(snakeY[0]>650)snakeY[0]=75;
            }

            repaint();
    }
        timer.start();
    }
}
