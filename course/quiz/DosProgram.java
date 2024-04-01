import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DosProgram {
    static void printFileList(File dir) {
        System.out.println("Full Path : " + dir.getAbsolutePath());

        List<Integer> subdir = new ArrayList<Integer>();
        
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
           File file = files[i];

           String filename = file.getName();
           SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
           String attribute = "";
           String size = "";
           
           if (file.isDirectory()) {
              attribute = "<DIR>";
              subdir.add(i);  
           } else {
              size = file.length() + "";
           }
           System.out.printf("%s  %3s  %10s  %s  \n", dt.format(new Date()), attribute, size, filename);
        }
        
        System.out.println("**********************************");

        for (int i = 0; i < subdir.size(); i++) { 
           int index = subdir.get(i);
           printFileList(files[index]); 
        }
     }

    public static void main(String[] args){

      if(args.length != 2 && args.length != 3 && args.length != 4) {
         
        System.out.println("사용법 : [java파일명] [디렉토리경로] dir");

        System.out.println("사용법 : [java파일명] [디렉토리경로] mkdir [생성 디렉토리명]");
         
        System.out.println("사용법 : [java파일명] [디렉토리경로] rmdir [폴더명]");
   
        System.out.println("사용법 : [java파일명] [디렉토리경로] rename [파일명 or 폴더명] [새로운 파일명 or 폴더명]");
         
        System.out.println("사용법 : [java파일명] [디렉토리경로] move [파일명 or 폴더명] [옮길 디렉토리 경로]");
         
        System.out.println("사용법 : [java파일명] [디렉토리경로] find [검색 내용] [파일명]");
   
        System.exit(0);

        }

        File f = new File(args[0]);

        if(!f.exists() || !f.isDirectory()) {

        System.out.println("유효하지 않은 디렉토리입니다");
   
        System.exit(0);

        }
        
        if(args[1].equals("dir")){
            printFileList(f);
        }
        
        if(args[1].equals("mkdir")){
            File dir = new File(f + "\\" + args[2]);
            if (dir.exists()) System.out.println("이미 존재하는 폴더입니다.");
            else if (dir.mkdir()) System.out.println("폴더 생성 완료");
            else System.out.println("폴더 생성 실패");
        }
        
        if(args[1].equals("rmdir")){
            File dir = new File(f + "\\" + args[2]);
            if (dir.delete()) System.out.println("폴더 삭제 완료");
            else System.out.println("폴더 삭제 실패");
        }
        
        if(args[1].equals("rename")) {
            File targetFile = new File(f + "\\" + args[2]);
            if (!targetFile.exists()) {
            System.out.println("존재하지 않는 파일 혹은 폴더입니다.");
            return;
            }
            File renameFile = new File(f + "\\" + args[3]);
            if(targetFile.renameTo(renameFile)) {
            System.out.println(args[2] + " -> " + args[3] + " 변경 완료되었습니다.");
            } else {
            System.out.println("이름 변경이 실패했습니다.");
            }
        }
        if(args[1].equals("move")) {
            File targetFile = new File(f + "\\" + args[2]);
            if (!targetFile.exists()) {
            System.out.println("존재하지 않는 파일 혹은 폴더입니다.");
            return;
            }
            File renameFile = new File(args[3] + "\\" + args[2]);
            if (targetFile.renameTo(renameFile)) {
            System.out.println(args[2] + " -> " + args[3] + " 이동 완료되었습니다.");
            } else {
            System.out.println("이동이 실패했습니다.");
            }
        }
        if(args[1].equals("find")) {
            File targetFile = new File(f + "\\" + args[3]); //파일명 확인
            if(!targetFile.exists() | !targetFile.isFile()) {
                System.out.println("해당 파일이 존재하지 않습니다");
                return;
            }
            System.out.println(targetFile); // 파일명
            BufferedReader br = null;
            String line = "";
            try {
            br = new BufferedReader(new FileReader(targetFile));
            while((line = br.readLine()) != null) {
                if(line.indexOf(args[2]) != -1) {
                    System.out.println(line);
                }
            }
            } catch (IOException e) {
            e.printStackTrace();
            }
        }
    }
}