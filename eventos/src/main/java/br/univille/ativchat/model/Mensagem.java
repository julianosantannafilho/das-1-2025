package br.univille.ativchat.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mensagem{
    
    private String nome;
    private String texto;

    @Override
    public String toString() {
        return this.nome+ ": " + this.texto;

    }
} 
