package umc.study.domain.mission.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.mission.repository.MissionRepository;
import umc.study.global.apipayload.code.status.ErrorStatus;
import umc.study.global.exception.GeneralException;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;

    @Override
    public Mission findMissionById(Long id) {
        return missionRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND)
        );
    }
}
