package com.qy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qy.model.Link;
import com.qy.dao.LinkMapper;
import com.qy.service.ILinkService;
import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiuyang
 * @since 2020-08-18
 */
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements ILinkService {

    @Override
    public Link findByLongUrl(String longUrl) {
        return super.getOne(new QueryWrapper<Link>().eq("long_url",longUrl));
    }

    @Override
    public Link findByShortUrl(String shortUrl) {
        return super.getOne(new QueryWrapper<Link>().eq("short_url",shortUrl));
    }
}
