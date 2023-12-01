package umc.study.domain.store.dto;

import lombok.Getter;
import umc.study.domain.region.validation.annotation.ExistRegion;
import javax.validation.constraints.NotBlank;

@Getter
public class StoreRequestDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String info;
    @NotBlank
    private String address;
    @ExistRegion
    private Long region;
}
