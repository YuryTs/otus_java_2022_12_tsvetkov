package homework;

public class CellImpl{
    private BanknoteImpl banknote;
    private int quantity;

    public CellImpl(NominalBanknote nominalBanknote, int quantity) {
        this.banknote = new BanknoteImpl(nominalBanknote);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public NominalBanknote getNominal(){
        return banknote.getNominal();
    }

    public BanknoteImpl getBanknote(){
        return banknote;
    }


}
