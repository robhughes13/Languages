# Simple starter file:
# Rob Hughes, 02/12/2020, Printing the users's string input

.text
.globl __start

__start:                #setting a register to check for 'x'
	ori $t0, $zero, 0x78
		#loads address
	li $t1, 0x10010060
	or $t2, $zero, $t1
readLoop:
		#continues to read chars until a char is 'x'
	ori $a0, $zero, 12
	syscall
	beq $v0,$t0, end
	sb $v0, 0($t1)
	addi $t1, $t1, 1
	j readLoop

end:
		#prints newline
	la $t6, nl
	ori $a0, $zero, 4
	or $a1, $zero, $t6
	syscall
		#prints name
	la $t5, t
	ori $a0, $zero, 4
	or $a1, $zero, $t5
	syscall
		#prints the chars entered
	ori $a0, $zero, 4
	or $a1,$zero, $t2
	syscall
	

	ori $a0,$zero,10	#clean exit - stops PC properly!
	syscall
    
      
############### Data Segment  
.data    # at default data segment address
    	.word 9,10,11,12,13,14,15,16,17
vals:
	.word 0x01234567, 0x00AF0001
t:	
	.asciiz "\nRob Hughes\n"
x:
	.byte 5,6,7,8,9,124   	
nl:
	.asciiz "\n"