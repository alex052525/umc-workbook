package umc.study.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.global.apipayload.code.BaseErrorCode;
import umc.study.global.apipayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}