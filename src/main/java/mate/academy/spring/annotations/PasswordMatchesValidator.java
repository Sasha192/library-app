
package mate.academy.spring.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import mate.academy.spring.dto.UserRegistrationDto;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserRegistrationDto user = (UserRegistrationDto) obj;
        return user.getPassword().equals(user.getRepeatPassword());
    }

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
}
