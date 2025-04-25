package br.univille.ativchat.config;

import java.util.function.Consumer;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.models.ServiceBusReceiveMode;

import br.univille.ativchat.model.Mensagem;
import br.univille.ativchat.util.MensagemFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Subscriber {
    private String serviceBus;
    private String topicName;
    private String subscription;

    public void receberMensagens(Consumer<Mensagem> callback) {

        MensagemFormat mensagemFormat = new MensagemFormat();

        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

        ServiceBusProcessorClient processorClient = new ServiceBusClientBuilder()
                .fullyQualifiedNamespace(serviceBus)
                .credential(credential)
                .transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
                .processor()
                .topicName(topicName)
                .subscriptionName(subscription)
                .receiveMode(ServiceBusReceiveMode.PEEK_LOCK)
                .processMessage(context -> {
                    Mensagem mensagem = mensagemFormat.formatMensagem(context);
                    callback.accept(mensagem);
                    context.complete();
                })
                .processError(context -> {
                    System.out.println("Erro: " + context.getException().getMessage());
                })
                .buildProcessorClient();

        processorClient.start();
    }
}
