package file_csv;

import Manage.BicycleManage;
import model.Bicycle;
import model.Receipt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class WriteReadToFile {
    //ghi ra file quản lý xe
    public static void writeToFile(List<Bicycle> bicycleList) throws FileNotFoundException {

        File file = new File("src\\bicycle-Manage.csv");
        PrintWriter printWriter = new PrintWriter(file);
        String str = "Id,Biển số,Màu sắc,Trạng thái,Giá cho thuê" + "\n";
        for (Bicycle i : bicycleList) {
            str += i.getId() + "," + i.getLicensePlate() + "," + i.getColor() + "," + i.getStatus() + "," + i.getRentCost() + "\n";
        }
        printWriter.write(str);
        printWriter.close();
    }

// đọc từ
    public static List<Bicycle> readFile(String path, List<Bicycle> bicycleList) throws FileNotFoundException {
        FileReader file = new FileReader(path);
        Scanner sc = new Scanner(file);
        if (sc.nextLine() != null){
            while (sc.hasNext()) {
                String a = sc.nextLine();
                String[] value = a.split(",");
                bicycleList.add(new Bicycle(Integer.parseInt(value[0]), value[1], value[2], value[3],Integer.parseInt(value[0]) ));

            }
            sc.close();
        } else {
            throw new FileNotFoundException();
        }
        return bicycleList;
    }
    // ghi ra file quản lý hóa đơn
    public static void writeToFileReceipt(List<Receipt>receiptList) throws FileNotFoundException{
        File file1 =new File("src\\receipt-Manage.csv");
        PrintWriter printWriter1 = new PrintWriter(file1);
        String str = "Identity,Tên,Thời gian mượn,Thời gian trả,ID Xe thuê,Biển số,Giá/giờ,Chi Phí\n";
        for (Receipt i:receiptList) {
            str+= i.getIdentity()+","
                    +i.getName()+","
                    +i.getBorrowedTime()+","
                    +i.getPayTime()+","
                    + i.getBicycle().getId()+","
                    +i.getBicycle().getLicensePlate()+","
                    +i.getBicycle().getRentCost()+","
                    +i.getCost() + "\n";
        }
        printWriter1.write(str);
        printWriter1.close();
    }
    // doc file
    public static List<Receipt> readFileReceipt(String path, List<Receipt> receiptList) throws Exception {
        FileReader file1 = new FileReader(path);
        Scanner sc = new Scanner(file1);

            while (sc.hasNext()) {
                if (sc.nextLine() != null){
                String a = sc.nextLine();
                String[] value = a.split(",");
                Bicycle bicycle = new Bicycle(Integer.parseInt(value[5]), value[6], Integer.parseInt(value[7]) );
                receiptList.add(new Receipt(Integer.parseInt(value[0]), value[1], Double.parseDouble(value[2]), Double.parseDouble(value[3]),Integer.parseInt(value[4]), bicycle));
            } else {
                    throw new Exception();
                }
            sc.close();
        }

        return receiptList;
    }
}
