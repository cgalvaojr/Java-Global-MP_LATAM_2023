package Java8_9_10_11;

import Java8_9_10_11.jmp_cloud_bank_impl.bank.Bank;
import Java8_9_10_11.jmp_cloud_service_impl.CloudService;
import Java8_9_10_11.jmp_dto.BankCard;
import Java8_9_10_11.jmp_dto.Subscription;
import Java8_9_10_11.jmp_dto.User;
import Java8_9_10_11.jmp_dto.enums.BankCardType;

import java.io.*;
import java.time.LocalDate;
import java.util.Optional;

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

        //Serializating
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            double averageUsersAge = cloudService.getAverageUsersAge();
            System.out.println(averageUsersAge);
            oos.writeObject(cloudService);

            //deserializing
            byte[] bytes = baos.toByteArray();
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            CloudService cloudService1 = (CloudService) new ObjectInputStream(bis).readObject();
            double averageUsersAge1 = cloudService1.getAverageUsersAge();
            System.out.println(averageUsersAge1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}