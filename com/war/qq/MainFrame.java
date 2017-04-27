package com.war.qq;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * wanglu2325@qq.com
 * Created by 89114282 on 2017-4-14 9:45
 */
public class MainFrame extends Frame {
    public static void main(String[] args) throws IOException, URISyntaxException {
        JFrame jf = new JFrame("测试");
        final JButton jb1 = new JButton(new ImageIcon("src/imgs/x.png"));
        jb1.setBorder(null);//设置无边框
        JPanel jp = new BackgroundPanel(new ImageIcon("src/imgs/bf.png").getImage());
        jp.setBounds(0, 0, 430, 180);
        jf.setBounds(350, 350, 430, 330);//设置窗口位置。
        Container c = jf.getContentPane();

        jf.setUndecorated(true);
//        右上角按钮
        jb1.setBackground(new Color(0,203,245));
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                jb1.setBorder(null);//设置无边框
                jb1.setBackground(new Color(212,64,39));
            }
            @Override
            public void mouseExited(MouseEvent e) {

                jb1.setBackground(new Color(0,203,245));
            }
            @Override
            public void mouseClicked(MouseEvent e){
                jb1.setBackground(new Color(212,64,39));
            }
        });

        jb1.setBounds(400, 0, 30, 30);
//        jb1.setContentAreaFilled(false); //设置按钮透明
        jb1.setFocusPainted(false);
        jf.setLayout(null);

        jf.setIconImage(ImageIO.read(new File("src/imgs/eyes-1059234.jpg")));
        jf.add(jb1);
        jf.add(jp);
        //按钮点击事件。
        jb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        /**
         * 这里是下方文本区域。
         */
        //设置 Jpanel
        JPanel jp1 = new JPanel();
        JLabel jl = new JLabel(new ImageIcon("src/imgs/head.png"));      // 将图片放在Jlable上

        //自定义布局
        jp1.setLayout(null);//设置Jpanel为自动布局。
        jp1.setBackground(new Color(235,242,249));
        jp1.setBounds(0,180,430,150);//Jpanel画布大小以及位置
        jl.setBounds(40,15,80,80);//设置头像位置
        jp1.add(jl);
        jf.add(jp1);
        //设置文本框
        LoginButton ss = new LoginButton();
        ss.Input(jp1);
        // 注册链接
        ss.link(jp1);
        //登录。。。
        ss.ButtonLogin(jp1,jf);
        jf.setVisible(true);
    }
}
