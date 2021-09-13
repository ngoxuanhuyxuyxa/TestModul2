package view;

import controller.PhoneBookManagement;
import model.Phonebook;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneMenu {
    public static   Scanner scanner = new Scanner(System.in);
    public static PhoneBookManagement phoneBookManagement = new PhoneBookManagement();
    public static void run() {
        int choice;
        do {
            System.out.println("----Chương TRÌNH QUẢN LÝ DANH BẠ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1.Xem danh sách");
            System.out.println("2.Thêm mới");
            System.out.println("3.Cập nhật");
            System.out.println("4.Xóa");
            System.out.println("5.Tìm Kiếm");
            System.out.println("6.Đọc từ file");
            System.out.println("7.Ghi từ file");
            System.out.println("8.Thoát");
            System.out.println("Mời nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:{
                    phoneBookManagement.showAll();
                    break;
                }
                case 2:{
                    phoneBookManagement.addNew(addNew());
                    break;
                }
                case 3:{
                    System.out.println("Nhập số điện thoại muốn sửa");
                    String numberPhone = scanner.nextLine();
                    phoneBookManagement.updateById(numberPhone,addNew());
                    break;
                }
                case 4:{
                    System.out.println("Nhập số điện thoại muốn xóa");
                    String numberPhone = scanner.nextLine();
                    phoneBookManagement.deleteById(numberPhone,scanner);
                    break;
                }
                case 5:{
                    System.out.println("Nhập số điện thoại muốn tìm muôn tìm");
                    String numberPhone = scanner.nextLine();
                    phoneBookManagement.searchNumberPhone(numberPhone);
                    break;
                }
                case 6:{
                    phoneBookManagement.readContactFromFile();
                    break;
                }
                case 7:{
                    phoneBookManagement.writeContactToFile();
                    break;
                }


            }

        } while (choice != 0);
    }

    private static Phonebook addNew() {
        Matcher matcher3;
        String numberPhone;
        do {
            System.out.println("Nhập số điện thoại");
            numberPhone = scanner.nextLine();
            String regex = "^[0-9]{2}-0[1-9][0-9]{8}$";
            Pattern pattern = Pattern.compile(regex);
            matcher3 = pattern.matcher(numberPhone);
            if (!matcher3.matches()) {
                System.err.println("Sai mã vùng hoặc số điện thoại");
            }
        } while (!matcher3.matches());
        System.out.println("Nhập nhóm");
        String group = scanner.nextLine();
        System.out.println("Nhập họ và tên");
        String fullName = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        String dateOfBirth = scanner.nextLine();
        Matcher matcher2;
        String email;
        do {
            System.out.println("Nhập Email");
            email = scanner.nextLine();
            String regex = "^[A-Za-z0-9_]{4,}@[A-Za-z]mail.com$";
            Pattern pattern = Pattern.compile(regex);
            matcher2 = pattern.matcher(email);
            if (!matcher2.matches()) {
                System.err.println("Mail không hợp lệ");
            }
        } while (!matcher2.matches());

        Phonebook phonebook = new Phonebook(numberPhone,group,fullName,gender,address,dateOfBirth,email);
        return phonebook;
    }

}
