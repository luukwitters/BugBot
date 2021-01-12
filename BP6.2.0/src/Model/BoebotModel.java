package Model;

import TI.Servo;

public class BoebotModel {

    public int ix;
    public int iy;
    public String richting;

    public BoebotModel(int ix, int iy, String richting) {
        this.ix = ix;
        this.iy = iy;
        this.richting = richting;
    }

    public int getIx() {
        return ix;
    }

    public void setIx(int ix) {
        this.ix = ix;
    }

    public int getIy() {
        return iy;
    }

    public void setIy(int iy) {
        this.iy = iy;
    }

    public String getRichting() {
        return richting;
    }

    public void setRichting(String richting) {
        this.richting = richting;
    }

    @Override
    public String toString() {
        return "BoebotModel{" +
                "ix=" + ix +
                ", iy=" + iy +
                ", richting='" + richting + '\'' +
                '}';
    }
}
