package assignment06;

public class DIV extends Instruction {
    public DIV(Processor cpu, Memory memory) {
        super(cpu, memory);
    }
    
    @Override
    public void execute(int arg, boolean immediate, boolean indirect) throws DataAccessException{
        if (immediate) {
        	if (arg == 0){
        		try {
					throw new DivideByZeroException("ERROR: Division by zero");
				} catch (DivideByZeroException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
            cpu.setAccumulator(cpu.getAccumulator() / arg);
        }
        else if (indirect) {
            int arg1 = memory.getData(arg);
            if(memory.getData(arg1) == 0){
            	try {
					throw new DivideByZeroException("ERROR: Division by zero");
				} catch (DivideByZeroException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            cpu.setAccumulator(cpu.getAccumulator() / memory.getData(arg1));                    
        } 
        else {
        	if(memory.getData(arg) == 0){
            	try {
					throw new DivideByZeroException("ERROR: Division by zero");
				} catch (DivideByZeroException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            cpu.setAccumulator(cpu.getAccumulator() / memory.getData(arg));         
        }
        cpu.incrementCounter();     
    }
}
