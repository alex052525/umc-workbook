package umc.study.domain.mission.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionPreViewByStoreDTO {
    String storeName;
    String description;
    Integer reward;
    LocalDate createdAt;
}
