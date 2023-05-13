package Java8_9_10_11.jmp_service_api;

import Java8_9_10_11.jmp_dto.BankCard;
import Java8_9_10_11.jmp_dto.Subscription;
import Java8_9_10_11.jmp_dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public interface Service {

    default double getAverageUsersAge() {
        var users = getAllUsers();
        var usersCount = users.size();
        double userAgeSum = users.stream().mapToLong(user -> {
            LocalDate today = LocalDate.now();
            LocalDate userBirth = user.getBirthday();
            return ChronoUnit.YEARS.between(userBirth, today);
        }).sum();
        return userAgeSum / usersCount;
    }

    static boolean isPaybleUser(User user) {
        LocalDate today = LocalDate.now();
        LocalDate userBirth = user.getBirthday();
        long userAge = ChronoUnit.YEARS.between(today, userBirth);

        if (userAge > 18) {
            return true;
        }
        return false;
    }
    void subscribe(BankCard bankCard);
    Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber);

    List<User> getAllUsers();

}
