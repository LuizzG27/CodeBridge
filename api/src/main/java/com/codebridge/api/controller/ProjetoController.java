package com.codebridge.api.controller;

import com.codebridge.api.dto.ProjetoDTO;
import com.codebridge.api.dto.PropostaDTO;
import com.codebridge.api.model.Projeto;
import com.codebridge.api.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<Projeto>> listar() {
        return ResponseEntity.ok(projetoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Projeto> criar(@RequestBody ProjetoDTO dto) {
        Projeto novoProjeto = projetoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProjeto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizar(@PathVariable Long id, @RequestBody ProjetoDTO dto) {
        Projeto projetoAtualizado = projetoService.atualizar(id, dto);
        return ResponseEntity.ok(projetoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        projetoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/propostas")
    public ResponseEntity<Projeto> adicionarProposta(@PathVariable Long id, @RequestBody PropostaDTO propostaDto) {
        Projeto projetoAtualizado = projetoService.adicionarProposta(id, propostaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoAtualizado);
    }
}