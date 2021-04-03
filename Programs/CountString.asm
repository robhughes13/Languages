# Simple starter file:
# Rob Hughes, Dr. Catron, 02/10/2020
# Counting string length

.text
.globl __start

__start:                
	
		# Loads address of name into register and prints its

	lui $t0, 0x1001
	ori $t0,$t0, 0x003B
	ori $a0, $zero, 4
	or $a1, $zero, $t0
	syscall
	
		#loads address of string into $t0
	lui $t0, 0x1001
	ori $t0, $t0, 0x0047
	
		#count
	and $t1, $t1, $zero
	
notEnded:
		#loads byte from word register
	lb $t4,0($t0)
	
		#branch equals to see if string has ended
	beq $t4, $zero, ended
	
		#adds to count
	addi $t1, $t1, 1
	
		#adds to register with the address to get the next byte
	addi $t0, $t0, 1
		
		#loops with jump
	j notEnded
	
ended:
		#prints count
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
	.asciiz "Rob Hughes\n"
	.asciiz "String Count"
x:
	.byte 5,6,7,8,9,124  
