package controller;

import model.Phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PhoneBookManagement {
    List<Phonebook> phonebooks = new ArrayList<>();

    public void showAll(){
        for (Phonebook phonebook:phonebooks) {
            System.out.println(phonebook);
        }
    }

    public void addNew(Phonebook phonebook) {
        phonebooks.add(phonebook);
    }


    public void updateById(String numberPhone, Phonebook phonebook) {
        int index = findById(numberPhone);
        if (index != -1) {
            phonebooks.set(index, phonebook);
        } else {
            System.out.println("Không tìm thấy số điện thoại cần sửa");
        }
    }


    public void deleteById(String numberPhone, Scanner scanner) {
        int index = findById(numberPhone);
        if (index != -1) {
            System.out.println("Bạn có chắc muốn xóa không? nhập y hoặc Y để xóa");
            String choice =scanner.nextLine();
            switch (choice){
                case "y":
                case "Y":{
                    phonebooks.remove(index);
                    break;
                }
                default: break;
            }
        } else {
            System.out.println("Không tìm thấy số điện thoại cần xóa");
        }
    }
    public void searchNumberPhone(String numberPhone){
        int index = findById(numberPhone);
        if (index!=-1){
            System.out.println(phonebooks.get(index));
        }else {
            System.out.println("không tìm thấy số điện thoại");
        }

    }

    public int findById(String numberPhone) {
        int index = -1;
        for (int i = 0; i < phonebooks.size(); i++) {
            if (numberPhone.equals(phonebooks.get(i).getNumberPhone())) {
                index = i;
                break;
            }
        }
        return index;
    }
    public void readContactFromFile() {
        try {
            FileReader fileReader = new FileReader("contact.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";

            while (true) {
                if (line == null) {
                    break;
                }
                line = bufferedReader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeContactToFile() {
        try {
            FileWriter fileWriter = new FileWriter("contact.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Phonebook phonebook : phonebooks) {
                bufferedWriter.write(String.valueOf(phonebook));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi thành công !!!");
    }

}
