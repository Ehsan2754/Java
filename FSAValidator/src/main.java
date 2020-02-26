import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new FileReader("fsa.txt"));
        String result = "";

        try {
            String input;
            String info;

            input = scanner.nextLine();
            if (!input.matches("states=[{][A-Za-z0-9_,]*}\\s*")) throw new InputFormatException();
            info = getInfo(input);
            String states[] = getData(info);

            input = scanner.nextLine();
            if (!input.matches("alpha=[{][A-Za-z0-9_,]*}\\s*")) throw new InputFormatException();
            info = getInfo(input);
            String alphaNames[] = getData(info);

            input = scanner.nextLine();
            if (!input.matches("init.st=[{][A-Za-z0-9,]*}\\s*")) throw new InputFormatException();
            String init = getInfo(input);
            if(init.equals("")) throw new InitUndefException();

            input = scanner.nextLine();
            if (!input.matches("fin.st=[{][A-Za-z0-9,]*}\\s*")) throw new InputFormatException();
            info = getInfo(input);
            String fins[] = getData(info);

            input = scanner.nextLine();
            if (input.matches("trans=[{][A-Za-z0-9,]*}\\s*")) throw new InputFormatException();
            info = getInfo(input);
            String alphas[] = getData(info);

            FSA fsa = new FSA(states, alphaNames, init, fins, alphas);
            result = fsa.validate();
        }
        catch (InputFormatException ex) {
            result = "Error:\nE5: Input file is malformed";
        }
        catch (InitUndefException ex) {
            result = "Error:\nE4: Initial state is not defined";
        }
        catch (StateNotExistException ex) {
            result = "Error:\nE1: A state '" + ex.stateName + "' is not in set of states";
        }
        catch (AlphaNotExistException ex) {
            result = "Error:\nE3: A transition '" + ex.alphaName + "' is not represented in the alphabet";
        }
        catch (DisjointStateException ex) {
            result = "Error:\nE2: Some states are disjoint";
        }
        finally {
            scanner.close();
            FileWriter writer = new FileWriter("result.txt");
            writer.write(result);
            writer.close();
        }
    }

    static String getInfo(String input) {
        return input.substring(input.indexOf('{') + 1, input.indexOf('}'));
    }

    static String[] getData(String info) {
        if (!info.equals("")) {
            return info.split(",");
        } else {
            return new String[0];
        }
    }
}
