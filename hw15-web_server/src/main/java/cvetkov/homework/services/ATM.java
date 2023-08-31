package cvetkov.homework.services;


import cvetkov.homework.model.NominalBanknote;
import cvetkov.homework.services.impl.BanknoteImpl;

import java.util.List;

public interface ATM {
    void putBanknotes(NominalBanknote nominal, int quantity);

    List<BanknoteImpl> getBanknotes(int amount);

    int getBalance();
}
