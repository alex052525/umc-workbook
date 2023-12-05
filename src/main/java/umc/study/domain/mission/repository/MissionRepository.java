package umc.study.domain.mission.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mission.entity.Mission;
import umc.study.domain.store.entity.Store;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
