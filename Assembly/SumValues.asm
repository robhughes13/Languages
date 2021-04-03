# Simple starter file:
# Rob Hughes, 02/10/2020, Adds the values from an array and prints

.text
.globl __start

__start:                
	
		# Loads address of name into register and prints its

	lui $t0, 0x1001
	ori $t0,$t0, 0x003B
	ori $a0, $zero, 4
	or $a1, $zero, $t0
	syscall
	
	
		#loads address of array into $t0
	lui $t1, 0x1001
	ori $t1, $t1, 0x0024
	
		#sum
	and $t2, $zero, $t2

sumCount:
		#loads bye into register
	lb $t3, 0($t1)
	
		#branch equals to test if ended
	beq $t3,$zero,end
	
		#adding to sum
	add $t2, $t2, $t3
	
		#adding to count
	addi $t1, $t1, 1
	
		#jump to continue loop
	j sumCount
	

end:
		#prints sum
	ori $a0, $zero, 1
	or $a1, $zero, $t2
	syscall
	
	

	ori $a0,$zero,10	#clean exit - stops PC properly!
	syscall
    
      
############### Data Segment  
.data    # at default data segment address
    	.word 9,10,11,12,13,14,15,16,17
vals:
	.word 0x13210542, 0x00000032
t:	.asciiz "hello - world\n"
	.asciiz "Rob Hughes\n"
x:
	.byte 5,6,7,8,9,124   	