package umc.study.domain.temp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import umc.study.domain.temp.exception.handler.TempHandler;
import umc.study.global.apipayload.code.status.ErrorStatus;


@Service
@RequiredArgsConstructor
@Primary
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
