package com.udogan.yilanoyunu;

import java.util.stream.IntStream;

public class Yilan {

	private Ekran ekran;
	public boolean oyunBitti = false;
	private int[] yilanKonum = new int[3];

	public Yilan(Ekran ekran) {
		this.ekran = ekran;
		yilanKonum[0] = 2 * this.ekran.x + 1;
		yilanKonum[1] = this.ekran.x + 1;
		yilanKonum[2] = 1;
	}

	public void yilanYerlestir() {
		ekran.doldur(yilanKonum);
	}

	public void sag() {
		if (yilanKonum[0] % ekran.x == 0) {
			System.out.println("Duvara tosladýn - Oyun Bitti!");
			this.oyunBitti = true;
			return;
		}
		yilaninHareketi(1);
		if (!oyunBitti) {
			yilanYerlestir();
		}		
	}

	public void sol() {
		if (yilanKonum[0] % ekran.x == 1) {
			System.out.println("Duvara tosladýn - Oyun Bitti!");
			this.oyunBitti = true;
			return;
		}
		yilaninHareketi(-1);
		if (!oyunBitti) {
			yilanYerlestir();
		}
	}

	public void yukari() {
		if (yilanKonum[0] < ekran.x) {
			System.out.println("Duvara tosladýn - Oyun Bitti!");
			this.oyunBitti = true;
			return;
		}
		yilaninHareketi(-ekran.x);
		if (!oyunBitti) {
			yilanYerlestir();
		}
	}

	public void asagi() {
		if (yilanKonum[0] > (ekran.y - 1) * ekran.x) {
			System.out.println("Duvara tosladýn - Oyun Bitti!");
			this.oyunBitti = true;
			return;
		}
		yilaninHareketi(ekran.x);
		if (!oyunBitti) {
			yilanYerlestir();
		}
	}

	private void yilaninHareketi(int yilaninHareketi) {
		if (IntStream.of(yilanKonum).anyMatch(i -> i == yilanKonum[0] + yilaninHareketi)) {
			System.out.println("Isýrýldýn - Oyun Bitti!");
			this.oyunBitti = true;
			return;
		}
		
		if (yilanKonum[0] + yilaninHareketi == ekran.yeminYeri) {
			if (yilanKonum.length + 1 == ekran.y * ekran.x) {
				System.out.println("Tebrikler Oyunu Kazandýn\n\nPuan: " + (ekran.puan + 10));
			}
			
			int[] tempYilanKonum = new int[yilanKonum.length + 1];
			tempYilanKonum[0] = yilanKonum[0] + yilaninHareketi;
			for (int i = 0; i < yilanKonum.length; i++) {
				tempYilanKonum[i + 1] = yilanKonum[i];
			}
			yilanKonum = tempYilanKonum;
		} else {
			if (yilanKonum[0] + yilaninHareketi == yilanKonum[1]) {
				return;
			}

			for (int i = yilanKonum.length - 1; i >= 0; i--) {
				if (i == 0) {
					yilanKonum[0] = yilanKonum[0] + yilaninHareketi;
				} else {
					yilanKonum[i] = yilanKonum[i-1];
				}
			}
		}
	}
}
