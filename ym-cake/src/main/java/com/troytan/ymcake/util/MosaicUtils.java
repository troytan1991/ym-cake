package com.troytan.ymcake.util;

/**
 * 敏感信息模糊工具类
 * 
 * @author troytan
 * @date 2018年6月21日
 */
public class MosaicUtils {

    /**
     * 手机号脱敏
     *
     * @author troytan
     * @date 2018年6月21日
     * @param phone
     * @return
     */
    public static String phoneMosaic(String phone) {
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 昵称脱敏
     *
     * @author troytan
     * @date 2018年6月21日
     * @param name
     * @return
     */
    public static String nameMosaic(String name) {
        return name.replaceAll("(^.).*(.$)", "$1***$2");
    }
}
