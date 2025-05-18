package entities;

import model.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    protected Double balance;
    private Double withdrawLimit ;


    Account(){}

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double withdraw(Double amount) throws DomainException{
        if (amount > balance){
            throw new DomainException("Amount is superior than balance");
        }
        if (amount> withdrawLimit){
            throw new DomainException("Amount is superior than withdraw limit");
        }
        return balance -= amount;
    }

    public void deposit(Double amount){
        balance +=amount;
    }
}
