package Manage;

import model.Bicycle;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class BicycleManage {
    public static List<Bicycle> bicycleList = new ArrayList<>();
    public static final String READY = "READY";
    public static final String NOT_NOW = "NOT NOW";

    public void add(Bicycle bicycle) {
        bicycleList.add(bicycle);
        System.out.println("Bạn đã THÊM thành công một xe mới");

    }

    public void display() {
        if (bicycleList.isEmpty()) {
            System.out.println(" Danh sách xe chưa được cập nhật !!!");
            System.out.println("----------------------------------------------------------------");
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
        boolean check = true;
        for (int i = 0; i < bicycleList.size(); i++) {
            if (bicycleList.get(i).getId() == id) {
                System.out.println(bicycleList.get(i));
                check = true;
            }
        }
    }

    public void edit(int id, Bicycle bicycle) {
        bicycleList.set(findIndexById(id), bicycle);

    }

    public void delete(int id) {
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Xe này không có trong danh sách ");
        } else {
            bicycleList.remove(findIndexById(id));
            System.out.println("------------------------ XÓA thành công--------------------------");
        }

    }

    public void deleteAll() {
        bicycleList.removeAll(bicycleList);
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

    public void busyToEmpty(int id) {
        int index = findIndexById(id);
        if(bicycleList.get(index).getStatus().equals(NOT_NOW)) {
            bicycleList.get(index).setStatus("READY");
            System.out.println("------------------- UPDATE THÀNH CÔNG----------------------");
        } else {
            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        }
    }
    public void emptyToBuSy(int id) {
        int index = findIndexById(id);
        if(bicycleList.get(index).getStatus().equals(READY)) {
            bicycleList.get(index).setStatus("NOT NOW");
            System.out.println("------------------- UPDATE THÀNH CÔNG----------------------");
        } else {
            System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><><><><>");
        }
    }


    public void displayMenu() {
        System.out.println("<>.<>.<>.<>.<>.<>.\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38さくら株 式 会 社\uD83C\uDF38\uD83C\uDF38\uD83C\uDF38<>.<>.<>.<>.<>");

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

    }

}