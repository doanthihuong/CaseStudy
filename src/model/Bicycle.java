package model;

public class Bicycle {  //License plate: biển số
    private int id;
    private String licensePlate;
    private String color;
    private String status;
    private int rentCost;

    public Bicycle() {
    }

    public Bicycle(int id, String licensePlate, int rentCost) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.rentCost = rentCost;
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
        System.out.printf(ANSI_BLUE+"\"| %-10s| %-10s| %-10s| %-10s| %-10s|\n\"", "ID", "BIỂN SỐ", " MÀU SẮC", "TRẠNG THÁI", "GIÁ/GIỜ"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"-------------------------------------------------------------"+ANSI_RESET);
        return String.format("\"| %-10s| %-10s| %-10s| %-10s| %-10s|\n\"",id, licensePlate,color,status,rentCost);
    }



    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

}
