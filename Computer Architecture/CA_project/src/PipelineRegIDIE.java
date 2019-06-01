
public class PipelineRegIDIE {
	Decode Decoder;
	String controlString;
	
	public PipelineRegIDIE(Decode Decoder,String Controlstring) {
		this.Decoder=Decoder;
		this.controlString=Controlstring;
	}

	public Decode getDecoder() {
		return Decoder;
	}

	public void setDecoder(Decode decoder) {
		Decoder = decoder;
	}

	public String getControlString() {
		return controlString;
	}

	public void setControlString(String controlString) {
		this.controlString = controlString;
	}

}
