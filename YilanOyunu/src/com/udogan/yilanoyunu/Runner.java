package com.udogan.yilanoyunu;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Ekran ekran = new Ekran();
		System.out.println("Lütfen oyun alanýnýn en deðerini giriniz.");
		ekran.x = sc.nextInt();
		System.out.println("Lütfen oyun alanýnýn boy deðerini giriniz.");
		ekran.y = sc.nextInt();
		Yilan yilan = new Yilan(ekran);
		yilan.yilanYerlestir();
		sc.reset();
		while (true) {
			System.out.println("\nSað: 3 \nSol: 1 \nYukarý: 5 \nAþaðý: 2 \nYön belirleyiniz. \n\nÇýkmak için: 9");
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
				System.out.println("hatalý tuþ!");
			}
		}
	}
}
