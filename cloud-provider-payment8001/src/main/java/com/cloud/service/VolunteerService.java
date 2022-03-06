package com.cloud.service;

import com.cloud.entity.VolunteerList;
import com.cloud.entity.comm.PageResult;

public interface VolunteerService {

    PageResult<VolunteerList> volunteerPage(String userId,
                                            int pageSize,
                                            int pageNum);
}
