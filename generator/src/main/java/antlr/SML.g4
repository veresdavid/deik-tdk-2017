grammar SML;

expr: STATE_DELIMITER state_expr OPERATOR_DELIMITER operator_expr+ EOF;

state_expr: state_description state_start state_goal;
state_description: STATE_ATTRIBUTES_DELIMITER state_description_line+;
state_description_line: attr_name KEYWORD_IS (attr_struct KEYWORD_OF)? attr_type;
state_start: STATE_START_DELIMITER expression*;
state_goal: STATE_GOAL_DELIMITER  expression+;

/*-----------------------------------------------------------------------------------------------*/

operator_expr: operator_description operator_precondition operator_effect;
operator_description: OPERATOR_DESCRIPTION_DELIMITER operator_cost? parameter_description_line*;
operator_cost: KEYWORD_COST number;
operator_precondition: OPERATOR_PRECONDITION_DELIMITER expression*;
operator_effect: OPERATOR_EFFECT_DELIMITER expression+;

/*-----------------------------------------------------------------------------------------------*/

attr_name: KEYWORD_ATTRIBUTE INT;
attr_reference: SYMBOL_REFERENCE INT;
parameterized_attr_reference: SYMBOL_REFERENCE PARAM_NAME;
matrix_reference: attr_reference dimension;
parameterized_matrix_reference: parameterized_attr_reference dimension;
dimension: SYMBOL_LBRACK dimensionN=expression SYMOBL_RBRACK SYMBOL_LBRACK dimensionM=expression SYMOBL_RBRACK;
normal_reference: (attr_reference | matrix_reference);
parameterized_reference: (parameterized_attr_reference | parameterized_matrix_reference);
reference: (normal_reference | parameterized_reference);

attr_struct: KEYWORD_SET | (KEYWORD_MATRIX dimension);
attr_type: KEYWORD_WORD | KEYWORD_NUMBER;

comparator: SYMBOL_EQUAL | SYMBOL_NOT_EQUAL | SYMBOL_GREATER | SYMBOL_LESSER | SYMBOL_GREATER_OR_EQUAL | SYMBOL_LESSER_OR_EQUAL;
binary_operator: SYMBOL_ADDITION | SYMBOL_SUBSTRACT | SYMBOL_MULTIPLICATION | SYMBOL_DIVISION | SYMBOL_POWER;
unary_operator: KEYWORD_MAXIMUM
  | KEYWORD_MINIMUM
  | KEYWORD_AVERAGE
  | KEYWORD_ABS
  | KEYWORD_CARDINALITY
  | KEYWORD_UNION
  | KEYWORD_ADD
  | KEYWORD_REMOVE
  | KEYWORD_SUM
  | KEYWORD_LENGTH
  | KEYWORD_CHAR_AT;

boolean_operator: KEYWORD_AND | KEYWORD_OR;

expression
  :  SYMBOL_LPAREN expression SYMBOL_RPAREN #paren_expr
  | left=expression comparator right=expression #compare_expr
  | left=expression boolean_operator right=expression #bool_expr
  | left=expression binary_operator right=expression #binary_expr
  | unary_operator SYMBOL_LPAREN left=expression (SYMBOL_COMMA right=expression)? SYMBOL_RPAREN #unary_expr
  | SYMBOL_LBRACE (expression (SYMBOL_COMMA  expression)*) SYMBOL_RBRACE #set_init_expr
  | reference SYMBOL_ASSIGN expression #assign_expr
  | for_statement SYMBOL_LBRACE expression+ SYMBOL_RBRACE #for_expr
  | if_statement SYMBOL_LBRACE expression+ SYMBOL_RBRACE else_statement? #if_expr
  | KEYWORD_VAR attr_type PARAM_NAME SYMBOL_ASSIGN expression #var_defining_expression
  | reference #reference_expr
  | word #word_expr
  | number #number_expr
  | PARAM_NAME #param_name_expr
  ;

parameter_description_line: KEYWORD_PARAM PARAM_NAME KEYWORD_FROM INT KEYWORD_TO INT (KEYWORD_BY INT)?;
for_statement: KEYWORD_FOR variable=PARAM_NAME KEYWORD_FROM from=expression KEYWORD_TO to=expression (KEYWORD_BY by=expression)?;
if_statement: KEYWORD_IF SYMBOL_LPAREN condition=expression SYMBOL_RPAREN;
else_statement: KEYWORD_ELSE SYMBOL_LBRACE expression+ SYMBOL_RBRACE;

