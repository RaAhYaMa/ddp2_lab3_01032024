public class MataKuliah {
    private String kodeMatkul;
    private Siswa[] listSiswa;
    private int kapasitas;
    private int jumlahSiswa;

    /**
     * Constructs a new MataKuliah object with the given course code and capacity.
     *
     * @param kodeMatkul Course code.
     * @param kapasitas  Maximum capacity for the course.
     */
    public MataKuliah(String kodeMatkul, int kapasitas){
        this.kodeMatkul = kodeMatkul;
        this.kapasitas = kapasitas;
        this.listSiswa = new Siswa[100];
    }

    /**
     * Gets the course code.
     *
     * @return Course code.
     */
    public String getKodeMatkul() {
        return kodeMatkul;
    }

    /**
     * Sets the list of students enrolled in the course.
     *
     * @param listSiswa Array of students enrolled.
     */
    public void setListSiswa(Siswa[] listSiswa) {
        this.listSiswa = listSiswa;
    }

    /**
     * Gets the list of students enrolled in the course.
     *
     * @return Array of students enrolled.
     */
    public Siswa[] getListSiswa() {
        return listSiswa;
    }

    /**
     * Gets the maximum capacity of the course.
     *
     * @return Maximum capacity of the course.
     */
    public int getKapasitas() {
        return kapasitas;
    }

    /**
     * Sets the current number of students enrolled in the course.
     *
     * @param jumlahSiswa Current number of students enrolled.
     */
    public void setJumlahSiswa(int jumlahSiswa) {
        this.jumlahSiswa = jumlahSiswa;
    }

    /**
     * Gets the current number of students enrolled in the course.
     *
     * @return Current number of students enrolled.
     */
    public int getJumlahSiswa() {
        return jumlahSiswa;
    }
}