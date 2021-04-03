# Simple starter file:
# Rob Hughes, 01/30/2020, Individual Homework Assignment

.text
.globl __start

__start:                
	
		#reads an interger from user
	ori $a0, $zero, 5
	syscall
	
		#finds group number
	or $t0, $zero,$v0
	srl $t0, $t0, 4
	andi $t0, $t0, 1
	
		#finds subgroup number
	andi $t1, $v0, 0x000F
	
		# loads name in register
	lui $t3, 0x1001
	ori $t3, $t3, 0x003B
	
		#prints name
	ori $a0, $zero, 4
	or $a1, $zero, $t3
	syscall
	
		#loads "group" in register
	and $t5,$zero, $t5
	addi $t5,$t3, 0x000B
	
		#prints "group"
	ori $a0, $zero, 4
	or $a1, $zero, $t5
	syscall
	
		#prints group number
	ori $a0, $zero, 1
	or $a1, $zero, $t0
	syscall
	
		# saves "subgroup" in register t2
	and $t2, $zero, $t5
	addi $t2, $t5, 0x0008
	
		#prints "subgroup"
	ori $a0, $zero, 4
	or $a1, $zero, $t2
	syscall
	
		#prints subgroup number
	ori $a0, $zero, 1
	or $a1, $zero, $t1
	syscall


	ori $a0,$zero,10	#clean exit - stops PC properly!
	syscall
    
      
############### Data Segment  
.data    # at default data segment address
    	.word 9,10,11,12,13,14,15,16,17
vals:
	.word 0x01234567, 0x00AF0001
t:	.asciiz "hello - world\n"
	.asciiz "Rob Hughes"
	.asciiz " Group:"
	.asciiz " Subgroup:"
x:
	.byte 5,6,7,8,9,124   	
