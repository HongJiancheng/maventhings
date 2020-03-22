package kwicPipe.tojava;

import java.util.Vector;

public class Alphabetizer {
    private static Output output;
    public Alphabetizer( Ui ui, Pipeline pipeline){
        sort(pipeline);
        ui.showToUser("### Alphabetization has completed, the sorted result as shown in below: ");
        for(int i=0;i<pipeline.getLines().size();i++) {
            ui.showToUser(pipeline.getLines().get(i));
        }
        pipeline.setLines(pipeline.getLines());
        output=new Output(pipeline);
        output.out(ui, pipeline);
    }
    private static void sort(Pipeline pipeline){
        pipeline.setLines(quickSort(pipeline.getLines()));
    }
    private static Vector<String> quickSort(Vector<String> toSort){
        int mid;
        String a,pivot;
        Vector<String> result;
        if  (toSort.size() <= 1){
            return toSort;
        } else {
            mid = toSort.size()/2;
        }
        pivot = toSort.get(mid);
        Vector<String> smaller=new Vector<String>(),larger=new Vector<String>();
        for(int i=0;i<toSort.size();i++){
            a = toSort.get(i);
            if(i!=mid){
                if(CompareAPI.isSmaller(a,pivot)){
                    smaller.add(a);
                }else if(CompareAPI.isSmaller(pivot,a)){
                    larger.add(a);
                }else{
                    if(i<mid){
                        smaller.add(a);
                    }else{
                        larger.add(a);
                    }
                }
            }
        }
        result =quickSort(smaller);
        result.add(toSort.get(mid));
        result.addAll(quickSort(larger));
        return result;
    }

}
