package com.spring.gradle.shopping.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.spring.gradle.shopping.entity.model.UserBean;

@Component
public class UserValidator extends ValidationSupport {
	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	// String ID_PATTERN = "[0-9]+";
	// String STRING_PATTERN = "[a-zA-Z]+";
	// String MOBILE_PATTERN = "[0-9]{10}";

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object target, Errors error) {
		UserBean userBean = (UserBean) target;

		if (isEmpty(userBean.getEmailId())) {
			error.rejectValue("emailId", "You must enter an Email Id.",
					"You must enter an Email Id.");
		} else {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(userBean.getEmailId());
			if (!matcher.matches()) {
				error.rejectValue("emailId", "Enter a correct email",
						"Enter a correct email");
			}

		}

		if (isEmpty(userBean.getPassword())) {
			error.rejectValue("password", "You must enter Password.",
					"You must enter Password.");
		}

	}

}
