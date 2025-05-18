package entities;

public final class SavingsAccount extends Account{
    private Double interestRate;

    SavingsAccount(){}

    public SavingsAccount(Integer number, String holder, Double balance,Double withdraw, Double interestRate) {
        super(number, holder, balance,withdraw);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance(){
        balance += balance * interestRate;
    }

    @Override
    public Double withdraw(Double amount){
        return balance -= amount;
    }
}
