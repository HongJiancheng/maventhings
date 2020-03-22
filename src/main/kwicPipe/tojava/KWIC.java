package kwicPipe.tojava;


public class KWIC {
    static private Ui ui=new Ui();
    static private Commands command=new Commands();
    static private Pipeline pipeline=new Pipeline();
    public KWIC(String FILEPATH){

    }
    public static void main(String[] args) {
        ui.printWelcome();
        while(!command.toExit()){
            command.command(ui.readUserCommand(),ui,pipeline);
        }
        ui.printBye();
    }
}
