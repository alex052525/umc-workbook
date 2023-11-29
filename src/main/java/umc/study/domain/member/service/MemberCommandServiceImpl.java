package umc.study.domain.member.service;

import lombok.RequiredArgsConstructor;
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
import umc.study.global.apipayload.code.status.ErrorStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;


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
}