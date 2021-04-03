#Program Homework fibonacci calculation procedure
#This is the 'main' calling program;  you may not change anything between
# start and end (except print your name)
	.globl	__start
.text
__start:
	####add code to print your name from prompt below####
	la $a1, name
	ori $a0, $zero, 4
	syscall

##  Display fib(3)
	li $s0, 3	#run test value
	move $a0,$s0
	jal printPrompt
	move $a0,$a0
	jal  fib
	move $a1,$v0  	#print results
	li $a0, 1
	syscall

##  Display fib(14) 
	li $s0, 14	#run test value
	move $a0,$s0
	jal printPrompt
	move $a0,$a0
	jal  fib
	move $a1,$v0  	#print results
	li $a0, 1
	syscall

	li $a0, 10
__exit:	syscall


#Function: print value and prompt
printPrompt:
	move $t1,$a0
	li $a0,11
	li $a1,'\n'	 #newline
	syscall
	move $a1,$t1	  #print number value
	li  $a0,1
	syscall
	la $a1, numPrompt #print prompt
	li $a0, 4
	syscall
	jr $ra

######
######add your fib function code below this line

fib:
	and $t2, $t2, $zero
	li $t3, 1
	li $t4, 2
	slt $t6, $t1, $t3
	bne $t6, $zero, printZero
	addi $t1, $t1, 1
	
loopFib:	#finds fibonacci value
	slt $t6, $t4, $t1
	beq $t6, $zero, endLoop
	add $t5, $t2, $t3
	move $t2, $t3
	move $t3, $t5
	addi $t4, $t4, 1
	j loopFib
	
endLoop:	#moves value into v0 and links back
	move $v0, $t3
	jr $ra
	
printZero:	#loads the 0 meaning the inputis invalid and links back
	li $v0, 0
	jr $ra

.data
name:	.asciiz "Rob Hughes\n"
numPrompt:
 	.asciiz " calculates to:\t"
	