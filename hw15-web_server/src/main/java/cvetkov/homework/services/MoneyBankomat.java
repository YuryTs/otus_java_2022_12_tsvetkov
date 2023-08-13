package cvetkov.homework.services;

import java.util.TreeSet;

public interface MoneyBankomat {

    TreeSet<CellImpl> getCellList();

    void addCellToVault(CellImpl cell);

    int getMoneyBankomatBalance();

}
