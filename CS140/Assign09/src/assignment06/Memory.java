package assignment06;

import java.util.Arrays;

public class Memory {
    public static final int DATA_SIZE = 512;
    public static final int CODE_SIZE = 256;
    private int[] data = new int[DATA_SIZE];
    private Code[] code = new Code [CODE_SIZE];

    public Memory () {
        clearCode();
    }

    public void setData(int index, int value) throws DataAccessException {
//throw DataAccessException if index out of range
    	if(index < 0 || index >= data.length) {
            throw new DataAccessException("ERROR: Cannot access data location " + index);
        }
        data[index] = value;
    }

    public int getData(int index) throws DataAccessException {
//throw DataAccessException if index out of range
    	if(index < 0 || index >= data.length) {
            throw new DataAccessException("ERROR: Cannot access data location " + index);
        }
        return data[index];
    }

    public void setCode(int index, int opcode, int arg) throws CodeAccessException {
//throw CodeAccessException if index out of range
    	if(index < 0 || index >= data.length) {
            throw new CodeAccessException("ERROR: Cannot code location " + index);
        }
        code[index].opcode = opcode;
        code[index].arg = arg;
    }

    public int getOpcode(int index) throws CodeAccessException {
//throw CodeAccessException if index out of range
    	if(index < 0 || index >= data.length) {
            throw new CodeAccessException("ERROR: Cannot code location " + index);
        }
        return code[index].opcode;
    }

    public int getArg(int index) throws CodeAccessException {
//throw CodeAccessException if index out of range
    	if(index < 0 || index >= data.length) {
            throw new CodeAccessException("ERROR: Cannot code location " + index);
        }
        return code[index].arg;
    }

    // Note package private -- just for JUnit test
    int[] getData() {
        return data;
    }

    public void clearCode() {
        for(int i = 0; i < CODE_SIZE; i++) {
            code[i] = new Code();
        }
    }

    public void clearData() {
        Arrays.fill(data, 0);       
    }

    private class Code { // INNER CLASS
        int opcode;
        int arg;
    }
}
