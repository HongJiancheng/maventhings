package kwicPipe.tojava;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Input {
//    private static Vector<String> lines=new Vector();
    private CircularShift shift;
    public Input(Pipeline in) throws FileNotFoundException{
        getLine(in);
    }
    private static void getLine(Pipeline in) throws FileNotFoundException {
        File f = new File(in.getInputPath());
        Scanner s = new Scanner(f);
        String thisLine;
        while(s.hasNext()) {
            thisLine=s.nextLine();
            if(!thisLine.isEmpty()){
                in.addLine(thisLine.trim());
            }
        }
    }
    public void runCircular(Ui ui,Pipeline pipeline, ToIgnore ignore, ToRequire require){
        shift=new CircularShift(ui,pipeline, ignore, require);
    }
}
