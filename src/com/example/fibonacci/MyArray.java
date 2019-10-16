package com.example.fibonacci;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

class MyArray {
    private int[] a;
    private int size;
    private Random random = new Random();

    MyArray(int size) {
        this.size = size;
        a = new int[size];
    }

    boolean inputMyArray() {
        System.out.println("введите элементы массива:");
        try (Scanner in = new Scanner(System.in)) {
            for (int i = 0; i < size; i++) {
                int x = in.nextInt();
                a[i] = x;
            }
            return true;
        } catch (InputMismatchException e) {
            System.out.println("введено не целое число!");
            System.out.println("ошибка ввода массива!");
            return false;
        }
    }

    void randomMyArray() {
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(100);
        }
    }

    void fibonachiMyArray() {
        int x = 1, y = 1, z;
        a[0] = x;
        a[1] = y;
        for (int i = 2; i < size; i++) {
            z = x + y;
            x = y;
            a[i] = z;
            y = z;
        }
        int temp;
        for (int i = 0; i < size / 2; i++) {
            temp = a[i];
            a[i] = a[size - i - 1];
            a[size - i - 1] = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(String.format("Массив:%n"));
        for (int element : a) {
            s.append(element).append(" ");
        }
        s.append(String.format("%n"));
        return s.toString();
    }
}
