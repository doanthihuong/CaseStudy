package Manage;

import model.Bicycle;

import java.util.ArrayList;
import java.util.List;

public class BicycleManage {
    public static List<Bicycle> bicycleList=new ArrayList<>();
    public static final String EMPTY = "E";
    public static final String BUSY = "B";

    public void add(Bicycle bicycle) {
        bicycleList.add(bicycle);
        System.out.println("Bạn đã thêm thành công một xe mới");

    }
    public void display(){
        boolean  check = false;
        for (int i = 0; i < bicycleList.size(); i++) {
            System.out.println( bicycleList.get(i));
            check =true;
        }
        if(check==false){
            System.out.println( " chưa có xe nào được thêm mới");
        }
    }
    public int findIndexById(int id) {
        for (int i = 0; i < bicycleList.size(); i++) {
            if (bicycleList.get(i).getId()==id){
                return i;
            }
        } return -1;
    }
    public void findById(int id){
        boolean check =false;
        for (int i = 0; i < bicycleList.size(); i++) {
            if(bicycleList.get(i).getId()==id){
                System.out.println(bicycleList.get(i));
                check =true;
            }
        }
        if (check==false) {
            System.out.println( "Id này không có trong danh sách");
        }

    }
    public void edit(int id, Bicycle bicycle){
        bicycleList.set(findIndexById(id), bicycle);

    }
    public void delete(int id) {
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Xe này không có trong danh sách ");
        } else {
            bicycleList.remove(findIndexById(id));
            System.out.println("---------- Xóa thành công-------------");
        }

    }
    public void deleteAll() {
        bicycleList.removeAll(bicycleList);
    }

    // Tìm kiếm theo giá cho thuê (ngoài giá bình thường, còn có giá ưu đãi
    // học sinh, sinh viên ...v .vv)
    public void findByRentCost(String cost) {
        boolean check = false;
        for (int i = 0; i < bicycleList.size(); i++) {
            if (String.valueOf(bicycleList.get(i).getRentCost()).contains((cost))) {
                System.out.println(bicycleList.get(i));
                check = false;
            }
//            if(String.valueOf(bicycleList.get(i).getRentCost()).contains(cost)) {
//                System.out.println(bicycleList.get(i));
//                check = false;
//            }

        }
        if ( check==false){
            System.out.println( "không tại tạo giá thuê này");
        }
    }

    // Tìm xe chưa cho thuê
    public void findEmptyBicycle(){
        boolean check = false;
        for (int i=0; i<bicycleList.size(); i++) {
            if (bicycleList.get(i).getStatus().equals(EMPTY)) {
                System.out.println(bicycleList.get(i));
                check = true;
            }
        }
        if ( check == false){
            System.out.println(" tất cả xe đểu ở trạng thái đã cho thuê");
        }
    }
    //Tìm xe đã cho thuê
    public void findBusyBicycle(){
        boolean check = false;
        for (int i=0; i<bicycleList.size(); i++) {
            if (bicycleList.get(i).getStatus().equals(BUSY)) {
                System.out.println(bicycleList.get(i));
                check = true;
            }
        }
        if (check == false) {
            System.out.println( "Tất cả xe đều ở trạng thái rảnh");
        }

    }

    // chuyển từ xe đã cho thuê sang xe rảnh, chuyển theo id
    public void buSyToEmpty(int id) {
        int index = findIndexById(id) ;
        if(index == -1) {
            System.out.println(" Không có id xe này trong danh sách");
        } else {bicycleList.get(index).setStatus("Xe đang rảnh");
            System.out.println("Bạn đã cập nhật thành công");
        }

    }
    // chuyển sang chế đỗ " đã cho thuê
    public void emptyToBusy(int id){
        int index = findIndexById(id); ;
        if(index == -1) {
            System.out.println(" Không có id xe này trong danh sách");
        } else {bicycleList.get(index).setStatus("Xe đã cho thuê");
            System.out.println("Bạn đã cập nhật thành công");
        }
    }

    public void displayMenu() {
        System.out.println("------------MENU LỰA CHỌN------------");
        System.out.println("1 - Hiển thị số lượng xe đạp ");
        System.out.println("2 - Thêm 1 xe đạp mới");
        System.out.println("3 - Sửa thông tin xe theo số id");
        System.out.println("4 - Xóa xe đap theo id");
        System.out.println("5 - Xóa tất cả xe");
        System.out.println("6 - Hiển thị xe đã cho thuê/ đang rảnh");
        System.out.println("7 - Thay đổi trạng thái xe đạp (Từ đang rảnh/đã cho thuê, )");
        System.out.println("8 - Tìm xe theo id xe (hiển thị xe duy nhất)");
        System.out.println("9 - Tìm xe theo giá cho thuê");
        System.out.println("10 - Xem lại danh sách Menu");
        System.out.println("11 - Thoát");
    }
}
