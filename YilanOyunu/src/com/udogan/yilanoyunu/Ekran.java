package com.udogan.yilanoyunu;

import java.util.Random;
import java.util.stream.IntStream;

public class Ekran {

	public int x;
	public int y;
	public int yeminYeri = 0;
	int puan = 0;

	public Ekran() {

	}

	public void doldur(int[] yilan) {
		Random rand = new Random();

		while (IntStream.of(yilan).anyMatch(i -> i == yeminYeri) || yeminYeri == 0) {
			if (yilan[0] == yeminYeri) {
				yeminYeri = rand.nextInt(this.x * this.y) + 1;
				puan = puan + 10;
			} else {
				yeminYeri = rand.nextInt(this.x * this.y) + 1;
			}
		}

		for (int i = 0; i < y; i++) {
			for (int j = 1; j <= x; j++) {
				if (i * x + j == yilan[0]) {
					System.out.print(" O ");
					continue;
				}
				if (i * x + j == yeminYeri) {
					System.out.print(" * ");
					continue;
				}
				boolean yilaninParcasi = false;
				for (int k = 1; k < yilan.length; k++) {
					if (i * x + j == yilan[k]) {
						yilaninParcasi = true;
						break;
					} else {
						yilaninParcasi = false;
					}
				}
				if (yilaninParcasi) {
					System.out.print(" X ");
				} else {
					System.out.print(" . ");
				}
			}
			System.out.println();
		}

		System.out.println("\nPuan: " + this.puan);
	}
}
