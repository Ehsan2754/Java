public class StateNotExistException extends Exception {
    public String stateName;
    StateNotExistException(String stateName) {
        this.stateName = stateName;
    }
}
