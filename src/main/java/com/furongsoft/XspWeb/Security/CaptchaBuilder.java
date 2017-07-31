package com.furongsoft.XspWeb.Security;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.furongsoft.XspWeb.Common.BaseBean;

@Component
public class CaptchaBuilder extends BaseBean
{
    // 随机产生的字符串
    private static final String RANDOM_STRS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String FONT_NAME = "Fixedsys";
    private static final int FONT_SIZE = 18;
    private static final int sWidth = 80; // 图片宽
    private static final int sHeight = 25; // 图片高
    private static final int sLineNum = 50; // 干扰线数量
    private static final int sStrNum = 4; // 随机产生字符数量

    private Random mRandom = new Random();

    /**
     * 生成随机图片
     */
    public BufferedImage makeRandomCodeImage(StringBuffer randomCode)
    {
        // BufferedImage类是具有缓冲区的Image类
        BufferedImage image = new BufferedImage(
            sWidth, sHeight, BufferedImage.TYPE_INT_BGR);

        // 获取Graphics对象,便于对图像进行各种绘制操作
        Graphics g = image.getGraphics();
        // 设置背景色
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, sWidth, sHeight);

        // 设置干扰线的颜色
        g.setColor(getRandColor(110, 120));

        // 绘制干扰线
        for (int i = 0; i <= sLineNum; i++) {
            drawLine(g);
        }

        // 绘制随机字符
        g.setFont(new Font(FONT_NAME, Font.ROMAN_BASELINE, FONT_SIZE));
        for (int i = 1; i <= sStrNum; i++) {
            randomCode.append(drawString(g, i));
        }

        g.dispose();

        return image;
    }

    /**
     * 给定范围获得随机颜色
     */
    private Color getRandColor(int fc, int bc)
    {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;

        int r = fc + mRandom.nextInt(bc - fc);
        int g = fc + mRandom.nextInt(bc - fc);
        int b = fc + mRandom.nextInt(bc - fc);

        return new Color(r, g, b);
    }

    /**
     * 绘制字符串
     */
    private String drawString(Graphics g, int i)
    {
        String rand = String.valueOf(getRandomString(mRandom
            .nextInt(RANDOM_STRS.length())));
        g.setColor(new Color(
            mRandom.nextInt(101), mRandom.nextInt(111), mRandom.nextInt(121)));
        g.translate(mRandom.nextInt(3), mRandom.nextInt(3));
        g.drawString(rand, 13 * i, 16);

        return rand;
    }

    /**
     * 绘制干扰线
     */
    private void drawLine(Graphics g)
    {
        int x = mRandom.nextInt(sWidth);
        int y = mRandom.nextInt(sHeight);
        int x0 = mRandom.nextInt(16);
        int y0 = mRandom.nextInt(16);

        g.drawLine(x, y, x + x0, y + y0);
    }

    /**
     * 获取随机的字符
     */
    private String getRandomString(int num)
    {
        return String.valueOf(RANDOM_STRS.charAt(num));
    }
}