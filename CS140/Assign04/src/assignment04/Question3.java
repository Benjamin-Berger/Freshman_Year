package assignment04;

public class Question3
{
  private int[] sumRow = new int[4];
  private int[] sumCol = new int[4];
  private int[] sums = new int[10];
  private int[][] input = new int[4][4];
  private int[][] solution = new int[4][4];
  
  public Question3(int[][] input, int[] sumRow, int[] sumCol, int[] sums)
  {
    this.sumRow = sumRow.clone();
    this.sumCol = sumCol.clone();
    this.sums = sums.clone();
    this.input = input.clone();
  }
  
 
  public void solve()
  {
    // In the first for loop, we want to minimize the number of
    // loops. If input[0][0] > 0, then the loop executes once with
    // i00 = input[0][0]. Otherwise, if input[0][0] is 0, then the
    // loop runs from 0 to 9
    int max00 = input[0][0];
    if (max00 == 0)
    {
      max00 = 9;
    }
    for (int i00 = input[0][0]; i00 <= max00; i00++)
    {
      solution[0][0] = i00;
      // normally "break" is undesirable--it jumps out of the loop,
      // meaning the loop has 2 exit points, which is outside our
      // normal rules. In this case we could avoid it by changing
      // "i00<=max00" above to "i00<=max00 && solution[0][0]+3<=sumRow[0]"
      // However, in the third "for-loop" avoiding the "break" is a lot
      // more messy
      if (solution[0][0] + 3 > sumRow[0])
      {
        break;
      }
      int max01 = input[0][1];
      if (max01 == 0)
      {
        max01 = 9;
      }
      for (int i01 = input[0][1]; i01 <= max01; i01++)
      {
        solution[0][1] = i01;
        if (solution[0][0] + solution[0][1] + 2 > sumRow[0])
        {
          break;
        }
        int max02 = input[0][2];
        if (max02 == 0)
        {
          max02 = 9;
        }
        for (int i02 = input[0][2]; i02 <= max02; i02++)
        {
          solution[0][2] = i02;
          if (input[0][3] == 0)
          {
            solution[0][3] = sumRow[0] - solution[0][0] - solution[0][1]
                - solution[0][2];
            if (solution[0][3] <= 0)
            {
              break;
            }
          }
          else
          {
            solution[0][3] = input[0][3];
          }
          
          // REPEAT THE NESTED LOOPS FOR row 1
          int max10 = input[1][0];
          if (max10 == 0)
          {
            max10 = 9;
          }
          for (int i10 = input[1][0]; i10 <= max10; i10++)
          {
            solution[1][0] = i10;
            // normally "break" is undesirable--it jumps out of the loop,
            // meaning the loop has 2 exit points, which is outside our
            // normal rules. In this case we could avoid it by changing
            // "i00<=max00" above to "i00<=max00 && solution[0][0]+3<=sumRow[0]"
            // However, in the third "for-loop" avoiding the "break" is a lot
            // more messy
            if (solution[1][0] + 3 > sumRow[1])
            {
              break;
            }
            int max11 = input[1][1];
            if (max11 == 0)
            {
              max11 = 9;
            }
            for (int i11 = input[1][1]; i11 <= max11; i11++)
            {
              solution[1][1] = i11;
              if (solution[1][0] + solution[1][1] + 2 > sumRow[1])
              {
                break;
              }
              int max12 = input[1][2];
              if (max12 == 0)
              {
                max12 = 9;
              }
              for (int i12 = input[1][2]; i12 <= max12; i12++)
              {
                solution[1][2] = i12;
                if (input[1][3] == 0)
                {
                  solution[1][3] = sumRow[1] - solution[1][0] - solution[1][1]
                      - solution[1][2];
                  if (solution[1][3] <= 0)
                  {
                    break;
                  }
                }
                else
                {
                  solution[1][3] = input[1][3];
                }
                
                // REPEAT THE NESTED LOOPS FOR row 2
                
                int max20 = input[2][0];
                if (max20 == 0)
                {
                  max20 = 9;
                }
                for (int i20 = input[2][0]; i20 <= max20; i20++)
                {
                  solution[2][0] = i20;
                  // normally "break" is undesirable--it jumps out of the loop,
                  // meaning the loop has 2 exit points, which is outside our
                  // normal rules. In this case we could avoid it by changing
                  // "i00<=max00" above to
                  // "i00<=max00 && solution[0][0]+3<=sumRow[0]"
                  // However, in the third "for-loop" avoiding the "break" is a
                  // lot
                  // more messy
                  if (solution[2][0] + 3 > sumRow[2])
                  {
                    break;
                  }
                  int max21 = input[2][1];
                  if (max21 == 0)
                  {
                    max21 = 9;
                  }
                  for (int i21 = input[2][1]; i21 <= max21; i21++)
                  {
                    solution[2][1] = i21;
                    if (solution[2][0] + solution[2][1] + 2 > sumRow[2])
                    {
                      break;
                    }
                    int max22 = input[2][2];
                    if (max22 == 0)
                    {
                      max22 = 9;
                    }
                    for (int i22 = input[2][2]; i22 <= max22; i22++)
                    {
                      solution[2][2] = i22;
                      if (input[2][3] == 0)
                      {
                        solution[2][3] = sumRow[2] - solution[2][0]
                            - solution[2][1] - solution[2][2];
                        if (solution[2][3] <= 0)
                        {
                          break;
                        }
                      }
                      else
                      {
                        solution[2][3] = input[2][3];
                      }
                      // INSTEAD OF FOR LOOPS, COMPUTE row 3:
                      if (input[3][0] == 0)
                      {
                        solution[3][0] = sumCol[0] - solution[0][0]
                            - solution[1][0] - solution[2][0];
                        if (solution[3][0] <= 0)
                        {
                          break;
                        }
                      }
                      else
                      {
                        solution[3][0] = input[3][0];
                      }
                      
                      // SAME FOR COLUMN 1
                      if (input[3][1] == 0)
                      {
                        solution[3][1] = sumCol[1] - solution[0][1]
                            - solution[1][1] - solution[2][1];
                        if (solution[3][1] <= 0)
                        {
                          break;
                        }
                      }
                      else
                      {
                        solution[3][1] = input[3][1];
                      }
                      // SAME FOR COLUMN 2
                      if (input[3][2] == 0)
                      {
                        solution[3][2] = sumCol[1] - solution[0][2]
                            - solution[1][2] - solution[2][2];
                        if (solution[3][2] <= 0)
                        {
                          break;
                        }
                      }
                      else
                      {
                        solution[3][2] = input[3][2];
                      }
                      // SAME FOR COLUMN 3
                      if (input[3][3] == 0)
                      {
                        solution[3][3] = sumCol[3] - solution[0][3]
                            - solution[1][3] - solution[2][3];
                        if (solution[3][3] <= 0)
                        {
                          break;
                        }
                      }
                      else
                      {
                        solution[3][3] = input[3][3];
                      }
                      
//                      if (input[0][0] + input[1][1] + input[2][2] + input[3][3] != sums[8])
//                      {
//                        break;
//                      }
//                      if (input[0][3] + input[1][2] + input[2][1] + input[3][0] != sums[9])
//                      {
//                        break;
//                      }
                      
                      if (checkSolution(solution))
                      {
                        printInput(input);
                        System.out.println();
                        printGrid(solution);
                        System.out.println();
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean checkSolution(int[][] solution)
  {
    boolean retVal = true;
    int sumD1 = 0;
    int sumD2 = 0;
    for (int i = 0; i < 4 && retVal == true; i++)
    {
      for (int j = 0; j < 4 && retVal == true; j++)
      {
        if (solution[i][j] < 1 || solution[i][j] > 9)
        {
          retVal = false;
        }
        else
        {
          if (sumCol[j] != solution[0][j] + solution[1][j] + solution[2][j]
              + solution[3][j])
          {
            retVal = false;
          }
          if (sumRow[i] != solution[i][0] + solution[i][1] + solution[i][2]
              + solution[i][3])
          {
            retVal = false;
          }
          if (i == j)
          {
            sumD1 += solution[i][j];
          }
          if (i + j == 3)
          {
            sumD2 += solution[i][j];
          }
        }
      }
    }
    return retVal;
  }
  
  private void printInput(int[][] input)
  {
    System.out.println("hi");
  }
  
  private void printGrid(int[][] solution)
  {
    
  }
  
}