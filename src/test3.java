import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class test3 {
    public static void main(String[] args) {
        List<File> files = getFiles("F:/A_errorIns/");
        for(File f : files){
            System.out.println(f.getName());
        }

    }

    public static List<File> getFiles(String path){
        File root = new File(path);
        List<File> files = new ArrayList<File>();
        if(!root.isDirectory()){
            files.add(root);
        }else{
            File[] subFiles = root.listFiles();
            assert subFiles != null;
            for(File f : subFiles){
                files.addAll(getFiles(f.getAbsolutePath()));
            }
        }
        return files;
    }
}
