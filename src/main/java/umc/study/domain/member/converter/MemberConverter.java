package umc.study.domain.member.converter;

import umc.study.domain.member.dto.MemberRequestDTO;
import umc.study.domain.member.dto.MemberResponseDTO;
import umc.study.domain.member.entity.Member;
import umc.study.domain.member.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){
        Gender gender = null;
        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }
        return Member.builder()
                .name(request.getName())
                .birthDay(Integer.toString(request.getBirthYear()) +
                        Integer.toString(request.getBirthMonth()) +
                        Integer.toString(request.getBirthDay()))
                .address(request.getAddress())
//                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .foodCategoryPreference(new ArrayList<>())
                .build();
    }
}
