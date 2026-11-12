package com.codebridge.api.service;

import com.codebridge.api.dto.ProjetoDTO;
import com.codebridge.api.dto.PropostaDTO;
import com.codebridge.api.exception.NotFoundException;
import com.codebridge.api.model.Projeto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjetoService {

    private final List<Projeto> projetos = new ArrayList<>();
    private Long proximoId = 1L;

    public ProjetoService() {
        projetos.add(new Projeto(proximoId++, "Landing Page para Startup", "Desenvolvimento em React", 2000.00));
    }

    public List<Projeto> listarTodos() {
        return projetos;
    }

    public Projeto buscarPorId(Long id) {
        return projetos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Projeto com ID " + id + " não encontrado."));
    }

    public Projeto criar(ProjetoDTO dto) {
        Projeto projeto = new Projeto(proximoId++, dto.getTitulo(), dto.getDescricao(), dto.getOrcamento());
        projetos.add(projeto);
        return projeto;
    }

    public Projeto atualizar(Long id, ProjetoDTO dto) {
        Projeto projeto = buscarPorId(id);
        projeto.setTitulo(dto.getTitulo());
        projeto.setDescricao(dto.getDescricao());
        projeto.setOrcamento(dto.getOrcamento());
        return projeto;
    }

    public void deletar(Long id) {
        Projeto projeto = buscarPorId(id);
        projetos.remove(projeto);
    }

    public Projeto adicionarProposta(Long id, PropostaDTO propostaDto) {
        Projeto projeto = buscarPorId(id);
        projeto.getPropostas().add(propostaDto);
        return projeto;
    }
}