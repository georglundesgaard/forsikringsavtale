package no.lundesgaard.forsikring.forsikringsavtale.fagsystem;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Avtale {
    private final Kundenummer kundenummer;
    private final Avtaletype avtaletype;
    private final int forsikringssum;
}
