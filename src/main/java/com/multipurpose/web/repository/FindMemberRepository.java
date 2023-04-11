package com.multipurpose.web.repository;

import com.multipurpose.web.vo.JoinMember;
import com.multipurpose.web.vo.LoginMember;

import java.util.List;

public interface FindMemberRepository {
    List<JoinMember> findById(String id);

    List<JoinMember> findMemberUseLoginInfo(LoginMember loginMember);

    List<JoinMember> findDuplicateId(String id);


}
