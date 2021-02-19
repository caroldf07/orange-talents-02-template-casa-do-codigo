package br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.validacao;

import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.ClienteRequest;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClienteRequestGroupSequenceProvider implements DefaultGroupSequenceProvider<ClienteRequest> {

    protected boolean isPessoaSelecionada(ClienteRequest clienteRequest) {
        return clienteRequest != null && clienteRequest.getTipoCliente() != null;
    }

    @Override
    public List<Class<?>> getValidationGroups(ClienteRequest clienteRequest) {

        List<Class<?>> groups = new ArrayList<>();
        groups.add(ClienteRequest.class);

        if (isPessoaSelecionada(clienteRequest)) {
            groups.add(clienteRequest.getTipoCliente().getGroup());
        }
        return groups;
    }
}
