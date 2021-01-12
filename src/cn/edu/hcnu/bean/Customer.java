package cn.edu.hcnu.bean;


public class Customer {
    private int id;
    private String name;
    private String phone;
    private String cardid;//身份证号
    private String birthDAte;//出生日期

    public Customer(){
        super();
    }

    public Customer(int id, String name, String phone, String cardid,String  birthDAte) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.cardid = cardid;
        this.birthDAte = birthDAte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getBirthDAte() {
        return birthDAte;
    }

    public void setBirthDAte(String birthDAte) {
        this.birthDAte = birthDAte;
    }
}
