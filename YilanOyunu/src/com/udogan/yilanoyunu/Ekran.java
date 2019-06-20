package com.udogan.yilanoyunu;

public class Ekran {

	public int x;
	public int y;

	public Ekran() {

	}

	public void doldur(int[] yilan) {
		for (int i = 0; i < y; i++) {
			for (int j = 1; j <= x; j++) {
				if (i * x + j == yilan[0]) {
					System.out.print(" O ");
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
				}
				else {
					System.out.print(" . ");
				}
			}
			System.out.println();
		}
	}
}
