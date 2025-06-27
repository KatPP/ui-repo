package sprint7.userpassword.validator;

import sprint7.userpassword.exceptions.ValidateException;
import sprint7.userpassword.exceptions.ValidateNameException;

public class NameValidator implements Validator {
    @Override
    public void validate(String value) throws ValidateException {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidateNameException("Имя не должно быть пустым");
        }
    }
}
