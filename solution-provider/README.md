## Heuristic

To parse the heuristic function, the component uses an external API called JEP (Java Expression Parser), you can check it here(link).

The standard supported functions and operators are listed below.

#### Operators
All common arithmetic operators are supported. Boolean operators are also fully supported. Boolean expressions are evaluated to be either 1 or 0 (true or false respectively).

A tick indicates that the operator can be used with the specific type of variable. Refer to the grammar for detailed information about operator precedence.

|                              |        | Double   | Complex  | String            | Vector   |
| ---------------------------- | ------ | :------: | :------: | :---------------: | :------: |
| Power                        | ^      | &#10004; | &#10004; |                   |          |
| Boolean Not                  | !      | &#10004; |          |                   |          |
| Unary Plus, Unary Minus      | +x, -x | &#10004; | &#10004; |                   |          |
| Modulus                      | %      | &#10004; |          |                   |          |
| Division                     | /      | &#10004; | &#10004; |                   | &#10004; |
| Multiplication               | *      | &#10004; | &#10004; |                   | &#10004; |
| Addition, Subtraction        | +, -   | &#10004; | &#10004; | &#10004; (only +) |          |
| Less or Equal, More or Equal | <=, >= | &#10004; |          |                   |          |
| Less Than, Greater Than      | <, >   | &#10004; |          |                   |          |
| Not Equal, Equal             | !=, == | &#10004; | &#10004; | &#10004;          |          |
| Boolean And                  | &&     | &#10004; |          |                   |          |
| Boolean Or                   | \|\|   | &#10004; |          |                   |          |



#### Standard functions
Each of the following functions can be applied to objects of the types indicated.

|                                 |         | Double   | Complex  | String | Vector |
| ------------------------------- | ------- | :------: | :------: | :----: | :----: |
| Sine                            | sin()   | &#10004; | &#10004; |        |        |
| Cosine                          | cos()   | &#10004; | &#10004; |        |        |
| Tangent                         | tan()   | &#10004; | &#10004; |        |        |
| Arc Sine                        | asin()  | &#10004; | &#10004; |        |        |
| Arc Cosine                      | acos()  | &#10004; | &#10004; |        |        |
| Arc Tangent                     | atan()  | &#10004; | &#10004; |        |        |
| Hyperbolic Sine                 | sinh()  | &#10004; | &#10004; |        |        |
| Hyperbolic Cosine               | cosh()  | &#10004; | &#10004; |        |        |
| Hyperbolic Tangent              | tanh()  | &#10004; | &#10004; |        |        |
| Inverse Hyperbolic Sine         | asinh() | &#10004; | &#10004; |        |        |
| Inverse Hyperbolic Cosine       | acosh() | &#10004; | &#10004; |        |        |
| Inverse Hyperbolic Tangent      | atanh() | &#10004; | &#10004; |        |        |
| Natural Logarithm               | ln()    | &#10004; | &#10004; |        |        |
| Logarithm base 10               | log()   | &#10004; | &#10004; |        |        |
| Angle                           | angle() | &#10004; |          |        |        |
| Absolute Value / Magnitude      | abs()   | &#10004; | &#10004; |        |        |
| Random number (between 0 and 1) | rand()  |          |          |        |        |
| Modulus                         | mod()   | &#10004; |          |        |        |
| Square Root                     | sqrt()  | &#10004; | &#10004; |        |        |
| Sum                             | sum()   | &#10004; |          |        |        |

#### Extra functions

|             |        | Double   | Complex | String | Vector   |
| ----------- | ------ | :------: | :-----: | :----: | :------: |
| Average     | avg()  | &#10004; |         |        | &#10004; |
| Cardinality | card() | &#10004; |         |        | &#10004; |
| Maximum     | max()  | &#10004; |         |        | &#10004; |
| Minimum     | min()  | &#10004; |         |        | &#10004; |

To create a valid heuristic function use this operator and functions. In the heuristic function you are allowed refer to the variables located in your Node class (for example ``` Node.state.attr0 ``` ) in this case, you have to list the variables in the "Variables in heuristic function:" input field separated with commas.

#### Examples

Three jugs:
```
abs(4-Node.state.attr0[0][0])
```

8 queens:
```
abs(72-sum(Node.state.attr0))
```

Hanoi towers:
```
4-card(Node.state.attr2)
```