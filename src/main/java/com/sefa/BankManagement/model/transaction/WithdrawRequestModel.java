package com.sefa.BankManagement.model.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WithdrawRequestModel {

    private String card_number;
    private String cvv;
    private Double amount;
}
