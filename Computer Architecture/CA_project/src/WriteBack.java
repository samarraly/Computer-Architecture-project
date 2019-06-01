


public class WriteBack {
	//Write back to memory or Write Back to register file
	Boolean MemOrReg;
	//Destination Register
	int rd;
	//Control Signal
	String ControlString;
	//Passed decoder
	Decode decoder;
	//Passed AlU
	ALU alu;
	
	
	public WriteBack(PipelineIEWB IEWB) {
		this.decoder=IEWB.getDecoder();
		this.alu=IEWB.getAlu();
		this.ControlString=IEWB.getControlString();
		//checking for the RegWrite,MemRead and MemWrite
				if(ControlString.charAt(1)=='1' || (ControlString.charAt(8)=='1')){
					Operation.reg[decoder.getRd()].setValue(alu.getResult());
					System.out.println(decoder.getRd());
				}

				//checking the result of JumpZ ,JumpG , Jump and Link, Jump Register and unconditional jump
				if(alu.result==0 && (ControlString.charAt(1)=='0') && (ControlString.charAt(7)=='0')){
					System.out.println("in zero"+decoder.getJumpaddress());
					Fetch.setPc(decoder.getJumpaddress()-1);
				}
				else{
					System.out.println(ControlString);
					//Store Word condition
					if(ControlString.charAt(9)=='1'){
					MemoryElement me=new MemoryElement(alu.getResult(),decoder.getRd());
					Operation.Memory.add(me);
					System.out.println("storing "+me.getData());}
					}

		
	}

}
