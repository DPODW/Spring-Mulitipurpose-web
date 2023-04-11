package com.multipurpose.web.repository;



import com.multipurpose.web.vo.JoinMember;
import com.multipurpose.web.vo.LoginMember;

import java.util.List;

public interface MemberRepository {

    JoinMember insert(JoinMember member);

    JoinMember update(JoinMember joinMember);

    List<LoginMember> logins(LoginMember loginMember);

    void delete(JoinMember joinMember);



}
