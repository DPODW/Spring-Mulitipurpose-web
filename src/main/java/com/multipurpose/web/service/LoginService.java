package com.multipurpose.web.service;

import com.multipurpose.web.repository.MemberRepository;
import com.multipurpose.web.repository.SessionConst;
import com.multipurpose.web.vo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

        public List<LoginMember> loginCheck(LoginMember loginMember){
            return memberRepository.logins(loginMember);
    }

}
