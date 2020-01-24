package no.lundesgaard.forsikring.forsikringsavtale.integrasjon;

import no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste.Brev;
import no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste.Brevtjeneste;
import no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste.Utsendelsesstatus;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtale;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Avtalenummer;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Fagsystem;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Kunde;
import no.lundesgaard.forsikring.forsikringsavtale.fagsystem.Kundenummer;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.generator.BrevGenerator;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.mapper.AvtaleMapper;
import no.lundesgaard.forsikring.forsikringsavtale.integrasjon.mapper.KundeMapper;

import org.springframework.stereotype.Service;

@Service
public class ForsikringsavtaleService {
    private final Fagsystem fagsystem;
    private final Brevtjeneste brevtjeneste;
    private final KundeMapper kundeMapper;
    private final AvtaleMapper avtaleMapper;
    private final BrevGenerator brevGenerator;

    public ForsikringsavtaleService(Fagsystem fagsystem, Brevtjeneste brevtjeneste, KundeMapper kundeMapper, AvtaleMapper avtaleMapper, BrevGenerator brevGenerator) {
        this.fagsystem = fagsystem;
        this.brevtjeneste = brevtjeneste;
        this.kundeMapper = kundeMapper;
        this.avtaleMapper = avtaleMapper;
        this.brevGenerator = brevGenerator;
    }

    public ForsikringsavtaleInfo opprettAvtale(Forsikringsavtale forsikringsavtale) {
        Kunde kunde = kundeMapper.toKunde(forsikringsavtale);
        Kundenummer kundenummer = fagsystem.opprettKunde(kunde);
        
        Avtale avtale = avtaleMapper.tilAvtale(kundenummer, forsikringsavtale);
        Avtalenummer avtalenummer = fagsystem.opprettAvtale(avtale);
        
        Brev brev = brevGenerator.genererAvtalebrev(kunde, avtalenummer, avtale);
        Utsendelsesstatus utsendelsesstatus = brevtjeneste.sendBrev(brev);
        
        return ForsikringsavtaleInfo.builder()
                .forsikringsavtalenummer(new Forsikringsavtalenummer(avtalenummer.getAvtalenummer()))
                .forsikringsavtaleStatus(ForsikringsavtaleStatus.AVTALE_SENDT)
                .build();
    }
}
