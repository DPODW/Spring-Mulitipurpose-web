package com.multipurpose.web.service.memberservice;

import com.multipurpose.web.vo.membervo.LoginMember;

import java.util.List;

public interface LoginService {

    List<LoginMember> loginCheck(LoginMember loginMember);
}
