package kwicPipe.tojava;

public class CircularShift {
    private Alphabetizer sort;
    public CircularShift(Ui ui,Pipeline pipeline, ToIgnore ignore, ToRequire require){
        shiftAction(pipeline);
        ui.showToUser("### Circular shift has completed, the shifted result as shown in below: ");
        for(int i=0;i<pipeline.getLines().size();i++) {
            ui.showToUser(pipeline.getLines().get(i));
        }
        ignore.runIgnoreFilter(pipeline);
        require.runIgnoreFilter(pipeline);
        sort=new Alphabetizer(ui,pipeline);
    }
    private static void shiftAction(Pipeline pipeline){
        for(int i=0;i<pipeline.getLines().size();i++){
            int cycle=numberOfShift(pipeline.getLines().get(i));
            for(int j=0;j<cycle;j++){
                pipeline.addLine(i+1,shiftALine(pipeline.getLines().get(i)).trim());
                i++;
            }
        }
    }
    private static String shiftALine(String line){
        return line.substring(line.indexOf(" ")+1)+" "+line.substring(0,line.indexOf(" "));
    }
    private static int numberOfShift(String line){
        String[] words=line.split(" ");
        return words.length-1;
    }
}
