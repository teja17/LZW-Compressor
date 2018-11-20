 /**Name:Tejaswini Naredla StudentID: 801020539 **/
import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import static java.lang.Math.pow;

public class Encoder {

    static ArrayList<Character> input=new ArrayList<>();
    static Hashtable<String,Integer> table=new Hashtable<>();
    static int bit_length,max_tableSize;
    static String symbol,file_name;

    public static void main(String[] args){
       try {
           /**Reading command line arguments **/
           file_name = args[0];
           bit_length = Integer.valueOf(args[1]);
           max_tableSize = (int) pow(2, bit_length);
           System.out.println("Max table size:" + max_tableSize);

           /**Opening the input text file **/
           BufferedReader reader = new BufferedReader(new FileReader(file_name));

           int line,i;
           char c;
           i=0;

           /**Read Input Text **/
           while ((line=reader.read())>0){
               c=(char) line;
               input.add(c);  //add input into char array list
               i++;
           }

           /**Initialization of Hash Table **/
           for(i=0;i<=255;i++){
               String st;
               st=String.valueOf((char)i);
               table.put(st,i);
           }

           /**Calling the encode method**/
           encode();
       }catch (IOException e){
           e.printStackTrace();
       }
    }

    public static void encode() throws IOException{

        /**Creating the output file **/
        String output_fileName=file_name.substring(0,file_name.length()-4)+".lzw";

        Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(output_fileName), "UTF-16BE"));

        /****Encoding the input text and writing into output file ****/
        String string="";
        int value,i;
        value=256;
        for(i=0;i<input.size();i++){
            char s;
            s = input.get(i);
            symbol=String.valueOf(s);

            if(table.containsKey(symbol+string)){
                string=symbol+string;
            }else {
                System.out.println(table.get(string));
                writer.write(table.get(string));
                if(table.size()<max_tableSize){
                    table.put(symbol+string,value);
                    value++;
                }
                string=symbol;
            }

        }
        System.out.println(table.get(string));
        writer.write(table.get(string));
        writer.close();
    }
}
