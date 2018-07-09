package com.troytan.ymcake.repository;

import com.troytan.ymcake.domain.Designer;
import com.troytan.ymcake.dto.DesignerDto;
import com.troytan.ymcake.vo.OrderVo;

import java.util.List;

public interface DesignerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_designer
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer designerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_designer
     *
     * @mbg.generated
     */
    int insert(Designer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_designer
     *
     * @mbg.generated
     */
    Designer selectByPrimaryKey(Integer designerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_designer
     *
     * @mbg.generated
     */
    List<Designer> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_designer
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Designer record);
    
    List<DesignerDto> listByWork();
    
}