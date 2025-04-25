package br.univille.ativchat.config;

import java.util.function.Consumer;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.models.ServiceBusReceiveMode;

import br.univille.ativchat.model.Mensagem;
import br.univille.ativchat.util.MensagemUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Subscriber {

    private String fqnds;
    private String topicName;
    private String subscriptionNome;
    
    public void receberMensagens(Consumer<Mensagem> callback) {

        MensagemUtil mensagemUtil = new MensagemUtil();

        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

        ServiceBusProcessorClient processorClient = new ServiceBusClientBuilder()
            .fullyQualifiedNamespace(fqnds)
            .credential(credential)
            .transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
            .processor()
            .topicName(topicName)
            .subscriptionName(subscriptionNome)
            .receiveMode(ServiceBusReceiveMode.PEEK_LOCK)
            .processMessage(context -> {
                Mensagem mensagem = mensagemUtil.buildMensagem(context);
                callback.accept(mensagem);
                System.out.println("Mensagem recebida: " + mensagem.toString());
                context.complete();
            })

            .processError(context -> {
                System.out.println("Erro: " + context.getException().getMessage());
            })
            .buildProcessorClient();

        processorClient.start();
    }
}
