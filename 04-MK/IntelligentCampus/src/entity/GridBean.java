package entity;

import java.util.List;

public class GridBean<T>{
    private int status;
    private String msg;
    private int total;
    private List<T> rows;
    public GridBean(){}
    public GridBean(int status, String msg, int total, List<T> rows) {
        this.status = status;
        this.msg = msg;
        this.total = total;
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "GridBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", total=" + total +
                ", rows=" + rows +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
