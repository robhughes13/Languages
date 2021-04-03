# Simple starter file:
# Rob Hughes, 02/26/2020, Vowel Trasher

.text
.globl __start

__start:                
	
	la $a0, sourceString
	la $a1, dest
	li $s0, 97					#a
	li $s1, 101					#e
	li $s2, 105					#i
	li $s3, 111					#o
	li $s4, 117					#u
	
	jal vowelTrasher

							
	ori $a0,$zero,10	#clean exit - stops PC properly!
	syscall
    

vowelTrasher:
	move $t0, $a0
	and $t1, $t1, $zero				#counter
	addi $sp, $sp, -8				
	
trashStart:
	lb $t2, 0($t0)
	j isVowel
	
vowelLoop:
	addi $t0, $t0,1
	j trashStart

notLoop:
	sb $t2, 0($sp)
	addi $t0, $t0, 1				#increment source string address
	addi $t1, $t1, 1				#increment stack counter
	addi $sp, $sp, -4				#decrement stack pointer
	j trashStart
		
isVowel:
	beq $t2, $zero, printSetup			
	beq $t2, $s0, vowelLoop
	beq $t2, $s1, vowelLoop				#checks if byte value equal to any vowel
	beq $t2, $s2, vowelLoop
	beq $t2, $s3, vowelLoop
	beq $t2, $s4, vowelLoop
	j notLoop

printSetup:
	move $t0, $a1
	and $t3, $t3, $zero				#print counter
	addi $sp, $sp, 4
	
backPrint:
	slt $t4, $t3, $t1
	beq $t4, $zero, printDest
	lb $t5, 0($sp)
	sb $t5, 0($t0)					#loads bytes from sp backwards into dest address
	addi $sp, $sp, 4
	addi $t0, $t0, 1
	addi $t3, $t3, 1
	j backPrint

printDest:
	addi $sp, $sp, 4
	ori $a0, $zero, 4		#prints the original string backwards w/o vowels, and returns sp
	syscall 
	move $v0, $a1
	jr $ra




############### Data Segment  
.data    # at default data segment address
    	.word 9,10,11,12,13,14,15,16,17
vals:
	.word 0x01234567, 0x00AF0001
sourceString:
	.asciiz "robert bryan hughes"
t:	.asciiz "hello - world\n"
x:
	.byte 5,6,7,8,9,124   
dest:
	
	
