
package Q2_lambdas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Q2_lambdas {
    public static void files_lambdas(){
        File file=new File("src/Q2_lambdas/file.txt");
        try {
            FileInputStream fis=new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            
            StringBuilder build=new StringBuilder();
            while(br.ready()){
             build.append(br.readLine()).append("\n");
            }
            System.out.println("(result)->: "+build);
            
            operations_Q2_lambdas oql=(text)->{
                
                HashMap<String,Integer> hash=new HashMap();
                
                for (int i = 0; i <text.length(); i++) {
                Character ch=text.charAt(i);
                Integer num=hash.get(ch.toString());
                    if (num==null) {
                        hash.put(ch.toString(), 1);
                    }else{
                       hash.put(ch.toString(), num+1);
                    }
                
                }
                return hash;
            };
            
            System.out.println("(result) -> :"+oql.operation_part(build.toString()));
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Q2_lambdas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Q2_lambdas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        files_lambdas();
    }
    interface operations_Q2_lambdas{
        public Object operation_part(String text);
    }
}
