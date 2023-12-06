package umc.study.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.foodcategory.converter.MemberFoodCategoryConverter;
import umc.study.domain.foodcategory.entity.FoodCategory;
import umc.study.domain.foodcategory.exception.handler.FoodCategoryHandler;
import umc.study.domain.foodcategory.repository.FoodCategoryRepository;
import umc.study.domain.mapping.MemberFoodCategory;
import umc.study.domain.member.converter.MemberConverter;
import umc.study.domain.member.dto.MemberRequestDTO;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.repository.MemberRepository;
import umc.study.domain.membermission.converter.MemberMissionConverter;
import umc.study.domain.membermission.entity.MemberMission;
import umc.study.domain.membermission.service.MemberMissionService;
import umc.study.domain.mission.dto.MissionPreViewListByMemberDTO;
import umc.study.global.apipayload.code.status.ErrorStatus;
import umc.study.global.exception.GeneralException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MemberMissionService memberMissionService;
    private final MemberMissionConverter memberMissionConverter;
    private final Integer MEMBER_MISSION_PAGE_SIZE = 10;


    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {
        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getFoodCategoryPreferences().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberFoodCategory> memberPreferList = MemberFoodCategoryConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    public Member findMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
    }
    @Override
    public Page<MemberMission> findAllMissionByMember(Member member, PageRequest pageRequest) {
        return memberMissionService.findAllByMemberAndStatus(member, pageRequest);
    }

    @Override
    public MissionPreViewListByMemberDTO getMissionList(Long memberId, Integer page) {
        Member member = findMemberById(memberId);
        Page<MemberMission> memberMissionPage = findAllMissionByMember(member, PageRequest.of(page,MEMBER_MISSION_PAGE_SIZE));
        return memberMissionConverter.toMissionPreViewListDTO(memberMissionPage);
    }
}