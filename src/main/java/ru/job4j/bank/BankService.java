package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает главный сервис для банковской системы.
 * В системе можно производить следующие действия:
 *
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы
 * могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * @author Damir Rakhmankulov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей осуществляется в коллекции типа HashMap.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя проверяет существует ли
     * такой же, если такого же пользователя нет,
     * то добавляет его в коллекцию.
     * @param user пользователь который добавляется в коллекцию.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход номер пасспорта и аккаунт. Осуществляет
     * поиск пользователя по номеру пасспорта
     * в коллекции и если находит, то сравнивает аккаунт принятый на
     * вход метода с аккаунтами пользователя, при
     * отсутствии совпадений добавляет пользователю аккаунт.
     * @param passport номер пасспорта пользователя
     * @param account новый аккаунт для пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> usersAccounts = users.get(user);
            if (!usersAccounts.contains(account)) {
                usersAccounts.add(account);
            }
        }
    }

    /**
     * Метод осуществляет поиск пользователя в коллекции по номеру
     * пасспорта
     * @param passport номер пасспорта пользователя
     * @return возвращает найденного в коллекции пользователя или
     * Null если пользователь не найден.
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод осуществляет поиск аккаунта в коллекции по номеру
     * пасспорта пользователя и реквизиту аккаунта
     * @param passport номер пасспорта пользователя
     * @param requisite реквизит из аккаунта пользователя
     * @return возвращает найденный в коллекции аккаунт или Null
     * если не будет найден пользователь с номером пасспорта
     * и реквизитом аккаунта пришедшими на вход метода.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account foundAccount = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            for (Account account : userAccounts) {
                if (account.getRequisite().equals(requisite)) {
                    foundAccount = account;
                    break;
                }
            }
        }
        return foundAccount;
    }

    /**
     * Метод принимает на вход сумму перевода, номера пасспортов
     * и реквизиты аккаунтов пользователей,
     * и осуществляет перевод между ними в случае прохождения
     * проверок.
     * Проверки происходят на наличие в коллекции аккаунтов
     * отправителя и получателя, а также на соответствие
     * размера баланса отправителя возможности осуществить
     * перевод получателю.
     * @param srcPassport номер пасспорта пользователя отправителя
     * перевода
     * @param srcRequisite реквизиты аккаунта отправителя
     * @param destPassport номер пасспорта пользователя получателя
     * перевода
     * @param destRequisite реквизиты аккаунта получателя
     * @param amount сумма перевода
     * @return возвращает true если перевод осуществлен и false
     * если проверки не пройдены и перевод не осуществлялся.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if ((srcAccount != null && destAccount != null) && (srcAccount.getBalance() >= amount)) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;

        }
        return rsl;
    }
}