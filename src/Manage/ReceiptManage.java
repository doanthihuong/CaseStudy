package Manage;

import model.Receipt;

import java.util.ArrayList;
import java.util.List;

public class ReceiptManage {
    List<Receipt> receiptList = new ArrayList<>();
    //Thêm thuộc tính số hóa đơn
    private int receiptNumber = 0;
    public ReceiptManage(){
    }

    public List<Receipt> getReceiptList() {
        return receiptList;
    }

    public void setReceiptList(List<Receipt> receiptList) {
        this.receiptList = receiptList;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }
    public void addReceipt(Receipt receipt) {
        receiptList.add(receipt);
        receiptNumber++;
        System.out.println("Bạn đã thêm thành công 1 hóa đơn mới" );
    }
    public void editReceipt(String identity,Receipt receipt){
        int index = findIndexById(identity);
        if(index == -1) {
            System.out.println("Không có số CMND nào phù hợp");
        } else {
            receiptList.set(index,receipt);
            System.out.println(" Bạn đã sửa thành công hóa đơn");
        }
    }
    public void deleteReceipt(String identity){
        int index = findIndexById(identity);
        if(index == -1) {
            System.out.println("Không có số CMND nào phù hợp");
        } else {
            receiptList.remove(index);
            System.out.println(" Bạn đã xóa thành công hóa đơn");
        }

    }
    public void displayFull(){
        int receiptNumber=0;
        boolean check = false;
        for (int i=0; i<receiptList.size(); i++) {
            System.out.println(receiptList.get(i));
            receiptNumber++;
            System.out.println("Số hóa đơn thứ: " + receiptNumber);
            System.out.println("------------------------------------------------------------");
            check = true;
        }

        if (check == false) {
            System.out.println("Chưa có hóa đơn nào được thêm mới!");
        }

    }

    public void findIdentity(String identity) {
        boolean check = false;
        for (int i = 0; i < receiptList.size(); i++) {
            if(receiptList.get(i).getIdentity().equals(identity)) {
                System.out.println(receiptList.get(i));
                check=true;
            }
        }
        if(check==false){
            System.out.println("Không Id này trong danh sách");
        }
    }
    //Tìm vị trí index
    public int findIndexById(String identity) {
        for (int i = 0; i < receiptList.size(); i++) {
            if(receiptList.get(i).getIdentity().equals(identity)) {
                return i;
            }
        }
        return -1;

    }
    public void displayMenu(){
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
    }

}
