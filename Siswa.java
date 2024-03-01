public class Siswa {
    private String npm;
    private NilaiController[] listNilai = new NilaiController[100];

    /**
     * Constructs a new Siswa object with the given student ID.
     *
     * @param npm Student ID.
     */
    public Siswa(String npm){
        this.npm = npm;
    }

    /**
     * Enrolls the student in a course, represented by the given MataKuliah object.
     *
     * @param mataKuliah Course to be enrolled.
     * @return A message indicating the success or failure of course enrollment.
     */
    public String ambilMatkul(MataKuliah mataKuliah) {
        String output = "";

        if (mataKuliah.getJumlahSiswa() >= mataKuliah.getKapasitas()) {
            output += "Siswa dengan NPM" + this.npm 
            + " gagal mengambil matkul dengan kode " 
            + mataKuliah.getKodeMatkul();
            return output;
        }

        String kodeMatkul = mataKuliah.getKodeMatkul();
        NilaiController nilai = new NilaiController(kodeMatkul);

        for (int i=0 ; i < listNilai.length ; ++i) {
            if (listNilai[i] == null) {
                listNilai[i] = nilai;
                break;
            }
        }

        mataKuliah.setJumlahSiswa(mataKuliah.getJumlahSiswa() + 1);

        output += "Siswa dengan NPM " + this.npm 
        + " berhasil mengambil matkul dengan kode " 
        + mataKuliah.getKodeMatkul();
        return output;
    }

    /**
     * Displays the grades of the student for all enrolled courses.
     *
     * @return A string representation of the student's grades.
     */
    public String tampilkanNilai() {
        String output = "";

        for (NilaiController nilaicontroller : listNilai) {
            if (nilaicontroller == null) {
                break;
            }
            output += "Kode matkul " + nilaicontroller.getKodeMatkul() 
            + " memiliki nilai " + nilaicontroller.getNilai() + "\n";
        }

        if (output.equals("")) {
            return "Siswa belum mengambil mata kuliah :v\n";
        }
        
        return output;
    }

    /**
     * Gets the list of grades for the student.
     *
     * @return Array of grades.
     */
    public NilaiController[] getListNilai() {
        return listNilai;
    }

    /**
     * Gets the student's ID.
     *
     * @return Student ID.
     */
    public String getNpm() {
        return npm;
    }
}