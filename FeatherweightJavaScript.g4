grammar FeatherweightJavaScript;


@header { package edu.sjsu.fwjs.parser; }

// Reserved words
IF        : 'if' ;
ELSE      : 'else' ;
WHILE	  : 'while' ;
FUNCTION  : 'function' ;
VAR		  : 'var'		;
ID       : ([a-z] | [A-Z] | '_') ([a-z] | [A-Z] | [0-9] | '_')* ;
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
COMMA     : ',' ;


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
    | WHILE '(' expr ')' block							# while
    | PRINT '(' expr ')' SEPARATOR						# print
    | SEPARATOR											# empty
    | VAR ID EQL expr SEPARATOR                         # VarDec  
    | ID '(' expr expr* ')' SEPARATOR                   # FunctionApp ////////
    ;

expr: expr op=( '*' | '/' | '%' ) expr                  # MulDivMod
	| expr op=( '+' | '-' ) expr 						# AddSub
	| expr op=( '<' | '<=' | '>' | '>=' | '==' ) expr 	# Equality
	| FUNCTION '(' expr* expr* ')' block 				# FunctionDec /////////
    | ID ','                                            # argument
	| ID '(' ')'										# VarRefer
	| ID '=' expr 										# AssiState
    | INT                                               # int
    | BOOL												# bool
    | NULL 												# null
    | '(' expr ')'                                      # parens
    | ID                                                # id
    ;

block: '{' stat* '}'                                    # fullBlock
     | stat                                             # simpBlock
     ;
