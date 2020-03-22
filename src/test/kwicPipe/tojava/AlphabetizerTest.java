package kwicPipe.tojava;


import kwicPipe.tojava.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AlphabetizerTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void test1() {
        String inputPath = "TIC3001-Assignment2-testcases/Test1/Titles1.txt";
        String ignorePath = "TIC3001-Assignment2-testcases/Test1/Ignored1.txt";
        String requiredPath = "TIC3001-Assignment2-testcases/Test1/Required1.txt";
        String outputPath = "TIC3001-Assignment2-testcases/Test1/RealOut1.txt";
        String comparePath = "TIC3001-Assignment2-testcases/Test1/Output1.txt";
        Input input;
        ToIgnore ignore;
        ToRequire require;
        Ui ui=new Ui();
        Pipeline pipeline=new Pipeline();
        pipeline.setInputPath(inputPath);
        pipeline.setIgnoreListPath(ignorePath);
        pipeline.setRequiredListPath(requiredPath);
        pipeline.setOutputPath(outputPath);
        try {
            input=new Input(pipeline);
            ignore = new ToIgnore(pipeline);
            require = new ToRequire(pipeline);
            input.runCircular(ui, pipeline,ignore,require);
            List<String> file1 = Files.readAllLines(Paths.get(outputPath));
            List<String> file2 = Files.readAllLines(Paths.get(comparePath));

            assertEquals(file1.size(), file2.size());
            for(int i = 0; i < file1.size(); i++) {
                System.out.println("Comparing line: " + i);
                assertEquals(file1.get(i), file2.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException a){
            System.out.println(a);
        }
    }
    @Test
    public void test2() {
        String inputPath = "TIC3001-Assignment2-testcases/Test2/Titles2.txt";
        String ignorePath = "TIC3001-Assignment2-testcases/Test2/Ignored2.txt";
        String requiredPath = "TIC3001-Assignment2-testcases/Test2/Required2.txt";
        String outputPath = "TIC3001-Assignment2-testcases/Test2/RealOut2.txt";
        String comparePath = "TIC3001-Assignment2-testcases/Test2/Output2.txt";
        Input input;
        ToIgnore ignore;
        ToRequire require;
        Ui ui=new Ui();
        Pipeline pipeline=new Pipeline();
        pipeline.setInputPath(inputPath);
        pipeline.setIgnoreListPath(ignorePath);
        pipeline.setRequiredListPath(requiredPath);
        pipeline.setOutputPath(outputPath);
        try {
            input=new Input(pipeline);
            ignore = new ToIgnore(pipeline);
            require = new ToRequire(pipeline);
            input.runCircular(ui, pipeline,ignore,require);
            List<String> file1 = Files.readAllLines(Paths.get(outputPath));
            List<String> file2 = Files.readAllLines(Paths.get(comparePath));

            assertEquals(file1.size(), file2.size());
            for(int i = 0; i < file1.size(); i++) {
                System.out.println("Comparing line: " + i);
                assertEquals(file1.get(i), file2.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException a){
            System.out.println(a);
        }
    }
    @Test
    public void test3() {
        String inputPath = "TIC3001-Assignment2-testcases/Test3/Titles3.txt";
        String ignorePath = "TIC3001-Assignment2-testcases/Test3/Ignored3.txt";
        String requiredPath = "TIC3001-Assignment2-testcases/Test3/Required3.txt";
        String outputPath = "TIC3001-Assignment2-testcases/Test3/RealOut3.txt";
        String comparePath = "TIC3001-Assignment2-testcases/Test3/Output3.txt";
        Input input;
        ToIgnore ignore;
        ToRequire require;
        Ui ui=new Ui();
        Pipeline pipeline=new Pipeline();
        pipeline.setInputPath(inputPath);
        pipeline.setIgnoreListPath(ignorePath);
        pipeline.setRequiredListPath(requiredPath);
        pipeline.setOutputPath(outputPath);
        try {
            input=new Input(pipeline);
            ignore = new ToIgnore(pipeline);
            require = new ToRequire(pipeline);
            input.runCircular(ui, pipeline,ignore,require);
            List<String> file1 = Files.readAllLines(Paths.get(outputPath));
            List<String> file2 = Files.readAllLines(Paths.get(comparePath));

            assertEquals(file1.size(), file2.size());
            for(int i = 0; i < file1.size(); i++) {
                System.out.println("Comparing line: " + i);
                assertEquals(file1.get(i), file2.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException a){
            System.out.println(a);
        }
    }
    @Test
    public void test4() {
        String inputPath = "TIC3001-Assignment2-testcases/Test4/Titles4.txt";
        String ignorePath = "TIC3001-Assignment2-testcases/Test4/Ignored4.txt";
        String requiredPath = "TIC3001-Assignment2-testcases/Test4/Required4.txt";
        String outputPath = "TIC3001-Assignment2-testcases/Test4/RealOut4.txt";
        String comparePath = "TIC3001-Assignment2-testcases/Test4/Output4.txt";
        Input input;
        ToIgnore ignore;
        ToRequire require;
        Ui ui=new Ui();
        Pipeline pipeline=new Pipeline();
        pipeline.setInputPath(inputPath);
        pipeline.setIgnoreListPath(ignorePath);
        pipeline.setRequiredListPath(requiredPath);
        pipeline.setOutputPath(outputPath);
        try {
            input=new Input(pipeline);
            ignore = new ToIgnore(pipeline);
            require = new ToRequire(pipeline);
            input.runCircular(ui, pipeline,ignore,require);
            List<String> file1 = Files.readAllLines(Paths.get(outputPath));
            List<String> file2 = Files.readAllLines(Paths.get(comparePath));

            assertEquals(file1.size(), file2.size());
            for(int i = 0; i < file1.size(); i++) {
                System.out.println("Comparing line: " + i);
                assertEquals(file1.get(i), file2.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException a){
            System.out.println(a);
        }
    }
    @Test
    public void test5() {
        String inputPath = "TIC3001-Assignment2-testcases/Test5/Titles5.txt";
        String ignorePath = "TIC3001-Assignment2-testcases/Test5/Ignored5.txt";
        String requiredPath = "TIC3001-Assignment2-testcases/Test5/Required5.txt";
        String outputPath = "TIC3001-Assignment2-testcases/Test5/RealOut5.txt";
        String comparePath = "TIC3001-Assignment2-testcases/Test5/Output5.txt";
        Input input;
        ToIgnore ignore;
        ToRequire require;
        Ui ui=new Ui();
        Pipeline pipeline=new Pipeline();
        pipeline.setInputPath(inputPath);
        pipeline.setIgnoreListPath(ignorePath);
        pipeline.setRequiredListPath(requiredPath);
        pipeline.setOutputPath(outputPath);
        try {
            input=new Input(pipeline);
            ignore = new ToIgnore(pipeline);
            require = new ToRequire(pipeline);
            input.runCircular(ui, pipeline,ignore,require);
            List<String> file1 = Files.readAllLines(Paths.get(outputPath));
            List<String> file2 = Files.readAllLines(Paths.get(comparePath));

            assertEquals(file1.size(), file2.size());
            for(int i = 0; i < file1.size(); i++) {
                System.out.println("Comparing line: " + i);
                assertEquals(file1.get(i), file2.get(i));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException a){
            System.out.println(a);
        }
    }
}
