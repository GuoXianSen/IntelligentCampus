package entity;

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;//用户id
    private String username;//用户名
    private String password;//密码
    private int age;//年龄
    private String sex;//性别
    private String phonenumber;//手机号码
    private String userimg;//用户头像
    private String email;//用户邮箱
    private String college;//用户学院
    private String major;//专业

    public User() {
    }
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", userimg='" + userimg + '\'' +
                ", email='" + email + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public User(int id, String username, String password, int age, String sex, String phonenumber, String userimg, String email, String college, String major) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.phonenumber = phonenumber;
        this.userimg = userimg;
        this.email = email;
        this.college = college;
        this.major = major;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


}
