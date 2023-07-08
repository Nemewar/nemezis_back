package com.cavanosa.TutorialStripe.http;

import lombok.ToString;

@ToString
public class PaymentIntentDto {
    public enum Currency{
        usd, eur;
    }

    private String description;
    private int amount;
    private Currency currency;

    private Metadata metadata;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
