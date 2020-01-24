package no.lundesgaard.forsikring.forsikringsavtale.integrasjon.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste.Brev;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtale;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtalenummer;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Kunde;

import org.junit.jupiter.api.Test;

class BrevGeneratorTest {

    @Test
    void genererAvtalebrev_alt_ok() {
        Kunde kunde = Kunde.builder().build();
        Avtalenummer avtalenummer = new Avtalenummer("HUS-12345678");
        Avtale avtale = Avtale.builder().build();

        Brev brev = new BrevGenerator().genererAvtalebrev(kunde, avtalenummer, avtale);
        
        assertThat(brev).isNotNull();
        // TODO - utvid test med flere felter for brev
    }
    
    // TODO - legg på test-varianter inkl. data med feil
}
