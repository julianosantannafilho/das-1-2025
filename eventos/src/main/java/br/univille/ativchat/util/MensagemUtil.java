package br.univille.ativchat.util;

import com.azure.messaging.servicebus.ServiceBusReceivedMessageContext;

import br.univille.ativchat.model.Mensagem;

public class MensagemUtil {

    public Mensagem buildMensagem(ServiceBusReceivedMessageContext context) {

        String[] string = context.getMessage().getBody().toString().split(":");

        return Mensagem.builder()
                .nome(string[0])
                .texto(string[1])
                .build();
    }
}