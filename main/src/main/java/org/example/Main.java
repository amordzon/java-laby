package org.example;
import java.util.Scanner;

public class Main {
    private static long factorial(int n){
        long solution = n;
        for(int i = n - 1; i > 0; i--){
            solution*=i;
        }
        return solution;
    }

    private static long power(int n){
        long solution = 1;
        for(int i = 0; i < n; i++){
            solution*=2;
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println("Program wylicza wartosc wyrazenia n! (silnia) dla podanej liczby n");
        int choice;
        do{
            System.out.println("\n1. Oblicz silnie\n2. Oblicz potege\n3. Wyjdz z programu\n");
            choice = new Scanner(System.in).nextInt();
            switch(choice){
                case 1:
                    System.out.println("Podaj liczbe n: ");
                    int n = new Scanner(System.in).nextInt();
                    long solution = factorial(n);
                    System.out.println("Silnia dla wartosci "+n+" wynosi "+solution);
                    break;
                case 2:
                    System.out.println("Podaj liczbe n: ");
                    int number = new Scanner(System.in).nextInt();
                    long powerSolution = power(number);
                    System.out.println("Potega 2 do n dla wartosci "+number+" wynosi "+powerSolution);
                    break;
                case 3:
                    System.out.println("Konczenie programu");
                    break;
                default:
                    System.out.println("Zla opcja z menu!");
            }

        } while(choice!=3);
    }
}