package umc.study.global.apipayload.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ReasonDTO {
    private final String code;
    private final String message;
}
