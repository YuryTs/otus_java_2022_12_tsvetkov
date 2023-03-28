package homework;

import java.util.List;

public interface ATM {
    void putBanknotes(NominalBanknote nominal, int quantity);

    List<BanknoteImpl> getBanknotes(int amount);

    int getBalance();
}
