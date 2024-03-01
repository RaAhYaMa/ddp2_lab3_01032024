import java.io.*;
import java.util.StringTokenizer;

public class DekDepeNG {
    private static InputReader in = new InputReader(System.in);
    private static OutputStream outputStream = System.out;
    private static PrintWriter out = new PrintWriter(outputStream); 
    private static Dosen[] listDosen;
    private static Siswa[] listSiswa;
    private static MataKuliah[] listMataKuliah;

    /**
     * Main method to execute the program.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        int jumlahDosen = in.nextInt();
        listDosen = new Dosen[jumlahDosen];
        listMataKuliah = new MataKuliah[jumlahDosen];

        // Input lecturer and course data
        for (int i = 0; i < jumlahDosen; i++){
            String idDosen = in.next();
            String kodeMatkul = in.next();
            int kapasitas = in.nextInt();

            MataKuliah matakuliah = new MataKuliah(kodeMatkul, kapasitas);
            Dosen dosen = new Dosen(idDosen, matakuliah);

            listDosen[i] = dosen;
            listMataKuliah[i] = matakuliah;
        }

        int jumlahSiswa = in.nextInt();
        listSiswa = new Siswa[jumlahSiswa];

        // Input student data
        for (int i = 0; i < jumlahSiswa; i++){
            String npm = in.next();

            Siswa siswa = new Siswa(npm);
            listSiswa[i] = siswa;
        }

        int jumlahPerintah = in.nextInt();

        // Process commands
        for(int i = 0; i < jumlahPerintah; i++){
            String perintah = in.next();

            switch (perintah) {
                case "BERINILAI": {
                    String idDosen = in.next();
                    String npm = in.next();
                    int nilai = in.nextInt();

                    beriNilai(idDosen, npm, nilai);
                    break;
                }
                case "CEKNILAI": {
                    String npm = in.next();

                    cekNilai(npm);
                    break;
                }
                case "AMBILMATKUL": {
                    String npm = in.next();
                    String kodeMatkul = in.next();

                    ambilMatkul(npm, kodeMatkul);
                    break;
                }
            }
        }
        out.close();
    }

    /**
     * Assigns a grade to a student for a specific lecturer.
     *
     * @param idDosen Lecturer ID.
     * @param npm     Student ID.
     * @param nilai   Grade to be assigned.
     */
    public static void beriNilai(String idDosen, String npm, int nilai) {
        String output = "";

        for (Dosen dosen : listDosen) {
            if (dosen.getIdDosen().equals(idDosen)) {
                output += dosen.beriNilai(npm, nilai);
                break;
            }
        }

        if (output.equals("")) {
            out.println(idDosen 
            + " gagal memberikan nilai kepada siswa dengan NPM " + npm);
        }
        else {
            out.println(output);
        }    
    }

    /**
     * Displays the grade of a student.
     *
     * @param npm Student ID.
     */
    public static void cekNilai(String npm) {
        Siswa siswa = null;

        for (Siswa s : listSiswa) {
            if (s.getNpm().equals(npm)) {
                siswa = s;
                break;
            }
        }

        out.print(siswa.tampilkanNilai());
    }

    /**
     * Enrolls a student in a course.
     *
     * @param npm        Student ID.
     * @param kodeMatkul Course code.
     */
    public static void ambilMatkul(String npm, String kodeMatkul) {
        String output = "";
        Siswa siswa = null;
        MataKuliah mataKuliah = null;

        // Find the student
        for (Siswa s : listSiswa) {
            if (s.getNpm().equals(npm)) {
                siswa = s;
                break;
            }
        }

        // Find the course
        for (MataKuliah mk : listMataKuliah) {
            if (mk.getKodeMatkul().equals(kodeMatkul)) {
                mataKuliah = mk;
                break;
            }
        }

        // Check if both student and course are found
        if (siswa == null || mataKuliah == null) {
            out.println("Siswa dengan NPM " + npm 
            + " gagal mengambil matkul dengan kode " + kodeMatkul);
        }
        else {
            Siswa[] listsiswa = mataKuliah.getListSiswa();

            for (int i=0 ; i < listsiswa.length ; ++i) {
                if (listsiswa[i] == null) {
                    listsiswa[i] = siswa;
                    break;
                }
            }

            mataKuliah.setListSiswa(listsiswa);
            
            output += siswa.ambilMatkul(mataKuliah);
            out.println(output);  
        }
    }
    
    // taken from https://codeforces.com/submissions/Petr
    // together with PrintWriter, these input-output (IO) is much faster than the usual Scanner(System.in) and System.out
    // please use these classes to avoid your fast algorithm gets Time Limit Exceeded caused by slow input-output (IO)
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}