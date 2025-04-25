package br.univille.ativchat.service;

import br.univille.ativchat.view.Form;

import br.univille.ativchat.model.Mensagem;

public interface BrokerMensagemService {
    void enviarMensagem(Mensagem mensagem);
    void buscarMensagens(Form form);
}
