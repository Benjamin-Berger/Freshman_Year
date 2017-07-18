package assignment06;

public class NOT extends Instruction {
    public NOT(Processor cpu, Memory memory) {
        super(cpu, memory);
    }

    @Override
    public void execute(int arg, boolean immediate, boolean indirect) throws DataAccessException {
        if (immediate || indirect) {
        	System.out.println("Illegal Construction Error: NOT cannot be immediate or indirect.");
        }
        else {
        	if(cpu.getAccumulator() == 0){
        		cpu.setAccumulator(1);
        	}
        	else{
        		cpu.setAccumulator(0);
        	}
        	cpu.incrementCounter();
        }
                 
    }
}
