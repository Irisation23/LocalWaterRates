package nhn.academy.localwaterrates;

public class WaterBill {

    private int waterBillSeq;
    private String city;
    private String sector;
    private int stage;
    private int unitStart;
    private int unitEnd;
    private int unitPrice;

    public WaterBill(int waterBillSeq, String city, String sector, int stage, int unitStart,
                     int unitEnd, int unitPrice) {
        this.waterBillSeq = waterBillSeq;
        this.city = city;
        this.sector = sector;
        this.stage = stage;
        this.unitStart = unitStart;
        this.unitEnd = unitEnd;
        this.unitPrice = unitPrice;
    }

    public String getCity() {
        return city;
    }

    public String getSector() {
        return sector;
    }

    public int getStage() {
        return stage;
    }

    public int getUnitStart() {
        return unitStart;
    }

    public int getUnitEnd() {
        return unitEnd;
    }

    public int getUnitPrice() {
        return unitPrice;
    }
}
