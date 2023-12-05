package umc.study.domain.membermission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.membermission.entity.MemberMission;
import umc.study.domain.mission.enums.MissionStatus;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE MemberMission mm SET mm.missionStatus = :status WHERE mm.mission.id = :missionId")
    void updateMissionStatusByMissionId(Long missionId, MissionStatus status);
}
