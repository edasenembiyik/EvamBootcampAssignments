package invoice;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceModel {
    private BigDecimal amount;
    private String precess_date;
    private int bill_type;
    private int id;

    public InvoiceModel(BigDecimal amount, String precess_date, int bill_type, int id) {
        this.amount = amount;
        this.precess_date = precess_date;
        this.bill_type = bill_type;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceModel)) return false;
        InvoiceModel that = (InvoiceModel) o;
        return getBill_type() == that.getBill_type() && getId() == that.getId() && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getPrecess_date(), that.getPrecess_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getPrecess_date(), getBill_type(), getId());
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPrecess_date() {
        return precess_date;
    }

    public void setPrecess_date(String precess_date) {
        this.precess_date = precess_date;
    }

    public int getBill_type() {
        return bill_type;
    }

    public void setBill_type(int bill_type) {
        this.bill_type = bill_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
