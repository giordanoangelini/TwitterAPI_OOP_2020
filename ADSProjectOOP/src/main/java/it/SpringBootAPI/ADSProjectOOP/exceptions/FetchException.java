package it.SpringBootAPI.ADSProjectOOP.exceptions;

/** <b>FetchException: </b>
 * eccezione personalizzata che si verifica in caso di problemi 
 * nello stream del file o nel oarsing in JSONObject
 * @author Cristian Di Silvestre
 */
public class FetchException extends RuntimeException{

	private static final long serialVersionUID = 8838704443735091336L;

	public FetchException () {
		super ("ERROR: FAILED TO FETCH FRIENDS");
	}
}
