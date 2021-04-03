# Simple starter file:
# Add your name, date, and program overview
# Rob Hughes
# 01/29/2020
# MIPS First Lab

.text
.globl __start

__start:                
	
	# your code goes here
	
	#DIY 1 
	
	#finding address of vals, adding them, and printing the sum
	ori $t0, $zero, 0x1001
	sll $t0, $t0, 16
	ori $t0, $t0, 0x0024
	lw $t4, 0($t0)
	lw $t5, 4($t0)
	add $t6, $t4, $t5
	ori $a0, $zero, 1
	or $a1, $zero, $t6
	syscall
	
	#prints newline character
	ori $t7, $zero, 0x0a
	ori $a0, $zero, 11
	or $a1, $zero, $t7
	syscall
	
	
	
	#all of this prints out the string of me and my partner's names	
	ori $t1, $zero, 0x1001 
	sll $t1, $t1, 16
	ori $t1, $t1, 0x0041 
	ori $a0, $zero, 4
	or $a1, $zero, $t1
	syscall
	
	
	#DIY2
	
	#reads an interger from user
	ori $a0, $zero, 5
	syscall
	
	#re-prints the integer
	ori $a0, $zero, 1
	or $a1, $zero, $v0
	syscall 
	#adds newline
	ori $t7, $zero, 0x0a
	ori $a0, $zero, 11
	or $a1, $zero, $t7
	syscall
	#re-prints integer plus 2000
	addi $v0, $v0, 2000
	ori $a0, $zero, 1
	or $a1, $zero, $v0
	syscall
	
	#DIY 3
	
	#makes $t3 0, then compares $v0 to see if input is odd or not
	andi $t3, $v0, 1
	
	
	
	ori $a0,$zero,10	#clean exit - stops PC properly!
	syscall
      
############### Data Segment  
.data    # at default data segment address
    	.word 9,10,11,12,13,14,15,16,17
vals:
	.word 0x01234567, 0x00AF0001
t:	.asciiz "hello - world\n"
x:
	.byte 5,6,7,8,9,10   	
	
		
	.asciiz "Rob and Jerry\n"	
	
		#4a.  0x10010024
		
