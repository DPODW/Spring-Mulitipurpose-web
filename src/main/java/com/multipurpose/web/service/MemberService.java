package com.multipurpose.web.service;

import com.multipurpose.web.vo.JoinMember;
import com.multipurpose.web.vo.LoginMember;

public interface MemberService {

    void joinOk(JoinMember joinMember);

    JoinMember memberUpdate(JoinMember joinMember);

    void memberDelete(JoinMember deleteMember);

    JoinMember memberInfoView(LoginMember loginMember);
}
