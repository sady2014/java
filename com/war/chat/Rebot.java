package com.war.chat;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * wanglu2325@qq.com
 * Created by 89114282 on 2017-4-17 13:14
 */
public class Rebot {
    public static void FFFF() throws IOException {


        Frame f = new Frame("欢迎使用机器人");
        f.setBounds(350, 350, 430, 530);
        f.setBackground(Color.lightGray);
        f.setLayout(null);
        JLabel jl = new JLabel();
        jl.setBackground(Color.red);
        jl.setBounds(300, 300, 200, 50);
        f.add(jl);
        JTextArea ta = new JTextArea();
        ta.setLineWrap(true);
        ta.setEditable(false);
        ta.setBounds(15,35,400,430);
        ta.setBackground(new Color(237,237,237));
        f.add(ta);
        TextField  tf = new TextField();
        tf.setBounds(55,480,300,30);
        Button bt1 = new Button("export");
        bt1.setBounds(10,480,40,30);
        f.add(bt1);
        f.add(tf);
        Button bt = new Button("Sent");
        bt.setBounds(360, 480, 60, 30);
        bt.setBackground(new Color(237, 237, 237));
        f.add(bt);
        Cclick(ta, tf, bt);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
        export(bt1, ta);
    }
    public static void Cclick(final JTextArea ta, final TextField tf, final Button b) throws IOException {
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ccc(ta,tf,b);
            }
        });
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    ccc(ta,tf,b);
                }
            }
        });
    }
    public static void ccc(final JTextArea ta, final TextField tf, Button b){
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        sdf.format(dt);
        String APIKEY = "06b49d6e39bb456193ae905d87562c95";
        String question = tf.getText();
        String INFO = null;
        try {
            INFO = URLEncoder.encode(question, "utf-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY+ "&info=" + INFO;
        URL getUrl = null;
        try {
            getUrl = new URL(getURL);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) getUrl.openConnection();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            connection.connect();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        // 取得输入流，并使用Reader读取
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        // 断开连接
        connection.disconnect();
        String txt = sb.toString();
        String str1[]=txt.split("\":\"|\"}");
        System.out.println(str1[1]);
        System.out.println();
        String str = "";
        ta.setText(tf.getText()+"   "+sdf.format(dt)+System.getProperty("line.separator") + str1[1]+ System.getProperty("line.separator")+ta.getText());
        tf.setText("");
    }
    public static void export(Button bt1, final JTextArea ta) throws IOException {
        bt1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    FileWriter fw = new FileWriter("D:\\chat.txt");
                    fw.write(String.valueOf(ta.getText()));
                    fw.flush();
                    fw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println("导出成功！聊天记录保存在D：/chat.txt中！");

            }
        });
    }
    public static void date(){
    }
}
