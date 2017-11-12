package kz.kamadi.websocket.model;

public class Product {
    private int id;
    private String cim;
    private String tid;
    private String sgtin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getSgtin() {
        return sgtin;
    }

    public void setSgtin(String sgtin) {
        this.sgtin = sgtin;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", cim='" + cim + '\'' +
                ", tid='" + tid + '\'' +
                ", sgtin='" + sgtin + '\'' +
                '}';
    }
}
