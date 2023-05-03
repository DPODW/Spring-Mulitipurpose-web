package com.multipurpose.web.repository.memberrepository;

import com.multipurpose.web.vo.membervo.JoinMember;
import com.multipurpose.web.vo.membervo.LoginMember;

import java.util.List;

public interface FindMemberRepository {
    List<JoinMember> findById(String id);

    List<JoinMember> findMemberUseLoginInfo(LoginMember loginMember);

    List<JoinMember> findDuplicateId(String duplicateId);

    List<JoinMember> findDuplicateCall(String duplicateCall);

    List<JoinMember> findCallById(String existingCallId);


}
