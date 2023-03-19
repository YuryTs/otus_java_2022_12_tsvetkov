package homework;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AtmImpl implements ATM{

    private final MoneyBankomat moneyBankomat;

    public AtmImpl(Map<NominalBanknote, Integer> money) {
        moneyBankomat = new MoneyBankomat();
        money.forEach(this::putBanknotes);
    }

    @Override
    public void putBanknotes(NominalBanknote denomination, int quantity) {
        CellImpl atmCell = new CellImpl(denomination, quantity);
        moneyBankomat.addCellToVault(atmCell);
    }

    @Override
    public List<Banknote> getBanknotes(int amount) {
        if (amount == 0) {
            throw new RuntimeException("Запрашиваемая сумма должна быть больше 0");
        }
        return getMoneyFromAtmRecursively(new ArrayList<>(), amount);
    }

    private List<Banknote> getMoneyFromAtmRecursively(List<Banknote> money, int resultAmount) {
        if (resultAmount == 0) {
            return money;
        } else if (resultAmount < 0) {
            recoverMoneyBack(money);
            throw new RuntimeException("Данная сумма не может быть выдана банкоматом");
        }
        if (getBalance() <= 0) {
            throw new RuntimeException("В банкомате нет денег");
        }

        Banknote finalTempBanknote = getClosestToAmountBanknote(resultAmount);
        if (finalTempBanknote == null) {
            recoverMoneyBack(money);
            throw new RuntimeException("Данная сумма не может быть выдана банкоматом");
        }

        resultAmount = decreaseBanknoteQuantityAndAddItIntoList(money, finalTempBanknote, resultAmount);

        return getMoneyFromAtmRecursively(money, resultAmount);
    }

    private int decreaseBanknoteQuantityAndAddItIntoList(List<Banknote> money, Banknote finalTempBanknote, int resultAmount) {
        for (CellImpl cell : moneyBankomat.getCellList()) {
            if (cell.getBanknote().equals(finalTempBanknote)) {
                money.add(finalTempBanknote);
                cell.setQuantity(cell.getQuantity() - 1);
                resultAmount = resultAmount - finalTempBanknote.getNominal().getValue();
            }
        }
        return resultAmount;
    }

    private void recoverMoneyBack(List<Banknote> money) {
        for (Banknote banknote : money) {
            moneyBankomat.getCellList().stream()
                    .filter(c -> c.getBanknote().equals(banknote))
                    .findFirst()
                    .ifPresent(cell -> cell.setQuantity(cell.getQuantity() + 1));
        }
    }

    private Banknote getClosestToAmountBanknote(int amount) {
        Banknote tempBanknote = null;
        for (CellImpl cell : moneyBankomat.getCellList()) {
            if (cell.getNominal().getValue() <= amount && cell.getQuantity() > 0) {
                tempBanknote = cell.getBanknote();
            }
        }
        return tempBanknote;
    }

    @Override
    public int getBalance() {
        return moneyBankomat.getMoneyBankomatBalance();
    }




}
