package umc.study.domain.temp.exception.handler;

import umc.study.global.apipayload.code.BaseErrorCode;
import umc.study.global.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}