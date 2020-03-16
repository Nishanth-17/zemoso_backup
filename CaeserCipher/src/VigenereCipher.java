import edu.duke.FileResource;

public class VigenereCipher {
    public static String sliceString(String message,int whichSlice,int totalSlices){
        String sliceString="";
        for(int i=whichSlice;i<message.length();i+=totalSlices){
            sliceString+=message.charAt(i);
        }
        return sliceString;
    }
    public void tryKeyLength(String encrypted,int klength,char mostCommon){}
    public static void main(String args[]){
        System.out.println(sliceString("abcdefghijklm", 2, 3));
    }
    public int breakVigenere(){
        FileResource fr=new FileResource();
        return 1;
        }
    }

