package model;


public class Documentos {

    private String cpf;
    private String rg;
    private String orgEmissor;
    private String numSus;

    public Documentos() {

    }

    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getRg() {
        return rg;
    }


    public void setRg(String rg) {
        this.rg = rg;
    }


    public String getOrgEmissor() {
        return orgEmissor;
    }


    public void setOrgEmissor(String orgEmissor) {
        this.orgEmissor = orgEmissor.toUpperCase();
    }


    public String getNumSus() {
        return numSus;
    }


    public void setNumSus(String numSus) {
        this.numSus = numSus;
    }

}
