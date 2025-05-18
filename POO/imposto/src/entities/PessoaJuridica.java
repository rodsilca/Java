package entities;

public class PessoaJuridica extends Pessoa{
    private Integer numberEmployees;

    public PessoaJuridica(){
        super();
    }

    public PessoaJuridica(String nome, Double rendaAnual, Integer numberEmployees) {
        super(nome, rendaAnual);
        this.numberEmployees = numberEmployees;
    }

    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }

    @Override
    public Double calculoImposto() {
        if (numberEmployees > 10) {
            return getRendaAnual() * 0.14 ;
        }

        return getRendaAnual() * 0.16;
    }
}
