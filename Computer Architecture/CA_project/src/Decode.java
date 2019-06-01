import java.util.StringTokenizer;


public class Decode {
	
	Registers rs;
	int rd;
	Registers rt;
	int offset;
	Registers baseaddress;
	int immediate;
	String opcode;
	int jumpaddress;

	

	public  Decode(PiplineRegIFID IFID) {
		StringTokenizer st=new StringTokenizer(IFID.getCurrentInstruction(),"/");
		opcode=st.nextToken();
		switch (opcode) {
		case "0001":
			//add immediate
			rd=Integer.parseInt(st.nextToken(),2);
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			immediate=Integer.parseInt(st.nextToken(),2);
			break;
		case "0000":
			//add registers
			rd=Integer.parseInt(st.nextToken(),2);
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			rt=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			break;
		case "0010":
			//Multiply registers
			rd=Integer.parseInt(st.nextToken(),2);
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			rt=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			break;
		case "0011":
			//Modulus registers
			rd=Integer.parseInt(st.nextToken(),2);
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			rt=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			break;
		case "0100":
			//Factorial registers
			rd=Integer.parseInt(st.nextToken(),2);
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			break;
		case "0110":
			//Or registers
			rd=Integer.parseInt(st.nextToken(),2);
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			rt=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			break;
		case "0111":
			//Nor registers
			rd=Integer.parseInt(st.nextToken(),2);
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			rt=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			break;
		case "0101":
			//AND registers
			rd=Integer.parseInt(st.nextToken(),2);
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			rt=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			break;
		case "1110":
			//load word
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			offset=Integer.parseInt(st.nextToken(),2);
			baseaddress=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			break;
		case "1111":
			//store 
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			offset=Integer.parseInt(st.nextToken(),2);
			baseaddress=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			rd=offset+baseaddress.getValue();
			break;
		case "1000":
			//Jump Z (jump if registers are equal)
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			immediate=Operation.reg[Integer.parseInt(st.nextToken(),2)].getValue();
			jumpaddress=Integer.parseInt(st.nextToken(),2);
			break;
		case "1001":
			//Jump G (jump if register 1 is greater than 2)
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			immediate=Operation.reg[Integer.parseInt(st.nextToken(),2)].getValue();
			jumpaddress=Integer.parseInt(st.nextToken(),2);
			break;
		case "1010":
			//Unconditional Jump
			jumpaddress=Integer.parseInt(st.nextToken(),2);
			break;
		case "1011":
			//Jump and link
			rd=13;
			jumpaddress=Integer.parseInt(st.nextToken(),2);
			break;
		case "1100":
			//Jump Register
			jumpaddress=Operation.reg[Integer.parseInt(st.nextToken(),2)].getValue();
			break;
		case "1101":
			//Jump Signed
			rs=Operation.reg[Integer.parseInt(st.nextToken(),2)];
			immediate=Operation.reg[Integer.parseInt(st.nextToken(),2)].getValue();
			jumpaddress=Integer.parseInt(st.nextToken(),2);
			break;

		default:
			break;
		}
		PipelineRegIDIE IDIE=new PipelineRegIDIE(this, IFID.getControlSignal());
		ALU alu=new ALU(IDIE);
		//checking for the RegDst 
		if(IFID.getControlSignal().charAt(0)=='1'){
			alu.computationRtype(IFID.getControlSignal().substring(3, 7), getRs(),getRt());
		}
		else{
			if(opcode.equals("1110")){
				alu.computationItype(IFID.getControlSignal().substring(3, 7),Operation.reg[getRd()],getOffset(),Fetch.getPc());
			}
			else{
				if(opcode.equals("1111")){
					alu.computationItype(IFID.ControlSignal.substring(3, 7), getRs(), (getOffset()+getBaseaddress().getValue()),Fetch.getPc());
				}
				else{
					alu.computationItype(IFID.getControlSignal().substring(3, 7), getRs(),getImmediate(),Fetch.getPc());
					System.out.println("Ay 7aga");
				}
				
			}
			
		}
		
	}



	public int getJumpaddress() {
		return jumpaddress;
	}



	public void setJumpaddress(int jumpaddress) {
		this.jumpaddress = jumpaddress;
	}



	public Registers getRs() {
		return rs;
	}



	public void setRs(Registers rs) {
		this.rs = rs;
	}



	public int getRd() {
		return rd;
	}



	public void setRd(int rd) {
		this.rd = rd;
	}



	public Registers getRt() {
		return rt;
	}



	public void setRt(Registers rt) {
		this.rt = rt;
	}



	public int getOffset() {
		return offset;
	}



	public void setOffset(int offset) {
		this.offset = offset;
	}



	public Registers getBaseaddress() {
		return baseaddress;
	}



	public void setBaseaddress(Registers baseaddress) {
		this.baseaddress = baseaddress;
	}



	public int getImmediate() {
		return immediate;
	}



	public void setImmediate(int immediate) {
		this.immediate = immediate;
	}



	public String getOpcode() {
		return opcode;
	}



	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
	
	
	
	

}
