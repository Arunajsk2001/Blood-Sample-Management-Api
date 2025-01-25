package com.example.bsm.entity;

import com.example.bsm.enums.BloodGroup;
import com.example.bsm.enums.Gender;
import com.example.bsm.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
   private String userName;
   private String email;
   private String password;
   private String phnonumber;
   private BloodGroup bloodGroup;
   private String lastDonatedAt;
   private int age;
   private Gender gender;
   private String availableCity;
   private boolean verified;
   private String lastModifiedAt;
   private String lastCreatedAt;
   private Role role;

   @OneToOne(mappedBy = "user",fetch = FetchType.EAGER)
  private Admin admin;

}
