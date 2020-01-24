package no.lundesgaard.forsikring.forsikringsavtale.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForsikringsavtalekundeJson {
    private final String fnr;
    private final String navn;
    private final String addresse;
    private final String epost;
    private final String telefonnummer;
}
