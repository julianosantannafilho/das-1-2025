package br.univille.ativchat.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Mensagem{
    
    private String nome;
    private String texto;

    @Override
    public String toString() {
        return this.nome+ ": " + this.texto;

    }
} 
