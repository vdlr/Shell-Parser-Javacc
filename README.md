Shell parser based on javacc

A few months ago we require to develop some rules over shell code, as a result this is a full (almost) parser for 99% of shell (bash, ksh), it do some tricks (in the lexer then in the parser) in order to get a representation of shell structure. 

How to Test:
Just copy your file to test/resources, add file to Test class and run JUnit. 

How is represented:
It covers grammar, commands and sintaxis decribe here http://hyperpolyglot.org/unix-shells, generated AST tree shows like that:

script
 statement
  variableassigment  (size)
  value
   expression  (value)
    literal  (value)
  if_stm
  condition
   testcommand
    sqrbrkts_close
    testexpr
     conditions
      expression  ($size)
       varref  ($size)
       literal  ($size)
      option  (-eq)
      expression  (0)
       integer  (0)
    sqrbrkts_close
  then_stm
  commands
   statement
    builtincommand  (echo)
    params
     expression  ("List empty !!!")
      interpolatingquotes  ("List empty !!!")
    redirectOut  (>>)
     expression  ($log)
        varref  ($log)
        literal  ($log)
  else_stmd
  commands
    statement
      builtincommand  (echo)
      params
        expression  ("List ok !!!")
          interpolatingquotes  ("List ok !!!")
      redirectOut  (>>)
        expression  ($Log)
          varref  ($Log)
          literal  ($Log)
