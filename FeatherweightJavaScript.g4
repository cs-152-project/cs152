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

BLOCK_COMMENT : '/*' .* '*/' -> skip ;  


// ***Parsing rules ***

/** The start rule */
prog: stat+ ;

stat: expr SEPARATOR                                    # bareExpr   //DONE
    | IF '(' expr ')' block ELSE block                  # ifThenElse //DONE
    | IF '(' expr ')' block                             # ifThen     // DONE
    | WHILE '(' expr ')' block							# while             // TEMP_DONE
    | PRINT '(' expr ')' SEPARATOR						# print             // TEMP_DONE
    | SEPARATOR											# empty             //?????
    | VAR ID EQL expr SEPARATOR                         # varDec            // TEMP_DONE
    | expr '(' expr expr* ')' SEPARATOR                 # functionApp     // TEMP_DONE 
    ;

expr: expr op=( '*' | '/' | '%' ) expr                  # mulDivMod       // TEMP_DONE
	| expr op=( '+' | '-' ) expr 						# addSub          // TEMP_DONE
	| expr op=( '<' | '<=' | '>' | '>=' | '==' ) expr 	# equality        // TEMP_DONE
	| FUNCTION '(' (expr (',' expr)*)? ')' block 		# functionDec       // is this a list of string or list of expr
	| ID '(' (expr (',' expr)*)? ')'					# varRefer
	| ID '=' expr 										# assiState        // TEMP_DONE
    | INT                                               # int       // DONE
    | BOOL												# bool             // TEMP_DONE
    | NULL 												# null             // TEMP_DONE
    | '(' expr ')'                                      # parens     ///DONE
    | ID                                                # id               // TEMP_DONE
    ;

block: '{' stat* '}'                                    # fullBlock       // TEMP_DONE
     | stat                                             # simpBlock // DONE
     ;
