package br.univille.ativchat.service.impl;


import java.util.List;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.azure.messaging.servicebus.administration.ServiceBusAdministrationClient;
import com.azure.messaging.servicebus.administration.ServiceBusAdministrationClientBuilder;
import com.azure.messaging.servicebus.models.ServiceBusReceiveMode;

import br.univille.ativchat.model.Mensagem;
import br.univille.ativchat.service.BrokerMensagemService;
import br.univille.ativchat.view.Form;

public class BrokerMensagemServiceImpl implements BrokerMensagemService {
    String topicName = "topic-chat";
    String serviceBus = "sb-das12025-test-brazilsouth.servicebus.windows.net";
    String subscription = "subscription-" +  System.getenv("USERNAME");

    DefaultAzureCredential credential =
        new DefaultAzureCredentialBuilder()
        .build();
       
    @Override
    public void enviarMensagem(Mensagem mensagem) {
        
        ServiceBusAdministrationClient adminClient = 
        new ServiceBusAdministrationClientBuilder()
        .credential(serviceBus, credential)
        .buildClient();
        try {
            adminClient.createSubscription(topicName, subscription); 
        } catch (Exception e) {
            // TODO: handle exception
        }

        
        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
        .fullyQualifiedNamespace("sb-das12025-test-brazilsouth.servicebus.windows.net")
        .credential(credential)
        .transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
        .sender()
        .topicName(topicName)
        .buildClient();

        senderClient.sendMessage(new ServiceBusMessage(mensagem.getNome() + ": " +mensagem.getTexto()));
    }

    @Override
    public void buscarMensagens(List<Mensagem> mensagens) {
        ServiceBusProcessorClient processorClient = new ServiceBusClientBuilder()
            .fullyQualifiedNamespace(serviceBus)
            .credential(credential)
            .transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
            .processor()
            .topicName(topicName)
            .subscriptionName(subscription)
            .receiveMode(ServiceBusReceiveMode.PEEK_LOCK)
            .processMessage(context -> {
                System.out.println("Mensagem recebida: " + context.getMessage().getBody().toString());
                context.complete();
            })
            .processError(context -> {
                System.out.println("Erro: " + context.getException().getMessage());
            })
            .buildProcessorClient();

        processorClient.start();
        System.out.println("Aguardando mensagens ...");
        try {
            System.in.read();
        } catch(Exception e) {
            e.printStackTrace();
        } finally{
            processorClient.close();
        }
        mensagens.stream().forEach(m -> System.out.println(m));
    }
    
}


