package com.cloud.controller;

import com.cloud.entity.VolunteerList;
import com.cloud.entity.comm.PageResult;
import com.cloud.service.VolunteerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class VolunteerController {

    @Resource
    private VolunteerService volunteerService;

    @GetMapping("/volunteerListPage")
    public ResponseEntity<PageResult<VolunteerList>> volunteerListPage(@RequestParam String userId,
                                                                       @RequestParam int pageSize,
                                                                       @RequestParam int pageNum) {
        return ResponseEntity.ok(volunteerService.volunteerPage(userId, pageSize, pageNum));
    }
}
