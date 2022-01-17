package pl.marzenapepera.BUDGET.transactions;

import javax.persistence.Column;

public class Amount {
    @Column(name = "amount")
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
