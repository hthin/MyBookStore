package BookStore;

public class PojoAlisVeris {

    private String uyeNo;
    private String uyeAdi;
    private String kitapAdi;

    public PojoAlisVeris(String uyeNo, String uyeAdi, String kitapAdi) {
        this.uyeNo = uyeNo;
        this.uyeAdi = uyeAdi;
        this.kitapAdi = kitapAdi;
    }



    public String getUyeNo() {
        return uyeNo;
    }

    public void setUyeNo(String uyeNo) {
        this.uyeNo = uyeNo;
    }

    public String getUyeAdi() {
        return uyeAdi;
    }

    public void setUyeAdi(String uyeAdi) {
        this.uyeAdi = uyeAdi;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }
}
