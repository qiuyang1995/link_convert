package com.qy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qy.model.Link;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qiuyang
 * @since 2020-08-18
 */
public interface ILinkService extends IService<Link> {
    Link findByLongUrl(String longUrl);
    Link findByShortUrl(String shortUrl);
}
