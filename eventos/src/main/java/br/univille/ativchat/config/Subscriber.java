package br.univille.ativchat.config;

import java.util.function.Consumer;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.models.ServiceBusReceiveMode;

import br.univille.ativchat.model.Mensagem;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Subscriber {

    private String serviceBus;
    private String topicName;
    private String subscription;
    
    public void receberMensagens(Consumer<Mensagem> callback) {

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
                    ServiceBusReceivedMessage message = context.getMessage();
                    String messageBody = message.getBody().toString();
                    System.out.println("Mensagem recebida: " + messageBody);
                    String nomeRemetente = "";
                    String textoMensagem = messageBody.toString();
                    int colonIndex = messageBody.indexOf(":");
                    if (colonIndex != -1) {
                        nomeRemetente = messageBody.substring(0, colonIndex).trim();
                        textoMensagem = messageBody.substring(colonIndex + 1).trim();
                    }

                    Mensagem mensagemRecebida = new Mensagem(nomeRemetente, textoMensagem);

                    callback.accept(mensagemRecebida);
                    context.complete();
                })
                .processError(context -> {
                    System.out.println("Erro: " + context.getException().getMessage());
                })
                .buildProcessorClient();

        processorClient.start();
    }
}
