package assignment06;

public class JUMP extends Instruction{
	public JUMP(Processor cpu, Memory memory){
		super(cpu, memory);
	}
	
	@Override
	public void execute(int arg, boolean immediate, boolean indirect) throws DataAccessException{
		if(immediate){
			System.out.println("Illegal Construction Error: JUMP cannot be immediate.");
		}
		else if(indirect){
			int argY = memory.getData(arg);
			cpu.setProgramCounter(argY);
		}
		else{
			cpu.setProgramCounter(arg);
		}
	}
}
