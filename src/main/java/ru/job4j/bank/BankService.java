package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        String key = user.getPassport();
        if (!users.containsKey(key)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> usersAccounts = users.get(user);
            if (!usersAccounts.contains(account)) {
                usersAccounts.add(account);
                users.put(user, usersAccounts);
            }
        }
    }


    public User findByPassport(String passport) {
        User rsl = null;
        for (User var : users.keySet()) {
            if (var.getPassport().equals(passport)) {
                rsl = var;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account foundAccount = null;
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            for (Account account : userAccounts) {
                if (account.getRequisite().equals(requisite)) {
                    foundAccount = account;
                }
            }
        }
        return foundAccount;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;

        User srcUser = findByPassport(srcPassport);
        User destUser = findByPassport(destPassport);
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (srcUser != null && destUser != null) {
            if (srcAccount != null && destAccount != null) {
                if (srcAccount.getBalance() >= amount) {
                    srcAccount.setBalance(srcAccount.getBalance() - amount);
                    destAccount.setBalance(destAccount.getBalance() + amount);
                    rsl = true;
                }
            }
        }

        return rsl;
    }
}