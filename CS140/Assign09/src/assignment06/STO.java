package assignment06;

public class STO extends Instruction{
	public STO(Processor cpu, Memory memory){
		super(cpu, memory);
	}
	
	@Override
	public void execute(int arg, boolean immediate, boolean indirect) throws DataAccessException{
		if(immediate){
			System.out.println("Illegal Instruction Error: STO cannot be immediate.");
		}
		else if(indirect){
			int argY = memory.getData(arg);
			memory.setData(argY, cpu.getAccumulator());
			cpu.incrementCounter();
		}
		else{
			memory.setData(arg,cpu.getAccumulator());
			cpu.incrementCounter();
		}
	}
}
