package com.qy.controller;

import com.qy.model.Link;
import com.qy.service.impl.LinkServiceImpl;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author qiuyang
 * @date 2020/8/18
 */
@Controller
@RequestMapping
public class LinkController {

    @Autowired
    private LinkServiceImpl linkService;

    /**
     * 获取链接列表
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Object list(){
        List<Link> list = linkService.list();
        return list;
    }

    @RequestMapping("delete")
    public Object delete(Integer id){
        linkService.removeById(id);
        return "link.html";
    }

    /**
     * 转换短链接
     * @param longUrl
     * @return
     */
    @RequestMapping("getShortUrl")
    @ResponseBody
    public String longUrlToShortUrl(String longUrl){
        if (longUrl == null || "".equals(longUrl)){
            return "请输入正确的地址";
        }
        if (!longUrl.contains("http") || !longUrl.contains("https")){
            return "请输入正确的网址";
        }
        // 把长链接转换成短链接
        String shortUrl = getShortUrl(longUrl);
        // 保存
        Link link = new Link();
        link.setLongUrl(longUrl);
        link.setShortUrl(shortUrl);
        link.setCreateTime(new Date());
        linkService.save(link);
        // 保存数据
        return shortUrl;
    }


    // 生成短链接
    private String getShortUrl(String longUrl){
        // 要使用生成 URL 的字符
        String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
                "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z" };
        // 随机取5个字符
        String shortUrl = "";
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0 ;i < 5;i++){
            sb.append(chars[random.nextInt(chars.length)]);
        }
        shortUrl = "http://127.0.0.1//" + sb.toString();
        return shortUrl;
    }




}
