package Manage;

import file_csv.WriteReadToFile;
import model.Bicycle;

import javax.swing.plaf.PanelUI;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BicycleManage {
    public static List<Bicycle> bicycleList = new ArrayList<>();
    public static final String READY = "READY";
    public static final String NOT_NOW = "NOT NOW";
    int sum;


    public BicycleManage() throws FileNotFoundException {
        bicycleList = WriteReadToFile.readFile("src\\bicycle-Manage.csv", bicycleList);
    }


    public void add(Bicycle bicycle) throws FileNotFoundException {
        bicycleList.add(bicycle);
        WriteReadToFile.writeToFile(bicycleList);
    }

    public void display() {
        if (bicycleList.isEmpty()) {
            System.out.println(" Danh sách xe chưa được cập nhật !!!");
            System.out.println("--------------------------------------------------------");
            return;
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("\"| %-10s| %-10s| %-10s| %-10s| %-10s|\n\"", "ID", "BIỂN SỐ", " MÀU SẮC", "TRẠNG THÁI", "GIÁ/GIỜ");
        System.out.println("-------------------------------------------------------------");
        for (Bicycle bicycle : bicycleList) {
            System.out.printf("\"| %-10s| %-10s| %-10s| %-10s| %-10s|\n\"", bicycle.getId(), bicycle.getLicensePlate(), bicycle.getColor(), bicycle.getStatus(), bicycle.getRentCost());
            System.out.println("------------------------------------------------------------");
        }
    }

    public List<Bicycle> getBicycleList() {
        return bicycleList;
    }

    public static void setBicycleList(List<Bicycle> bicycleList) {
        BicycleManage.bicycleList = bicycleList;
    }

    public int findIndexById(int id) {
        for (int i = 0; i < bicycleList.size(); i++) {
            if (bicycleList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void findById(int id) {
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Xe này không có trong danh sách ");
        } else {
            for (int i = 0; i < bicycleList.size(); i++) {
                if (bicycleList.get(i).getId() == id) {
                    System.out.println(" Xe có ID " + id + " cần tìm là : ");
                    System.out.println(bicycleList.get(i));
                }
            }
        }
    }

    public void edit(int id, Bicycle bicycle) throws FileNotFoundException {
        int index = findIndexById(id);
        bicycleList.set(index, bicycle);
        WriteReadToFile.writeToFile(bicycleList);
    }

    public void delete(int id) throws FileNotFoundException {
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Xe này không có trong danh sách ");
        } else {
            bicycleList.remove(findIndexById(id));
            WriteReadToFile.writeToFile(bicycleList);
            System.out.println("------------------------ XÓA thành công--------------------------");
        }

    }

    public void deleteAll() throws FileNotFoundException {
        bicycleList.removeAll(bicycleList);
        WriteReadToFile.writeToFile(bicycleList);
    }


    public void findByRentCost(String cost) {
        boolean check = false;
        for (int i = 0; i < bicycleList.size(); i++) {
            if (String.valueOf(bicycleList.get(i).getRentCost()).contains((cost))) {
                System.out.println(bicycleList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println("----CÔNG TY KHÔNG CHO THUÊ VỚI GIÁ NÀY!");
        }
    }

    // Tìm xe chưa cho thuê
    public void findEmptyBicycle() {
        boolean check = false;
        for (int i = 0; i < bicycleList.size(); i++) {
            if (bicycleList.get(i).getStatus().equals(READY)) {
                System.out.println(bicycleList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println("TẤT CẢ XE ĐỀU Ở TRẠNG THÁI ĐÃ CHO THUÊ");
        }
    }

    public void findBusyBicycle() {
        boolean check = false;
        for (int i = 0; i < bicycleList.size(); i++) {
            if (bicycleList.get(i).getStatus().equals(NOT_NOW)) {
                System.out.println(bicycleList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println("-----------------TẤT CẢ XE ĐỀU SẴN SÀNG-------------");
        }

    }

    public void busyToEmpty(int id) throws FileNotFoundException {
        int index = findIndexById(id);
        if (bicycleList.get(index).getStatus().equals(NOT_NOW)) {
            bicycleList.get(index).setStatus("READY");
            WriteReadToFile.writeToFile(bicycleList);
            System.out.println("------------------- UPDATE THÀNH CÔNG----------------------");
        } else {
            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        }
    }

    public void emptyToBuSy(int id) throws FileNotFoundException {
        int index = findIndexById(id);
        if (bicycleList.get(index).getStatus().equals(READY)) {
            bicycleList.get(index).setStatus("NOT NOW");
            WriteReadToFile.writeToFile(bicycleList);
            System.out.println("------------------- UPDATE THÀNH CÔNG----------------------");
        } else {
            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        }
    }

    public void displayMenu() {
        System.out.println("                               <>.<>.<>.<>.<>.<>.\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38さくら株 式 会 社\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38<>.<>.<>.<>.<>");

        System.out.println("                               *=*=*=*=*=*=*=MENU QUẢN LÝ CHO THUÊ XE ĐẠP=*=*=*=*=*=*=*=*");
        System.out.println("                               *-1 -  Hiển thị số lượng xe đạp                         =*");
        System.out.println("                               *-2 - Thêm 1 xe đạp mới                                 =*");
        System.out.println("                               *-3 - Sửa thông tin xe theo số i                        =*");
        System.out.println("                               *-4 - Xóa xe đap theo id                                =*");
        System.out.println("                               *-5 - Xóa tất cả xe                                     =*");
        System.out.println("                               *-6 - Hiển thị xe đã cho thuê/ đang rảnh                =*");
        System.out.println("                               *-7 - Thay đổi trạng thái xe đạp (READY/ NOT_NOW)       =*");
        System.out.println("                               *-8 - Tìm xe theo id xe (hiển thị xe duy nhất)          =*");
        System.out.println("                               *-9 - Tìm xe theo giá cho thuê                          =*");
        System.out.println("                               *-10 - Xem menu hóa đơn                                 =*");
        System.out.println("                               *-11 - Xem lại danh sách Menu                           =*");
        System.out.println("                               *-12 - Thoát                                            =*");
        System.out.println("                               *-             \uD83D\uDC49 \uD83D\uDC49 Mời nhập lựa chọn của bạn       =*");
        System.out.println("                               =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
    }

    public void displayMenuReceipt() {
        System.out.println("                                     <>.<>.<>.<>.<>.<>.\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38さくら株 式 会 社\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38<>.<>.<>.<>.<>");
        System.out.println("                                    *=*=*=*=*=*=*=*=*=*=*=*Menu Hóa Đơn=*=*=*=*=*=*=*=*=*=*=*");
        System.out.println("                                    *-1 - Hiển thị danh sách hóa đơn                       =*");
        System.out.println("                                    *-2 - Thêm hóa đơn                                     =*");
        System.out.println("                                    *-3 - Sửa thông tin hóa đơn theo số CMND của khách     =*");
        System.out.println("                                    *-4 - Tính tiền hóa đơn - Xóa luôn hóa đơn             =*");
        System.out.println("                                    *-5 - Xuất hoá đơn   1                                 =*");
        System.out.println("                                    *-6 - Xem lại MENU CHÍNH!                              =*");
        System.out.println("                                    *-7 - Thoát                                            =*");
        System.out.println("                                    *-           \uD83D\uDC49mời nhập lựa chọn của bạn     =*");
        System.out.println("                                    *=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
    }


    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
}