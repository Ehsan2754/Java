public class AlphaNotExistException extends Exception {
    public String alphaName;
    AlphaNotExistException(String alphaName) {
        this.alphaName = alphaName;
    }
}
