package kwicPipe.tojava;

import java.util.Vector;

public class Search {
    private String search;
    public Search(String in){
        search=in;
    }
    public void runSearch(Input in, Ui ui,Pipeline pipeline,ToIgnore ignore, ToRequire require){
        in.runCircular(ui,pipeline,ignore,require);
        ui.showToUser("\n\n### Search result(s) for "+search+" :");
        match(pipeline,ui);
    }
    public void match(Pipeline pipeline, Ui ui){
        Vector<String> searchFrom=pipeline.getLines();
        for(int i=0;i<searchFrom.size();i++){
            String currentTerm=searchFrom.get(i);
            if(search.equals(currentTerm.substring(0,currentTerm.indexOf(" ")))){
                ui.showToUser(currentTerm);
            }
        }
    }
}
