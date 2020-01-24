package no.lundesgaard.forsikring.forsikringsavtale.fagsystem;

import org.springframework.stereotype.Service;

@Service
public class Fagsystem {
    public Kundenummer opprettKunde(Kunde kunde) {
        return new Kundenummer("12345678");
    }
    
    public Avtalenummer opprettAvtale(Avtale avtale) {
        return new Avtalenummer(avtale.getAvtaletype() + "-12345678");
    }
    
    public Avtalestatus oppdaterStatus(Avtalenummer avtalenummer, Avtalestatus avtalestatus) {
        return avtalestatus;
    }
}
