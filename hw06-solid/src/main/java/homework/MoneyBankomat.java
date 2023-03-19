package homework;

import java.util.Comparator;
import java.util.TreeSet;

public class MoneyBankomat {
    private final TreeSet<CellImpl> cellList;

    public MoneyBankomat() {
        cellList = new TreeSet<>(Comparator.comparingInt(c -> c.getNominal().getValue()));
    }

    public TreeSet<CellImpl> getCellList() {
        return cellList;
    }

    public void addCellToVault(CellImpl cell) {
        cellList.add(cell);
    }

    public int getMoneyBankomatBalance() {
        return cellList.stream().mapToInt(c -> c.getNominal().getValue() * c.getQuantity()).sum();
    }
}
