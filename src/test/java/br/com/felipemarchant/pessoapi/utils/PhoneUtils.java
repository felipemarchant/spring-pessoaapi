package br.com.felipemarchant.pessoapi.utils;

import br.com.felipemarchant.pessoapi.dto.request.TelefoneDTO;
import br.com.felipemarchant.pessoapi.enums.TipoTelefone;
import br.com.felipemarchant.pessoapi.entities.Telefone;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final TipoTelefone PHONE_TYPE = TipoTelefone.MOBILE;
    private static final long PHONE_ID = 1L;

    public static TelefoneDTO createFakeDTO() {
        return TelefoneDTO.builder()
                .numero(PHONE_NUMBER)
                .tipo(PHONE_TYPE)
                .build();
    }

    public static Telefone createFakeEntity() {
        return Telefone.builder()
                .id(PHONE_ID)
                .numero(PHONE_NUMBER)
                .tipo(PHONE_TYPE)
                .build();
    }
}
