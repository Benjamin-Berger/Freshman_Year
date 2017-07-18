package assignment06;

public class CMPZ extends Instruction {
    public CMPZ(Processor cpu, Memory memory) {
        super(cpu, memory);
    }

    @Override
    public void execute(int arg, boolean immediate, boolean indirect) throws DataAccessException {
        if (immediate || indirect) {
        	System.out.println("Illegal Construction Error: CMPZ cannot be indirect ot immmediate."); 
        }
        else{
        	if(memory.getData(arg) == 0){
        		cpu.setAccumulator(1);
        	}
        	else{
        		cpu.setAccumulator(0);
        	}
        	cpu.incrementCounter();
        }
               
    }
}
