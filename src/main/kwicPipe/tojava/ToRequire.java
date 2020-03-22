package kwicPipe.tojava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ToRequire {
    public ToRequire(Pipeline in) throws FileNotFoundException {addWholeListFromFile(in);};
    private static void addWholeListFromFile(Pipeline in) throws FileNotFoundException {
        File f = new File(in.getRequiredListPath());
        Scanner s = new Scanner(f);
        String thisLine;
        while(s.hasNext()) {
            thisLine=s.nextLine();
            if(!thisLine.isEmpty()){
                in.addRequiredLine(thisLine.trim());
            }
        }
    }
    public void filterList(Pipeline in){
        Vector<String> requiredList=in.getToRequire();
        for(int i=0;i<in.getLines().size();i++){
            boolean toKeep=false;
            for(int j=0;j<requiredList.size();j++){
                String firstWord;
                if(in.getLines().elementAt(i).contains(" ")){
                    firstWord=in.getLines().elementAt(i).substring(0,in.getLines().elementAt(i).indexOf(" "));
                }else{
                    firstWord=in.getLines().elementAt(i);
                }
                if(CompareAPI.isEqual(firstWord,requiredList.elementAt(j))){
                    toKeep=true;
                }
                if(!toKeep && j==requiredList.size()-1){
                    in.getLines().remove(i);
                    i--;
                    break;
                }
            }
        }
    }
    public void runIgnoreFilter(Pipeline in){
        if(!in.getToRequire().isEmpty()){
            filterList(in);
        }
    }
}
