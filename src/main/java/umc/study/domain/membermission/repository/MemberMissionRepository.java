package umc.study.domain.membermission.repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.member.entity.Member;
import umc.study.domain.membermission.entity.MemberMission;
import umc.study.domain.mission.enums.MissionStatus;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE MemberMission mm SET mm.missionStatus = :status WHERE mm.mission.id = :missionId")
    void updateMissionStatusByMissionId(Long missionId, MissionStatus status);

    @Query("SELECT mm FROM MemberMission mm WHERE mm.member = :member AND mm.missionStatus = :status")
    Page<MemberMission> findAllByMemberAndMissionStatus(@Param("member") Member member, @Param("status") MissionStatus status, PageRequest pageRequest);

    @Transactional
    @Modifying
    @Query("UPDATE MemberMission mm SET mm.missionStatus = :afterStatus WHERE mm.mission.id = :missionId AND mm.member.id = :memberId AND mm.missionStatus = :previousStatus")
    void updateStatusToComplete(Long memberId, Long missionId, MissionStatus previousStatus, MissionStatus afterStatus);

    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);
}
