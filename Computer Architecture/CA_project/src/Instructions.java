
public class Instructions {
	
	String Opcode;
	String Destination;
	String Source1;
	String Source2;
	String fullins;
	
	public Instructions(String intsString) {
		this.fullins=intsString;
	}

	public String getFullins() {
		return fullins;
	}

	public void setFullins(String fullins) {
		this.fullins = fullins;
	}

	public String getOpcode() {
		return Opcode;
	}

	public void setOpcode(String opcode) {
		Opcode = opcode;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public String getSource1() {
		return Source1;
	}

	public void setSource1(String source1) {
		Source1 = source1;
	}

	public String getSource2() {
		return Source2;
	}

	public void setSource2(String source2) {
		Source2 = source2;
	}
	
	

}
