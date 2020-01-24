package no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Utsendelsesstatus {
    private final Utsendelsesstatuskode utsendelsesstatuskode;
    private final String melding;
}
