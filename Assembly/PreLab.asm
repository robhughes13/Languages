# Rob Hughes, 02/12/2020, Individual Exam Pre-Lab

.text
.globl __start

__start:                
		#Q1
	la $t5, val
	lw $t0, 0($t5)
	lb $t1, 1($t5)
	lbu $t2, 1($t5)
		# t0= 0x B380C49C
		# t1= 0x FFFFFFC4
		# t2= 0x 000000C4
	
	
		#Q2
	li $a0, 5
	syscall
	
	la $t1, arr
		#count
	and $t2,$t2, $zero 
		#offest value
	and $t3, $t3, $zero 
start:
		#loop to find address of i
	beq $t2, $v0, middle
	addi $t3, $t3, 4
	addi $t2, $t2, 1
	j start
	

middle:
	add $t1, $t1, $t3
	lw $t5, 0($t1)
	ori $t6, $zero, 15
	beq $t5, $t6, end
	ori $t5, $zero, 5
	j finish
end:
	addi $t5, $t5, 9
	j finish
	
finish:
		# "adding 1" to the input
	addi $t5, $t1, 4 
	lw $t5,0($t5)
	ori $a0, $zero, 1
	or $a1, $zero, $t5
	syscall
	
	li $t5, 0x10010028
	li $t4, 0x1001002C
	li $t6, 0x6B6C6568
	sw $t6, 0($t5)
	li $t1, 0x69
	sb $t1, 0($t4)
	
	
	
	ori $a0,$zero,10	#clean exit - stops PC properly!
	syscall
    
      
############### Data Segment  
.data  
arr:
    	.word 3,6,9,12,15,18,21,24
vals:
	.word 0x01234567, 0x00AF0001
t:	.asciiz "hello - world\n"
x:
	.byte 5,6,7,8,9,124   	
val:
	.word 0xB380C49C
	