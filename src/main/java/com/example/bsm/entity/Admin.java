package com.example.bsm.entity;

import com.example.bsm.enums.AdminType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue
    private int adminId;

    @OneToOne
    private User user;
    private AdminType adminType;

}
