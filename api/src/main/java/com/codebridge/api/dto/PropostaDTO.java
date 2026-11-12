package com.codebridge.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropostaDTO {
    private String nomeFreelancer;
    private Double valorProposto;
    private String mensagem;
}