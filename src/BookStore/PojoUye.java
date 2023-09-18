package BookStore;

public class PojoUye {

    private String adSoyad;
    private String uyeNo;
    private String yas;

    public PojoUye(String adSoyad, String uyeNo, String yas) {
        this.adSoyad = adSoyad;
        this.uyeNo = uyeNo;
        this.yas = yas;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getUyeNo() {
        return uyeNo;
    }

    public void setUyeNo(String uyeNo) {
        this.uyeNo = uyeNo;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

}
