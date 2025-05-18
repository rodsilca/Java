package entities;

public class BussinessAccount extends Account{
    public Double loanLimit;

    BussinessAccount(){}

    public BussinessAccount(Integer number, String holder, Double balance,Double withdraw, Double loanLimit) {
        super(number, holder, balance,withdraw);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(Double amount){
        if (amount<= loanLimit){
            balance+= amount -10.0;
        }
    }

    @Override
    public Double withdraw(Double amount){

        return balance -= 2.0;
    }
}
