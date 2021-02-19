package br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.validacao;

import br.com.orangetalents.casadocodigo.fluxodepagamento.cadastrocliente.model.Cliente;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<Cliente> {
    protected boolean isPessoaSelecionada(Cliente cliente) {
        return cliente != null && cliente.getTipoCliente() != null;
    }

    @Override
    public List<Class<?>> getValidationGroups(Cliente cliente) {

        List<Class<?>> groups = new ArrayList<>();
        groups.add(Cliente.class);

        if (isPessoaSelecionada(cliente)) {
            groups.add(cliente.getTipoCliente().getGroup());
        }
        return groups;
    }
}
