package pl.marzenapepera.BUDGET.transactions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CategoryGroup {

    @Column(name = "amount")
    private Double amount;

    @Column(name = "category")
    private String category;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
