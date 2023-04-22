package org.example;
import java.util.Scanner;

public class Main {
    static boolean stop = false;
    public static void main(String[] args) {
        System.out.println("Program sluzy do dodawania ocen uzytkownika, liczenia sredniej, min i max");
        GradeList grades = new GradeList();
        do {
            System.out.println("Wybierz opcje z menu\n1.Dodanie nowej oceny\n2.Wyliczenie sredniej\n3.Wyswietlenie najwyzszej oceny\n4.Wyswietlenie najnizszej oceny\n5.Wyjscie z programu\n");
            int wybor=new Scanner(System.in).nextInt();
            returnSwitch(wybor,grades);
        } while (!stop);
    }

    private static void returnSwitch(int wybor, GradeList grades){
        switch (wybor) {
            case 1 -> {
                System.out.println("Podaj ocene: ");
                Double ocena = new Scanner(System.in).nextDouble();
                grades.addGrade(ocena);
            }
            case 2 -> {
                Double srednia = grades.calculateAvg();
                if (srednia == -1.0) System.out.println("Lista jest pusta!");
                else System.out.println("Srednia wynosi " + srednia);
            }
            case 3 -> {
                Double max = grades.findMax();
                if (max == -1.0) System.out.println("Lista jest pusta!");
                else System.out.println("Max wynosi " + max);
            }
            case 4 -> {
                Double min = grades.findMin();
                if (min == -1.0) System.out.println("Lista jest pusta!");
                else System.out.println("Min wynosi " + min);
            }
            case 5 -> {
                stop = true;
                System.out.println("Koniec programu!");
            }
            default -> System.out.println("Wybierz poprawna opcje!");
        }
    }
}