package homework;

public class BanknoteImpl implements Banknote {
    private final NominalBanknote nominal;

    public BanknoteImpl(NominalBanknote nominal) {
        this.nominal = nominal;
    }

    @Override
    public NominalBanknote getNominal() {
        return nominal;
    }

    @Override
    public String toString() {
        return "BanknoteImpl{" +
                "nominal=" + nominal.getValue() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BanknoteImpl banknote = (BanknoteImpl) o;
        return nominal == banknote.nominal;
    }
}
