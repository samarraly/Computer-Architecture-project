
import java.util.*;
public class Fetch  {
	 //program counter
	 public static int pc ; 
	 //instruction list
	 ArrayList<Instructions> inslist;
	 //control string
	 String ControlString;
	 
	 
//constructor for setting the array list
public Fetch() {
	inslist=Operation.instList;

}


 


//start the fetching process
public void start() {

	String opcode;
	for ( pc = 0; pc< inslist.size(); pc++) {
		Instructions CurrentInstruction=inslist.get(pc);
		Control_Unit ct=new Control_Unit();
		StringTokenizer st=new StringTokenizer(CurrentInstruction.getFullins(),"/");
		opcode=st.nextToken();
		ControlString=ct.GetControlSignal(opcode);
		PiplineRegIFID IFID=new PiplineRegIFID(CurrentInstruction.getFullins(), ControlString);
		Decode decoder=new Decode(IFID);
		
	}
}
	
//0001/0001/0001/0011
//0001/0010/0010/0010
//1101/0001/0010/0000
//endOfInstructions

public static int getPc() {
	return pc;
}

public static void setPc(int pc) {
	Fetch.pc = pc;
}


public static void main(String[] args){ 
	
		
} 
	


}