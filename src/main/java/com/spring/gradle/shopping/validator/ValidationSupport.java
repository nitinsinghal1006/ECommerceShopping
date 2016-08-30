package com.spring.gradle.shopping.validator;

import java.util.Collection;

import org.springframework.validation.Validator;


public abstract class ValidationSupport implements Validator {

	public boolean matches(String value1, String value2) {
		return value1 != null && value2 != null && value1.equals(value2);
	}

	public boolean isEmpty(@SuppressWarnings("rawtypes") Collection values) {
		return values == null || values.isEmpty();
	}

	public boolean isEmpty(String value) {
		return value == null || value.trim().isEmpty();
	}

	public boolean minSize(String value, int size) {
		return value != null && value.length() >= size;
	}

	public boolean maxSize(String value, int size) {
		return value != null && value.length() <= size;
	}

	public boolean isBetween(String value, int min, int max) {
		return minSize(value, min) && maxSize(value, max);
	}

	public boolean isAlphaNumeric(String value) {
		return !isNumeric(value) && !isAlpha(value);
	}

	public boolean isNumeric(String value) {
		return value.matches("\\d+");
	}

	public boolean isAlpha(String value) {
		return value.matches("\\D+");
	}

}
