package com.multipurpose.web.repository.memberrepository;



import com.multipurpose.web.vo.membervo.JoinMember;
import com.multipurpose.web.vo.membervo.LoginMember;

import java.util.List;

public interface MemberRepository {

    JoinMember insert(JoinMember member);

    JoinMember update(JoinMember joinMember);

    List<LoginMember> logins(LoginMember loginMember);

    void delete(JoinMember joinMember);



}
