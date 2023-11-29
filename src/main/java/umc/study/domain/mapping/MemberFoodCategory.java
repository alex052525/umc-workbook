package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.foodcategory.entity.FoodCategory;
import umc.study.domain.member.entity.Member;
import umc.study.global.entity.BaseTimeEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberFoodCategory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodCategory_id", nullable = false)
    private FoodCategory foodCategory;
    public void setMember(Member member){
        if(this.member != null)
            member.getFoodCategoryPreference().remove(this);
        this.member = member;
        member.getFoodCategoryPreference().add(this);
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.foodCategory = foodCategory;
    }
}


