/*package util;
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import model.GuitarChord;

/** TODO Documentation
*
*/
public class GuitarChordFactory {
    
	private GuitarChordFactory() {}

	/** Interprets chord data string following the format: 
	* "TUNING",FRETNUM,STRING_FRET0, STRING_FRET1,...,"NAME" (e.g. "EADbBe",1,-1,0,2,2,2,0,"AMaj") 
	* and returns the corresponding {@link GuitarChord}.
	*
	* @param chordData The chord data string to be interpreted. 
	* @return The GuitarChord corresponding to the data contained in chordData.
	*/
	public static GuitarChord interpretChordData(String chordData) {
	    String formatRegex = "\"?([a-zA-Z]*)\"?,(\\-?[0-9]),((\\-?[0-9],)*)\"?([a-zA-Z]*)\"?";
	    Matcher matcher = Pattern.compile(formatRegex).matcher(chordData.replaceAll("\\s+",""));
	    
	    if (!matcher.matches()) {
	        throw new IllegalArgumentException("String format did not match specification.");
	    }
	    
	    String tuning = matcher.group(1);
	    int fretNumber = Integer.valueOf(matcher.group(2));
	    
	    String[] stringFretsChars = matcher.group(3).split(",");
	    int[] stringFrets = new int[stringFretsChars.length];
	    for (int i = 0; i < stringFrets.length; i++) {
	        stringFrets[i] = Integer.valueOf(stringFretsChars[i]);
	    }
	    
	    String name = matcher.group(5);
	    
	    return new GuitarChord(name, tuning, fretNumber, stringFrets);
	}
}