package kwicPipe.tojava;

import java.io.File;
import java.util.Scanner;

public class Ui {
    public Ui(){}
    public void showToUser(String s){
        System.out.println(s);
    }
    public void inputIndicator(String s) {System.out.print(s);}

    public void printWelcome(){
        showToUser(
                "****************************************************************************************\n" +
                "** Welcome to KWIC!                                                                   **\n" +
                "** To start, please use \"input\" command to set the input file directory,              **\n" +
                "** or use \"saveTo\" command to set the output file directory.                          **\n" +
                "**                                                                                    **\n" +
                "** If the output file directory is not specified,                                     **\n" +
                "** program will save the output file as following default setting:                    **\n" +
                "** C:\\OutputFile.txt                                                                  **\n" +
                "** To exit, please use \"exit\" command.                                                **\n" +
                "****************************************************************************************");
        inputIndicator("Command: ");
    }
    public void printBye(){showToUser(
            "*******************************************\n" +
            "** Thank you for using KWIC! Bye!        **\n" +
            "*******************************************");}
    public String readUserCommand(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void printError(String s){
        showToUser("### Error: "+s);
    }

    public void setInputPath(Pipeline pipeline, String newPath){
        pipeline.setInputPath(newPath);
        showToUser("### Input Path has been set as: "+newPath);
    }
    public void setIgnorePath(Pipeline pipeline, String newPath){
        pipeline.setIgnoreListPath(newPath);
        showToUser("### Ignore List Path has been set as: "+newPath);
    }
    public void setRequiredPath(Pipeline pipeline, String newPath){
        pipeline.setRequiredListPath(newPath);
        showToUser("### Required List Path has been set as: "+newPath);
    }
    public void setOutputPath(Pipeline pipeline, String newPath){
        File tempDir = new File(newPath.substring(0,newPath.lastIndexOf("\\")));
        if(tempDir.exists()){
            if(newPath.substring(newPath.lastIndexOf("\\")).contains(".txt")){
                pipeline.setOutputPath(newPath);
                showToUser("### Output Path has been set as: "+newPath);
                showToUser(
                        "****************************************************************************************\n" +
                        "** Output directory has been successfully updated!                                    **\n" +
                        "** To change save file directory, please use \"saveTo\" command.                        **\n" +
                        "** To proceed for circular shifting and alphabetizer, please use \"run\" command.       **\n" +
                        "** To exit, please use \"exit\" command.                                                **\n" +
                        "****************************************************************************************");
            }else{
                printError("Output file name is not exist! Please try again!");
            }
        }else{
            printError("Output directory is not exist! Please try again!");
        }

    }
}
