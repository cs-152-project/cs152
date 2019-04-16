grammar FeatherweightJavaScript;


@header { package edu.sjsu.fwjs.parser; }

// Reserved words
IF        : 'if' ;
ELSE      : 'else' ;
WHILE	  : 'while' ;
FUNCTION  : 'function' ;
VAR       : ([a-z] | [A-Z] | '_') ([a-z] | [A-Z] | [0-9] | '_')* ;
PRINT	  : 'print' ;

// Literals
INT       : [1-9][0-9]* | '0' ;
BOOL      : 'true' | 'false' ;
NULL 	  : 'null' ;

// Symbols
MUL       : '*' ;
DIV       : '/' ;
SEPARATOR : ';' ;
ADD		  : '+' ;
SUB       : '-' ;
MOD       : '%' ;
BIGGER    : '>' ;
SMALLER   : '<' ;
BIGOREQL  : '>='  ;
SMALLOREQL: '<=' ;
SAME 	  : '=='  ;
EQL		  : '=' ;


// Whitespace and comments
NEWLINE   : '\r\n' ? '\n' -> skip ;
LINE_COMMENT  : '//' ~[\n\r]* -> skip ;
WS            : [ \t]+ -> skip ; // ignore whitespace

BLOCK_COMMENT : '/*' .* '*/' -> skip ;  // this is where I got the logic from https://stackoverflow.com/questions/7526630/grammar-to-parse-multiline-comments-and-string-literals-simultaneously


// ***Parsing rules ***

/** The start rule */
prog: stat+ ;

stat: expr SEPARATOR                                    # bareExpr
    | IF '(' expr ')' block ELSE block                  # ifThenElse
    | IF '(' expr ')' block                             # ifThen
    | WHILE '(' expr ')'   								# while
    | PRINT '(' expr ')' SEPARATOR						# print
    | SEPARATOR											# empty
    ;

expr: expr op=( '*' | '/' | '%' ) expr                  # MulDivMod
	| expr op=( '+' | '-' ) expr 						# AddSub
	| expr op=( '<' | '<=' | '>' | '>=' | '==' ) expr 	# Equality
	| FUNCTION '(' VAR  '){' expr '}' 					# FunctionDec /////////
	| 'f(' expr ')'										# FunctionApp ////////
    | INT                                               # int
    | BOOL												# bool
    | NULL 												# null
    | '(' expr ')'                                      # parens
    ;

block: '{' stat* '}'                                    # fullBlock
     | stat                                             # simpBlock
     ;
