package main;

import Manage.BicycleManage;
import Manage.ReceiptManage;
import model.Receipt;

import java.util.Date;
import java.util.Scanner;

public class MainReceipt {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ReceiptManage receiptManage =new ReceiptManage();
        BicycleManage bicycleManage =new BicycleManage();
        Date now =new Date();
        boolean check;
        int choice = -1;
        receiptManage.displayMenu();
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
                    bicycleManage.display();
                    break;
                case 2:
                    System.out.println("Mời nhập vào thông tin hóa đơn");
                    int id = -1;
                    check = false;
                    while (!check) {
                        System.out.println("  Nhập số CMND của khách thuê xe");
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
                            System.out.println("chọn xe khách thuê : (nhập ID)");
                            bicycleManage.display();
                            int indexOfBicycle = sc.nextInt();
                            receiptManage.addReceipt(new Receipt(id, name, borrowedTime, payTime, BicycleManage.bicycleList.get(bicycleManage.findIndexById(indexOfBicycle))));

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
                                System.out.println("------------------Nhập tên mới -------------------");
                                String name1 =sc.nextLine();
                                System.out.println("------------------Nhập thời gian mới---------------");
                                double borrowedTime1 =sc.nextDouble();
                                System.out.println("---------------- -Nhập thời gian trả mới------------");
                                double payTime1 =sc.nextDouble();

                                break;
                            case 4:
                                int id2 = -1;
                                check = false;
                                while (!check) {
                                    System.out.println("  Nhập số CMND của khách thuê xe");
                                    try {
                                        id2 = sc.nextInt();

                                        check = true;
                                    } catch (Exception e) {
                                        System.out.println(" ERROR! chỉ được nhập số !");
                                        sc.nextLine();
                                    }
                                }

                                receiptManage.deleteReceipt(id2);
                                System.out.println("-----------------XÓA THÀNH CÔNG---------------");
                                break;
                            case 6:
                                receiptManage.displayMenu();
                                break;

                            case 7:
                                System.exit(0);
                                break;
                        }
                    }while (choice >= 1 && choice <= 7) ;
        }
}
