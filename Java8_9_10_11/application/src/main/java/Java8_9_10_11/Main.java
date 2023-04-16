package Java8_9_10_11;

import Java8_9_10_11.jmp_cloud_bank_impl.bank.Bank;
import Java8_9_10_11.jmp_cloud_service_impl.CloudService;
import Java8_9_10_11.jmp_dto.BankCard;
import Java8_9_10_11.jmp_dto.User;
import Java8_9_10_11.jmp_dto.enums.BankCardType;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        User user = new User();
        user.setName("Ciro");
        user.setSurname("Galvão");
        user.setBirthday(LocalDate.parse("1987-03-03"));
        BankCard bankCard = bank.createBankCard(user, BankCardType.CREDIT);
        CloudService cloudService = new CloudService();

        cloudService.subscribe(bankCard);
    }
}