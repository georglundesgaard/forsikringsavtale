package no.lundesgaard.forsikring.forsikringsavtale.integrasjon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste.Brev;
import no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste.Brevtjeneste;
import no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste.Utsendelsesstatus;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtale;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtalenummer;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtalestatus;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Fagsystem;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Kunde;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Kundenummer;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.generator.BrevGenerator;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.mapper.AvtaleMapper;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.mapper.KundeMapper;

import org.junit.jupiter.api.Test;

class ForsikringsavtaleServiceTest {

    @Test
    void opprettAvtale_alt_ok() {
        Forsikringsavtale forsikringsavtale = Forsikringsavtale.builder().build();
        Kunde kunde = Kunde.builder().build();
        Kundenummer kundenummer = new Kundenummer("12345678");
        Avtale avtale = Avtale.builder().build();
        Avtalenummer avtalenummer = new Avtalenummer("HUS-12345678");
        Brev brev =  new Brev();
        Utsendelsesstatus utsendelsesstatus = Utsendelsesstatus.builder().build();
        Avtalestatus avtalestatusSendt = Avtalestatus.AVTALE_SENDT;

        Fagsystem fagsystem = mock(Fagsystem.class);
        Brevtjeneste brevtjeneste = mock(Brevtjeneste.class);
        KundeMapper kundeMapper = mock(KundeMapper.class);
        AvtaleMapper avtaleMapper = mock(AvtaleMapper.class);
        BrevGenerator brevGenerator = mock(BrevGenerator.class);
        ForsikringsavtaleService service = new ForsikringsavtaleService(fagsystem, brevtjeneste, kundeMapper, avtaleMapper, brevGenerator);
        
        when(fagsystem.opprettKunde(kunde)).thenReturn(kundenummer);
        when(fagsystem.opprettAvtale(avtale)).thenReturn(avtalenummer);
        when(fagsystem.oppdaterStatus(avtalenummer, avtalestatusSendt)).thenReturn(avtalestatusSendt);
        when(brevtjeneste.sendBrev(brev)).thenReturn(utsendelsesstatus);
        when(kundeMapper.toKunde(forsikringsavtale)).thenReturn(kunde);
        when(avtaleMapper.tilAvtale(kundenummer, forsikringsavtale)).thenReturn(avtale);
        when(brevGenerator.genererAvtalebrev(kunde, avtalenummer, avtale)).thenReturn(brev);

        ForsikringsavtaleInfo forsikringsavtaleInfo = service.opprettAvtale(forsikringsavtale);
        
        assertThat(forsikringsavtaleInfo).isNotNull();
        assertThat(forsikringsavtaleInfo.getForsikringsavtalenummer()).isEqualTo(new Forsikringsavtalenummer("HUS-12345678"));
        assertThat(forsikringsavtaleInfo.getForsikringsavtaleStatus()).isEqualTo(ForsikringsavtaleStatus.AVTALE_SENDT);
    }
}
