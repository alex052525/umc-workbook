package umc.study.domain.mission.exception;

import umc.study.global.apipayload.code.status.ErrorStatus;
import umc.study.global.exception.GeneralException;

public class MissionNotFoundException extends GeneralException {
    public MissionNotFoundException() {
        super(ErrorStatus.MISSION_NOT_FOUND);
    }
}
