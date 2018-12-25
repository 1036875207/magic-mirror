package com.magi.demo.Mapper;

import com.magi.demo.Model.Register;

import java.util.List;

public interface RegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Register record);

    int insertSelective(Register record);

    Register selectByPrimaryKey(Integer id);

    List<Register> selectByUserId(Integer id);

    List<Register> selectByProductId(Integer id);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}