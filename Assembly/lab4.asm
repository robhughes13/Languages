# Simple starter file:
# Rob Hughes, 02/19/2020, Lab4

.text
.globl __start

__start:                
	and $t5, $t5, $zero
	
		# printing name
	la $t7,name
	ori $a0, $zero, 4
	or $a1, $zero, $t7
	syscall

		#main
	ori $a0, $zero, 12
	syscall
		#checks if char is a number or letter
	li $t0, 64
	slt $t0, $v0, $t0
	bne $t0, $zero, abs

isUpper:	#isUpper method
	li $t0, 0x5E
	slt $t0, $v0, $t0
	bne $t0, $zero, endLetter
	
isAlpha:	#isAlpha method
	li $t1, 0x60
	li $t2, 32
	slt $t1, $v0, $t1
	bne $t1, $zero, endLetter
	sub $v0, $v0, $t2
	j endLetter

abs:		#abs method
	andi $t0, $v0, 0x0f
	j endNumber


endLetter:	#prints the letter char
	la $t4, nl
	ori $a0, $zero, 4
	or $a1, $zero, $t4
	syscall
	
	li $t4, 0x10010080
	sb $v0, 0($t4)
	ori $a0, $zero, 4
	or $a1, $zero, $t4
	syscall
	j strlen
	
endNumber:	#prints the number char
	la $t4, nl
	ori $a0, $zero, 4
	or $a1, $zero, $t4
	syscall
	
	ori $a0, $zero, 11
	or $a1, $zero, $v0
	syscall
	

strlen:		#finds string length of name
	
	lb $t4, 0($t7)
	beq $t4, $zero, end
	addi $t5, $t5, 1
	addi $t7, $t7, 1
	j strlen
	
end:		#prints string length of name
	la $t4, nl
	ori $a0, $zero, 4
	or $a1, $zero, $t4
	syscall
	
	ori $a0, $zero, 1
	or $a1, $zero, $t5
	syscall
	
			
	ori $a0,$zero,10	#clean exit - stops PC properly!
	syscall
    
      
############### Data Segment  
.data    # at default data segment address
    	.word 9,10,11,12,13,14,15,16,17
vals:
	.word 0x01234567, 0x00AF0001
t:	.asciiz "hello - world\n"
name:	.asciiz "Rob Hughes\n"
nl:	.asciiz "\n"
x:
	.byte 5,6,7,8,9,124   	
	