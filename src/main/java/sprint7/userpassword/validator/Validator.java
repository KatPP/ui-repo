package sprint7.userpassword.validator;

import sprint7.userpassword.exceptions.ValidateException;

public interface Validator {
    void validate(String value) throws ValidateException;
}