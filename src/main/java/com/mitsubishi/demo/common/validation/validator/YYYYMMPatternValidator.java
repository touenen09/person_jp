package com.mitsubishi.demo.common.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mitsubishi.demo.common.util.DateUtil;
import com.mitsubishi.demo.common.validation.YYYYMMPattern;

public class YYYYMMPatternValidator implements ConstraintValidator<YYYYMMPattern, String> {

	@Override
	public void initialize(YYYYMMPattern yYYYMMPattern) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || "".equals(value)) {
			return false;
		}

		return isYYYYMM(value);
	}

	private boolean isYYYYMM(String value) {

		try {
			DateUtil.convertStringToDate(value, DateUtil.DATE_PATTERN_YEAR_MONTH_MOL);
		} catch (Exception e) {
			return false;
		}
		return false;
	}

}