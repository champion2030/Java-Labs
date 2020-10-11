package laboratory_work_9;

import java.io.*;

public class FileWork {
    public String PathToFile;
    public String StrInFile;
    public String ResultStr;
    FileWork(String filepath){ this.PathToFile = filepath; }

    public String read_file() throws IOException, CheckFileException {
        File myFile = new File(PathToFile);
        if (myFile.exists()) {
            if (myFile.length() != 0) {
                BufferedReader br = new BufferedReader(new FileReader(PathToFile));
                StrInFile = br.readLine();
                br.close();
            } else throw new CheckFileException("File is Empty");
        } else throw new CheckFileException("Don't have such file");
        return StrInFile;
    }

    public void write_result_file() throws CheckFileException, IOException {
        BufferedWriter br = null;
        br = new BufferedWriter(new FileWriter("result.txt"));
        if(!StrInFile.isEmpty()){
            br.write(StrInFile);
            br.close();
        }
    }

    public String get_result_str() throws IOException, CheckFileException {
        File res_file = new File("result.txt");
        if (res_file.exists()) {
            if (res_file.length() != 0) {
                BufferedReader br = new BufferedReader(new FileReader("result.txt"));
                ResultStr = br.readLine();
                br.close();
            } else throw new CheckFileException("File is Empty");
        } else throw new CheckFileException("Don't have such file");
        return StrInFile;
    }
}
