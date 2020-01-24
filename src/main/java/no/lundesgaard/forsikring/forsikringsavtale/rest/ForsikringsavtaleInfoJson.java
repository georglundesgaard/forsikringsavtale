package no.lundesgaard.forsikring.forsikringsavtale.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForsikringsavtaleInfoJson {
    private String avtalenummer;
    private String status;
}
