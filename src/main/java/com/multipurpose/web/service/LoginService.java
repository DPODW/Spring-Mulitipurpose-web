package com.multipurpose.web.service;

import com.multipurpose.web.vo.JoinMember;
import com.multipurpose.web.vo.LoginMember;

import java.util.List;

public interface LoginService {

    List<LoginMember> loginCheck(LoginMember loginMember);
}
