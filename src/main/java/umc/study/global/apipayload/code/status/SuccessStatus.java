package umc.study.global.apipayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.management.loading.MLetContent;

@Getter
@AllArgsConstructor
public enum SuccessStatus {


    _OK(HttpStatus.OK,"COMMON200","요청 성공입니다.");
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
