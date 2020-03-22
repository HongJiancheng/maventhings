package kwicPipe.tojava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class ToIgnore {
    public ToIgnore(Pipeline in) throws FileNotFoundException {addWholeListFromFile(in);};
    private static void addWholeListFromFile(Pipeline in) throws FileNotFoundException {
        File f = new File(in.getIgnoreListPath());
        Scanner s = new Scanner(f);
        String thisLine;
        while(s.hasNext()) {
            thisLine=s.nextLine();
            if(!thisLine.isEmpty()){
                in.addIgnoreLine(thisLine.trim());
            }
        }
    }
    public void filterList(Pipeline in){
        Vector<String> ignoreList=in.getToIgnore();
        for(int i=0;i<in.getLines().size();i++){
            for(int j=0;j<ignoreList.size();j++){
                String firstWord;
                if(in.getLines().elementAt(i).contains(" ")){
                    firstWord=in.getLines().elementAt(i).substring(0,in.getLines().elementAt(i).indexOf(" "));
                }else{
                    firstWord=in.getLines().elementAt(i);
                }

                if(CompareAPI.isEqual(firstWord,ignoreList.elementAt(j))){
                    in.getLines().remove(i);
                    i--;
                    break;
                }
            }
        }
    }
    public void runIgnoreFilter(Pipeline in){
        if(!in.getToIgnore().isEmpty()){
            filterList(in);
        }
    }
}
