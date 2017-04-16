# State-space Modelling Language

## Control-flow statements
<pre>if(<i>condition</i>) {<i>statements</i>} [else {<i>statements</i>}] </pre>
   If the condition is true, the statements following the condition are executed. Otherwise, the execution continues in the following branch, either in the else block (which is optional), or if there is no else branch, then after the end of the statement.

<pre>for <i>variable</i> from <i>initial value</i> to <i>final value</i> by <i>scale</i> {<i>statements</i>} </pre>
   Iterates through the given range of values. The iteration starts with the initial value, finishes including the final value and increments after every loop with the given scale.

## Other statements

<pre>attr<i>number</i> is {set | matrix[<i>column</i>][<i>row</i>]} of {number | word} </pre>
   Defines an attribute which can be matrix or set, and each can contain numbers or words.

<pre>{<i>value1</i>, <i>value2</i>, … <i>valuen</i>}</pre>
   Defines a set containing the given values.

<pre>param <i>parameter name</i> from <i>initial value</i> to <i>final value</i> [by <i>scale</i>]</pre>
   Defines an operator parameter. This parameter will take values in the given range of values. If the scale is not specified explicitly it will be set to 1 aoutomatically.

<pre>cost <i>value</i></pre>
   Defines the cost of an operator.

## Operators
Symbol  |	Effect
--------|-------
\=	    | Assign
\+	    | Add
\-	    | Subtract
\*      | Multiple
\/      | Divide
\^	    | Power
\==	    | Equal
\!=	    | Non-equal
\<=	    | Less-than or equal
\>=	    | Greater-than or equal
\< 	    | Less-than
\> 	    | Greater-than
\!	    | Logical negation
and	    | Logical and
or	    | Logical or

## Functions
Name       | Effect
---------- | ----------
inf	       | Represents infinity
abs        | Returns the absolute value of a number
min	       | Returns the minimum of a collection or two numbers
max	       | Returns the maximum of a collection or two numbers
avg	       | Returns the average of a collection or two numbers
sum	       | Returns the sum of a collection or two numbers
add	       | Adds an element to a set
remove	   | Removes an element from a set
card	     | Returns the cardinality of a collection
union	     | Returns the union of two sets
intersect	 | Returns the intersect of two sets
difference | Returns the difference of two sets
length	   | Returns the length of a word
charAt	   | Returns the character at the given position

## Delimiters
Keyword                | Purpose
---------------------- | ----------------------
STATE:	               | Marks the beginning of the definition of state
STATE_ATTRIBUTES:	     | Marks the beginning of the definition of state attributes
STATE_START:	         | Marks the beginning of the definition of state start
STATE_GOAL:	           | Marks the beginning of the definition of state goal
OPERATORS:	           | Marks the beginning of the definition of operators
OPERATOR_DESCRIPTION:	 | Marks the beginning of the definition of operator description
OPERATOR_PRECONDITION: | Marks the beginning of the definition of operator precondition
OPERATOR_EFFECT:	     | Marks the beginning of the definition of operator effect


