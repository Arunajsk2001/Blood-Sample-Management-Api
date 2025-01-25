package com.example.bsm.request;

import com.example.bsm.enums.BloodGroup;
import com.example.bsm.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotNull(message = "UserName cannot be Null")
    @NotBlank(message = "userName cannot be Blank ")
    @Pattern(regexp = "&[a-zA-Z_]",message = "userName must contain alphabet and underScore")
    private String userName;
    @NotNull(message = "email cannot be Null")
    @NotBlank(message = "email cannot be Blank ")
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-z]+.[a-z]")
    private String email;
    @NotNull(message = "password cannot be Null")
    @NotBlank(message = "password cannot be Blank ")
//    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%&*])(?!.*[@#$%&*]{2,})[A-Za-z@#$%&*]{8,}$\n")
    private String password;
    @NotNull(message = "phonnumber cannot be Null")
    @NotBlank(message = "phonnumber cannot be Blank ")
    @Pattern(regexp = "^\\d{10}$\n")
    private String phnonumber;
    private BloodGroup bloodGroup;
    private int age;
    private Gender gender;
    private String availableCity;

}
