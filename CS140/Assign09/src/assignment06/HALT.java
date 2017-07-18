package assignment06;

public class HALT extends Instruction{
	private Machine machine;
	private GUIMachine gmachine;
	public HALT(Processor cpu, Memory memory){
		super(cpu, memory);
	}
	
	@Override
	public void execute(int arg, boolean immediate, boolean indirect) throws DataAccessException{
		if(immediate || indirect){
			System.out.println("Illegal Construction Error: HALT cannot be indirect or immediate."); 
		}
		else{
			if (machine != null) {
	            machine.halt();
	        }
			
	        if (gmachine != null) {
	            gmachine.halt();
	        }
		}
	}
	
	 public void setGmachine(GUIMachine machine) {
	     this.gmachine = machine;
	 }
	
	public void setMachine(Machine machineIn){
		machine = machineIn;
	}
}
