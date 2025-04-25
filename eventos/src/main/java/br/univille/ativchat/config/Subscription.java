package br.univille.ativchat.config;

import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.servicebus.administration.ServiceBusAdministrationClient;
import com.azure.messaging.servicebus.administration.ServiceBusAdministrationClientBuilder;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

    private String serviceBus;
    private String topicName;
    private String subscription;

        public void criarSubscription(){

        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

        ServiceBusAdministrationClient adminClient = new ServiceBusAdministrationClientBuilder()
            .credential(serviceBus, credential)
            .buildClient();

        adminClient.createSubscription(topicName, subscription);   
    }
}
