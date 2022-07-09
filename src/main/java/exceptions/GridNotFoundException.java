package exceptions;

/**
 * Created by Yule.Paulusha on 7/9/2022.
 */
public class GridNotFoundException extends RuntimeException {
    public GridNotFoundException(String message) {
        super(message);
    }
}
