package Test;

import org.junit.jupiter.api.Test;

public class LcWaikikiTest extends BaseTest {

    @Test
    public void test(){

        homePage
                .anasayfayaGit()
                .anasayfaKontrol()
                .girisSayfasinaGit()
                .girisYap("osmanimsi@hotmail.com","1q2w3e4r5t6y7u")
                .girisKontrol()
                .aramaYap("pantolon")
                .scrollDown()
                .dahaFazlaUrun()
                .urunSec()
                .sepeteEkle()
                .sepeteGit()
                .fiyatKontrol()
                .urunEkle()
                .adetKontrol()
                .urunSil()
                .sonKontrol();

    }
}
