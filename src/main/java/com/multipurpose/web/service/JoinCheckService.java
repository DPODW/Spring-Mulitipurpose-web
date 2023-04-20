package com.multipurpose.web.service;

import com.multipurpose.web.vo.JoinMember;

import java.util.List;

public interface JoinCheckService {

    boolean duplicateIdCheck(String duplicateId);

    boolean comparePwdCheck(String userPwd , String samePwd);

    boolean duplicateCallCheck(String duplicatedCall);

}
