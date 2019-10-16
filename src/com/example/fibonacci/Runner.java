package com.example.fibonacci;

import java.util.InputMismatchException;
import java.util.Scanner;

class Runner {

    public static void main(String[] args) {
        System.out.println("укажите размер массива >2:");
        try (Scanner in = new Scanner(System.in)) {
            int size = in.nextInt();
            if (size < 3) {
                throw new MyArrayException("Размер массива <3!");
            }
            MyArray a = new MyArray(size);
            System.out.println("выберите способ заполнения массива:");
            System.out.println("1-ввод");
            System.out.println("2-заполнение случайными числами");
            System.out.println("3-заполнение последовательностью Фибоначчи");
            int x = in.nextInt();
            switch (x) {
                case 1:
                    if (a.inputMyArray())
                        System.out.println(a.toString());
                    break;
                case 2:
                    a.randomMyArray();
                    System.out.println(a.toString());
                    break;
                case 3:
                    a.fibonachiMyArray();
                    System.out.println(a.toString());
                    break;
                default:
                    System.out.println("нет такой операции");
            }
        } catch (MyArrayException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("введено не целое число!");
        }
    }
}
