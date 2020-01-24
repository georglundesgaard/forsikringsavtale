package no.lundesgaard.forsikring.forsikringsavtale.rest.mapper;

import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringasvtaletype;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtale;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtalekunde;
import no.lundesgaard.forsikring.forsikringsavtale.rest.ForsikringsavtaleJson;
import no.lundesgaard.forsikring.forsikringsavtale.rest.ForsikringsavtalekundeJson;

import org.springframework.stereotype.Component;

@Component
public class ForsikringsavtaleMapper {
    public Forsikringsavtale toForsikringsavtale(ForsikringsavtaleJson forsikringsavtaleJson) {
        return Forsikringsavtale.builder()
                .kunde(forsikringavtalekunde(forsikringsavtaleJson.getKunde()))
                .type(Forsikringasvtaletype.valueOf(forsikringsavtaleJson.getType()))
                .forsikringssum(forsikringsavtaleJson.getForsikringssum())
                .build();
    }

    private Forsikringsavtalekunde forsikringavtalekunde(ForsikringsavtalekundeJson forsikringsavtaleJson) {
        return Forsikringsavtalekunde.builder()
                .fnr(forsikringsavtaleJson.getFnr())
                .navn(forsikringsavtaleJson.getNavn())
                .addresse(forsikringsavtaleJson.getAddresse())
                .epost(forsikringsavtaleJson.getEpost())
                .telefonnummer(forsikringsavtaleJson.getTelefonnummer())
                .build();
    }
}
