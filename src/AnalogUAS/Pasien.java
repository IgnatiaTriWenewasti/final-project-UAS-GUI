package AnalogUAS;

public class Pasien {
	String nama;
	int umur;
	String alamat;
	String poli;
	String kelas;
	String status = "Belum Terpanggil";
	
	public Pasien(String nama, int umur, String alamat, String poli, String kelas) {
		this.nama = nama;
		this.umur = umur;
		this.alamat = alamat;
		this.poli = poli;
		this.kelas = kelas;
	}
	
	

	public Pasien(String nama, int umur, String alamat, String poli, String kelas, String status) {
		this.nama = nama;
		this.umur = umur;
		this.alamat = alamat;
		this.poli = poli;
		this.kelas = kelas;
		this.status = status;
	}



	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getUmur() {
		return umur;
	}

	public void setUmur(int umur) {
		this.umur = umur;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getPoli() {
		return poli;
	}

	public void setPoli(String poli) {
		this.poli = poli;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(Boolean status) {
		if(status == true) {
			this.status = "Sudah Terpanggil";
		}
		else if (status == false){
			this.status = "Belum Terpanggil";
		}
	}
	
	

}
