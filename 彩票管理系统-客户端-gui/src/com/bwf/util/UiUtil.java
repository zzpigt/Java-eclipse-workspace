/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bwf.util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Administrator
 */
public class UiUtil {
    private UiUtil(){}
    //修改窗体的图标为
    public static void setFrameImage(JFrame jf){
        //获取工具类对象
      //  public static Toolkit getDefaultkit();获取默认工具包
        //ctrl+shift+i导包
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        //根据路径获取图片
        Image i = tk.getImage("src\\com\\bwf\\resource\\cp.jpg");
        
        //给窗体设置图片
        jf.setIconImage(i);
    }
    
    // 
    public static void setFrameCenter(JFrame jf){
    /*
        思路：
        A:获取屏幕的宽和高
        B:获取窗体的宽和高
        C:（用屏幕的宽-窗体的宽）/2，(用屏幕的高-窗体的高)/2作为窗体的新坐标
        */
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        //获取屏幕宽高
        Dimension d = tk.getScreenSize();
        double screenWidth = d.getWidth();
        double screenHeight = d.getHeight();
        
        //获取窗体宽高
        int frameWidth = jf.getWidth();
        int frameHeight = jf.getHeight();
        
        //获取新的宽高
        int width = (int)(screenWidth - frameWidth)/2;
        int height = (int)(screenHeight - frameHeight)/2;
                
        //设置窗体坐标
        jf.setLocation(width, height);
    }
}
