package Java8_9_10_11.jmp_bank_api;

import Java8_9_10_11.jmp_dto.BankCard;
import Java8_9_10_11.jmp_dto.User;
import Java8_9_10_11.jmp_dto.enums.BankCardType;

public interface Bank {
    BankCard createBankCard(User user, BankCardType bankCardType);
}
