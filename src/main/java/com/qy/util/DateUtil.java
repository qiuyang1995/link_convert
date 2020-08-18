package com.qy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qiuyang
 * @date 2020/8/18
 */
public class DateUtil {
    // 比较两个时间相差分钟数
    public static long getTimeSub(Date beginDate, Date endDate){
        long beginDateTime = beginDate.getTime();
        long endDateTime = endDate.getTime();
        long time = endDateTime - beginDateTime;
        return time / (1000 * 60);
    }

}
