package no.lundesgaard.forsikring.forsikringsavtale.integrasjon.generator;

import no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste.Brev;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtale;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtalenummer;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Kunde;

import org.springframework.stereotype.Component;

@Component
public class BrevGenerator {
    public Brev genererAvtalebrev(Kunde kunde, Avtalenummer avtalenummer, Avtale avtale) {
        return new Brev();
    }
}
