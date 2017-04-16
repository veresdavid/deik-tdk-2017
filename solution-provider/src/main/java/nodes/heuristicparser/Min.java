package nodes.heuristicparser;

import java.util.Stack;

import org.nfunk.jep.ParseException;
import org.nfunk.jep.function.PostfixMathCommand;

public class Min extends PostfixMathCommand {

	public Min() {
		numberOfParameters = -1;
	}

	public void run(Stack stack) throws ParseException {

		if (null == stack) {
			throw new ParseException("Stack argument null");
		}

		Object param = null;
		double result = Double.POSITIVE_INFINITY;
		int i = 0;

		while (i < curNumberOfParameters) {
			param = stack.pop();
			if (param instanceof Number) {
				if(result > ((Number) param).doubleValue())
					result = ((Number) param).doubleValue();
			} else {
				throw new ParseException("Invalid parameter type");
			}

			i++;
		}

		stack.push(new Double(result));
	}
}