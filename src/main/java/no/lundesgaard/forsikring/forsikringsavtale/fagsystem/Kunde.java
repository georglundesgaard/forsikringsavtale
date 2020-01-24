package no.lundesgaard.forsikring.forsikringsavtale.fagsystem;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Kunde {
    private final String fnr;
    private final String navn;
    private final String addresse;
    private final String epost;
    private final String telefonnummer;
}
