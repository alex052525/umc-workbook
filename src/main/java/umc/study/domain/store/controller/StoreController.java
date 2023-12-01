package umc.study.domain.store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.domain.store.dto.StoreRequestDTO;
import umc.study.domain.store.dto.StoreResponseDTO;
import umc.study.domain.store.service.StoreService;
import umc.study.global.apipayload.ApiResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO> createStore(@RequestBody @Valid
                                                       StoreRequestDTO request) {
        StoreResponseDTO response = storeService.createStore(request);
        return ApiResponse.onSuccess(response);
    }
}
