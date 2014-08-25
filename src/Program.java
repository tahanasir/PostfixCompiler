import java.util.StringTokenizer;

/** Program class simply stores a list of SimpleFunction
 * 	@author Taha Nasir
 */
public class Program {
	
	// local variable 
    SimpleListADT<SimpleFunction> func = new ArraySimpleList<SimpleFunction>();

    /** Constructor which builds a program by using tokens from st 
     * to build SimpleFunction and store them in a list 
     * @param st StringTokenizer parameter
     */
    public Program(StringTokenizer st) {
        while(st.hasMoreTokens()) {
            func.addToRear(new SimpleFunction(st));
        }
    }

    /** Method to find the SimpleFunction in the list with the given 
     * name and returns it 
     * @param name takes a String name to find
     * @return func.find(name) finds a SimpleFunction in the list with a name and returns it
     */
    public SimpleFunction find(String name) {
        return func.find(name);
    }
}