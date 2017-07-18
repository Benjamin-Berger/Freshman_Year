package assignment06;

public class NOP extends Instruction{
	public NOP(Processor cpu, Memory memory){
		super(cpu, memory);
	}
	
	@Override
	public void execute(int arg, boolean immediate, boolean indirect) throws DataAccessException{
		if(immediate || indirect){
			System.out.println("Illegal Construction Error: NOP cannot be immediate or indirect.");
		}
		else{
			cpu.incrementCounter();
		}
	}
}