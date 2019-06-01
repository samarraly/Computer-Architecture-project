
public class PipelineIEWB {
	Decode decoder;
	ALU alu;
	String ControlString;
	
	public PipelineIEWB(Decode decoder,ALU alu,String ControlString) {
		this.decoder=decoder;
		this.alu=alu;
		this.ControlString=ControlString;
	}

	public Decode getDecoder() {
		return decoder;
	}

	public void setDecoder(Decode decoder) {
		this.decoder = decoder;
	}

	public ALU getAlu() {
		return alu;
	}

	public void setAlu(ALU alu) {
		this.alu = alu;
	}

	public String getControlString() {
		return ControlString;
	}

	public void setControlString(String controlString) {
		ControlString = controlString;
	}
	

}
