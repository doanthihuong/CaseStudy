package model;

import Manage.BicycleManage;
import Manage.ReceiptManage;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);

    public void menuMain() {
        System.out.println("                                 <>.<>.<>.<>.<>.<>.\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38さくら株 式 会 社\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38<>.<>.<>.<>.<>");
        System.out.println("                                                 --------------------------");
        System.out.println("                                                 |1. Đăng nhập              |");
        System.out.println("                                                 --------------------------");
        System.out.println("                                                 |2. Đăng kí                 |");
        System.out.println("                                                 --------------------------");
//        int choice = sc.nextInt();
        int choice = -1;
        sc.nextLine();

        boolean check0 = false;
        while (!check0) {
            System.out.println("Mời bạn chọn chức năng");
            try {
                choice = sc.nextInt();
                if (choice<0 || choice >2) throw new Exception();
                check0 = true;
            } catch (InputMismatchException e) {
                System.out.println("Chỉ được nhập số");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Chỉ được nhập số từ 1 --> 2");
            }
        }

            switch (choice) {
                case 1:
                    System.out.println("|Tên đăng nhập            |");
                    String user = sc.nextLine();
                    System.out.println("|Mật khẩu                 |");
                    String pass = sc.nextLine();
                    if (user.equals("admin") && pass.equals("admin")) {
                        System.out.println("Đăng nhập thành công");
                    } else {
                        System.out.println("Đăng nhập thất bại, thử lại");
                        menuMain();
                    }
                    break;
                case 2:
                    System.out.println("Coming soon!");
                    menuMain();
                    break;
            }
    }
    public void menuReceipt() throws FileNotFoundException {
        ReceiptManage receiptManage = new ReceiptManage();
        BicycleManage bicycleManage = new BicycleManage();
        Date now = new Date();
        boolean check;
        int choice = -1;
        receiptManage.displayMenuReceipt1();
        do {

            do {

                try {
                    choice = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("ERROR.... chỉ nhập số");
                    sc.nextLine();
                    choice = -1;
                }
            } while (choice < 1 || choice > 7);

            switch (choice) {
                case 1:
                    System.out.println("\uD83C\uDF38 \uD83C\uDF38さくら 株 式 会 社\uD83C\uDF38 \uD83C\uDF38");
                    receiptManage.displayFull();
                    break;
                case 2:
                    System.out.println("Mời nhập vào thông tin hóa đơn");
                    int id = -1;
                    check = false;
                    while (!check) {
                        System.out.println("Nhập số CMND của khách thuê xe");
                        try {
                            id = sc.nextInt();

                            check = true;
                        } catch (Exception e) {
                            System.out.println(" ERROR!chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }
                    System.out.println(" Nhập họ tên của khách thuê xe");
                    sc.nextLine();
                    String name = sc.nextLine();

                    double borrowedTime = -1;
                    check = false;
                    while (!check) {
                        System.out.println("Nhập thời gian khách THUÊ xe");
                        try {
                            borrowedTime = sc.nextDouble();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("------------------ERROR.... Chỉ được nhập số----------------");
                            sc.nextLine();
                        }
                    }
                    double payTime = -1;
                    check = false;
                    while (!check) {
                        System.out.println("Nhập thời gian khách TRẢ xe");
                        try {
                            payTime = sc.nextDouble();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("-------------ERROR....Chỉ được nhập số-------------------");
                            sc.nextLine();
                        }
                    }
                    int idx = -1;
                    Bicycle bicycle = null;
                    check = false;
                    while (!check) {
                        System.out.println(" Nhập ID xe thuê");
                        try {
                            idx = sc.nextInt();
                            int index = bicycleManage.findIndexById(idx);
                            if (index != -1){
                                bicycle = BicycleManage.bicycleList.get(index);
                            } else {
                                throw new Exception();
                            }
                            check = true;
                        } catch (Exception e) {
                            System.out.println("\uD83C\uDD98 Nhập lại !");
                            sc.nextLine();
                        }
                    }
                    receiptManage.addReceipt(new Receipt(id, name, borrowedTime, payTime, bicycle));
                    break;
                case 3:
                    int id1 = -1;
                    check = false;
                    while (!check) {
                        System.out.println("  Nhập số CMND của khách muốn sửa");
                        try {
                            id1 = sc.nextInt();

                            check = true;
                        } catch (Exception e) {
                            System.out.println(" ERROR! chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }
                    int id2 = -1;
                    check = false;
                    while (!check) {
                        System.out.println("  Nhập số CMND của khách muốn sửa");
                        try {
                            id2 = sc.nextInt();

                            check = true;
                        } catch (Exception e) {
                            System.out.println(" ERROR! chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }
                    System.out.println("------------------Nhập tên mới -------------------");
                    String name1 = sc.nextLine();
                    System.out.println("------------------Nhập thời gian mới---------------");
                    double borrowedTime1 = sc.nextDouble();
                    System.out.println("---------------- -Nhập thời gian trả mới------------");
                    System.out.println("------------------ Nhập ID xe mượn mới---------------");
//
                    break;
                case 4:
                    int id3 = -1;
                    check = false;
                    while (!check) {
                        System.out.println("  Nhập số CMND của khách thuê xe");
                        try {
                            id3 = sc.nextInt();

                            check = true;
                        } catch (Exception e) {
                            System.out.println(" ERROR! chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }

                    receiptManage.deleteReceipt(id3);
                    System.out.println("-----------------XÓA THÀNH CÔNG---------------");
                    break;
                case 6:
                    receiptManage.displayMenuReceipt1();
                    break;

                case 7:
                    System.exit(0);
                    break;
            }
        } while (choice >= 1 && choice <= 7);
    }

  }
