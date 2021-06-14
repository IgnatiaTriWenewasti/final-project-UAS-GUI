package AnalogUAS;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoketRumahSakit {

	private JFrame MainMenu;

	private String nama;
	private int umur;
	private String alamat;
	private String poli;
	private String kelas;
	private int jumlahP;

	ArrayList<Pasien> pasiens = new ArrayList<Pasien>();

	private JComboBox<String> cbPoli;
	private JComboBox<String> cbKelas;
	private JSpinner spinUmur;
	private JLabel gambarLogo;
	private JLabel lblAlamatRS;
	private JPanel pnlPendaftaran;
	private JLabel lblNoHP;
	private JLabel lblAntrianke;
	private JLabel lblNomorA;
	private JTextField tfNama;
	private JLabel lblNamaPs;
	private JLabel lblUmurPs;
	private JTextField tfAlamat;
	private JLabel lblAlamatPs;
	private JButton btnDaftar;
	private JLabel lblStatus;
	private JFrame MenuTable;
	private JTable tableP;
	private DefaultTableModel dtm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoketRumahSakit window = new LoketRumahSakit();
					window.MainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoketRumahSakit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		// Untuk Menghitung Jumlah Antrian
		jumlahP = 0;

		// Ini Model Tabel Yang Akan Di Gunakan DI JTable
		dtm = new DefaultTableModel();
		dtm.addColumn("No.");
		dtm.addColumn("Nama Pasien");
		dtm.addColumn("Umur");
		dtm.addColumn("Alamat Pasien");
		dtm.addColumn("Poli");
		dtm.addColumn("Kelas");
		dtm.addColumn("Status");

		MainMenu = new JFrame("Antrian Rumah Sakit");
		MainMenu.setResizable(false);
		MainMenu.setBounds(100, 100, 797, 480);
		MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainMenu.getContentPane().setLayout(null);

		gambarLogo = new JLabel("Gmabar logo");
		gambarLogo.setIcon(new ImageIcon(LoketRumahSakit.class.getResource("/Images/Desain tanpa judul.png")));
		gambarLogo.setBounds(10, 18, 69, 65);
		MainMenu.getContentPane().add(gambarLogo);

		pnlPendaftaran = new JPanel();
		pnlPendaftaran.setForeground(Color.WHITE);
		pnlPendaftaran.setBounds(10, 152, 374, 230);
		MainMenu.getContentPane().add(pnlPendaftaran);
		pnlPendaftaran.setLayout(null);

		lblNamaPs = new JLabel("Nama");
		lblNamaPs.setBounds(14, 27, 39, 19);
		pnlPendaftaran.add(lblNamaPs);
		lblNamaPs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNamaPs.setHorizontalAlignment(SwingConstants.LEFT);

		tfNama = new JTextField();
		tfNama.addKeyListener(new KeyAdapter() {
			@Override
			// Menthod membatasi karakter yang dimasukan hanya berupa alphabet
			public void keyTyped(KeyEvent e) {
				char a = e.getKeyChar();
				String key = String.valueOf(a);
				if (!(key.matches("(.*)[a-zA-Z ](.*)")) && (key != "\b")) {
					e.consume();
				}
			}
		});
		tfNama.setBounds(73, 28, 275, 20);
		pnlPendaftaran.add(tfNama);
		tfNama.setColumns(10);

		lblUmurPs = new JLabel("Umur");
		lblUmurPs.setBounds(14, 60, 49, 14);
		pnlPendaftaran.add(lblUmurPs);
		lblUmurPs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUmurPs.setHorizontalAlignment(SwingConstants.LEFT);

		lblAlamatPs = new JLabel("Alamat");
		lblAlamatPs.setBounds(14, 91, 59, 14);
		pnlPendaftaran.add(lblAlamatPs);
		lblAlamatPs.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlamatPs.setFont(new Font("Tahoma", Font.PLAIN, 15));

		tfAlamat = new JTextField();
		tfAlamat.setBounds(73, 90, 275, 20);
		pnlPendaftaran.add(tfAlamat);
		tfAlamat.setColumns(10);

		cbPoli = new JComboBox<String>();
		cbPoli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Poli Bedah Saraf", "Poli Jantung",
				"Poli Kulit Kelamin", "Poli Mata", "Poli Ortopedi", "Poli Kandungan", "Poli Paru", }));
		cbPoli.setBounds(73, 126, 275, 22);
		pnlPendaftaran.add(cbPoli);

		btnDaftar = new JButton("DAFTAR");
		btnDaftar.setBounds(131, 192, 89, 23);
		pnlPendaftaran.add(btnDaftar);

		cbKelas = new JComboBox<String>();
		cbKelas.setBounds(73, 159, 275, 22);
		pnlPendaftaran.add(cbKelas);
		cbKelas.setModel(new DefaultComboBoxModel<String>(new String[] { "KELAS I", "KELAS II", "KELAS III","VIP", "VVIP",
				"ICU", "UNIT LUKA BAKAR", "PERINATOLOGI" }));

		JLabel lblPoliPs = new JLabel("Poli");
		lblPoliPs.setBounds(24, 128, 39, 14);
		lblPoliPs.setHorizontalAlignment(SwingConstants.LEFT);
		lblPoliPs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlPendaftaran.add(lblPoliPs);

		JLabel lblKelasPs = new JLabel("Kelas");
		lblKelasPs.setBounds(17, 161, 82, 14);
		lblKelasPs.setHorizontalAlignment(SwingConstants.LEFT);
		lblKelasPs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlPendaftaran.add(lblKelasPs);

		spinUmur = new JSpinner();
		spinUmur.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinUmur.setBounds(73, 58, 275, 20);
		pnlPendaftaran.add(spinUmur);

		pnlAntian = new JPanel();
		pnlAntian.setBounds(428, 152, 325, 230);
		MainMenu.getContentPane().add(pnlAntian);
		pnlAntian.setLayout(null);

		lblAntrianke = new JLabel("NO ANTRIAN KE");
		lblAntrianke.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAntrianke.setBounds(68, 10, 179, 14);
		pnlAntian.add(lblAntrianke);
		lblAntrianke.setHorizontalAlignment(SwingConstants.CENTER);

		lblNomorA = new JLabel("0");
		lblNomorA.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNomorA.setBounds(83, 44, 157, 59);
		pnlAntian.add(lblNomorA);
		lblNomorA.setHorizontalAlignment(SwingConstants.CENTER);

		// Button untuk mengubah status pasien menjadi terpanggil di menu utama
		JButton btnPanggil = new JButton("PANGGIL");
		btnPanggil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Menggunakan label antrian untuk mendapatkan indek arraylist
				// Dan mengubah status pasien yang di maksud
				int nomorT = (Integer.parseInt(lblNomorA.getText()) - 1);
				if (pasiens.get(nomorT).status == "Belum Terpanggil") {
					pasiens.get(nomorT).setStatus(true);
					jumlahP = jumlahP - 1;
				}
				refreshStatus();
			}
		});
		btnPanggil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPanggil.setBounds(109, 184, 99, 23);
		pnlAntian.add(btnPanggil);

		// Button untuk mengurangi atau menscroll Lebel Nomor Antrian
		btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int kurang = Integer.parseInt(lblNomorA.getText());
				if (kurang > 1) {
					int hasilK = kurang - 1;
					lblNomorA.setText(String.valueOf(hasilK));
				}
				refreshStatus();
			}
		});
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnMinus.setBounds(44, 74, 55, 23);
		pnlAntian.add(btnMinus);

		// Button Menambah Lebel Nomor antrian
		btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tambah = Integer.parseInt(lblNomorA.getText());
				if (tambah < pasiens.size()) {
					int hasilT = tambah + 1;
					lblNomorA.setText(String.valueOf(hasilT));
				}
				refreshStatus();

			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnPlus.setBounds(217, 74, 55, 23);
		pnlAntian.add(btnPlus);

		lblJumlahA = new JLabel(" Jumlah Antrian :");
		lblJumlahA.setBounds(29, 205, 179, 26);
		pnlAntian.add(lblJumlahA);
		lblJumlahA.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblJumlahA.setHorizontalAlignment(SwingConstants.LEFT);

		lblDataA = new JLabel("0");
		lblDataA.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataA.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDataA.setBounds(168, 206, 103, 26);
		pnlAntian.add(lblDataA);

		JPanel pnlStatus = new JPanel();
		pnlStatus.setBounds(61, 149, 199, 23);
		pnlAntian.add(pnlStatus);
		pnlStatus.setBackground(UIManager.getColor("Button.light"));
		pnlStatus.setLayout(null);

		lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 0, 179, 23);
		pnlStatus.add(lblStatus);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		panel.setBounds(54, 116, 206, 23);
		pnlAntian.add(panel);
		panel.setLayout(null);
		
		taNaPas = new JLabel("New label");
		taNaPas.setHorizontalAlignment(SwingConstants.CENTER);
		taNaPas.setBounds(10, 0, 186, 23);
		panel.add(taNaPas);
		taNaPas.setFont(new Font("Arial Narrow", Font.BOLD, 15));

		pnlRS = new JPanel();
		pnlRS.setBackground(new Color(30, 144, 255));
		pnlRS.setBounds(89, 0, 684, 81);
		MainMenu.getContentPane().add(pnlRS);
		pnlRS.setLayout(null);

		JLabel lblNamaRS = new JLabel("RSUD Antonius Pontianak");
		lblNamaRS.setBounds(10, 0, 617, 32);
		pnlRS.add(lblNamaRS);
		lblNamaRS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNamaRS.setHorizontalAlignment(SwingConstants.LEFT);
		lblNamaRS.setVerticalAlignment(SwingConstants.BOTTOM);

		lblAlamatRS = new JLabel(
				"Jl.Khw. Hasyim No.249, Sungai Jawi Dalam, Kec.Pontianak Kota, Kota Pontianak, Kalimantan Barat 78243");
		lblAlamatRS.setBounds(10, 29, 654, 26);
		pnlRS.add(lblAlamatRS);
		lblAlamatRS.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNoHP = new JLabel("Phone + 62 561 732 101");
		lblNoHP.setBounds(10, 50, 617, 20);
		pnlRS.add(lblNoHP);
		lblNoHP.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblForm = new JLabel("FORM PENDAFTARAN");
		lblForm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblForm.setBounds(107, 124, 201, 17);
		MainMenu.getContentPane().add(lblForm);

		JButton btnList = new JButton("LIST PASIEN");
		btnList.setBounds(113, 392, 142, 23);
		MainMenu.getContentPane().add(btnList);

		background = new JLabel("");
		background.setBounds(0, 83, 783, 360);
		MainMenu.getContentPane().add(background);
		
		//Button list pasien ke menu Tabel
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainMenu.setVisible(false);
				MenuTable.setVisible(true);
				refreshTable();
			}
		});

		// Buttton untuk mendaftarkan pasien
		btnDaftar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nama = tfNama.getText();
				umur = (int) spinUmur.getValue();
				alamat = tfAlamat.getText();
				poli = cbPoli.getSelectedItem().toString();
				kelas = cbKelas.getSelectedItem().toString();
				
				//Untuk Mengecek Apakah User telah Memasukan data Dengan Lengkap Atau tidak
				if (!(nama.equals("")) && !(alamat.equals(""))) {
					
					//Memasukan Data Yang Di input ke array list yang dibuat
					pasiens.add(new Pasien(nama, umur, alamat, poli, kelas));
					JOptionPane.showMessageDialog(null, "Pasien DiDaftarkan");
					
					// Jumlah Antrian Pasien ditambah 1
					jumlahP = jumlahP + 1;

					// ini kondisi pertamakali medaftarkan pasien
					if (lblNomorA.getText() == "0") {
						lblNomorA.setText("1");
					}
					refreshStatus();
					
					resetData();
				} else {
					JOptionPane.showMessageDialog(null, "Harap Masukan Data Dengan Lengkap");
				}

				

			}
		});

		// Window Table / menu Ke 2
		MenuTable = new JFrame();
		MenuTable.setResizable(false);
		MenuTable.setBounds(100, 100, 797, 480);
		MenuTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuTable.getContentPane().setLayout(null);

		// Tombol untuk kembali ke menu utama (di saat berada di menu 2)
		JButton btnKembali = new JButton("Kembali");
		btnKembali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuTable.setVisible(false);
				MainMenu.setVisible(true);
			}
		});
		btnKembali.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		btnKembali.setBounds(84, 389, 130, 21);
		MenuTable.getContentPane().add(btnKembali);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 50, 656, 329);
		MenuTable.getContentPane().add(scrollPane);

		// Contrustor table
		tableP = new JTable();
		tableP.setModel(dtm);
		//Untuk Mengatur  Besar Kolom Table
		tableP.getColumnModel().getColumn(0).setPreferredWidth(2);
		tableP.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableP.getColumnModel().getColumn(2).setPreferredWidth(2);
		tableP.getColumnModel().getColumn(3).setPreferredWidth(120);
		tableP.getColumnModel().getColumn(4).setPreferredWidth(60);
		tableP.getColumnModel().getColumn(5).setPreferredWidth(10);
		tableP.getColumnModel().getColumn(6).setPreferredWidth(60);
		scrollPane.setViewportView(tableP);

		// Button untuk memilih data pasien dan menampilkanya di menu utama
		JButton btnPilih = new JButton("Pilih Data Pasien");
		btnPilih.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableP.getSelectedRow() >= 0) {
					lblNomorA.setText(String.valueOf(tableP.getSelectedRow() + 1));
					MenuTable.setVisible(false);
					refreshStatus();
					MainMenu.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Data Belum Dipilih");
				}

			}
		});
		btnPilih.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		btnPilih.setBounds(548, 389, 156, 21);
		MenuTable.getContentPane().add(btnPilih);

		JLabel lblDaftarP = new JLabel("Daftar Pasien");
		lblDaftarP.setFont(new Font("Arial", Font.BOLD, 23));
		lblDaftarP.setBounds(292, 19, 164, 21);
		MenuTable.getContentPane().add(lblDaftarP);

		// button untuk mengganti status pasien
		JButton btnGantiS = new JButton("Ubah Status");
		btnGantiS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int S = (tableP.getSelectedRow());
					//memberikan opsi kepada user pilihan yes or no
					int o = JOptionPane.showConfirmDialog(null, "Apakah Yakin Ingin Mengubah Status?", "",
							JOptionPane.YES_NO_OPTION);
					if (o == JOptionPane.YES_OPTION) {
						if (pasiens.get(S).status == "Belum Terpanggil") {
							pasiens.get(S).setStatus(true);
							JOptionPane.showMessageDialog(null, "Status Di Ubah Menjadi 'Terpanggil' ");
							jumlahP = jumlahP - 1;
							refreshStatus();
						} else {
							pasiens.get(S).setStatus(false);
							jumlahP = jumlahP + 1;
							JOptionPane.showMessageDialog(null, "Status Di Ubah Menjadi 'Belum Terpannggil'");
							refreshStatus();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Dibatalkan");
					}
					
					refreshTable();
				} 	catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Data Belum Dipilih");
			}

			}}
		);
		btnGantiS.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		btnGantiS.setBounds(376, 384, 133, 30);
		MenuTable.getContentPane().add(btnGantiS);

		// Button untuk menghapus data pasien yang di pilih pada tabel
		JButton btnHapus = new JButton("Hapus Data");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int S = JOptionPane.showConfirmDialog(null, "Apakah Yakin Ingin Menghapus Data", "",
							JOptionPane.YES_NO_OPTION);
					if (S == JOptionPane.YES_OPTION) {
						pasiens.remove(tableP.getSelectedRow());
						refreshTable();
					} else {
						JOptionPane.showMessageDialog(null, "Dibatalkan");
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Harap Pilih Data Terlebih Dahulu");
				}
			}
		});
		btnHapus.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		btnHapus.setBounds(226, 384, 133, 30);
		MenuTable.getContentPane().add(btnHapus);
	}

	// Menthod Untuk Me refresh tampilan status panggilan pasien di menu utama
	public void refreshStatus() {
		int nomorT = (Integer.parseInt(lblNomorA.getText()) - 1);
		lblStatus.setText(pasiens.get(nomorT).status);
		lblDataA.setText(String.valueOf(jumlahP));
		taNaPas.setText(pasiens.get(nomorT).nama);
	}

	// Menthod untuk merefresh tabel di menu ke 2
	public void refreshTable() {

		dtm.setRowCount(0);
		for (int i = 0; i < pasiens.size(); i++) {
			String nama = pasiens.get(i).nama;
			String umur = String.valueOf(pasiens.get(i).umur);
			String alamat = pasiens.get(i).alamat;
			String poli = pasiens.get(i).poli;
			String kelas = pasiens.get(i).kelas;
			String status = pasiens.get(i).status;
			Object[] dataP = { 1 + i, nama, umur, alamat, poli, kelas, status };
			dtm.addRow(dataP);
		}

	}
	
	public void resetData() {
		tfNama.setText("");
		spinUmur.setValue(Integer.valueOf("1"));
		tfAlamat.setText("");
		cbPoli.setSelectedItem("Poli Bedah Saraf");
		cbKelas.setSelectedItem("KELAS I");
		
	}

	private JPanel pnlAntian;
	private JLabel lblJumlahA;
	private JPanel pnlRS;
	private JButton btnMinus;
	private JButton btnPlus;
	private JLabel lblForm;
	private JLabel lblDataA;
	private JLabel background;
	private JLabel taNaPas;
}
