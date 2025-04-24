package br.univille.ativchat.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;

import br.univille.ativchat.model.Mensagem;
import br.univille.ativchat.service.BrokerMensagemService;
import br.univille.ativchat.util.AppModule;
import br.univille.ativchat.view.Form;

public class Controller implements ActionListener {
    Injector injector = Guice.createInjector(new AppModule());
    BrokerMensagemService service = injector.getInstance(BrokerMensagemService.class);
    private Form form;
    private  List<Mensagem> mensagensRecebidas = new ArrayList<>();

    public Controller(Form form) {
        this.form = form;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Mensagem novaMensagem = new Mensagem(form.getNome(), form.getMensagem());
        service.enviarMensagem(novaMensagem);

        List<Mensagem> novasMensagens = service.buscarMensagens(mensagensRecebidas); 

        for (Mensagem mensagem : novasMensagens){
            System.out.println("AAAAAAAAAAAAAAA" + mensagem.getTexto());
            form.sendMessage(mensagem.getTexto());
            mensagensRecebidas.add(mensagem);
        }
        service.evict();
    }

}
