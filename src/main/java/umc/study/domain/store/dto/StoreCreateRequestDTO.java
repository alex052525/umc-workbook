package umc.study.domain.store.dto;

import lombok.Getter;
//import umc.study.domain.region.validation.annotation.ExistRegion;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class StoreCreateRequestDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String info;
    @NotBlank
    private String address;
    @NotNull
    private Long regionId;
}
