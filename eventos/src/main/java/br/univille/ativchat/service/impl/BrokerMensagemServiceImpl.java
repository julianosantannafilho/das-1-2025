package br.univille.ativchat.service.impl;

import br.univille.ativchat.model.Mensagem;
import br.univille.ativchat.service.BrokerMensagemService;
import br.univille.ativchat.view.Form;
import br.univille.ativchat.config.Publisher;
import br.univille.ativchat.config.Subscriber;
import br.univille.ativchat.config.Subscription;

public class BrokerMensagemServiceImpl implements BrokerMensagemService {
    private static final String topicName = "topic-chat";
    private static final String serviceBus = "sb-das12025-test-brazilsouth.servicebus.windows.net";
    private static final String subscription = "subscription-juliano";

    private final Subscription criadorSubscription = new Subscription(serviceBus, topicName, subscription);
    private final Publisher publisher = new Publisher(topicName, serviceBus);
    private final Subscriber subscriber = new Subscriber(serviceBus, topicName, subscription);

    @Override
    public void enviarMensagem(Mensagem mensagem) { 
        System.out.println("Enviando mensagem: " + mensagem.toString());
        try {
            criadorSubscription.criarSubscription();
        }catch (RuntimeException e){
            System.out.println(e.toString());
        }
        publisher.enviarMensagem(mensagem);      
    }

    @Override
    public void buscarMensagens(Form form) {
        System.out.println("Aguardando mensagens ...");
        subscriber.receberMensagens(mensagem -> form.sendMensagem(mensagem.toString()));
    }

}


