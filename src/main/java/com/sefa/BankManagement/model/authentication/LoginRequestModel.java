package com.sefa.BankManagement.model.authentication;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestModel {

    private String email;

    private String password;
}