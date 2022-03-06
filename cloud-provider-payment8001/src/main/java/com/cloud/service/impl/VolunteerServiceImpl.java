package com.cloud.service.impl;

import com.cloud.dao.VolunteerMapper;
import com.cloud.entity.VolunteerList;
import com.cloud.entity.comm.PageResult;
import com.cloud.service.VolunteerService;
import com.cloud.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Resource
    private VolunteerMapper volunteerMapper;

    @Override
    public PageResult<VolunteerList> volunteerPage(String userId, int pageSize, int pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<VolunteerList> volunteerList = volunteerMapper.getVolunteerList(userId);

        return PageUtils.getPageResult(new PageInfo<>(volunteerList));
    }
}
