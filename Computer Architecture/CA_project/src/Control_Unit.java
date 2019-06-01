
public class Control_Unit {

	String opcode;
	String result;
	String controlSignal="";
	
	public Control_Unit(){
		
	}
	
	public String GetControlSignal(String opcode) {
		switch (opcode) {
		case "0001":
			//add immediate
			controlSignal="0110000000";
			break;
		case "0000":
			//add registers
			controlSignal="1100000100";
			break;
		case "0010":
			//Multiply register
			controlSignal="1100001000";
			break;
		case "0011":
			//Modulus registers
			controlSignal="1100001100";
			break;
		case "0100":
			//Factorial registers
			controlSignal="1101010000";
			break;
		case "0110":
			//Or registers
			controlSignal="1101010100";
			break;
		case "0111":
			//Nor registers
			controlSignal="1101011000";
			break;
		case "0101":
			//And registers
			controlSignal="1101011100";
			break;
		case "1110":
			//load registers
			controlSignal="0110100010";
			break;
		case "1111":
			//store
			controlSignal="0011001101";
			break;
		case "1000":
			// Jump Z
			controlSignal="0001010000";
			break;
		case "1001":
			//Jump greater than
			controlSignal="0001011000";
			break;
		case "1010":
			//Unconditional Jump
			controlSignal="0001100000";
			break;
		case "1011":
			//Jump and Link
			controlSignal="0001101010";
			break;
		case "1100":
			//Jump register
			controlSignal="0001110010";
			break;
		case "1101":
			//Jump Signed
			controlSignal="0001111010";
			break;
		default:
			break;
		}
		return controlSignal;
	}
	
	
}
