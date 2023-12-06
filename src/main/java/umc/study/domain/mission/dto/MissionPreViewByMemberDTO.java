package umc.study.domain.mission.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.study.domain.mission.enums.MissionStatus;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionPreViewByMemberDTO {
    String memberName;
    String description;
    Integer reward;
    MissionStatus Status;
    LocalDate createdAt;

}
