package BookStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Admin {
    static String adminUserName = "admin";
    static String adminPassword = "admin01";


    static int kitapID = 0;


    public void adminMenu() throws InterruptedException {
        Menuler obje = new Menuler();
        System.out.println();
        System.out.println(BOLD+c_BLUE+"Değerli admin hoşgeldiniz. "+c_RESET);


        System.out.println("1 - Kitap eklemek için ");
        System.out.println("2 - Kitap silmek için ");
        System.out.println("3 - Çalışan eklemek için ");
        System.out.println("4 - Çalışan silmek için ");
        System.out.println("5 - Fiyat güncellemek için ");
        System.out.println("6 - Bir üst menüye dönmek için ");
        System.out.println("7 - Çıkış için ");
        System.out.print("Seçiniz : ");
        String secim = TryCatch.stringGirisi();

        switch (secim) {

            case "1" : bookAdding();     break;
            case "2" : bookDeleting();   break;
            case "3" : workerAdding();   break;
            case "4" : workerDeleting(); break;
            case "5" : priceUpdate();    break;
            case "6" : obje.anaMenu();   break;
            case "7" : System.out.println("\nÇıkış yapıyorsunuz. Iyi günler dileriz");
            break; default: System.out.println(BOLD + c_RED + "\n*** Hatalı Giriş. Yeniden Deneyin ***" + c_RESET);
            adminMenu();
            break;
        }


    }

    public void bookAdding() throws InterruptedException {

        Scanner scan = new Scanner(System.in);

        System.out.println("\nKitap kayıt sayfasındasınız..");
        System.out.print("Eklemek istediğiniz kitabın adını gir : ");
        String ad = TryCatch.stringGirisi();

        Enum bookType = kitapTuruBul();

        System.out.print("Yazar adı giriniz : ");
        String name = TryCatch.stringGirisi();

        System.out.print("Fiyat giriniz : ");
        double fiyat = scan.nextDouble();

        System.out.print("Basım yılı giriniz : ");
        String yil = TryCatch.stringGirisi();

        System.out.print("Yayın evi giriniz : ");
        String yayinEvi = TryCatch.stringGirisi();

        kitapID++;
        PojoKitap obje = new PojoKitap(kitapID,ad,bookType,name,fiyat,yil,yayinEvi);
        Mapler.kitaplarMap.put(kitapID,obje);
        System.out.println(BOLD+c_GREEN+"\nKayıt başarıyla yapıldı."+c_RESET);


        adminMenu();

    }

    public void bookDeleting() throws InterruptedException {
        System.out.print("\nSilmek istediğiniz kitabın numarasını giriniz : ");
        int no = TryCatch.intGirisi();

        if (Mapler.kitaplarMap.containsKey(no)) {
            System.out.println(Mapler.kitaplarMap.get(no).getKitapAdi()+" kitabı silindi.");
            Mapler.kitaplarMap.remove(no);

        }
        else {
            System.out.println("Girilen kitap numarası bulunamadı..");
        }
        adminMenu();

    }
    public void workerAdding() throws InterruptedException {
        System.out.println("\nPersonel ekleme sayfasındasınız..");
        System.out.print("Personel adı ve soyadı giriniz : ");
        String adSoyad = TryCatch.stringGirisi();

        System.out.print("Sicil no giriniz (4 haneli) : ");
        String sicilNo = TryCatch.stringGirisi();

        System.out.print("Statüsünü giriniz : ");
        String statu = TryCatch.stringGirisi();

        PojoCalisan obje = new PojoCalisan(adSoyad,sicilNo,statu);
        Mapler.calisanlarMap.put(sicilNo,obje);

        System.out.println(BOLD+c_GREEN+"\nKayıt başarıyla yapıldı."+c_RESET);

        adminMenu();
    }
    public void workerDeleting() throws InterruptedException {
        System.out.print("\nSilmek istediğiniz çalışanın sicil numarasını giriniz : ");
        String sNo = TryCatch.stringGirisi();

        if (Mapler.calisanlarMap.containsKey(sNo)) {
            System.out.println(Mapler.calisanlarMap.get(sNo).getAdSoyad()+ " adli çalışanın kaydı silinmiştir.");
            Mapler.calisanlarMap.remove(sNo);
        }
        else {
            System.out.println("Girilen sicil numarası bulunamadı..");
        }

        adminMenu();
    }
    public void priceUpdate() throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        System.out.print("\nFiyatını güncellemek istediğiniz kitabın numarasını giriniz : ");
        int iD = TryCatch.intGirisi();

        if (Mapler.kitaplarMap.containsKey(iD)) {
            System.out.print("Yeni fiyatı giriniz : ");
            double fiyat = scan.nextDouble();
            Mapler.kitaplarMap.get(iD).setFiyat(fiyat);
            System.out.println(BOLD+c_GREEN+"\nFiyat başarıyla güncellendi."+c_RESET);

        }
        else {
            System.out.println("Girilen kitap numarası bulunamadı..");
        }

        adminMenu();
    }
    private Enum kitapTuruBul() throws InterruptedException {
        Enum kitapTur = Enum.DENEME;
        ArrayList<String> list = new ArrayList<>(Arrays.asList("ROMAN","HIKAYE","COCUKKITABI","AKADEMIK", "SINAVHAZIRLIK", "YABANCIDIL", "SECONDHAND"));
        System.out.println(list);
        System.out.print("Bu kitap türlerinden birini seçiniz : ");
        String type = TryCatch.stringGirisi();
        type = type.replace(" ","");

        if (type.equalsIgnoreCase("roman")) kitapTur = Enum.ROMAN;
        else if (type.equalsIgnoreCase("hikaye")) kitapTur = Enum.HIKAYE;
        else if (type.equalsIgnoreCase("çocukkitabı")) kitapTur = Enum.COCUKKITABI;
        else if (type.equalsIgnoreCase("akademik")) kitapTur = Enum.AKADEMIK;
        else if (type.equalsIgnoreCase("sinavhazırlık")) kitapTur = Enum.SINAVHAZIRLIK;
        else if (type.equalsIgnoreCase("yabancıdil")) kitapTur = Enum.YABANCIDIL;
        else if (type.equalsIgnoreCase("secondhand")) kitapTur = Enum.SECONDHAND;
        else System.out.println("Hatalı giriş yaptınız. Tekrar deneyin.");

        return kitapTur;
    }

    static String c_RESET = "\u001B[0m";
    static String BOLD = "\033[0;1m";
    static String c_BLUE = "\u001B[34m";
    static String c_RED = "\u001B[31m";
    static String c_GREEN = "\u001B[32m";






}
