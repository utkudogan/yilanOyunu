package com.udogan.yilanoyunu;

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
		if (yilanKonum[0] % ekran.x == 0 ) {
			System.out.println("SA - Oyun Bitti!");
			this.oyunBitti = true;
			return;
		}
		yilaninHareketi(1);
		yilanYerlestir();
	}

	public void sol() {
		if (yilanKonum[0] % ekran.x == 1 ) {
			System.out.println("SO - Oyun Bitti!");
			this.oyunBitti = true;
			return;
		}		
		yilaninHareketi(-1);
		yilanYerlestir();
	}

	public void yukari() {
		if (yilanKonum[0] < ekran.x) {
			System.out.println("Y - Oyun Bitti!");
			this.oyunBitti = true;
			return;
		}
		yilaninHareketi(-ekran.x);
		yilanYerlestir();
	}

	public void asagi() {
		if (yilanKonum[0] > (ekran.y-1) * ekran.x) {
			System.out.println("A - Oyun Bitti!");
			this.oyunBitti = true;
			return;
		}
		yilaninHareketi(ekran.x);
		yilanYerlestir();
	}

	private void yilaninHareketi(int yilaninHareketi) {
		if (yilanKonum[0] + yilaninHareketi == yilanKonum[1]) {
			return;
		}
		yilanKonum[2] = yilanKonum[1];
		yilanKonum[1] = yilanKonum[0];
		yilanKonum[0] = yilanKonum[0] + yilaninHareketi;
	}
}
