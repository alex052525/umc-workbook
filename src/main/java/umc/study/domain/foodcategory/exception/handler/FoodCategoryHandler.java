package umc.study.domain.foodcategory.exception.handler;

import umc.study.global.apipayload.code.BaseErrorCode;
import umc.study.global.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

