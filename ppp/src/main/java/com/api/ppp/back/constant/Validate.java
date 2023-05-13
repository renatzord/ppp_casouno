package com.api.ppp.back.constant;

public class Validate {

    // To validate the password
    public static boolean isPasswordSecure(String password) {
        // Check if the password is at least 8 characters long.
        if (password.length() < 8) {
            return false;
        }
        // Check if the password contains at least one uppercase letter.
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        // Check if the password contains at least one lowercase letter.
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        // Check if the password contains at least one digit.
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        // Check if the password contains at least one special character.
        if (!password.matches(".*[!@#$%^&*()_+].*")) {
            return false;
        }
        return true;
    }

}
