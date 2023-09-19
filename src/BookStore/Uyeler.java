package BookStore;

public class Uyeler {
    static final String uyeUserName = "uye";
    static final String uyePassword = "uye01";
    static int uyeNo = 199;

    public void uyelerMenu() throws InterruptedException {
        Menuler obje = new Menuler();
        System.out.println();
        System.out.println(BOLD+c_BLUE+"Değerli üyemiz hoşgeldiniz. "+c_RESET);
        System.out.println("1 - Alışveriş yapmak için ");
        System.out.println("2 - Kampanyalar hakkında bilgi almak için ");
        System.out.println("3 - Bir üst menüye dönmek için ");
        System.out.println("4 - Çıkış için ");
        System.out.print("Seçiniz : ");

        String secim = TryCatch.stringGirisi();

        switch (secim) {

            case "1" : uyeAlisveris(); break;
            case "2" : kampanyaBilgilendirme();break;
            case "3" : obje.anaMenu(); break;
            case "4" :
                System.out.println("\nÇıkış yapıyorsunuz. Iyi günler dileriz");
                break;
            default: System.out.println(BOLD + c_RED + "\n*** Hatalı Giriş. Yeniden Deneyin ***" + c_RESET);
                uyelerMenu();
                break;
        }


    }
    public void kampanyaBilgilendirme() throws InterruptedException {
        System.out.println(BOLD+"\n\t *** KAMPANYALAR *** "+c_RESET);
        System.out.println("Yeni üye olanalara özel tek seferlik %25 indirim");
        System.out.println("Yılbaşına özel %10 indirim");

        uyelerMenu();


    }
    public void uyeAlisveris() throws InterruptedException {

        System.out.print("\nAdınızı giriniz : ");
        String adSoyad = TryCatch.stringGirisi();

        System.out.print("Üye numaranızı giriniz : ");
        String uyeNo = TryCatch.stringGirisi();


        System.out.print("Kitap adını giriniz : ");
        String kitapAdi = TryCatch.stringGirisi();

        PojoAlisVeris obje = new PojoAlisVeris(uyeNo,adSoyad,kitapAdi);
        Mapler.uyeAlisVerisMap.put(uyeNo,obje);
        uyelerMenu();


    }
    public void uyeEkle() throws InterruptedException {

        System.out.println("\nÜye kayıt sayfasındasınız..");
        System.out.print("Adınız ve Soyadınız : ");
        String name = TryCatch.stringGirisi();

        System.out.print("Yaşınız : ");
        String yas = TryCatch.stringGirisi();

        uyeNo++;
        String uyeNumarasi = String.valueOf(uyeNo);

        PojoUye obje = new PojoUye(uyeNumarasi,name,yas);
        Mapler.uyelerMap.put(uyeNumarasi,obje);
        System.out.println(c_RED+"\nÜye kaydı başarıyla yapılmıştır. \n"+c_RESET);

        Menuler ob = new Menuler();
        ob.anaMenu();

    }

    static String c_RESET = "\u001B[0m";
    static String BOLD = "\033[0;1m";
    static String c_BLUE = "\u001B[34m";
    static String c_RED = "\u001B[31m";
    static String c_GREEN = "\u001B[32m";

}
