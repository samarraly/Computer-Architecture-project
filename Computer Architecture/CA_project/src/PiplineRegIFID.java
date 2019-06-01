
public class PiplineRegIFID {
	
	 String CurrentInstruction;
	 String ControlSignal;
	
	public  String getCurrentInstruction() {
		return CurrentInstruction;
	}

	public void setCurrentInstruction(String currentInstruction) {
		CurrentInstruction = currentInstruction;
	}

	public String getControlSignal() {
		return ControlSignal;
	}

	public void setControlSignal(String controlSignal) {
		ControlSignal = controlSignal;
	}

	public PiplineRegIFID(String CurrentInstruction,String ControlSignal){
		this.ControlSignal=ControlSignal;
		this.CurrentInstruction=CurrentInstruction;
	}

}
