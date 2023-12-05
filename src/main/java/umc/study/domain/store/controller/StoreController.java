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
import umc.study.domain.mission.dto.MissionPreViewListDTO;
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


    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @GetMapping("/{storeId}/reviews")
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
        @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
        @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<ReviewPreViewListDTO> getReviewList(@PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page") Integer page){
        ReviewPreViewListDTO reviews = storeService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(reviews);
    }

    @GetMapping("/{storeId}/missions")
    public ApiResponse<MissionPreViewListDTO> getMissions (@PathVariable(name = "storeId") Long storeId, @RequestParam(name = "page", defaultValue = "0") Integer page){
        MissionPreViewListDTO missions = storeService.getMissionList(storeId,page);
        return ApiResponse.onSuccess(missions);
    }
}
