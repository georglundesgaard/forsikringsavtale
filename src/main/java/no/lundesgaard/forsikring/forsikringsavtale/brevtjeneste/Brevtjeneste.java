package no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste;

import static no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste.Utsendelsesstatuskode.UTSENDELSE_OK;

import org.springframework.stereotype.Service;

@Service
public class Brevtjeneste {
    public Utsendelsesstatus sendBrev(Brev brev) {
        return new Utsendelsesstatus(UTSENDELSE_OK, "Brev sendt");
    }
}
