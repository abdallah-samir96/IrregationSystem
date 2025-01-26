package sa.whitehelmet.exception;


public class PlotNotFoundException extends RuntimeException{
    private int status;
    public PlotNotFoundException(String message) {
        super(message);
    }
    public PlotNotFoundException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
