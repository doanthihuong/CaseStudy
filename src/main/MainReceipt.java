package main;

import Manage.BicycleManage;
import Manage.ReceiptManage;
import model.Receipt;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class MainReceipt {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc =new Scanner(System.in);
        ReceiptManage receiptManage =new ReceiptManage();
        BicycleManage bicycleManage =new BicycleManage();
        Date now =new Date();
        boolean check;
        int choice = -1;
        receiptManage.displayMenuReceipt1();
        do {

            do {

                try {
                    choice = sc.nextInt();
                    sc.nextLine();
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
                        String name = sc.nextLine();
                        sc.nextLine();
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
                    check = false;
                    while (!check) {
                        System.out.println(" Nhập ID xe thuê");
                        try {
                            idx = sc.nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("\uD83C\uDD98 Chỉ được nhập số !");
                            sc.nextLine();
                        }
                    }
                          // làm sao so sánh để tìm xe vị trí ID của xe trong list
                            receiptManage.addReceipt(new Receipt(id, name, borrowedTime, payTime, BicycleManage.bicycleList.get(bicycleManage.findIndexById(idx))));
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
                                String name1 =sc.nextLine();
                                System.out.println("------------------Nhập thời gian mới---------------");
                                double borrowedTime1 =sc.nextDouble();
                                System.out.println("---------------- -Nhập thời gian trả mới------------");
                                System.out.println("------------------ Nhập ID xe mượn mới---------------");
//                                double payTime1 =sc.nextDouble();
//                                Receipt receipt =new Receipt(id2,name1,borrowedTime1,payTime1,bicycleManage.)
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
                    }while (choice >= 1 && choice <= 7) ;
        }
}
