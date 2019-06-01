
public class ALU {
	int result=-1;
	//instance of the decoder
	Decode decoder;
	//Control Signal
	String ControlString;
	
	public ALU(PipelineRegIDIE IDIE) {
		this.decoder=IDIE.getDecoder();
		this.ControlString=IDIE.getControlString();
	}
	
	public int computationRtype(String ALUop,Registers operand1,Registers operand2){
		switch (ALUop) {
		case "0001":
			//add registers
			result=operand1.getValue()+operand2.getValue();
			break;
		case "0010":
			//Multiply registers
			result=operand1.getValue()*operand2.getValue();
			break;
		case "0011":
			//Modulus registers
			result=operand1.getValue()%operand2.getValue();
			break;
		case "0100":
			//Factorial registers 
			result=factorial(operand1.getValue());
			break;
		case "0101":
			//Or registers
			result=(operand1.getValue() | operand2.getValue());
			break;
		case "0110":
			//Nor registers
			result= ~(operand1.getValue() | operand2.getValue());
			break;
		case "0111":
			result=(operand1.getValue() & operand2.getValue());
			break;
		default:
			System.out.println("hereR-type");
			break;
		}
		PipelineIEWB IEWB=new PipelineIEWB(decoder, this, ControlString);
		WriteBack wb=new WriteBack(IEWB);
		return result;
		
	}
	
	public int computationItype(String ALUop,Registers operand1,int operand2,int pc){
		switch (ALUop) {
		case "0000":
			//add immediate
			result=operand1.getValue()+operand2;
			break;
		case "1000":
			//load 
			result=operand1.getValue()+operand2;
		case "1001":
			//store
			result=operand1.getValue();
			break;
		case "1010":
			//Jump Z (jump if registers are equal)
			result=operand1.getValue()-operand2;
			break;
		case "1011":
			//Jump G (jump if register 1 is greater than 2)
			if (operand1.getValue()>operand2) {
				result=0;
			}
			result=-1;
			break;
		case "1100":
			//Unconditional Jump
			result=0;
			break;
		case "1101":
			//Jump and Link
			result=0;
			break;
		case "1110":
			//Jump Register
			result=0;
			break;
		case "1111":
			result=operand1.getValue()-operand2;
			if(result<0){
				result=0;
			}
			break;
	
		default:
			break;
		}
		PipelineIEWB IEWB=new PipelineIEWB(decoder, this, ControlString);
		WriteBack wb=new WriteBack(IEWB);
		return result;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public static int factorial(int operand){
		if(operand == 0)
			return 1;
		else
			return operand * factorial(operand - 1);
	}
	

	
	
	
}
