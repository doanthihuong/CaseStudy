package model;

public class Receipt {//borrowed time : thời gian thuê
    // pay time :  thời gian trả
    private int identity;
    private String name;
    private double borrowedTime;
    private double payTime;
    private Bicycle bicycle;

    public Receipt() {
    }

    public Receipt(int identity, String name, double borrowedTime,double payTime, Bicycle bicycle) {
        this.identity = identity;
        this.name = name;
        this.borrowedTime = borrowedTime;
        this.payTime = payTime;
        this.bicycle = bicycle;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBorrowedTime() {
        return borrowedTime;
    }

    public void setBorrowedTime(int borrowedTime) {
        this.borrowedTime = borrowedTime;
    }

    public double getPayTime() {
        return payTime;
    }

    public void setPayTime(int payTime) {
        this.payTime = payTime;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public String toString() {
        return "Receipt: " +
                "identity: " + identity +
                ", name : " + name +
                ", borrowedTime: " + borrowedTime +
                ", payTime: " + payTime +
                ", bicycle: " + bicycle ;
    }

}
