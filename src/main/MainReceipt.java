package main;

import Manage.BicycleManage;
import Manage.ReceiptManage;
import model.Receipt;

import java.util.Scanner;

public class MainReceipt {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ReceiptManage receiptManage =new ReceiptManage();
        BicycleManage bicycleManage =new BicycleManage();
        int choice = -1;
        System.out.println ("*=*=*=*=*=*=*=*=*=*=*=*Menu Hóa Đơn=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println ("*-1 - Hiển thị danh sách hóa đơn                       =*");
        System.out.println ("*-2 - Thêm hóa đơn                                     =*");
        System.out.println ("*-3 - Sửa thông tin hóa đơn theo số CMND của khách     =*");
        System.out.println ("*-4 - Tính tiền hóa đơn - Xóa luôn hóa đơn             =*");
        System.out.println ("*-5 - Xuất hoá đơn(xuất file csv)                      =*");
        System.out.println ("*-6 - Xem lại Menu!                                    =*");
        System.out.println ("*-7 - Thoát                                            =*");
        System.out.println ("*-                mời nhập lựa chọn của bạn            =*");
        System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");

        do {

            do {

                try {
                    choice = sc.nextInt();
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println(" chỉ nhập số");
                    sc.nextLine();
                    choice = -1;

                }
            } while (choice < 1 || choice > 7);

            switch (choice) {
                case 1:
                    System.out.println("======Danh Sách Hóa Đơn===== ");

                    bicycleManage.display();
                    break;
                case 2:
                    System.out.println("Mời nhập vào thông tin hóa đơn");
                    System.out.println(" Nhập số CMND của khách thuê xe");
                    String identity =sc.nextLine();

                    System.out.println(" Nhập họ tên của khách thuê xe");
                    String name = sc.nextLine();
                    double borrowedTime = -1;
                    boolean  check =false;
                    while (!check) {
                        System.out.println("Nhập thời gian khách thuê xe");
                        try {
                            borrowedTime =sc.nextDouble();
                            check = true;
                        } catch (Exception e) {
                            System.out.println( "Chỉ được nhập số");
                            sc.nextLine();
                        }
                    }
                    double payTime =-1;
                    boolean check1 = false;
                    while (!check1) {
                        System.out.println("Nhập thời gian khách trả xe");
                        try {
                            payTime =sc.nextDouble();
                            check1 = true;
                        } catch (Exception e) {
                            System.out.println("Chỉ được nhập số");
                            sc.nextLine();
                        }
                    }
                    System.out.println("chọn xe khách thuê : (chọn id xe)");
                    bicycleManage.display();
                    int indexOfBicycle =sc.nextInt();
                    receiptManage.addReceipt(new Receipt(identity,name,borrowedTime,payTime,BicycleManage.bicycleList.get(bicycleManage.findIndexById(indexOfBicycle))));

                    break;
                case 3:
                    System.out.println("nhập số CMND của hóa đơn muốn sửa");
                    break;
                case 4:
                    System.out.println(" Nhập id xe muốn xóa");
                    String identity2 = sc.nextLine();
                    receiptManage.deleteReceipt(identity2);
                    System.out.println(" Xóa thành công");
                    break;
                case 5:
                    bicycleManage.deleteAll();
                    System.out.println("----------Danh sách trống--------------");
                    break;
                case 6:
                    receiptManage.displayMenu();
                    break;

                case 7:
                    System.exit(0);
                    break;
            }
        } while (choice >= 1 && choice <= 7);
    }
}
