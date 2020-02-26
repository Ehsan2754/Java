import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FSA {

    private class State {
        String name;
        LinkedList<Alpha> outAlphas = new LinkedList<>();
        LinkedList<Alpha> inAlphas = new LinkedList<>();
        HashSet<String> outAlphaNames = new HashSet<>();

        State(String name) {
            this.name = name;
        }

        void addOutAlpha(Alpha alpha) {
            outAlphaNames.add(alpha.name);
            outAlphas.addLast(alpha);
        }

        void addInAlpha(Alpha alpha) {
            inAlphas.addLast(alpha);
        }
    }

    private class Alpha {
        String name;
        State out;
        State in;

        Alpha (String name, State outState, State inState) {
            this.name = name;
            this.out = outState;
            this.in = inState;
        }
    }

    private HashMap<String, State> states = new HashMap<>();
    private HashSet<String> alphaNames = new HashSet<>();
    private State init;
    private String fins[];


    FSA (String states[], String alpha[], String init, String fins[], String trans[]) throws StateNotExistException, AlphaNotExistException {
        for (String stateName: states) {
            addState(stateName);
        }
        for (String alphaName: alpha) {
            addAlphaName(alphaName);
        }
        if (!this.states.containsKey(init))
            throw new StateNotExistException(init);
        this.init = this.states.get(init);
        this.fins = fins;

        for (String t: trans) {
            String names[] = t.split(">");
            String outState = names[0];
            String alphaName = names[1];
            String inState = names[2];
            addAlpha(alphaName, outState, inState);
        }
    }

    public void addState(String stateName) {
        states.put(stateName, new State(stateName));
    }

    public void addAlphaName(String alphaName) {
        alphaNames.add(alphaName);
    }

    public void addAlpha(String alphaName, String outState, String inState) throws AlphaNotExistException, StateNotExistException {
        if (!alphaNames.contains(alphaName)) {
            throw new AlphaNotExistException(alphaName);
        }
        if (!states.containsKey(inState))
            throw new StateNotExistException(inState);
        if (!states.containsKey(outState)) {
            throw new StateNotExistException(outState);
        }
        Alpha alpha = new Alpha(alphaName, states.get(outState), states.get(inState));
        states.get(outState).addOutAlpha(alpha);
        states.get(inState).addInAlpha(alpha);
    }

    private static void dirDfs(State state, HashSet<String> visited) {
        for (Alpha alpha: state.outAlphas) {
            State inState = alpha.in;
            if (!visited.contains(inState.name)) {
                visited.add(inState.name);
                dirDfs(inState, visited);
            }
        }
    }

    private static void undirDfs(State state, HashSet<String> visited) {
        for (Alpha alpha: state.outAlphas) {
            State inState = alpha.in;
            if (!visited.contains(inState.name)) {
                visited.add(inState.name);
                undirDfs(inState, visited);
            }
        }
        for (Alpha alpha: state.inAlphas) {
            State outState = alpha.out;
            if (!visited.contains(outState.name)) {
                visited.add(outState.name);
                undirDfs(outState, visited);
            }
        }
    }

    public String validate() throws DisjointStateException {
        boolean W1, W2, W3, complete;
        W1 = fins.length == 0;

        HashSet<String> visited = new HashSet<>();
        visited.add(init.name);
        dirDfs(init, visited);
        W2 = visited.size() != states.size();
        if (W2) {
            visited.clear();
            visited.add(init.name);
            undirDfs(init, visited);
            if (visited.size() != states.size())
                throw new DisjointStateException();
        }

        W3 = false;
        for(State state: states.values()) {
            if (state.outAlphas.size() > state.outAlphaNames.size()) {
                W3 = false;
                break;
            }
        }

        complete = true;
        for (State state: states.values()) {
            if (state.outAlphaNames.size() < alphaNames.size()) {
                complete = false;
                break;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("FSA is ");
        result.append(complete ? "complete" : "incomplete");
        if (W1 || W2 || W3) {
            result.append("\nWarning:");
            if (W1)
                result.append("\nW1: Accepting state is not defined");
            if (W2)
                result.append("\nW2: Some states are not reachable from initial state");
            if (W3)
                result.append("\nW3: FSA is nondeterministic");
        }
        return result.toString();
    }
}
