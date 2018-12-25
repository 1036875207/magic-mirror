package com.magi.demo.Mapper;

import com.magi.demo.Model.Data;

public interface DataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Data record);

    int insertSelective(Data record);

    Data selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKeyWithBLOBs(Data record);

    int updateByPrimaryKey(Data record);
}