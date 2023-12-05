package umc.study.domain.store.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.study.domain.review.dto.ReviewCreateRequestDto;
import umc.study.domain.review.dto.ReviewCreateResponseDto;
import umc.study.domain.review.dto.ReviewPreViewListDTO;
import umc.study.domain.store.dto.StoreCreateRequestDTO;
import umc.study.domain.store.dto.StoreCreateResponseDTO;
import umc.study.domain.store.service.StoreService;
import umc.study.global.apipayload.ApiResponse;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/createStore")
    public ApiResponse<StoreCreateResponseDTO> createStore(@RequestBody @Valid
    StoreCreateRequestDTO request) {
        StoreCreateResponseDTO response = storeService.createStore(request);
        return ApiResponse.onSuccess(response);
    }

    @PostMapping("/createReview")
    public ApiResponse<ReviewCreateResponseDto> createReview(@RequestBody @Valid
    ReviewCreateRequestDto request) {
        ReviewCreateResponseDto response = storeService.createReview(request);
        return ApiResponse.onSuccess(response);
    }

}
