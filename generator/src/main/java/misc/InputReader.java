package misc;

import antlr.SMLLexer;
import antlr.SMLParser;
import antlr.impl.BaseVisitor;
import antlr.impl.ErrorListener;
import exceptions.IncorrectInputException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import representation.ProjectRepresentation;
import representation.operator.OperatorRepresentation;
import representation.state.StateRepresentation;

public class InputReader {

  public InputReader() {
  }

  public ProjectRepresentation processInputFile(String filename)
      throws IncorrectInputException, IOException {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    ANTLRInputStream input = new ANTLRInputStream(reader);
    reader.close();

    SMLLexer lexer = new SMLLexer(input);
    lexer.removeErrorListeners();
    lexer.addErrorListener(new ErrorListener());
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    SMLParser parser = new SMLParser(tokens);
    parser.setBuildParseTree(true);
    parser.removeErrorListeners();
    parser.addErrorListener(new ErrorListener());
    ParseTree tree = parser.expr();

    BaseVisitor baseVisitor = new BaseVisitor();
    baseVisitor.visit(tree);

    StateRepresentation stateRepresentation = baseVisitor.getStateRepresentation();
    List<OperatorRepresentation> operatorRepresentations = baseVisitor
        .getOperatorRepresentations();

    baseVisitor.clear();

    return new ProjectRepresentation(stateRepresentation, operatorRepresentations);
  }
}
