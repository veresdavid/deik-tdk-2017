package nodes.heuristicparser;

import java.util.Stack;

import org.nfunk.jep.ParseException;
import org.nfunk.jep.function.PostfixMathCommand;

public class Avg extends PostfixMathCommand {

	public Avg() {
		numberOfParameters = -1;
	}

	public void run(Stack stack) throws ParseException {

		if (null == stack) {
			throw new ParseException("Stack argument null");
		}

		Object param = null;
		double result = 0;
		int i = 0;

		while (i < curNumberOfParameters) {
			param = stack.pop();
			if (param instanceof Number) {
				result += ((Number) param).doubleValue();
			} else {
				throw new ParseException("Invalid parameter type");
			}

			i++;
		}

		stack.push(new Double(result/curNumberOfParameters));
	}
}