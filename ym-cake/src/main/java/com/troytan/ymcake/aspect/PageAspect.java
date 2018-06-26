/*
* Copyright 2017 SAIC General Motors Corporation Ltd. All Rights Reserved.
*
* This software is published under the terms of the SGM Software
* License version 1.0, a copy of which has been included with this
* distribution in the LICENSE.txt file.
*
* @Project Name : sfol-backend-common
*
* @File name : PageAspect.java
*
* @Author : s8xriw
*
* @Date : 2017年9月8日
*
----------------------------------------------------------------------------------
*     Date       Who       Version     Comments
* 1. 2017年9月8日    s8xriw    1.0
*
*
*
*
----------------------------------------------------------------------------------
*/

package com.troytan.ymcake.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 后台分页切面
 * 
 * @author s8xriw
 * @date 2017年9月8日
 */
@Component
@Aspect
public class PageAspect {

    /**
     * 拦截repository的mapper类，以及方法参数以Page结尾
     * 
     * @author s8xriw
     * @date 2017年9月8日
     * @param jp
     * @param inputPage
     * @return
     * @throws Throwable
     */
    @Before("execution(* com.troytan.ymcake.repository.*.*(..)) && args(..,page)")
    public void handlePageHelper(Page<?> page) throws Throwable {
        if (page != null) {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
            if (page.getOrderBy() != null) {
                PageHelper.orderBy(page.getOrderBy());
            }
        }
    }
}
