package com.udogan.yilanoyunu;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Ekran ekran = new Ekran();
		System.out.println("L�tfen oyun alan�n�n en de�erini giriniz.");
		ekran.x = sc.nextInt();
		System.out.println("L�tfen oyun alan�n�n boy de�erini giriniz.");
		ekran.y = sc.nextInt();
		Yilan yilan = new Yilan(ekran);
		yilan.yilanYerlestir();
		sc.reset();
		while (true) {
			System.out.println("\nSa�: 3 \nSol: 1 \nYukar�: 5 \nA�a��: 2 \nY�n belirleyiniz. \n\n��kmak i�in: 9");
			int secim = sc.nextInt();
			if (secim == 3) {
				yilan.sag();
				if (yilan.oyunBitti) {
					break;
				}				
			} 
			else if (secim == 1) {
				yilan.sol();
				if (yilan.oyunBitti) {
					break;
				}
			} 
			else if (secim == 2) {
				yilan.asagi();
				if (yilan.oyunBitti) {
					break;
				}
			} 
			else if (secim == 5) {
				yilan.yukari();
				if (yilan.oyunBitti) {
					break;
				}
			} 
			else if (secim == 9) {
				System.out.println("Oyun Bitti");
				break;
			} 
			else {
				System.out.println("hatal� tu�!");
			}
		}
	}
}
