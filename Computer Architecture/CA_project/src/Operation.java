import java.util.ArrayList;
import java.util.Scanner;


public class Operation {
	
	// List of instruction
    static ArrayList<Instructions>  instList = new ArrayList<Instructions>();
	// Register file
    static Registers[] reg =new Registers[16];
	//Memory
    static ArrayList<MemoryElement> Memory=new ArrayList<MemoryElement>();

public static ArrayList<Instructions> getInstList() {
	return instList;
}


public static void setInstList(ArrayList<Instructions> instList) {
	Operation.instList = instList;
}

//Setting the register file
public static void SetReglist() {
reg[0]=new Registers("*0", 0);
reg[1]=new Registers("*r0",0);		
reg[2]=new Registers("*r1",0);		
reg[3]=new Registers("*I0",0);		
reg[4]=new Registers("*I1",0);		
reg[5]=new Registers("*I2",0);		
reg[6]=new Registers("*I3",0);
reg[7]=new Registers("*T0",0);		
reg[8]=new Registers("*T1",0);
reg[9]=new Registers("*T2",0);
reg[10]=new Registers("*S0",0);
reg[11]=new Registers("*S1",0);   
reg[12]=new Registers("*S2",0);  
reg[13]=new Registers("*ra",0);	    
reg[14]=new Registers("*sp",0);
reg[15]=new Registers("*PC",0); 
}

//0001/0001/0001/0011
//1111/0001/0000/0010
//0001/0100/0100/0011
//1110/0010/0000/0011
//endOfInstructions
 

//Constantly taking instructions from the console
public static void main(String[] args) { 
	int counter=0;
//	Operation op = new Operation();
	while(true){
	Scanner in =new Scanner(System.in);
	String StringInstruction = in.nextLine();
	if(StringInstruction.equals("endOfInstructions")){
		break;
	}
	else{
		Instructions ins=new Instructions(StringInstruction);
		instList.add(ins);
		System.out.println(instList.get(counter).getFullins());
		counter++;
	}
	}
	SetReglist();
	Fetch fe=new Fetch();
	fe.start();
	
	
		
} 

	

}