COMMENT: SYMBOL_COMMENT_START .*? SYMBOL_COMMENT_END -> skip;

STATE_DELIMITER: 'STATE:';
STATE_ATTRIBUTES_DELIMITER: 'STATE_ATTRIBUTES:';
STATE_START_DELIMITER: 'STATE_START:';
STATE_GOAL_DELIMITER: 'STATE_GOAL:';

OPERATOR_DELIMITER: 'OPERATORS:' ;
OPERATOR_DESCRIPTION_DELIMITER: 'OPERATOR_DESCRIPTION:';
OPERATOR_PRECONDITION_DELIMITER: 'OPERATOR_PRECONDITION:';
OPERATOR_EFFECT_DELIMITER: 'OPERATOR_EFFECT:';

KEYWORD_IF: 'if';
KEYWORD_ELSE: 'else';
KEYWORD_FOR: 'for';
KEYWORD_PARAM: 'param';
KEYWORD_FROM: 'from';
KEYWORD_TO: 'to';
KEYWORD_BY: 'by';
KEYWORD_TIMES: 'times';
KEYWORD_ATTRIBUTE: 'attr';
KEYWORD_VAR: 'var';
KEYWORD_COST: 'cost';

KEYWORD_IS: 'is';
KEYWORD_OF: 'of';
KEYWORD_SET: 'set';
KEYWORD_MATRIX: 'matrix';
KEYWORD_WORD: 'word';
KEYWORD_NUMBER: 'number';

KEYWORD_MINIMUM: 'min';
KEYWORD_MAXIMUM: 'max';
KEYWORD_SUM: 'sum';
KEYWORD_AVERAGE: 'avg';
KEYWORD_ABS: 'abs';

KEYWORD_UNION: 'union';
KEYWORD_INTERSECT: 'intersect';
KEYWORD_DIFFERENCE: 'difference';
KEYWORD_ADD: 'add';
KEYWORD_REMOVE: 'remove';
KEYWORD_CARDINALITY: 'card';

KEYWORD_CHAR_AT: 'charAt';
KEYWORD_LENGTH: 'length';

KEYWORD_AND: 'and';
KEYWORD_OR: 'or';
KEYWORD_NOT: 'not';

KEYWORD_INF: 'inf';

SYMBOL_EQUAL: '==';
SYMBOL_NOT_EQUAL: '!=';
SYMBOL_LESSER: '<';
SYMBOL_GREATER: '>';
SYMBOL_LESSER_OR_EQUAL: '<=';
SYMBOL_GREATER_OR_EQUAL: '>=';

SYMBOL_ADDITION: '+';
SYMBOL_SUBSTRACT: '-';
SYMBOL_MULTIPLICATION: '*';
SYMBOL_DIVISION: '/';
SYMBOL_POWER: '^';

SYMBOL_ASSIGN: '=';
SYMBOL_REFERENCE: '$';
SYMBOL_COMMA : ',' ;
SYMBOL_QUOTE: '\"';
SYMBOL_SINGLE_QOUTE: '\'';

SYMBOL_LPAREN: '(' ;
SYMBOL_RPAREN: ')' ;
SYMBOL_LBRACE: '{' ;
SYMBOL_RBRACE: '}' ;
SYMBOL_LBRACK: '[' ;
SYMOBL_RBRACK: ']' ;

SYMBOL_COMMENT_START: '/*';
SYMBOL_COMMENT_END: '*/';

INT: (('0' | '1'..'9') '0'..'9'*);
FLOAT: (('0' | '1'..'9') '0'..'9'*)'.'('0'..'9'*);
number: (SYMBOL_ADDITION | SYMBOL_SUBSTRACT)? (INT | FLOAT | KEYWORD_INF);
word: SYMBOL_QUOTE (~(SYMBOL_REFERENCE | SYMBOL_QUOTE | '\\'))* SYMBOL_QUOTE;
PARAM_NAME: ('a'..'z') ('_' | 'a'..'z' | 'A'..'Z')*;
WS: [ \t\r\n]+ -> skip ;