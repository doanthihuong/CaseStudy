package model;

public class Receipt {//borrowed time : thời gian thuê
    // pay time :  thời gian trả
    private int identity;
    private String name;
    private double borrowedTime;
    private double payTime;
    private double cost;
    private Bicycle bicycle;

    public Receipt() {
    }

    public Receipt(int identity, String name, double borrowedTime, double payTime, double cost, Bicycle bicycle) {
        this.identity = identity;
        this.name = name;
        this.borrowedTime = borrowedTime;
        this.payTime = payTime;
        this.cost = cost;
        this.bicycle = bicycle;
    }

    public Receipt(int identity, String name, double borrowedTime, double payTime, Bicycle bicycle) {
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

    public double getCost() {
        return (this.payTime - this.borrowedTime) * bicycle.getRentCost();
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public String toString() {
        System.out.printf("\"| %-7s| %-7s| %-7s| %-7s| %-7s| %-7s| %-7s|%-7s|\n\"","Số CMND","Tên","Tg MƯỢN","Tg TRẢ","ID XE","BIỂN SỐ","GIÁ/GIỜ","TỔNG TIỀN");
        System.out.println("------------------------------------------------------------------------");
        return String.format("\"| %-7s| %-7s| %-7s| %-7s| %-7s| %-7s| %-7s|%-7s|\n\"",identity,name,borrowedTime,payTime,bicycle.getId(),bicycle.getLicensePlate(),bicycle.getRentCost(),getCost());
    }

}
