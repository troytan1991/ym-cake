package com.troytan.ymcake.repository;

import com.github.pagehelper.Page;
import com.troytan.ymcake.domain.News;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NewsMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_news
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String mediaId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_news
     *
     * @mbg.generated
     */
    int insert(News record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_news
     *
     * @mbg.generated
     */
    News selectByPrimaryKey(String mediaId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_news
     *
     * @mbg.generated
     */
    List<News> selectAll();

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_news
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(News record);

    List<News> listByTitle(@Param("searchStr") String searchStr, Page<?> page);
}
