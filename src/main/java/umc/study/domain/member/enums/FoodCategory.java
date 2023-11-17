package umc.study.domain.member.enums;

public enum FoodCategory {
    KOREAN_FOOD("한식"),
    WESTERN_FOOD("양식"),
    JAPANESE_FOOD("일식"),
    CHINESE_FOOD("중식"),
    CHICKEN("치킨"),
    SNACKS("분식"),
    BBQ("고기/구이"),
    LUNCH_BOX("도시락"),
    NIGHT_SNACK("야식"),
    FAST_FOOD("패스트푸드"),
    DESSERT("디저트"),
    ASIAN_FOOD("아시안푸드");

    private final String category;

    FoodCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
