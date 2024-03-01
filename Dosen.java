public class Dosen {
    private String idDosen;
    private MataKuliah mataKuliah;

    /**
     * Constructs a new Dosen object with the given lecturer ID and associated course.
     *
     * @param idDosen    Lecturer ID.
     * @param mataKuliah Course associated with the lecturer.
     */
    public Dosen(String idDosen, MataKuliah mataKuliah){
        this.idDosen = idDosen;
        this.mataKuliah = mataKuliah;
    }

    /**
     * Assigns a grade to a student for the lecturer's associated course.
     *
     * @param npm   Student ID.
     * @param nilai Grade to be assigned.
     * @return A message indicating the success or failure of assigning the grade.
     */
    public String beriNilai(String npm, int nilai) {
        String output = "";

        for (Siswa siswa : this.mataKuliah.getListSiswa()) {
            if (siswa == null) {
                break;
            }
            else if (siswa.getNpm().equals(npm)) {
                for (NilaiController nilaicontroller : siswa.getListNilai()) {
                    if (nilaicontroller.getKodeMatkul().equals(mataKuliah.getKodeMatkul())) {
                        nilaicontroller.setNilai(nilai);
                        output += this.idDosen 
                        + " berhasil memberikan nilai kepada siswa dengan NPM "
                        + npm;
                        return output;
                    }
                }
            }
        }
        
        output += this.idDosen 
        + " gagal memberikan nilai kepada siswa dengan NPM " + npm;
        return output;
    }

    /**
     * Gets the lecturer's ID.
     *
     * @return Lecturer ID.
     */
    public String getIdDosen() {
        return idDosen;
    }

    /**
     * Gets the course associated with the lecturer.
     *
     * @return Associated course.
     */
    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }
}