package BookStore;

public class PojoCalisan {

    private String adSoyad;
    private String sicilNo;
    private String statu;

    public PojoCalisan(String adSoyad, String sicilNo, String statu) {
        this.adSoyad = adSoyad;
        this.sicilNo = sicilNo;
        this.statu = statu;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

}
