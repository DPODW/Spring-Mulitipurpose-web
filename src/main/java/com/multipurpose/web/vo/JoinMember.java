package com.multipurpose.web.vo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Component
@Data
public class JoinMember {
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9\uAC00-\uD7AF]*")//한글  영어 숫자 허용
    @Size(min=2, max= 20)
    private String joinName;
    @NotBlank
    @Size(min=2, max= 20)
    private String joinId;
    @NotBlank
    @Size(min=10, max= 20)
    private String joinPwd;

    @NotBlank
    @Size(min=11, max= 11)
    private String joinCall;
    /**
     * int 형으로 선언하게 되면, 회원가입 화면에 초기값 0이 출력되는 오류가 있음. (공백이 출력되어야 함)
     * th:value 로 검증 실패 값을 저장할때, 화면 최초 접근에는 th:value 에 아무런 값이 없음. 그래서 string 은 공백을, int 는 0을 출력함
     * Integer 로 선언하면 null 을 허용하기 때문에 보기싫은 초기값 0 을 출력하지 않고 공백으로 만들수 있음
     * */



    public JoinMember(String joinName, String joinId, String joinPwd, String joinCall) {
        this.joinName = joinName;
        this.joinId = joinId;
        this.joinPwd = joinPwd;
        this.joinCall = joinCall;
    }

    public JoinMember() {

    }
}
