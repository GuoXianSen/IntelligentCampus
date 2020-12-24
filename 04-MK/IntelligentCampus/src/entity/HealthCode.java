package entity;

public class HealthCode {
    private int userid;
    private String sno;
    private String phonenumber;
    private String username;
    private String healthstatus;
    private String healthcodeimg;
    private String healthInfo;

    public HealthCode() {
    }

    public HealthCode(int userid, String sno, String phonenumber, String username, String healthstatus, String healthcodeimg, String healthInfo) {
        this.userid = userid;
        this.sno = sno;
        this.phonenumber = phonenumber;
        this.username = username;
        this.healthstatus = healthstatus;
        this.healthcodeimg = healthcodeimg;
        this.healthInfo = healthInfo;
    }

    @Override
    public String toString() {
        return "HealthCode{" +
                "userid=" + userid +
                ", sno='" + sno + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", username='" + username + '\'' +
                ", healthstatus='" + healthstatus + '\'' +
                ", healthcodeimg='" + healthcodeimg + '\'' +
                ", healthInfo='" + healthInfo + '\'' +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHealthstatus() {
        return healthstatus;
    }

    public void setHealthstatus(String healthstatus) {
        this.healthstatus = healthstatus;
    }

    public String getHealthcodeimg() {
        return healthcodeimg;
    }

    public void setHealthcodeimg(String healthcodeimg) {
        this.healthcodeimg = healthcodeimg;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo = healthInfo;
    }
}
