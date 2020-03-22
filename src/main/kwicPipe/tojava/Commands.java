package kwicPipe.tojava;

import java.io.FileNotFoundException;

public class Commands {
    private Boolean isExit=false;
    private Boolean readyToRun=false;
    private Input in;
    private ToIgnore ignore;
    private ToRequire require;
    private Search search;
    public Commands(){}
    public void command(String input,Ui ui,Pipeline pipeline) {
        switch (input) {
            case "exit":
                isExit = true;
                break;
            case "input":
                ui.inputIndicator("Input File Directory: ");
                ui.setInputPath(pipeline, ui.readUserCommand());
                ui.inputIndicator("Ignore List File Directory: ");
                ui.setIgnorePath(pipeline, ui.readUserCommand());
                ui.inputIndicator("Required List File Directory: ");
                ui.setRequiredPath(pipeline, ui.readUserCommand());
                try{
                    pipeline.resetLines();
                    pipeline.resetIgnoreList();
                    pipeline.resetRequiredList();
                    in=new Input(pipeline);
                    ignore=new ToIgnore(pipeline);
                    require=new ToRequire(pipeline);
                    readyToRun=true;
                    ui.showToUser(
                            "*************************************************************************************\n"+
                            "** File has been successfully imported!                                            **\n" +
                            "** To set save file directory, please use \"saveTo\" command.                        **\n" +
                            "** To proceed for circular shifting and alphabetizer, please use \"run\" command.    **\n" +
                            "** To proceed for search, please use \"search\" command.                             **\n" +
                            "** To exit, please use \"exit\" command.                                             **\n" +
                            "*************************************************************************************");
                }  catch (FileNotFoundException e) {
                    ui.printError("Have problem in reading file, please try again!");
                }
                ui.inputIndicator("Command: ");
                break;
            case "search":
                ui.inputIndicator("Search Word: ");
                search=new Search(ui.readUserCommand());
                if(readyToRun){
                    ui.showToUser("### Circular shift for search has been started!");
                    search.runSearch(in, ui, pipeline,ignore,require);
                }else{
                    ui.printError("Input is not ready to run circular shift, please try again!");
                }
                ui.inputIndicator("Command: ");
                break;
            case "run":
                if(readyToRun){
                    ui.showToUser("### Circular shift has been started!");
                    in.runCircular(ui, pipeline, ignore, require);
                }else{
                    ui.printError("Input is not ready to run circular shift, please try again!");
                }
                ui.inputIndicator("Command: ");
                break;
            case "saveTo":
                ui.inputIndicator("File Directory: ");
                ui.setOutputPath(pipeline,ui.readUserCommand());
                ui.inputIndicator("Command: ");
                break;
            default:
                ui.printError("Unknown command! please try again!");
                ui.inputIndicator("Command: ");
                break;
        }
    }
    public boolean toExit(){
        return isExit;
    }
}
