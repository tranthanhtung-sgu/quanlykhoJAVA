package quanlykho;

import java.io.File;

public class chucnang {
	public void uploadfile(String source, String destination,String md5name)
    {
        try{

           File afile =new File(source);

           if(afile.renameTo(new File(destination + md5name))){
            System.out.println("File is moved successful!");
           }else{
            System.out.println("File is failed to move!");
           }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
