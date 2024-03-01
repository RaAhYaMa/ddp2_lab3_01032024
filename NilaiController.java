public class NilaiController {
    private String kodeMatkul;
    private int nilai;

    /**
     * Constructs a new NilaiController object with the given course code.
     *
     * @param kodeMatkul Course code.
     */
    public NilaiController(String kodeMatkul){
        this.kodeMatkul = kodeMatkul;
    }

    /**
     * Gets the course code associated with the grade controller.
     *
     * @return Course code.
     */
    public String getKodeMatkul() {
        return kodeMatkul;
    }

    /**
     * Gets the grade assigned for the course.
     *
     * @return Grade assigned.
     */
    public int getNilai() {
        return nilai;
    }

    /**
     * Sets the grade for the course.
     *
     * @param nilai Grade to be assigned.
     */
    public void setNilai(int nilai) {
        this.nilai = nilai;
    }
}