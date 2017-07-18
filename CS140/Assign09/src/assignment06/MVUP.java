package assignment06;

public class MVUP extends Instruction {

  public MVUP(Processor cpu, Memory memory)
  {
    super(cpu, memory);
  }

  @Override
  public void execute(int X, boolean immediate, boolean indirect) throws DataAccessException {
    int hold;
    int A1 = 0;
    int A2 = 0;
    int N = 0;
    if(immediate){
      return;
      // put a return statement here b\c was told to. just needed to exit and not do anything
    } else if(indirect){
      A1 = memory.getData(memory.getData(X));
      A2 = memory.getData(memory.getData(X+1));
      N = memory.getData(memory.getData(X+2));
    } else {
      A1 = memory.getData(X);
      A2 = memory.getData(X+1);
      N = memory.getData(X+2);
    }
    if(A1 > A2 || N < 0){
      try
      {
        throw new MemoryMoveException();
      }
      catch (MemoryMoveException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
    for(int i = 0; i < N; N--){
      hold = memory.getData(A1 + N - 1);
      memory.setData(A2 + N -1, hold);
      memory.setData(A1 + N -1, 0);
    }
    
  }
  
  
  
  
}
