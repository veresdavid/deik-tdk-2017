package nodes.heuristicparser;

import java.util.Stack;

import org.nfunk.jep.ParseException;
import org.nfunk.jep.function.PostfixMathCommand;

public class Card extends PostfixMathCommand {

	public Card() {
		numberOfParameters = -1;
	}

	public void run(Stack stack) throws ParseException {

		if (null == stack) {
			throw new ParseException("Stack argument null");
		}

		int i = 0;

		while (i < curNumberOfParameters) {
			stack.pop();
			i++;
		}
		
		stack.push(new Double(curNumberOfParameters));
	}
}