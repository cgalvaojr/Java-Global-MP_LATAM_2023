package Java8_9_10_11.jmp_cloud_service_impl;

import Java8_9_10_11.jmp_dto.BankCard;
import Java8_9_10_11.jmp_dto.Subscription;
import Java8_9_10_11.jmp_dto.User;
import Java8_9_10_11.jmp_service_api.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CloudService implements Service, Serializable {

    public List<Subscription> subscriptions = new ArrayList<>();
    public List<User> users = new ArrayList<>();
    @Override
    public void subscribe(BankCard bankCard) {
        Subscription subscription = new Subscription();
        subscription.bankcard = bankCard.number;
        subscription.startDate = LocalDate.now();
        subscriptions.add(subscription);
        users.add(bankCard.user);
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String bankCardNumber) {
        try {
            return Optional.ofNullable(subscriptions.stream()
                    .filter(sub -> sub.bankcard.equals(bankCardNumber))
                    .findFirst()
                    .orElseThrow(() -> new OrElseException("Here we go, throw a new class exception")));
        } catch (OrElseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
