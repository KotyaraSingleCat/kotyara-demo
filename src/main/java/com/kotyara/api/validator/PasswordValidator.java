package com.kotyara.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

  private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z a-z]).{8,22}$";

  @Override
  public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
    try {
      Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
      Matcher matcher = pattern.matcher(password);
      return matcher.matches();
    } catch (Exception e) {
      return false;
    }
  }
}
