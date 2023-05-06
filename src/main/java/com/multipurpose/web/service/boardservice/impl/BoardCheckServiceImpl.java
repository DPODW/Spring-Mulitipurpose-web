package com.multipurpose.web.service.boardservice.impl;

import com.multipurpose.web.service.boardservice.BoardCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BoardCheckServiceImpl implements BoardCheckService {

    @Override
    public boolean accessCheck(String contentId, String loginId) {
        if(contentId.equals(loginId)){
            return true;
        }else{
            return false;
        }
    }
}
