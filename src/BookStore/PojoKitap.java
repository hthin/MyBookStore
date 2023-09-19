package BookStore;

public class PojoKitap {

    private  int kitapID;
    private String kitapAdi;
    private Enum kitapTuru; // enum olarak
    private String yazarAdi;
    private double fiyat;
    private String basimYili;
    private String yayinEvi;

    public PojoKitap(int kitapID, String kitapAdi, Enum kitapTuru, String yazarAdi, double fiyat, String basimYili, String yayinEvi) {
        this.kitapID = kitapID;
        this.kitapAdi = kitapAdi;
        this.kitapTuru = kitapTuru;
        this.yazarAdi = yazarAdi;
        this.fiyat = fiyat;
        this.basimYili = basimYili;
        this.yayinEvi = yayinEvi;
    }

    public PojoKitap() {
    }

    public int getKitapID() {
        return kitapID;
    }

    public void setKitapID(int kitapID) {
        this.kitapID = kitapID;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public Enum getKitapTuru() {
        return kitapTuru;
    }

    public void setKitapTuru(Enum kitapTuru) {
        this.kitapTuru = kitapTuru;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public String getBasimYili() {
        return basimYili;
    }

    public void setBasimYili(String basimYili) {
        this.basimYili = basimYili;
    }

    public String getYayinEvi() {
        return yayinEvi;
    }

    public void setYayinEvi(String yayinEvi) {
        this.yayinEvi = yayinEvi;
    }

}
