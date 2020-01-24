package no.lundesgaard.forsikring.forsikringsavtale.integrasjon.mapper;

import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Kunde;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtale;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtalekunde;

import org.springframework.stereotype.Component;

@Component
public class KundeMapper {
    public Kunde toKunde(Forsikringsavtale forsikringsavtale) {
        Forsikringsavtalekunde forsikringsavtalekunde = forsikringsavtale.getKunde();
        return Kunde.builder()
                .fnr(forsikringsavtalekunde.getFnr())
                .navn(forsikringsavtalekunde.getNavn())
                .addresse(forsikringsavtalekunde.getAddresse())
                .epost(forsikringsavtalekunde.getEpost())
                .telefonnummer(forsikringsavtalekunde.getTelefonnummer())
                .build();
    }
}
