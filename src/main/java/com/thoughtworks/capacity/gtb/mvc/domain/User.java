package com.thoughtworks.capacity.gtb.mvc.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull(message = "username can not be empty")
    @Pattern(regexp = "\\w+", message = "username should consist of alphanumerics and/or underscore")
    @Size(min = 3, max = 10, message = "username should be between 3 and 10 characters long")
    private String username;

    @Size(min = 5, max = 12, message = "password must be between 5 and 12 characters long")
    @NotNull(message = "password should not be empty")
    private String password;

    @Email
    private String email;
}
