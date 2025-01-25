package com.example.bsm.response;

import com.example.bsm.enums.BloodGroup;
import com.example.bsm.enums.Gender;
import com.example.bsm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private int userId;
    private String userName;
    private BloodGroup bloodGroup;
    private int age;
    private Gender gender;
    private String availableCity;
    private String lastDonatedAt;
    private String lastCreatedAt;
    private String lastModifiedAt;
    private Role role;

}
