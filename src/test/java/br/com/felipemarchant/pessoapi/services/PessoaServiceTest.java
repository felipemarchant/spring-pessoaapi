package br.com.felipemarchant.pessoapi.services;

import br.com.felipemarchant.pessoapi.dto.mapper.PessoaMapper;
import br.com.felipemarchant.pessoapi.dto.request.PessoaDTO;
import br.com.felipemarchant.pessoapi.dto.response.MensagemResponseDTO;
import br.com.felipemarchant.pessoapi.entities.Pessoa;
import br.com.felipemarchant.pessoapi.utils.PessoaUtils;
import br.com.felipemarchant.pessoapi.repositories.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @Mock
    private PessoaMapper pessoaMapper;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testGivenPessoaDTOThenReturnSuccessSavedMessage() {
        PessoaDTO pessoaDTO = PessoaUtils.createFakeDTO();
        Pessoa expectedSavedPessoa = PessoaUtils.createFakeEntity();

        when(pessoaMapper.toModel(pessoaDTO)).thenReturn(expectedSavedPessoa);
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(expectedSavedPessoa);

        MensagemResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPessoa.getId());
        MensagemResponseDTO successMessage = pessoaService.create(pessoaDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MensagemResponseDTO createExpectedSuccessMessage(Long savedPessoaId) {
        return MensagemResponseDTO.builder()
                .mensagem("Pessoa criada com sucesso, ID: " + savedPessoaId)
                .build();
    }

}
