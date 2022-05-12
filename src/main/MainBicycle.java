package main;

import Manage.BicycleManage;
import file_csv.WriteReadToFile;
import model.Bicycle;
import model.Menu;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainBicycle {
    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        menu.menuMain();
        BicycleManage bicycleManage = new BicycleManage();
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            boolean check;
            bicycleManage.displayMenu();
            do {

                do {
                    try {
                        choice = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println(ANSI_RED+"\uD83C\uDD98 Chỉ nhập số"+ANSI_RESET);
                        sc.nextLine();
                        choice = -1;
                    }
                } while (choice < 1 || choice > 11);

                switch (choice) {
                    case 1:
                        System.out.println("                 \uD83C\uDF38 \uD83C\uDF38さくら 株 式 会 社\uD83C\uDF38 \uD83C\uDF38");
                        bicycleManage.display();
                        System.out.println("\uD83D\uDC49 Mời nhập lựa chọn của bạn");
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
                                System.out.println(ANSI_RED+"\uD83C\uDD98 Chỉ nhập số"+ANSI_RESET);
                                sc.nextLine();
                            }
                        }
                        sc.nextLine();
                        System.out.println("\uD83D\uDC49 Nhập biển số xe");
                        String licensePlate = sc.nextLine();
                        System.out.println("\uD83D\uDC49 Nhập màu xe");
                        String color = sc.nextLine();
                        System.out.println("\uD83D\uDC49 Nhập trạng thái xe:\n1. SẴN SÀNG\t\t\t2. KHÔNG PHẢI BÂY GIỜ");
                        String status = "";
                        int choice1 = -1;
                        do {
                            System.out.println("\uD83D\uDC49 Chọn trạng thái 1 hoặc 2: ");
                            try {
                                choice1 = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED+"\uD83C\uDD98 Vui lòng chỉ nhập số"+ANSI_RESET);
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
                        while (choice1 < 1 || choice1 > 2);
                        int rentCost = -1;
                        check = false;
                        while (!check) {
                            System.out.println("\uD83D\uDC49 Nhập giá cho thuê/1 giờ)");
                            try {
                                rentCost = sc.nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println(ANSI_RED+"\uD83C\uDD98 Chỉ được nhập số !"+ANSI_RESET);
                                sc.nextLine();
                            }
                        }
                        Bicycle bicycle = new Bicycle(id, licensePlate, color, status, rentCost);
                        bicycleManage.add(bicycle);

                        System.out.println(ANSI_BLUE+"------------------------THÊM THÀNH CÔNG-----------------------"+ANSI_RESET);
                        System.out.println("\uD83D\uDC49 Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 3:
                        check = false;
                        while (!check) {
                            System.out.println("\uD83D\uDC49 Nhập id muốn sửa");
                            try {
                                int id1 = sc.nextInt();
                                int index = bicycleManage.findIndexById(id1);
                                if (index != -1) {
                                    System.out.println("\uD83D\uDC49 Nhập biển số mới: ");
                                    sc.nextLine();
                                    licensePlate = sc.nextLine();
                                    System.out.println("\uD83D\uDC49 Nhập màu xe mới: ");
                                    color = sc.nextLine();
                                    System.out.println("\uD83D\uDC49 Nhập trạng thái xe:\n1. SẴN SÀNG\t\t\t2. KHÔNG PHẢI BÂY GIỜ");
                                    String status1 = "";
                                    int choice2 = -1;
                                    check = false;
                                    do {
                                        System.out.println("\uD83D\uDC49 Chọn trạng thái 1 hoặc 2: ");
                                        try {
                                            choice2 = sc.nextInt();
                                        } catch (InputMismatchException e) {
                                            System.out.println(ANSI_RED+"\uD83C\uDD98 Chỉ nhập số"+ANSI_RESET);
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
                                        System.out.println("\uD83D\uDC49 Nhập giá cho thuê/1 giờ)");
                                        try {
                                            rentCost1 = sc.nextInt();
                                            check = true;
                                        } catch (Exception e) {
                                            System.out.println(ANSI_RED+"\uD83C\uDD98 Chỉ được nhập số !"+ANSI_RESET);
                                            sc.nextLine();
                                        }
                                    }
                                    Bicycle bicycle1 = new Bicycle(id1, licensePlate, color, status1, rentCost1);
                                    bicycleManage.edit(id1, bicycle1);
                                    WriteReadToFile.writeToFile(bicycleManage.getBicycleList());
                                    System.out.println("ĐÃ SỬA XONG!!!");
                                } else {
                                    System.out.println(ANSI_RED+"\uD83C\uDD98 Không tồn tại xe có ID = "+ANSI_RESET + id1 + ANSI_RED +" trong danh sách!!!"+ANSI_RESET);
                                }
                            } catch (Exception e) {
                                System.out.println(ANSI_RED+"\uD83C\uDD98  Chỉ được nhập số !"+ANSI_RESET);
                                sc.nextLine();
                            }
                        }
                        System.out.println("\uD83D\uDC49 Nhập giá cho thuê/1 giờ)");

                        System.out.println("\uD83D\uDC49 Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 4:
                        int id3 = -1;
                        check = false;
                        while (!check) {
                            System.out.println("\uD83D\uDC49 Nhập id xe muốn xóa");
                            try {
                                id3 = sc.nextInt();
                                check = true;
                            } catch (Exception e) {
                                System.out.println(ANSI_RED+" \uD83C\uDD98 chỉ được nhập số !"+ANSI_RESET);
                                sc.nextLine();
                            }
                        }
                        bicycleManage.delete(id3);
                        System.out.println("\uD83D\uDC49 Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 5:
                        bicycleManage.deleteAll();
                        System.out.println("--------------------DANH SÁCH TRỐNG---------------");
                        System.out.println("\uD83D\uDC49 Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 6:

                        System.out.println("\uD83D\uDC49 Nhập danh sách cần tìm: \n1.DANH SÁCH XE ĐÃ CHO THUÊ\t\t\t2.DANH SÁCH XE SẴN SÀNG");
                        int choice3 = -1;
                        do {
                            System.out.println("\uD83D\uDC49 Chọn lựa chọn 1 hoặc 2: ");
                            try {
                                choice3 = sc.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED+"\uD83D\uDC49 Vui lòng chỉ nhập số"+ANSI_RESET);
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


                        System.out.println("\uD83D\uDC49 Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 7:
                        check = false;
                        while (!check) {
                            try {
                                System.out.println("\uD83D\uDC49 Nhập ID xe muốn cập nhật trạng thái");
                                int id4 = sc.nextInt();
                                int idUpdate = bicycleManage.findIndexById(id4);
                                while (idUpdate != -1) {
                                    bicycleManage.findById(id4);
                                    System.out.println("\uD83D\uDC49 UPDATE TRẠNG THÁI: \n1.READY to NOT_NOW\t\t\t2.NOT_NOW XE to READY");
                                    int choice4;
                                    do {
                                        System.out.println("\uD83D\uDC49 Chọn lựa chọn 1 hoặc 2: ");
                                        choice4 = sc.nextInt();
                                    }
                                    while (choice4 != 1 && choice4 != 2);
                                    switch (choice4) {
                                        case 1:
                                            bicycleManage.emptyToBuSy(id4);
                                            break;
                                        case 2:
                                            bicycleManage.busyToEmpty(id4);
                                            break;
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println(ANSI_RED+"\uD83C\uDD98 Chỉ được nhập số !"+ANSI_RESET);
                                sc.nextLine();
                            }
                        }
                        System.out.println("\uD83D\uDC49 Mời nhập lựa chọn tiếp theo");
                        break;
                    case 8:
                        int id4 ;
                        check = false;
                        while (!check) {
                            System.out.println(ANSI_RED+"\uD83D\uDC49 Nhập id xe muốn tìm"+ANSI_RESET);
                            try {
                                id4 = sc.nextInt();
                                check = true;
                                bicycleManage.findById(id4);
                                System.out.println("\uD83D\uDC49 Nhập lựa chọn tiếp theo của bạn");
                            } catch (Exception e) {
                                System.out.println(ANSI_RED+"\uD83C\uDD98 Chỉ được nhập số"+ANSI_RESET);
                                sc.nextLine();
                            }
                        }


                        break;
                    case 9:
                        int cost;
                        check = false;
                        while (!check) {
                            System.out.println("\uD83D\uDC49 Nhập giá cho thuê muốn tìm");
                            try {
                                cost = sc.nextInt();
                                check = true;
                                bicycleManage.findByRentCost(String.valueOf(cost));
                            } catch (Exception e) {
                                System.out.println(" \uD83C\uDD98 Vui lòng nhập số");
                            }
                        }
                        System.out.println("\uD83D\uDC49 Nhập lựa chọn tiếp theo của bạn");
                        break;

                    case 10:
//                        bicycleManage.displayMenuReceipt();
                        menu.menuReceipt();
                        System.out.println("\uD83D\uDC49 Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 11:
                        bicycleManage.displayMenu();
                        System.out.println("\uD83D\uDC49 Nhập lựa chọn tiếp theo của bạn");
                        break;
                    case 12:
                        System.exit(0);
                        System.out.println(ANSI_CYAN+"さよなら..まった。。会いましょう　\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A"+ANSI_RESET);
                        break;
                }
            } while (choice >= 1 && choice <= 12);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






























    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

}


