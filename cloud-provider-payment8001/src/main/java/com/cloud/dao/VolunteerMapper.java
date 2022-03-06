package com.cloud.dao;

import com.cloud.entity.VolunteerList;
import com.cloud.entity.comm.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VolunteerMapper {

    List<VolunteerList> getVolunteerList(@Param("userId") String userId);
}
