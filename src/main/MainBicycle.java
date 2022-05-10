package main;

import Manage.BicycleManage;
import model.Bicycle;

import javax.jws.soap.SOAPBinding;
import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class MainBicycle {
    public static void main(String[] args) {

        BicycleManage bicycleManage = new BicycleManage();
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        System.out.println("==========================================================");
        System.out.println("*=*=*=*=*=*=*=MENU QUẢN LÝ CHO THUÊ XE ĐẠP=*=*=*=*=*=*=*=*");
        System.out.println("*-1 -  Hiển thị số lượng xe đạp                         =*");
        System.out.println("*-2 - Thêm 1 xe đạp mới                                 =*");
        System.out.println("*-3 - Sửa thông tin xe theo số i                        =*");
        System.out.println("*-4 - Xóa xe đap theo id                                =*");
        System.out.println("*-5 - Xóa tất cả xe                                     =*");
        System.out.println("*-6 - Hiển thị xe đã cho thuê/ đang rảnh                =*");
        System.out.println("*-7 - Thay đổi trạng thái xe đạp (đang rảnh/đã cho thuê)=*");
        System.out.println("*-8 - Tìm xe theo id xe (hiển thị xe duy nhất)          =*");
        System.out.println("*-9 - Tìm xe theo giá cho thuê                          =*");
        System.out.println("*-10 - Xem lại danh sách Menu                           =*");
        System.out.println("*-11 - Thoát                                            =*");
        System.out.println("*-                Mời nhập lựa chọn của bạn             =*");
        System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");

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
            } while (choice < 1 || choice > 11);

            switch (choice) {
                case 1:
                    System.out.println("ABCgaisha");
                    System.out.println("======Danh Sách Xe đạp điện cho thuê=======");
                    bicycleManage.display();
                    System.out.println("==============THÊM thành công===============");
                    System.out.println(" Mời nhập lựa chọn của bạn");
                    break;
                case 2:
                    System.out.println(" Nhâp thông tin xe mới");
                    int id = -1;
                    boolean check1 = false;
                    while (!check1) {
                        System.out.println(" nhập id xe mới");
                        try {
                            id = sc.nextInt();

                            check1 = true;
                        } catch (Exception e) {
                            System.out.println(" SOS!chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }
                    sc.nextLine();
                    System.out.println(" Nhập biển số xe");
                    String licensePlate = sc.nextLine();
                    System.out.println(" nhập màu xe");
                    String color = sc.nextLine();
                    System.out.println(" nhập trạng thái xe empty/busy");
                    String status = sc.nextLine();
                    int rentCost = -1;
                    boolean check2 = false;
                    while (!check2) {
                        System.out.println(" Nhập giá cho thuê/1 giờ)");
                        try {
                            rentCost = sc.nextInt();
                            check2 = true;
                        } catch (Exception e) {
                            System.out.println("SOS.. chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }
                    Bicycle bicycle = new Bicycle(id, licensePlate, color, status, rentCost);
                    bicycleManage.add(bicycle);
                    System.out.println("==============THÊM thành công===============");
                    System.out.println("nhập lựa chọn tiếp theo của bạn");
                    break;
                case 3:
                    int id1 = -1;
                    boolean check3 = false;
                    while (!check3) {
                        System.out.println(" nhập id xe muốn sửa");
                        try {
                            id1 = sc.nextInt();
                            check3 = true;
                        } catch (Exception e) {
                            System.out.println(" SOS!chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }
                    System.out.println(" Nhập biển số xe sửa thành: ");
                    licensePlate = sc.nextLine();
                    sc.nextLine();
                    System.out.println(" Nhập màu xe sửa thành : ");
                    color = sc.nextLine();
                    System.out.println(" nhập trạng thái xe empty/busy muốn sửa : ");
                    status = sc.nextLine();
                    int rentCost1 = -1;
                    boolean check4 = false;
                    while (!check4) {
                        System.out.println(" Nhập giá cho thuê/1 giờ)");
                        try {
                            rentCost1 = sc.nextInt();
                            check4 = true;
                        } catch (Exception e) {
                            System.out.println("SOS.. chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }
                    Bicycle bicycle1 = new Bicycle(id1,licensePlate,color,status,rentCost1);
                    bicycleManage.edit(id1, bicycle1);
                    System.out.println("nhập lựa chọn tiếp theo của bạn");
                    break;
                case 4:
                    int id2 = -1;
                    boolean check5 = false;
                    while (!check5) {
                        System.out.println(" nhập id xe muốn xóa");
                        try {
                            id2 = sc.nextInt();
                            check5 = true;
                        } catch (Exception e) {
                            System.out.println(" SOS!chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }
                    bicycleManage.delete(id2);
                    System.out.println("================= XÓA thành công==============");
                    System.out.println(" Nhập lựa chọn tiếp theo của bạn");
                    break;
                case 5:
                    bicycleManage.deleteAll();
                    System.out.println("------------------Danh sách trống--------------");
                    System.out.println("Nhập lựa chọn tiếp theo của bạn");
                    break;
                case 6:
                    bicycleManage.findBusyBicycle();
                    System.out.println("Nhập lựa chọn tiếp theo của bạn");
                    break;
                case 7:
                    System.out.println(" nhập id xe muốn thay đổi trạng thái");
                    int id3 = -1;
                    boolean check6 = false;
                    while (!check6) {
                        System.out.println(" nhập id xe mới");
                        try {
                            id3 = sc.nextInt();
                            check6 = true;
                        } catch (Exception e) {
                            System.out.println(" SOS!chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }
                    bicycleManage.emptyToBusy(id3);
                    System.out.println("nhập lựa chọn tiếp theo của bạn");
                    break;
                case 8:
                    int id4 = -1;
                    boolean check7 = false;
                    while (!check7) {
                        System.out.println(" nhập id xe muốn tìm");
                    }
                    try {
                        id4 = sc.nextInt();
                        check7 = true;
                    } catch (Exception e) {
                        System.out.println("SOS! chỉ được nhập số");

                    }
                    bicycleManage.findById(id4);
                    System.out.println("nhập lựa chọn của bạn");
                    break;
                case 9:
                    int cost ;
                    boolean check8 = false;
                    while (!check8) {
                        System.out.println(" Nhập giá cho thuê muốn tìm");
                        try {
                            cost =sc.nextInt();
                            check8 =true;
                        }
                        catch (Exception e) {
                            System.out.println(" ERROR .....  vui lòng nhập số");
                        }
                    }

//                    bicycleManage.findByRentCost(cost);
                    System.out.println("nhập lựa chọn tiếp theo của bạn");
                    break;
                case 10:
                    bicycleManage.displayMenu();
                    System.out.println("nhập lựa chọn tiếp theo của bạn");
                    break;
                case 11:
                    System.out.println("さよなら");
                    System.exit(0);

                    break;

            }
        } while (choice >= 1 && choice <= 11);
    }

}


