package com.multipurpose.web.service.memberservice;

public interface JoinCheckService {

    boolean duplicateIdCheck(String duplicateId);

    boolean comparePwdCheck(String userPwd , String samePwd);

    boolean duplicateCallCheck(String duplicatedCall);

    boolean existingCallPermitCheck(String existingCall,String updateCall);

}
