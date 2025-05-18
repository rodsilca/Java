package entities;

public class PessoaFisica extends Pessoa{
    private Double healthExpenses;

    public PessoaFisica(){}

    public PessoaFisica(String nome, Double rendaAnual, Double healthExpenses) {
        super(nome, rendaAnual);
        this.healthExpenses = healthExpenses;
    }

    public Double getHealthExpenses() {
        return healthExpenses;
    }

    public void setHealthExpenses(Double healthExpenses) {
        this.healthExpenses = healthExpenses;
    }

    @Override
    public Double calculoImposto() {
        if (getRendaAnual()<20000){
            if (healthExpenses != null){
                return (getRendaAnual() * 0.15) - (healthExpenses*0.5);
            }

            return (getRendaAnual() * 0.15);

        }else {
            if (healthExpenses != null){
                return (getRendaAnual() * 0.25) - (healthExpenses*0.5);
            }

            return (getRendaAnual() * 0.25);

        }
    }
}
