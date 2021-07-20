package br.com.felipemarchant.pessoapi.utils;

import br.com.felipemarchant.pessoapi.dto.request.PessoaDTO;
import br.com.felipemarchant.pessoapi.entities.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {

    private static final String NOME = "Felipe";
    private static final String SOBRENOME = "Soares";
    private static final String CPF = "141.226.570-32";
    private static final long PESSOA_ID = 1L;
    public static final LocalDate DATA_ANIVERSARIO = LocalDate.of(2006, 12, 31);

    public static PessoaDTO createFakeDTO() {
        return PessoaDTO.builder()
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF)
                .dataAniversario("31-12-2006")
                .telefones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Pessoa createFakeEntity() {
        return Pessoa.builder()
                .id(PESSOA_ID)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(CPF)
                .dataAniversario(DATA_ANIVERSARIO)
                .telefones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }




}
