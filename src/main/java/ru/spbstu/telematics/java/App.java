package ru.spbstu.telematics.java;
import java.util.Scanner;
public class App 
{   

    private final int key;
    public App(int key) {
        this.key = key;
    }

    public String encrypt(String text) {
        return caesarShiftRecursive(text, key);
    }

    public String decrypt(String text) {
        return caesarShiftRecursive(text, -key);
    }

    private String caesarShiftRecursive(String text, int shift) {
        if (text == null || text.isEmpty()) {
            return text;
        } else {
            char c = text.charAt(0);
            char shiftedChar = Character.isLetter(c) ? shiftChar(c, shift) : c;
            return shiftedChar + caesarShiftRecursive(text.substring(1), shift);
        }
    }

    private char shiftChar(char c, int shift) {
        char start = Character.isLowerCase(c) ? 'a' : 'A';
        int shiftedCharValue = c - start + shift;
        shiftedCharValue = (shiftedCharValue % 26 + 26) % 26;
        return (char) (shiftedCharValue + start);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Укажите ключ для шифрования: ");
        int key;
        try {
            key = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Некорректный формат ключа. Введите целое число.");
            scanner.close();
            return; 
        }
        App cipher = new App(key);
        System.out.print("Введите текст для шифрования: ");
        String textToEncrypt = scanner.nextLine(); 
        System.out.println(cipher.encrypt(textToEncrypt));
    
    
        System.out.print("Укажите ключ для расшифрования: ");
        int key1;
        try {
            key1 = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Некорректный формат ключа. Введите целое число.");
            scanner.close();
            return; 
        }
        App cipher1 = new App(key1);
        System.out.print("Введите текст для расшифрования: ");
        String textToDecrypt = scanner.nextLine();
        System.out.println(cipher1.decrypt(textToDecrypt));
    
        scanner.close();
}}
