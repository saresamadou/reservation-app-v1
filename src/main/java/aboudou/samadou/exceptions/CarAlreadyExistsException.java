/**
 * 
 */
package aboudou.samadou.exceptions;

/**
 * Class to define exception when users try to enter a new car that already exists
 * @author absare
 *
 */
public class CarAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	 
	public CarAlreadyExistsException(String message) {
		this.message =  message;
	}
}
