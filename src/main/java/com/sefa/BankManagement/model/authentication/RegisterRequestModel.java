package com.sefa.BankManagement.model.authentication;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestModel {

    private String name;

    private String phone;

    private String email;

    private String password;
}