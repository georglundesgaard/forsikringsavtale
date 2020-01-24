package no.lundesgaard.forsikring.forsikringsavtale.brevtjeneste;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BrevtjenesteTest {

    @Test
    void sendBrev_alt_ok() {
        Utsendelsesstatus utsendelsesstatus = new Brevtjeneste().sendBrev(new Brev());
        assertThat(utsendelsesstatus).isNotNull();
        assertThat(utsendelsesstatus.getUtsendelsesstatuskode()).isEqualTo(Utsendelsesstatuskode.UTSENDELSE_OK);
        assertThat(utsendelsesstatus.getMelding()).isEqualTo("Brev sendt");
    }
}
