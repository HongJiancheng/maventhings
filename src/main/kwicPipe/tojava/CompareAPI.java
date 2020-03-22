package kwicPipe.tojava;

public class CompareAPI {
    static int toCompare(char a){
        if(a>='0'&& a<='9'){
            return a-'0';
        }else if(a>='a' && a<='z'){
            return a-'a'+10;
        }else if (a>='A' && a<='Z'){
            return a-'A'+10;
        }
        return -1;
    }

    static boolean isSmaller(String a, String b){
        int size;
        boolean aLonger=false;
        if(a.length()>b.length()){
            size=b.length();
            aLonger=true;
        }else{
            size=a.length();
        }
        for(int i=0;i<size;i++){
            if(toCompare(a.charAt(i))< toCompare(b.charAt(i))){
                return true;
            }else if(toCompare(a.charAt(i))== toCompare(b.charAt(i))){
                continue;
            }else{
                return false;
            }
        }
        if(aLonger){
            return false;
        }else{
            return true;
        }
    }
    static boolean isEqual(String a, String b){
        int size;
        if(a.length()!=b.length()) {
            return false;
        }else{
            size=a.length();
        }
        for(int i=0;i<size;i++){
            if(toCompare(a.charAt(i))==toCompare(b.charAt(i))){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
