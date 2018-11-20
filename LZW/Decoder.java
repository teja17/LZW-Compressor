/**Name:Tejaswini Naredla.StudentID: 801020539 **/

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import static java.lang.Math.pow;

public class Decoder {
    static ArrayList<Integer> input=new ArrayList<>();
    static Hashtable<Integer,String> table=new Hashtable<>();
    static int code;
    static int bit_length,max_tableSize;
    static String string,new_string,file_name;

    public static void main(String[] args){
        try {
            /**Reading command line arguments **/
            file_name = args[0];
            bit_length = Integer.valueOf(args[1]);
            max_tableSize = (int) pow(2, bit_length);
            System.out.println("Max table size" + max_tableSize);

            /**Opening the input text file **/
            Reader reader = (new InputStreamReader
                    (new FileInputStream(file_name), "UTF-16BE"));

            int line,i;
            i=0;

            /**Read Input Text **/
            while((line=reader.read())!=-1) {
                i++;
                input.add(line);
            }

            /**Initialization of Hash Table **/
            for(i=0;i<=255;i++){
                String st;
                st=String.valueOf((char)i);
                table.put(i,st);
            }

            /**Calling the decode method**/
            decode();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void decode() throws IOException{
        /**Creating the output file **/
        String output_fileName=file_name.substring(0,file_name.length()-4)+"_decoded"+".txt";

        Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(output_fileName)));

        /****Decoding the encoded input text and writing into output file ****/
        int i,value;
        i=0;
        code=input.get(i);
        string=(table.get(code));
        System.out.println(string);
        writer.write(string);
        value=256;

        for(i=1;i<input.size();i++){
            code=input.get(i);

            if(!table.containsKey(code)){
                new_string=string+string.charAt(0);

            }else{
                new_string=table.get(code);
            }
            System.out.println(new_string);
            writer.write(new_string);
            if(table.size()<max_tableSize){
                table.put(value,(string+new_string.charAt(0)));
                value++;
            }
            string=new_string;
        }

        System.out.println("OUTPUT:"+string);
        writer.close();
    }
}
