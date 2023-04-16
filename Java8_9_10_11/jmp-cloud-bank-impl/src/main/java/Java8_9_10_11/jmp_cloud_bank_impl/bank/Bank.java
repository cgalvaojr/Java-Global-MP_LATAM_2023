package Java8_9_10_11.jmp_cloud_bank_impl.bank;

import Java8_9_10_11.jmp_dto.BankCard;
import Java8_9_10_11.jmp_dto.CreditBankCard;
import Java8_9_10_11.jmp_dto.DebitBankCard;
import Java8_9_10_11.jmp_dto.User;
import Java8_9_10_11.jmp_dto.enums.BankCardType;

public class Bank implements Java8_9_10_11.jmp_bank_api.Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        if(bankCardType.equals(BankCardType.CREDIT)) {
            BankCard creditBankCard = new CreditBankCard();
            creditBankCard.number = "874-6541-3217";
            creditBankCard.user = user;
            return creditBankCard;
        }
        BankCard debitBankCard = new DebitBankCard();
        debitBankCard.user = user;
        debitBankCard.number = "874-6541-3217";
        return debitBankCard;
    }
}
