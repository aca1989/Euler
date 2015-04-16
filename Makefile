# /home/aaron/Documents/Git/Euler
# A makefile for Euler Problems
#

# Compiler
#
JCC = javac

# Run-time Environment
#
JRE = java

# Flags
# -g : compile with debugging information
#
JFLAGS  = 

# 'make' compiles all the files
#
default: Problem01.class Problem02.class Problem03.class Problem04.class Problem05.class \
		 Problem06.class Problem07.class Problem08.class Problem09.class Problem10.class \
		 Problem11.class Problem12.class

# 'make ProblemXX.java' compiles a single problem
#
Problem01.class: Problem01.java
	$(JCC) $(JFLAGS) Problem01.java

Problem02.class: Problem02.java
	$(JCC) $(JFLAGS) Problem02.java

Problem03.class: Problem03.java
	$(JCC) $(JFLAGS) Problem03.java

Problem04.class: Problem04.java
	$(JCC) $(JFLAGS) Problem04.java

Problem05.class: Problem05.java
	$(JCC) $(JFLAGS) Problem05.java

Problem06.class: Problem06.java
	$(JCC) $(JFLAGS) Problem06.java

Problem07.class: Problem07.java
	$(JCC) $(JFLAGS) Problem07.java

Problem08.class: Problem08.java
	$(JCC) $(JFLAGS) Problem08.java

Problem09.class: Problem09.java
	$(JCC) $(JFLAGS) Problem09.java

Problem10.class: Problem10.java
	$(JCC) $(JFLAGS) Problem10.java

Problem11.class: Problem11.java
	$(JCC) $(JFLAGS) Problem11.java

Problem12.class: Problem12.java
	$(JCC) $(JFLAGS) Problem12.java

# Runs all the programs
Run: 
	$(JRE) Problem01
	$(JRE) Problem02
	$(JRE) Problem03
	$(JRE) Problem04
	$(JRE) Problem05
	$(JRE) Problem06
	$(JRE) Problem07
	$(JRE) Problem08
	$(JRE) Problem09
	$(JRE) Problem10
	$(JRE) Problem11
	$(JRE) Problem12

# 'Make clean' removes all .class files so the next make
# rebuilds them
#
clean: 
	$(RM) *.class