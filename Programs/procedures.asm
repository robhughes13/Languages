# Rob Hughes, 02/26/2020, Lab 5

.text
.globl __start

__start:                
	
	ori $a0, $zero, 4		#prints name
	la $a1, name
	syscall

					#main 
				
	la $a0, testString		#loads address of testing string
	jal length		
	
	move $s0, $v0			#puts string length into save register 0
	
	la $a0, testString		#loads address of testing string
	
	li $a1, 6			#loads an index parameter for charAt
	jal charAt		
	
	move $s1, $v0			#puts the character of the index desired into save register 1
	
	la $a0, testString		#loads address of testing string
	
	li $a1, 't'			#loads a character into argument register 1
	jal indexOf		
	
	move $s2, $v0			#loads the index of the character into save register 2
	

	ori $a0,$zero,10		#clean exit - stops PC properly!
	syscall
	
	
					#non-main function start
length:
	move $t0, $a0			#loads address of string
	and $t1, $t1, $zero		#count register
	
lengthCount:
	lb $t2, 0($t0)			#loads character from string
	beq $t2, $zero, lengthEnd	#tests if string has ended
	addi $t1, $t1, 1		#increments count
	addi $t0, $t0, 1		#increments address
	j lengthCount
	
lengthEnd:
	move $v0, $t1			#moves to return
	jr $ra
	
charAt:
	addi $t0, $s0, 1
	slt $t1, $a1, $t0		#checks if index is greater than length
	beq $t1, $zero, indexWrong
	
	and $t0, $t0, $zero		#count register
	move $t1, $a0			#address register
	move $t2, $a1			#desired index
	
charFinder:				#matches index to count
	lb $t3, 0($t1)		
	beq $t2, $t0, charEnd
	addi $t0, $t0, 1		#increments count
	addi $t1, $t1, 1		#increments index
	j charFinder
	
charEnd:
	move $v0, $t3
	jr $ra
	
indexWrong:
	la $v0, null
	jr $ra
	
indexOf:
	move $t0, $a0			#loads address of string
	move $t1, $a1			#loads char byte
	and $t2, $t2, $zero		#count register
	addi $t4, $s0, 1		#doesn't exist tester
	
charMatch:
	lb $t3, 0($t0)
	beq $t3, $t1, indexPrint
	addi $t0,$t0, 1			#increment address
	addi $t2, $t2, 1		#increment count
	
	slt $t5, $t2, $t4		#checks if string is over
	beq $t5, $zero, isnotReal
	j charMatch

isnotReal:				#prints -1 if character is not in string
	li $v0, -1
	jr $ra
	
indexPrint:
	move $v0, $t2
	jr $ra	    
	   	    
      
############### Data Segment  
.data    # at default data segment address
    	.word 9,10,11,12,13,14,15,16,17
vals:
	.word 0x01234567, 0x00AF0001
t:	.asciiz "hello - world\n"
testString:	
	.asciiz "zebra test"
name:	.asciiz "Rob Hughes\n"
x:
	.byte 5,6,7,8,9,124   	
null:
	.asciiz "null\n"