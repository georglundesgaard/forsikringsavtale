package no.lundesgaard.forsikring.forsikringsavtale.rest;

import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtalekunde;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ForsikringsavtaleJson {
    public ForsikringsavtalekundeJson kunde;
    public String type;
    public int forsikringssum;
}
