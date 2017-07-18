package assignment06;

public class JMPZ extends Instruction{
	public JMPZ(Processor cpu, Memory memory){
		super(cpu, memory);
	}
	
	@Override
	public void execute(int arg, boolean immediate, boolean indirect) throws DataAccessException{
		if(immediate){
			System.out.println("Illegal Construction Error: JMPZ cannot be immediate."); 
		}
		else if(indirect){
			if(cpu.getAccumulator() == 0){
				int argY = memory.getData(arg);
				cpu.setProgramCounter(argY);
			}
			else{
				cpu.incrementCounter();
			}
		}
		else{
			if(cpu.getAccumulator() == 0){
				cpu.setProgramCounter(arg);
			}
			else{
				cpu.incrementCounter();
			}
		}
	}
}