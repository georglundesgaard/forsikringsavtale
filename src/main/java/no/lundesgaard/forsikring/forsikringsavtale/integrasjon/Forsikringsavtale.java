package no.lundesgaard.forsikring.forsikringsavtale.integrasjon;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Forsikringsavtale {
    private final Forsikringsavtalekunde kunde;
    private final Forsikringasvtaletype type;
    private final int forsikringssum;
}
