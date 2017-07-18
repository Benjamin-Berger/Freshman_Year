package assignment06;

public class LOD extends Instruction {
	public LOD(Processor cpu, Memory memory){
		super(cpu, memory);
	}
	
	@Override
	public void execute(int arg, boolean immediate, boolean indirect) throws DataAccessException {
		if (immediate){
			cpu.setAccumulator(arg);
		}
		else if(indirect){
			int arg1 = memory.getData(arg);
			cpu.setAccumulator(memory.getData(arg1));
		}
		else{
			cpu.setAccumulator(memory.getData(arg));
		}
		cpu.incrementCounter();
		
	}
}
