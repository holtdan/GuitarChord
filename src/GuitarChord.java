//package model;

/** TODO Documentation
 */
public class GuitarChord {
	private String mName; 
	String mTuning;
	private int mFretNumber;
	private int[] mStringFrets;

	/** A new GuitarChord.
	*
	*@param name The name of the chord.
	*@param tuning //TODO
	*@param stringFrets //TODO
	*@param fretNum //TODO
	*/ 
	public GuitarChord(String name, String tuning, int fretNum, int[] stringFrets) {
		if (tuning.length() != stringFrets.length) {
			throw new IllegalArgumentException("Tuning length(" + tuning.length() + ") must equal"
				+ " string fret length(" + stringFrets.length + ")");
		}

		mName = name;
		mTuning = tuning;
		mFretNumber = fretNum;
		mStringFrets = stringFrets;
	}

	/************/
	/* Getters. */
	/************/

	public String getName() {
		return mName;
	}

	public String getTuning() {
		return mTuning;
	}

	public int getFretNumber() {
		return mFretNumber;
	}

	public int[] getStringFrets() {
		return mStringFrets;
	}

	//TODO not sure if you want setters
	/************/
	/* Setters. */
	/************/

	public void setName(String name) {
		mName = name;
	}

	public void setTuning(String tuning) {
		mTuning = tuning;	
	}

	public void setFretNumber(int fretNumber) {
		mFretNumber = fretNumber;
	}

	public void setStringFrets(int[] stringFrets) {
		mStringFrets = stringFrets;
	}
}