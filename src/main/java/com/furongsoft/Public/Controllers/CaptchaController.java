package com.furongsoft.Public.Controllers;

import com.furongsoft.XspWeb.Common.BaseController;
import com.furongsoft.XspWeb.Common.Constants;
import com.furongsoft.XspWeb.Common.Tracker;
import com.furongsoft.XspWeb.Security.CaptchaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/Captcha")
public class CaptchaController extends BaseController
{
    @Autowired
    public CaptchaBuilder mCaptchaBuilder;

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public void image(HttpServletRequest request, HttpServletResponse response)
    {
        // 设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        // 不缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);

        try {
            HttpSession session = request.getSession();

            StringBuffer code = new StringBuffer();
            BufferedImage image = mCaptchaBuilder.makeRandomCodeImage(code);
            session.removeAttribute((String) Constants
                .get("SESSION_KEY_CAPTCHA"));
            session.setAttribute(
                (String) Constants.get("SESSION_KEY_CAPTCHA"), code.toString());

            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());
            response.flushBuffer();
        }
        catch (Exception e) {
            Tracker.e(e);
        }
    }
}