package com.multipurpose.web.service.memberservice;

import com.multipurpose.web.vo.membervo.JoinMember;
import com.multipurpose.web.vo.membervo.LoginMember;

public interface MemberService {

    void joinOk(JoinMember joinMember);

    JoinMember memberUpdate(JoinMember joinMember);

    void memberDelete(JoinMember deleteMember);

    JoinMember memberInfoView(LoginMember loginMember);
}
