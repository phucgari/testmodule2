import java.util.List;
import java.util.Scanner;

public class Main {
    private static final StudentManager manager=new StudentManager();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean on=true;
        while(on) {
            System.out.println("---- Chương trình quản lý Sinh Viên ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng:");
            int selection;
            while (true) {
                try {
                    selection = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (Exception ignored) {
                }
            }
            System.out.println(selection);
            switch (selection) {
                case 1:
                    viewStudent();
                    break;
                case 2:
                    inputNewStudent(scanner);
                    break;
                case 3:
                    updateNewStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    sortStudent(scanner);
                    break;
                case 6:
                    readCsv();
                    break;
                case 7:
                    writeCSV();
                    break;
                case 8:
                    on=false;
            }
        }
    }

    private static void writeCSV() {
        System.out.println("viết File CSV");
        manager.writeCSV();
    }

    private static void readCsv() {
        manager.readCSV();
        System.out.println("Đọc File CSV");
        viewStudent();
    }

    private static void sortStudent(Scanner scanner) {
        while(true) {
            System.out.println("---- Sắp xếp sinh viên theo điểm trung bình ----");
            System.out.println("chọn chức năng theo số");
            System.out.println("1.Sắp xếp tăng dần");
            System.out.println("2.Sắp xếp giảm dần");
            System.out.println("3.Thoát");
            System.out.print("chọn chức năng");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    manager.sortByScore(true);
                    viewStudent();
                    return;
                case "2":
                    manager.sortByScore(false);
                    viewStudent();
                    return;
                case "3":
                    return;
            }
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.println("Xóa sinh viên");
        String id=inputID(scanner);
        System.out.println("nhập y để xác nhận xóa");
        System.out.println("khác để quay lại");
        String y=scanner.nextLine();
        if(y.equals("y"))manager.delete(id);
    }

    private static void updateNewStudent(Scanner scanner) {
        System.out.println("Cập nhật sinh viên");
        String id=inputID(scanner);
        if (id.equals("")) return;
        manager.edit(id, inputStudent(scanner));
    }

    private static String inputID(Scanner scanner) {
        String id;
        while (true) {
            System.out.println("Nhập id");
            id = scanner.nextLine();
            if (id.equals("")) return "";
            for (Student student :
                    manager.getList()) {
                if (id.equals(student.getId())) {
                    return id;
                }
            }
            System.out.println("Không tìm được sinh viên với mã sinh viên trên");
        }
    }

    private static void viewStudent() {
        List<Student> list=manager.getList();
        for (Student student:
             list) {
            System.out.println(student);
        }
    }

    private static void inputNewStudent(Scanner scanner) {
        System.out.println("Thêm Sinh viên ");
        Student student = inputStudent(scanner);
        manager.add(student);
    }

    private static Student inputStudent(Scanner scanner) {
        System.out.print("Nhập Mã Sinh Viên ");
        String id= scanner.nextLine();
        System.out.print("Nhập tên ");
        String name= scanner.nextLine();
        int age;
        while(true) {
            try {
                System.out.print("Nhập tuổi ");
                age = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception ignore) {}
        }
        boolean gender;
        while (true){
            System.out.println("Nhập giới tính");
            System.out.println("1 cho nam");
            System.out.println("0 cho nữ");
            String gen= scanner.nextLine();
            if(gen.equals("1")) {
                gender = true;
                break;
            }
            if(gen.equals("0")){
                gender=false;
                break;
            }
        }
        System.out.print("Nhập địa chỉ ");
        String address= scanner.nextLine();
        double score;
        while(true) {
            try {
                System.out.print("Nhập điểm trung bình ");
                score = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception ignore) {}
        }
        Student student=new Student(id,name,age,gender,address,score);
        return student;
    }
}