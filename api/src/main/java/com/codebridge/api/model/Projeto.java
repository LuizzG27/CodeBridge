package com.codebridge.api.model;

import com.codebridge.api.dto.PropostaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projeto {
    private Long id;
    private String titulo;
    private String descricao;
    private Double orcamento;
    private List<PropostaDTO> propostas = new ArrayList<>();

    public Projeto(Long id, String titulo, String descricao, Double orcamento) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.orcamento = orcamento;
    }
}