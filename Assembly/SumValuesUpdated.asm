# Simple starter file:
# Rob Hughes, 02/24/2020, Updated byte array addition problem

.text
.globl __start

__start:                
			#loading address of name and printing name
	ori $a0, $zero, 4
	la $a1, name
	syscall
	
	la $a0, x		#loading byte array base address
	and $t1, $t1, $zero 	#clearing a count register
	and $t2, $t2, $zero	#clearing a sum register
	li $t5, 5		#setting a limit register
	jal sum5		#jumps to function
	
	
	ori $a0, $zero, 1	#printing sum value
	or $a1, $zero, $v0
	syscall


	ori $a0,$zero,10	#clean exit - stops PC properly!
	syscall


sum5:				#loop to add the first 5 values of the byte array
	lb $t3, 0($a0)
	beq $t1, $t5, return
	add $t2, $t2, $t3
	addi $t1, $t1, 1
	addi $a0, $a0, 1
	j sum5
	
	
return:
	move $v0, $t2
	jr $ra
      
############### Data Segment  
.data    # at default data segment address
    	.word 9,10,11,12,13,14,15,16,17
vals:
	.word 0x01234567, 0x00AF0001
t:	.asciiz "hello - world\n"
name:	.asciiz "Rob Hughes\n"
x:
	.byte 5,6,100,8,24,124   	
	
