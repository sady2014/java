package com.war.qq;

import javax.swing.*;
        import java.awt.*;

//设置主页背景图片的JPnel类
public class BackgroundPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = -6352788025440244338L;

    private Image image = null;

    public BackgroundPanel(Image image) {
        this.image = image;
    }

    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}