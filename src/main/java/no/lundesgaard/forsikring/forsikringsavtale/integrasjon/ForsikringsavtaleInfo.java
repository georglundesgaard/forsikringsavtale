package no.lundesgaard.forsikring.forsikringsavtale.integrasjon;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForsikringsavtaleInfo {
    private final Forsikringsavtalenummer forsikringsavtalenummer;
    private final ForsikringsavtaleStatus forsikringsavtaleStatus;
}
