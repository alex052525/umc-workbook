package umc.study.domain.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mission.entity.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
