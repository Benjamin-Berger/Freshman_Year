package assignment06;

public class CMPL extends Instruction {
    public CMPL(Processor cpu, Memory memory) {
        super(cpu, memory);
    }

    @Override
    public void execute(int arg, boolean immediate, boolean indirect) throws DataAccessException {
        if (immediate || indirect) {
        	System.out.println("Illegal Construction Error: CMPL cannot be indirect or immediate."); 
        }
        else{
        	if(memory.getData(arg) < 0){
        		cpu.setAccumulator(1);
        	}
        	else{
        		cpu.setAccumulator(0);
        	}
        	cpu.incrementCounter();
        }
               
    }
}
