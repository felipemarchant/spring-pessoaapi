package br.com.felipemarchant.pessoapi.services;

import br.com.felipemarchant.pessoapi.dto.mapper.PessoaMapper;
import br.com.felipemarchant.pessoapi.dto.request.PessoaDTO;
import br.com.felipemarchant.pessoapi.dto.response.MensagemResponseDTO;
import br.com.felipemarchant.pessoapi.entities.Pessoa;
import lombok.AllArgsConstructor;
import br.com.felipemarchant.pessoapi.exception.PessoaNotFoundException;
import br.com.felipemarchant.pessoapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper;

    public MensagemResponseDTO create(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(pessoa);

        return createMessageResponse("Pessoa criada com sucesso, ID: ", savedPessoa.getId());
    }

    public PessoaDTO findById(Long id) throws PessoaNotFoundException {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        return pessoaMapper.toDTO(pessoa);
    }

    public List<PessoaDTO> listAll() {
        List<Pessoa> people = pessoaRepository.findAll();
        return people.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MensagemResponseDTO update(Long id, PessoaDTO pessoaDTO) throws PessoaNotFoundException {
        pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        Pessoa updatedPessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(updatedPessoa);

        return createMessageResponse("Pessoa atualizado com sucesso, ID: ", savedPessoa.getId());
    }

    public void delete(Long id) throws PessoaNotFoundException {
        pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));

        pessoaRepository.deleteById(id);
    }

    private MensagemResponseDTO createMessageResponse(String s, Long id2) {
        return MensagemResponseDTO.builder()
                .mensagem(s + id2)
                .build();
    }
}
