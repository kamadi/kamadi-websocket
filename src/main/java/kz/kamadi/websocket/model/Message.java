package kz.kamadi.websocket.model;

public class Message {
    private Action action;
    private Parameter parameter;
    private Status status;
    private Product product;
    private String cim;
    private String tid;
    private String sgtin;

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        return "Message{" +
                "action=" + action +
                ", parameter=" + parameter +
                ", status=" + status +
                ", product=" + product +
                ", cim='" + cim + '\'' +
                ", tid='" + tid + '\'' +
                ", sgtin='" + sgtin + '\'' +
                '}';
    }
}
