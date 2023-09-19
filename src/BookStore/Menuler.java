package BookStore;

public class Menuler {
    static String c_RESET = "\u001B[0m";
    static String BOLD = "\033[0;1m";
    static String c_BLUE = "\u001B[34m";
    static String c_RED = "\u001B[31m";
    static String c_GREEN = "\u001B[32m";
    Admin admin = new Admin();
    Uyeler uye = new Uyeler();
    Calisanlar calis = new Calisanlar();
    static int uyeOlmayanlarinID = 99;


    public void anaMenu() throws InterruptedException {
        System.out.println(BOLD + c_BLUE + "====================================");
        System.out.println(" WELCOME TO MY BOOK STORE ");
        System.out.println("====================================");
        System.out.println();
        System.out.println("1 - Admin olarak devam et ");
        System.out.println("2 - Çalışan olarak devam et ");
        System.out.println("3 - Üye olarak devam et ");
        System.out.println("4 - Üye olmadan devam et ");
        System.out.println("5 - Çıkış ");
        System.out.print("Seçiniz : " + c_RESET);

        String secim = TryCatch.stringGirisi();
        switch (secim) {

            case "1":
                System.out.print("\nKullanıcı adını giriniz : ");
                String kullaniciAdi = TryCatch.stringGirisi();
                System.out.print("Şifrenizi giriniz : ");
                String sifre = TryCatch.stringGirisi();
                if (kullaniciAdi.equals(Admin.adminUserName) && sifre.equals(Admin.adminPassword)) {
                    System.out.println(BOLD + c_GREEN + "\nAdmin olarak yönlendiriliyorsunuz." + c_RESET);
                    Thread.sleep(2000);
                    admin.adminMenu();
                }
                else {
                    System.out.println("Kullanıcı adınız ya da şifreniz hatalı. Tekrar deneyin.");
                    anaMenu();
                }
                break;

            case "2":
                System.out.print("\nKullanıcı adını giriniz : ");
                String kk = TryCatch.stringGirisi();
                System.out.print("Şifrenizi giriniz : ");
                String ss = TryCatch.stringGirisi();
                if (kk.equals(Calisanlar.calisanUserName) && ss.equals(Calisanlar.calisanPassword)) {
                    System.out.println(BOLD + c_GREEN + "\nÇalışan olarak yönlendiriliyorsunuz." + c_RESET);
                    Thread.sleep(2000);
                    calis.calisanMenu();

                }
                else {
                    System.out.println("Kullanıcı adınız ya da şifreniz hatalı. Tekrar deneyin.");
                    anaMenu();
                }
                break;

            case "3":
                System.out.print("\nKullanıcı adını giriniz : ");
                String k = TryCatch.stringGirisi();
                System.out.print("Şifrenizi giriniz : ");
                String s = TryCatch.stringGirisi();
                if (k.equals(Uyeler.uyeUserName) && s.equals(Uyeler.uyePassword)) {
                    System.out.println(BOLD + c_GREEN + "\nÜye olarak yönlendiriliyorsunuz." + c_RESET);
                    Thread.sleep(2000);
                    uye.uyelerMenu();

                }else {
                    System.out.println("Kullanıcı adınız ya da şifreniz hatalı. Tekrar deneyin.");
                    anaMenu();
                }
                break;

            case "4":
                System.out.println(BOLD + c_GREEN + "\nÜye olmadan devam ediyorsunuz." + c_RESET);
                Thread.sleep(2000);
                uyeOlmayanlarMenusu();
                break;
            case "5" :
                System.out.println("\nÇıkış yapıyorsunuz. Iyi günler dileriz");
                break;
            default:
                System.out.println(BOLD + c_RED + "\n*** Hatalı Giriş. Yeniden Deneyin ***" + c_RESET);
                anaMenu();
                break;


        }


    }

    public void uyeOlmayanlarMenusu() throws InterruptedException {
        Uyeler obje = new Uyeler();
        System.out.println();
        System.out.println(BOLD+c_BLUE+"Mağazamızda üye olmadan gezmektesiniz. "+c_RESET);
        System.out.println("1 - Alışveriş yapmak için ");
        System.out.println("2 - Kampanyalar hakkında bilgi almak için ");
        System.out.println("3 - Uye olmak için ");
        System.out.println("4 - Bir üst menüye dönmek için ");
        System.out.println("5 - Çıkış için ");
        System.out.print("Seçiniz : ");

        String secim = TryCatch.stringGirisi();

        switch (secim) {
            case "1" : uyeliksizAlisVeris(); break;
            case "2" : kampanyaBilgilendirme(); break;
            case "3" : obje.uyeEkle(); break;
            case "4" : anaMenu(); break;
            case "5" :
                System.out.println("\n Çıkış yapıyorsunuz. Iyi günler dileriz");
                break;
            default: System.out.println(BOLD + c_RED + "\n*** Hatalı Giriş. Yeniden Deneyin ***" + c_RESET);
                uyeOlmayanlarMenusu();
                break;
        }

    }
    public void kampanyaBilgilendirme() throws InterruptedException {
        System.out.println(BOLD+"\n\t *** KAMPANYALAR *** "+c_RESET);
        System.out.println("Yeni üye olanalara özel tek seferlik %25 indirim");
        System.out.println("Yılbaşına özel %10 indirim");

        uyeOlmayanlarMenusu();


    }
    public void uyeliksizAlisVeris() throws InterruptedException {

        System.out.print("\nAdınızı giriniz : ");
        String adSoyad = TryCatch.stringGirisi();

        System.out.print("Kitap adını giriniz : ");
        String kitapAdi = TryCatch.stringGirisi();
        uyeOlmayanlarinID++;
        String uyeOlmayanID = String.valueOf(uyeOlmayanlarinID++);
        PojoAlisVeris obje = new PojoAlisVeris(uyeOlmayanID,adSoyad,kitapAdi);

        Mapler.satisMap.put(uyeOlmayanID,obje);
        Mapler.uyesizAlisVerisMap.put(uyeOlmayanID,obje);
        System.out.println("\n"+Mapler.uyesizAlisVerisMap.get(uyeOlmayanID).getKitapAdi() +" kitabını satın aldınız.");

        uyeOlmayanlarMenusu();

    }



}
