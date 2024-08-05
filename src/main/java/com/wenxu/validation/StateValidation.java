package com.wenxu.validation;

import com.wenxu.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author zhaowenxu
 * @version 1.0
 */
public class StateValidation implements ConstraintValidator<State, String> {

    /**
     * 提供校验规则
     * @param s 将来要校验的数据
     * @param constraintValidatorContext
     * @return 返回false，则校验不通过，返回true，则通过
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        if (s.equals("已发布") || s.equals("草稿")) return true;
        return false;
    }
}
