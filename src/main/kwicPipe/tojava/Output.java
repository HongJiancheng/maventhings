package kwicPipe.tojava;

import java.io.IOException;
import java.io.FileWriter;

public class Output {
    private static String outputPath;
    public Output(Pipeline pipeline){
        outputPath=pipeline.getOutputPath();
    }
    private static void printFile(Ui ui, Pipeline pipeline){
        try {
            FileWriter fw = new FileWriter(outputPath);
            for (int i = 0; i < pipeline.getLines().size(); i++) {
                fw.write(pipeline.getLines().get(i));
                if(i!=pipeline.getLines().size()-1){
                    fw.write("\n");
                }
            }
            fw.close();
            ui.showToUser("### Output file has been successfully created.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void out(Ui ui, Pipeline pipeline){
        if(outputPath==null){
            outputPath="C:\\OutputFile.txt";
        }
        printFile(ui,pipeline);
    }
}
