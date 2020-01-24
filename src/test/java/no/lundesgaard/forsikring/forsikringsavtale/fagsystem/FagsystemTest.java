package no.lundesgaard.forsikring.forsikringsavtale.fagsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FagsystemTest {

    @Test
    void opprettKunde_alt_ok() {
        Kundenummer kundenummer = new Fagsystem().opprettKunde(Kunde.builder().build());
        assertThat(kundenummer).isEqualTo(new Kundenummer("12345678"));
    }

    @Test
    void opprettAvtale() {
        Avtale avtale = Avtale.builder().
                avtaletype(Avtaletype.HUS)
                .build();
        Avtalenummer avtalenummer = new Fagsystem().opprettAvtale(avtale);
        assertThat(avtalenummer).isEqualTo(new Avtalenummer("HUS-12345678"));
    }

    @Test
    void oppdaterStatus() {
        Avtalestatus avtalestatus = new Fagsystem().oppdaterStatus(new Avtalenummer("HUS-12345678"), Avtalestatus.AVTALE_SENDT);
        assertThat(avtalestatus).isEqualTo(Avtalestatus.AVTALE_SENDT);
    }
}
