import java.io.*;
import java.util.*;

/**
 * Class that reads a function definition 
 * and constructs a corresponding SimpleFunction
 * @author Taha Nasir
 */
public class SimpleFunction {
	
	private String name;
	private String current;
	private SimpleListADT<String> arguments;
	private SimpleListADT<String> steps;
	private StringTokenizer input;
	
	/**
	 * Constructor for SimpleFunction that takes a StringTokenizer as input
	 * and creates the SimpleFunction which assigns the name and build the two lists
	 * @param input input of StringTokenizer
	 */
	public SimpleFunction(StringTokenizer input) {
	
		this.input = input;	
	
		arguments = new ArraySimpleList<String>();
		steps  = new ArraySimpleList<String>();
		
		name = input.nextToken();
		current = input.nextToken();

		while (!current.equals("{")) {
			arguments.addToRear(current);
			current = input.nextToken();
			}
		
		current.equals("{");
		current = input.nextToken();
		
		while (!current.equals("}")) {
			steps.addToRear(current);
			current = input.nextToken();
			}
		}
	
	/** Method that evaluates by reading arguments from a stack.
	 * eval will apply its steps on this input, using stack to store all its results 
	 * @param stack creates a stack of integers
	 * @param prog takes input from a text file for  Program 
	 */
	public void eval(StackADT<Integer> stack, Program prog) {
		
		// local list variable
		SimpleListADT<Integer> vals = new ArraySimpleList<Integer>(); 
        
		int j = stack.size();
		for(int i=0; i<j; i++) {
			vals.addToRear(stack.pop());
        }
        
        for(int i=0; i<steps.size(); i++) {
        	String s = steps.get(i);
        	
        	if(s.equals("+")) {
        		int n = stack.pop(); 
        		int m = stack.pop();
        		stack.push(m+n);
        	}
        	
        	if(s.equals("-")) {
        		int n = stack.pop(); 
        		int m = stack.pop();
        		stack.push(m-n);
        	}
        	
        	if(s.equals("*")) {
        		int n = stack.pop(); 
        		int m = stack.pop();
        		stack.push(m*n);
        	}
        	
        	if (prog!=null) {
                SimpleFunction func=prog.find(s);
                if(func!=null)
                    func.eval(stack,prog);
            }
        	
        	 int index = arguments.indexOf(s);
        	 if(index != -1) 		
        		 stack.push(vals.get(index));
        	         	 
        	 if (s.equals("zero?")) {
                 int one = stack.pop();
                 if(one != 0)
                	 while(!(steps.get(i) == "done")); i++;
             }

             if (s.equals("nonzero?")) {
                 int one = stack.pop();
                 if(one == 0)
                     while(!(steps.get(i) == "Done")); i++;
                     }   		
        	}
        }
	
	/** Method that evaluates if Program is null 
	 * @param stack creates a stack of integers 
	 */
	public void eval(StackADT<Integer> stack) {
	      eval(stack,null);
	}
 
	/** ToString method that returns name
	 * @return name followed by blank
	 */
	public String toString() {
	    return name;
	}	
}
