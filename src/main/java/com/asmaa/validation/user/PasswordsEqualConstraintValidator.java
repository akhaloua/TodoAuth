package com.asmaa.validation.user;

import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.asmaa.Model.User;
public class PasswordsEqualConstraintValidator implements
    ConstraintValidator<PasswordsEqualConstraint, Object> {

@Override
public void initialize(PasswordsEqualConstraint arg0) {
}

@Override

public boolean isValid(Object candidate, ConstraintValidatorContext context) {
	User user = (User) candidate;
System.out.println("Candidate class::::"+user.getClass().getName());
    try {
        Method methodGetPassword = user.getClass().getMethod("getPassword");
        Method methodGetConfirmpassword = user.getClass().getMethod("getConfirmpassword");

        if(methodGetPassword.invoke(user) == null && methodGetConfirmpassword.invoke(user)==null) 
            return true;
        else if(methodGetPassword.invoke(user) == null )
            return false;
        return methodGetPassword.invoke(user).equals(methodGetConfirmpassword.invoke(user));

    } catch (NoSuchMethodException ex) {
        ex.printStackTrace();
        return false;
    } catch (Exception ex) {
        ex.printStackTrace();
        return false;
    }
}
}
