# Lab 2: Labels, arrays, Memory and more
# Rob Hughes  CSC 231
.text
.globl __start
__start:
		#Lab 2.1
		#loading and printing prompt2
	lui $t2,0x1001  
	ori $t2,$t2,0x004A
	
	ori $a0,$zero, 4
	or $a1,$zero, $t2
	syscall
	
	lui $t1,0x1001
	ori $t1,$t1, 0x0039
	ori $a0,$zero, 4
	or $a1,$zero, $t1
	syscall
	
		#Lab 2.2
	ori $a0, $zero, 5
	syscall 
		#loads address to register, loads word from register
	lui $t3, 0x1001
	ori $t3, $t3, 0x0008
	lw $t4,0($t3)
		#uses input to find the value in the array
	add $t5, $t4, $v0
		#adds (input+3)+(input+4) and stores in register
	addi $t6, $t5, 3
	addi $t7, $t5, 4
	add $t1, $t6, $t7
		#prints the sum of previous addition
	ori $a0, $zero, 1
	or $a1, $zero, $t1
	syscall
		#Lab 2.3
		#checks to see oif even or odd
	andi $t2, $v0, 1
		#branch statement to print even or odd
	bne $t2, $zero, odd
		#prints even statement
	lui $t4, 0x1001
	ori $t4, $t4, 0x00DA
	ori $a0, $zero, 4
	or $a1, $zero, $t4
	syscall
	j end
	
odd:
		#prints odd statement
	lui $t3, 0x1001
	ori $t3, $t3 ,0x00CB
	ori $a0, $zero, 4
	or $a1, $zero, $t3
	syscall
	
	
	
############# clean exit #######
end:
	ori $a0, $zero, 10
	syscall
     
.data  
myX:    .word -4, 4
arr:	.word 9, 10, 11, 12, 13, 14, 15, 16, 249
	.word 0x1290A0B0, 0x01234567, 0x44556611
	.byte 8
prompt1:
	.asciiz "Rob and Cole\n"
	.byte 5, 6, 7
prompt2:
	.asciiz   "not null terminated?\n"
	.byte 126, 64, 123, 94, 58,95,'b'
mySpace:
	.space 100
	
evenOdd:
	.asciiz  "\tNumber is odd"
	.asciiz  "\tEven Steven"