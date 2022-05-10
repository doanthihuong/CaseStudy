import model.Bicycle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class WriteReadToFile {
    //ghi ra file
    public static void writeToFile(List<Bicycle> bicycleList) throws FileNotFoundException {

        File file = new File("src\\QuanLy.csv");
        PrintWriter printWriter = new PrintWriter(file);
        String str = "id,Biển số, màu sắc, trạng thái, giá cho thuê" + "\n";
        for (Bicycle i : bicycleList) {
            str += i.getId() + "," + i.getLicensePlate() + "," + i.getColor() + "," + i.getStatus() + "," + i.getRentCost();
        }
        printWriter.write(str);
        printWriter.close();
    }
// đọc từ
    public static List<Bicycle> bicycleList(String path, List<Bicycle> bicycleList) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        sc.nextLine();
        while (sc.hasNext()) {
            String a = sc.nextLine();
            String[] value = a.split(",");
            bicycleList.add(new Bicycle(Integer.parseInt(value[0]), value[1], value[2], value[3],Integer.parseInt(value[0]) ));
        }
        return bicycleList;
    }
}
