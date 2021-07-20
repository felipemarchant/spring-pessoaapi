package br.com.felipemarchant.pessoapi.mapper;

import br.com.felipemarchant.pessoapi.dto.mapper.PessoaMapper;
import br.com.felipemarchant.pessoapi.dto.request.PessoaDTO;
import br.com.felipemarchant.pessoapi.dto.request.TelefoneDTO;
import br.com.felipemarchant.pessoapi.entities.Pessoa;
import br.com.felipemarchant.pessoapi.entities.Telefone;
import br.com.felipemarchant.pessoapi.utils.PessoaUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PessoaMapperTest {

    @Autowired
    private PessoaMapper pessoaMapper;

    @Test
    void testGivenPessoaDTOThenReturnPessoaEntity() {
        PessoaDTO pessoaDTO = PessoaUtils.createFakeDTO();
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);

        assertEquals(pessoaDTO.getSobrenome(), pessoa.getSobrenome());
        assertEquals(pessoaDTO.getSobrenome(), pessoa.getSobrenome());
        assertEquals(pessoaDTO.getCpf(), pessoa.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefoneDTO.getTipo(), telefone.getTipo());
        assertEquals(telefoneDTO.getNumero(), telefone.getNumero());
    }

    @Test
    void testGivenPessoaEntityThenReturnPessoaDTO() {
        Pessoa pessoa = PessoaUtils.createFakeEntity();
        PessoaDTO pessoaDTO = pessoaMapper.toDTO(pessoa);

        assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        assertEquals(pessoa.getSobrenome(), pessoaDTO.getSobrenome());
        assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());

        Telefone telefone = pessoa.getTelefones().get(0);
        TelefoneDTO telefoneDTO = pessoaDTO.getTelefones().get(0);

        assertEquals(telefone.getTipo(), telefoneDTO.getTipo());
        assertEquals(telefone.getNumero(), telefoneDTO.getNumero());
    }
}
