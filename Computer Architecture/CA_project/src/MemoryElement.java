
public class MemoryElement {
int data;
int address;

public MemoryElement(int data, int address){
	this.data = data;
	this.address = address;
}

public int getData() {
	return data;
}

public void setData(int data) {
	this.data = data;
}

public int getAddress() {
	return address;
}

public void setAddress(int address) {
	this.address = address;
}


}
