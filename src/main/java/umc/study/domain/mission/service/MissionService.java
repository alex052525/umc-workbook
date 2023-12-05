package umc.study.domain.mission.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.store.entity.Store;

public interface MissionService {
    Mission findMissionById(Long id);

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
