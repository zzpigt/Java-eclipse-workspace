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
    //�޸Ĵ����ͼ��Ϊ
    public static void setFrameImage(JFrame jf){
        //��ȡ���������
      //  public static Toolkit getDefaultkit();��ȡĬ�Ϲ��߰�
        //ctrl+shift+i����
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        //����·����ȡͼƬ
        Image i = tk.getImage("src\\com\\bwf\\resource\\cp.jpg");
        
        //����������ͼƬ
        jf.setIconImage(i);
    }
    
    // 
    public static void setFrameCenter(JFrame jf){
    /*
        ˼·��
        A:��ȡ��Ļ�Ŀ�͸�
        B:��ȡ����Ŀ�͸�
        C:������Ļ�Ŀ�-����Ŀ�/2��(����Ļ�ĸ�-����ĸ�)/2��Ϊ�����������
        */
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        //��ȡ��Ļ���
        Dimension d = tk.getScreenSize();
        double screenWidth = d.getWidth();
        double screenHeight = d.getHeight();
        
        //��ȡ������
        int frameWidth = jf.getWidth();
        int frameHeight = jf.getHeight();
        
        //��ȡ�µĿ��
        int width = (int)(screenWidth - frameWidth)/2;
        int height = (int)(screenHeight - frameHeight)/2;
                
        //���ô�������
        jf.setLocation(width, height);
    }
}
