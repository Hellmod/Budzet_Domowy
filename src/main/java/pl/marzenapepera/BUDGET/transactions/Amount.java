package pl.marzenapepera.BUDGET.transactions;

import javax.persistence.Column;

public class Amount {
    @Column(name = "amount")
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
