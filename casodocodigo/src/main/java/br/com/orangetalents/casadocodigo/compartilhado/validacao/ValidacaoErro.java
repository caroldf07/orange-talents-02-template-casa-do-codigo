package br.com.orangetalents.casadocodigo.compartilhado.validacao;

public class ValidacaoErro {
    private String campo;
    private String mensagem;

    public ValidacaoErro(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    /*
     * Getters criados para serem utilizados em ValidationErroHandler
     * */
    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
