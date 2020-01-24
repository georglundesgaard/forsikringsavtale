package no.lundesgaard.forsikring.forsikringsavtale.integrasjon.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Kunde;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtale;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.Forsikringsavtalekunde;

import org.junit.jupiter.api.Test;

class KundeMapperTest {

    @Test
    void toKunde_alt_ok() {
        KundeMapper kundeMapper = new KundeMapper();
        Forsikringsavtale forsikringsavtale = Forsikringsavtale.builder()
                .kunde(Forsikringsavtalekunde.builder()
                        .fnr("27088725404")
                        .navn("Test Testesen")
                        .addresse("Testveien 100, 1111 Teststad")
                        .epost("test@example.com")
                        .telefonnummer("99999999")
                        .build())
                .build();

        Kunde kunde = kundeMapper.toKunde(forsikringsavtale);
        
        assertThat(kunde).isNotNull();
        assertThat(kunde.getFnr()).isEqualTo("27088725404");
        assertThat(kunde.getNavn()).isEqualTo("Test Testesen");
        assertThat(kunde.getAddresse()).isEqualTo("Testveien 100, 1111 Teststad");
        assertThat(kunde.getEpost()).isEqualTo("test@example.com");
        assertThat(kunde.getTelefonnummer()).isEqualTo("99999999");
    }
    
    // TODO - legg på test-varianter inkl. data med feil
}
