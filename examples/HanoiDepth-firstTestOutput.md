### info

DepthFirst

### nodes

1|State{attr0=[2.0, Infinity, 3.0], attr1=[Infinity, 1.0], attr2=[Infinity]}

0|State{attr0=[1.0, 2.0, Infinity, 3.0], attr1=[Infinity], attr2=[Infinity]}

9|State{attr0=[Infinity, 2.0], attr1=[Infinity], attr2=[Infinity, 1.0, 3.0]}

8|State{attr0=[Infinity], attr1=[Infinity, 2.0], attr2=[Infinity, 1.0, 3.0]}

7|State{attr0=[Infinity, 1.0], attr1=[Infinity, 2.0], attr2=[Infinity, 3.0]}

6|State{attr0=[Infinity], attr1=[Infinity, 2.0, 1.0], attr2=[Infinity, 3.0]}

5|State{attr0=[Infinity, 3.0], attr1=[Infinity, 2.0, 1.0], attr2=[Infinity]}

4|State{attr0=[Infinity, 1.0, 3.0], attr1=[Infinity, 2.0], attr2=[Infinity]}

3|State{attr0=[Infinity, 3.0], attr1=[Infinity, 2.0], attr2=[Infinity, 1.0]}

2|State{attr0=[2.0, Infinity, 3.0], attr1=[Infinity], attr2=[Infinity, 1.0]}

14|State{attr0=[Infinity], attr1=[Infinity], attr2=[Infinity, 2.0, 1.0, 3.0]}

13|State{attr0=[Infinity, 1.0], attr1=[Infinity], attr2=[Infinity, 2.0, 3.0]}

12|State{attr0=[Infinity], attr1=[Infinity, 1.0], attr2=[Infinity, 2.0, 3.0]}

11|State{attr0=[Infinity, 2.0], attr1=[Infinity, 1.0], attr2=[Infinity, 3.0]}

10|State{attr0=[Infinity, 2.0, 1.0], attr1=[Infinity], attr2=[Infinity, 3.0]}

### operators

OP0|Operator1{i=0, j=0}

OP1|Operator1{i=0, j=1}

OP2|Operator1{i=0, j=2}

OP3|Operator1{i=1, j=0}

OP4|Operator1{i=1, j=1}

OP5|Operator1{i=1, j=2}

OP6|Operator1{i=2, j=0}

OP7|Operator1{i=2, j=1}

OP8|Operator1{i=2, j=2}

### connections

0|1|OP1

0|2|OP2

2|3|OP1

3|4|OP6

3|5|OP7

5|6|OP2

6|7|OP3

6|8|OP5

8|9|OP3

9|10|OP6

9|11|OP7

11|12|OP2

12|13|OP3

12|14|OP5

### steps

Activated nodes: [0] Inactivated nodes: [] Stepped on nodes: [] Closed nodes: [] Activated edges: [] Inactivated edges: []

Activated nodes: [1, 2] Inactivated nodes: [] Stepped on nodes: [0] Closed nodes: [] Activated edges: [0-OP1-1, 0-OP2-2] Inactivated edges: []

Activated nodes: [3] Inactivated nodes: [] Stepped on nodes: [2] Closed nodes: [0] Activated edges: [2-OP1-3] Inactivated edges: []

Activated nodes: [4, 5] Inactivated nodes: [] Stepped on nodes: [3] Closed nodes: [2] Activated edges: [3-OP6-4, 3-OP7-5] Inactivated edges: []

Activated nodes: [6] Inactivated nodes: [] Stepped on nodes: [5] Closed nodes: [3] Activated edges: [5-OP2-6] Inactivated edges: []

Activated nodes: [7, 8] Inactivated nodes: [] Stepped on nodes: [6] Closed nodes: [5] Activated edges: [6-OP3-7, 6-OP5-8] Inactivated edges: []

Activated nodes: [9] Inactivated nodes: [] Stepped on nodes: [8] Closed nodes: [6] Activated edges: [8-OP3-9] Inactivated edges: []

Activated nodes: [10, 11] Inactivated nodes: [] Stepped on nodes: [9] Closed nodes: [8] Activated edges: [9-OP6-10, 9-OP7-11] Inactivated edges: []

Activated nodes: [12] Inactivated nodes: [] Stepped on nodes: [11] Closed nodes: [9] Activated edges: [11-OP2-12] Inactivated edges: []

Activated nodes: [13, 14] Inactivated nodes: [] Stepped on nodes: [12] Closed nodes: [11] Activated edges: [12-OP3-13, 12-OP5-14] Inactivated edges: []

Activated nodes: [] Inactivated nodes: [] Stepped on nodes: [14] Closed nodes: [12] Activated edges: [] Inactivated edges: []

### solutions

0-OP2-2 2-OP1-3 3-OP7-5 5-OP2-6 6-OP5-8 8-OP3-9 9-OP7-11 11-OP2-12 12-OP5-14
