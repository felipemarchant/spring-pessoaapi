package br.com.felipemarchant.pessoapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {

    HOME("Residencial"),
    MOBILE("Celular"),
    COMMERCIAL("Comercial");

    private final String descricao;
}
