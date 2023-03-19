package homework;

import java.util.Collection;
import java.util.List;

public interface ATM {
    void putBanknotes(NominalBanknote nominal, int quantity);

    List<Banknote> getBanknotes(int amount);

    int getBalance();
}
