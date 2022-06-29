package member;

import java.math.BigDecimal;

public class MemberAccount {
    private int id;
    private String name;
    private String surname;
    private BigDecimal balance;
    private final String memberCode;
    private String phoneNumber;

    public MemberAccount(int id, String name, String surname, BigDecimal balance,  String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.memberCode = id+name.substring(0,2);
        this.phoneNumber = phoneNumber;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
