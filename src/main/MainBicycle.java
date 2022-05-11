package main;

import Manage.BicycleManage;
import model.Bicycle;
import model.Menu;

import javax.jws.soap.SOAPBinding;
import javax.sound.midi.Soundbank;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainBicycle {
    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        menu.menuMain();
        BicycleManage bicycleManage = new BicycleManage();
        try (Scanner sc = new Scanner(System.in)) {
            int choice = -1;
            boolean check;
            bicycleManage.displayMenu();

            do {

                do {
                    try {
                        choice = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println(" Chỉ nhập số");
                        sc.nextLine();
                        choice = -1;
                    }
                } while (choice < 1 || choice > 11);

                switch (choice) {
                    case 1:
//                        System.out.println("\uD83C\uDD98"); sos
                        System.out.println("\uD83C\uDF38 \uD83C\uDF38さくら 株 式 会 社\uD83C\uDF38 \uD83C\uDF38");
                        bicycleManage.display();
                        System.out.println(" \uD83D\uDC49Mời nhập lựa chọn của bạn");
                        break;
                    case 2:
                        System.out.println("\uD83D\uDC49 Nhâp thông tin xe ");
                        int id = -1;
                        check = false;
                        while (!check) {
                            System.out.println(" \uD83D\uDC49 Nhập ID xe ");
                            try {
                                id = sc.nextInt();

                                check = true;
                            } catch (Exception e) {
                                System.out.println(" \uD83C\uDD98 ERROR!chỉ được nhập số !");
                                sc.nextLine();
                            }
                        }
                        sc.nextLine();
                        System.out.println(" \uD83D\uDC49 Nhập biển số xe");
                        String licensePlate = sc.nextLine();
                        System.out.println(" nhập màu xe");
                        String color = sc.nextLine();
                        System.out.println(" \uD83D\uDC49 nhập trạng thái xe:\n1. SẴN SÀNG\t\t\t2. KHÔNG PHẢI BÂY GIỜ");
                        String status = "";
                        int choice1 = -1;
                        check = false;
                        do {
                            System.out.println("\uD83D\uDC49 Chọn trạng thái 1 hoặc 2: ");
                            try {
                                choice1 = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("\uD83D\uDC49 Vui lòng chỉ nhập số");
                                sc.nextLine();
                            }
                            if (choice1 == 1) {
                                status = "READY";
                                break;
                            } else if (choice1 == 2) {
                                status = "NOT NOW";
                                break;
                            }
                        }
                        while (choice1 <1 ||choice1>2);
                        check = true;
                        int rentCost = -1;
                        check = false;
                        while (!check) {
                            System.out.println(" Nhập giá cho thuê/1 giờ)");
                            try {
                                rentCost = sc.nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println("\uD83C\uDD98 chỉ được nhập số !");
                                sc.nextLine();
                            }
                        }
                        Bicycle bicycle = new Bicycle(id, licensePlate, color, status, rentCost);
                        bicycleManage.add(bicycle);

                        System.out.println("------------------------THÊM THÀNH CÔNG-----------------------");
                        System.out.println("nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 3:
                        int id1 = -1;
                        check = false;
                        while (!check) {
                            System.out.println(" nhập id xe muốn sửa");
                            try {
                                id1 = sc.nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println("\uD83C\uDD98  chỉ được nhập số !");
                                sc.nextLine();
                            }
                        }
                        System.out.println(" Nhập ID mới ");
                        id = sc.nextInt();
                        System.out.println(" Nhập biển số mới: ");
                        licensePlate = sc.nextLine();
                        sc.nextLine();
                        System.out.println(" Nhập màu xe mới: ");
                        color = sc.nextLine();
                        System.out.println(" nhập trạng thái xe:\n1. SẴN SÀNG\t\t\t2. KHÔNG PHẢI BÂY GIỜ");
                        String status1 = "";
                        int choice2 = -1;
                        check = false;
                        do {
                            System.out.println("Chọn trạng thái 1 hoặc 2: ");
                            try {
                                choice2 = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("\uD83C\uDD98 Chỉ nhập số");
                                sc.nextLine();
                            }
                            if (choice2 == 1) {
                                status1 = "READY";
                                break;
                            } else if (choice2 == 2) {
                                status1 = "NOT NOW";
                                break;
                            }
                        } while (choice2 != 3);
                        int rentCost1 = -1;
                        check = false;
                        while (!check) {
                            System.out.println(" Nhập giá cho thuê/1 giờ)");
                            try {
                                rentCost1 = sc.nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println("\uD83C\uDD98 chỉ được nhập số !");
                                sc.nextLine();
                            }
                        }
                        Bicycle bicycle1 = new Bicycle(id, licensePlate, color, status1, rentCost1);
                        bicycleManage.edit(id1, bicycle1);
                        System.out.println("\uD83C\uDD98 Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 4:
                        int id2 = -1;
                        check = false;
                        while (!check) {
                            System.out.println(" Nhập id xe muốn xóa");
                            try {
                                id2 = sc.nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println(" \uD83C\uDD98 chỉ được nhập số !");
                                sc.nextLine();
                            }
                        }
                        bicycleManage.delete(id2);
                        System.out.println(" Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 5:
                        bicycleManage.deleteAll();
                        System.out.println("--------------------Danh sách trống---------------");
                        System.out.println("Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 6:

                        System.out.println("Nhập danh sách cần tìm: \n1.DANH SÁCH XE ĐÃ CHO THUÊ\t\t\t2.DANH SÁCH XE SẴN SÀNG");
                        int choice3 = -1;
                        check = false;
                        do {
                            System.out.println("Chọn lựa chọn 1 hoặc 2: ");
                            try {
                                choice3 = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println(" Vui lòng chỉ nhập số");
                                sc.nextLine();
                            }
                            if (choice3 == 1) {
                                bicycleManage.findBusyBicycle();
                                break;
                            } else if (choice3 == 2) {
                                bicycleManage.findEmptyBicycle();
                                break;
                            }
                        } while (choice3 != 3);


                        System.out.println("Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 7:
                        System.out.println(" Tính năng đang được hệ thống bảo trì");
//                        xem lại
//                        System.out.print("Nhập vào Id xe cần update: ");
//                        int idOfUpdate = sc.nextInt();
//                        bicycleManage.busyToEmpty(idOfUpdate);
//                        break;
                        System.out.println("Nhập lựa chọn tiếp theo của bạn");
                    case 8:
                        int id4 = -1;
                        check = false;
                        while (!check) {
                            System.out.println(" Nhập id xe muốn tìm");
                            try {
                                id4 = sc.nextInt();
                                check = true;
                                bicycleManage.findById(id4);
                                System.out.println("Nhập lựa chọn tiếp theo của bạn");
                            } catch (Exception e) {
                                System.out.println("\uD83C\uDD98 chỉ được nhập số");
                                sc.nextLine();
                            }
                        }

                        break;
                    case 9:
                        int cost;
                        check = false;
                        while (!check) {
                            System.out.println(" Nhập giá cho thuê muốn tìm");
                            try {
                                cost = sc.nextInt();
                                check = true;
                                bicycleManage.findByRentCost(String.valueOf(cost));
                            } catch (Exception e) {
                                System.out.println(" \uD83C\uDD98 vui lòng nhập số");
                            }
                        }

    //                    bicycleManage.findByRentCost(cost);
                        System.out.println("Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 10:
                        bicycleManage.displayMenu();
                        System.out.println("Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 11:

                        menu.menuReceipt();
                        bicycleManage.displayMenuReceipt();

//                        System.out.println(" SORRY! updating");
//                        System.out.println("--------------------------------------------------------");
//                        System.out.println("PLEASE, COMING SOON !!!  ");
                        break;
                    case 12:
                        System.out.println("さよなら..まった。。会いましょう　\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A");
                        System.exit(0);

                        break;

                }
            } while (choice >= 1 && choice <= 12);
        }
    }
}


