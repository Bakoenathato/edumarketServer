package za.ac.cput.factory;

import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class UserFactory {
    public static User createUser(String firstName, String lastName, String password, String email, String phone, String role) {
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(password) ||
                Helper.validateEmail(email) || Helper.validatePhone(phone) || Helper.isNullOrEmpty(role))
            return null;

        return new User.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPassword(password)
                .setEmail(email)
                .setPhone(phone)
                .setRole(role)
                .build();
    }
}
