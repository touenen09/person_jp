package com.mitsubishi.demo.common.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.mitsubishi.demo.common.validation.validator.YYYYMMPatternValidator;

@Documented
@Constraint(validatedBy = { YYYYMMPatternValidator.class })
@Target({ FIELD })
@Retention(RUNTIME)
public @interface YYYYMMPattern {
	String message() default "";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ FIELD })
	@Retention(RUNTIME)
	@Documented
	public @interface List {
		YYYYMMPattern[] value();
	}
}