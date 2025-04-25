package br.univille.ativchat.config;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

import br.univille.ativchat.model.Mensagem;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    private String topicName;
    private String serviceBus;

    public void enviarMensagem(Mensagem mensagem) {

        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
            .fullyQualifiedNamespace(serviceBus)
            .credential(credential)
            .transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
            .sender()
            .topicName(topicName)
            .buildClient();
        senderClient.sendMessage(new ServiceBusMessage(mensagem.toString()));
    }

}
