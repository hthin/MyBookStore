package BookStore;

import java.util.Map;
import java.util.Objects;

public class Calisanlar {

    static String calisanUserName = "worker";
    static String calisanPassword = "worker01";

    public void calisanMenu() throws InterruptedException {
        Menuler obje = new Menuler();
        System.out.println(BOLD + c_GREEN + "====================================");
        System.out.println(" ÇALIŞAN SAYFASINA HOŞ GELDİNİZ ");
        System.out.println("====================================");
        System.out.println();
        System.out.println("1 - Kitap satmak için  ");
        System.out.println("2 - Kitapları listelemek için ");
        System.out.println("3 - Üye listesi için ");
        System.out.println("4 - Detaylı satış listesi için ");
        System.out.println("5 - Üye silmek için ");
        System.out.println("6 - Bir üst menüye dönmek için ");
        System.out.println("7 - Çıkış ");
        System.out.print("Seçiniz : " + c_RESET);

        String secim = TryCatch.stringGirisi();

        switch (secim) {

            case "1" : bookSelling();       break;
            case "2" : bookListing();       break;
            case "3" : uyeListing();        break;
            case "4" : detailListing();     break;
            case "5" : uyeDeleting();       break;
            case "6" : obje.anaMenu();      break;
            case "7" :
                System.out.println("\nÇıkış yapıyorsunuz. Iyi günler dileriz");
                break;
            default: System.out.println(BOLD + c_RED + "\n*** Hatalı Giriş. Yeniden Deneyin ***" + c_RESET);
                calisanMenu();
                break;
        }

    }
    public void bookSelling () throws InterruptedException {
        System.out.print("Satmak istediğiniz kitabın ID girin : ");
        int ID = TryCatch.intGirisi();

        if (Mapler.kitaplarMap.containsKey(ID)) {
            System.out.println("Satın alacak kişi üye ise üye numarasını ");
            System.out.print("Üye değil ise (1) olarak girin : ");
            String uyeNumarasi = TryCatch.stringGirisi();
            if (Mapler.uyelerMap.containsKey(uyeNumarasi)) {
                String uyeAdi = Mapler.uyelerMap.get(uyeNumarasi).getAdSoyad();
                String kitapAdi = Mapler.kitaplarMap.get(ID).getKitapAdi();

                PojoAlisVeris obje = new PojoAlisVeris(uyeNumarasi,uyeAdi,kitapAdi);
                Mapler.uyeAlisVerisMap.put(uyeNumarasi,obje);
                Mapler.satisMap.put(uyeNumarasi,obje);
                System.out.println("\nKitap satışı başarıyla yapıldı.");

            }
            else {
                Menuler.uyeOlmayanlarinID++;
                uyeNumarasi = String.valueOf(Menuler.uyeOlmayanlarinID++);
                String kitapAdi = Mapler.kitaplarMap.get(ID).getKitapAdi();
                System.out.print("Satın alacak kişinin adını girin : ");
                String adveSoyad = TryCatch.stringGirisi();

                PojoAlisVeris obje = new PojoAlisVeris(uyeNumarasi,adveSoyad,kitapAdi);
                Mapler.satisMap.put(uyeNumarasi,obje);
                Mapler.uyesizAlisVerisMap.put(uyeNumarasi,obje);
                System.out.println("\nKitap satışı başarıyla yapıldı.");
            }

        }
        else {
            System.out.println("Girilen kitap numarası bulunamadı..");
        }
        calisanMenu();

    }
    public void bookListing () throws InterruptedException {
        if (Mapler.kitaplarMap.size() != 0) {
            System.out.println("\nListelenen tüm kitapları görmektesiniz..");
            System.out.printf(BOLD+c_CYAN+"%20s%20s%20s%20s%20s%16s%22s","Kitap No","Kitap Adı","Kitap Türü","Yazar Adi",
                    "Fiyatı","Basım Yılı","Yayın Evi"+c_RESET);
            System.out.println();
            for (Map.Entry<Integer,PojoKitap> val : Mapler.kitaplarMap.entrySet()) {
                System.out.printf("%20d%20s%20s%20s%20.2f%16s%20s",val.getKey(),val.getValue().getKitapAdi(),val.getValue().getKitapTuru(),
                        val.getValue().getYazarAdi(),val.getValue().getFiyat(),val.getValue().getBasimYili(),val.getValue().getYayinEvi());
                System.out.println();
            }

        }
        else {
            System.out.println(c_PURPLE+"Görüntülenecek kayıt bulunmamaktadır."+c_RESET);
        }

        calisanMenu();


    }
    public void uyeListing () throws InterruptedException { // tüm üyeleri görüntüle
        if (Mapler.uyelerMap.size() != 0) {

            System.out.println("\nListelenen tüm üyeleri görmektesiniz..");
            System.out.printf(BOLD+c_CYAN+"%20s%20s%20s","Üye Numarası","Adı ve Soyadı","Yaşı"+c_RESET);
            System.out.println();
            for(Map.Entry<String, PojoUye> val : Mapler.uyelerMap.entrySet()) {
                System.out.printf("%20s%20s%20s",val.getValue().getAdSoyad(),val.getValue().getUyeNo(),val.getValue().getYas());
                System.out.println();

            }

        }else {
            System.out.println(c_PURPLE+"Görüntülenecek kayıt bulunmamaktadır."+c_RESET);
        }

        calisanMenu();
    }
    public void detailListing() throws InterruptedException { // bir üyenin tüm alışveriş detayını göster
        System.out.println("\nSadece bir üyeye ait satışları listelemek için 1'e");
        System.out.println("Tüm üyelere ait satışları listelemek için 2'ye");
        System.out.println("Tüm satışları listelemek için 3'e");
        System.out.print("Basınız : ");

        String secim = TryCatch.stringGirisi();

        if (secim.equals("1")) {
            System.out.println("\nListeleyeceğiniz kişinin üye numarasını giriniz : ");
            String uyeNo = TryCatch.stringGirisi();

            if (Mapler.uyeAlisVerisMap.size() != 0) {
                if (Mapler.uyeAlisVerisMap.containsKey(uyeNo)) {

                    System.out.printf(BOLD+c_CYAN+"%20s%20s%20s","Üye Numarası","Adı ve Soyadı","Kitap Adı"+c_RESET);
                    System.out.println();
                    for (Map.Entry<String,PojoAlisVeris> val : Mapler.uyeAlisVerisMap.entrySet()) {
                        if (Objects.equals(val.getKey(), uyeNo)) {
                            System.out.printf("%20s%20s%20s",val.getValue().getUyeNo(),val.getValue().getUyeAdi(),val.getValue().getKitapAdi());
                            System.out.println();
                        }

                    }

                }else {
                    System.out.println("Girilen üye numarası bulunamadı..");
                }

            }else {
                System.out.println(c_PURPLE+"Görüntülenecek kayıt bulunmamaktadır."+c_RESET);
            }

        }
        else if (secim.equals("2")) {

            if (Mapler.uyeAlisVerisMap.size() != 0) {
                System.out.println(BOLD+c_CYAN+"\nTüm üyelere ait satışları görmektesiniz.\n"+c_RESET);

                System.out.printf(BOLD+c_CYAN+"%20s%20s%20s","Üye Numarası","Adı ve Soyadı","Kitap Adı"+c_RESET);
                System.out.println();
                for (Map.Entry<String,PojoAlisVeris> val : Mapler.uyeAlisVerisMap.entrySet()) {
                    System.out.printf("%20s%20s%20s",val.getValue().getUyeNo(),val.getValue().getUyeAdi(),val.getValue().getKitapAdi());
                    System.out.println();
                }
            }
            else {
                System.out.println(c_PURPLE+"Görüntülenecek kayıt bulunmamaktadır."+c_RESET);
            }

        }
        else if (secim.equals("3")) {

            if (Mapler.satisMap.size() != 0) {
                System.out.println(BOLD+c_CYAN+"\nTüm yapılan satışları görmektesiniz.\n"+c_RESET);

                System.out.printf(BOLD+c_CYAN+"%20s%20s%20s","Üye Numarası","Adı ve Soyadı","Kitap Adı"+c_RESET);
                System.out.println();
                for (Map.Entry<String,PojoAlisVeris> val : Mapler.satisMap.entrySet()) {
                    System.out.printf("%20s%20s%20s",val.getValue().getUyeNo(),val.getValue().getUyeAdi(),val.getValue().getKitapAdi());
                    System.out.println();
                }
            }
            else {
                System.out.println(c_PURPLE+"Görüntülenecek kayıt bulunmamaktadır."+c_RESET);
            }

        }else {
            System.out.println("Hatalı giriş yaptınız.");
        }
        calisanMenu();

    }
    public void uyeDeleting () throws InterruptedException {
        System.out.print("\nSilmek istediğiniz üyenin numarasını giriniz : ");
        String no = TryCatch.stringGirisi();
        if (Mapler.uyelerMap.containsKey(no)) {
            System.out.println(Mapler.uyelerMap.get(no).getAdSoyad() +" üyesinin kaydı silinmiştir.");
            Mapler.uyelerMap.remove(no);
        }
        else {
            System.out.println("Girilen üye numarası bulunamadı..");
        }

        calisanMenu();

    }

    static String c_RESET = "\u001B[0m";
    static String BOLD = "\033[0;1m";
    static String c_BLUE = "\u001B[34m";
    static String c_RED = "\u001B[31m";
    static String c_GREEN = "\u001B[32m";
    static String c_CYAN   = "\u001B[36m";
    static String c_PURPLE = "\u001B[35m";






}
