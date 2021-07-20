package br.com.felipemarchant.pessoapi.dto.mapper;

import br.com.felipemarchant.pessoapi.dto.request.PessoaDTO;
import br.com.felipemarchant.pessoapi.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    @Mapping(target = "dataAniversario", source = "dataAniversario", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO dto);

    PessoaDTO toDTO(Pessoa dto);
}
