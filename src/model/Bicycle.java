package model;

public class Bicycle {  //License plate: biển số
    private int id;
    private String licensePlate;
    private String color;
    private String status;
    private int rentCost;

    public Bicycle() {
    }

    public Bicycle(int id, String licensePlate, String color, String status, int rentCost) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.color = color;
        this.status = status;
        this.rentCost = rentCost;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(int rentCost) {
        this.rentCost = rentCost;
    }


    @Override
    public String toString() {
        System.out.printf("\"| %-10s| %-10s| %-10s| %-10s| %-10s|\n\"", "ID", "BIỂN SỐ", " MÀU SẮC", "TRẠNG THÁI", "GIÁ/GIỜ");
        System.out.println("-------------------------------------------------------------");
        return String.format("\"| %-10s| %-10s| %-10s| %-10s| %-10s|\n\"",id, licensePlate,color,status,rentCost);
    }


}
