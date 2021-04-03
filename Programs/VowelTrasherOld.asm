# Simple starter file:
# Rob Hughes, 02/26/2020, Vowel Trasher Indi HW

.text
.globl __start

__start:   
							#main program
	la $a0, sourceString                  
	li $a1, 0x10010060				#final destination destination
	li $a2, 0x100100A0				#pre-backwards address
	li $s0, 97					#a
	li $s1, 101					#e
	li $s2, 105					#i
	li $s3, 111					#o
	li $s4, 117					#u
					
	jal vowelTrasher
	

	ori $a0,$zero,10	#clean exit - stops PC properly!
	syscall
	
	
checkLength:
	move $t0, $a2			#loads address of string
	and $t1, $t1, $zero		#count register
	
lengthCount:
	lb $t2, 0($t0)			#loads character from string
	beq $t2, $zero, lengthEnd	#tests if string has ended
	addi $t1, $t1, 1		#increments count
	addi $t0, $t0, 1		#increments address
	j lengthCount
	
lengthEnd:
	move $s5, $t1			#moves to return
	j vowelEnding
	
vowelTrasher:
  	move $t0, $a0			#loads sourceString address
  	move $t5, $a2			#loads pre-backwards address
      	and $t2, $t2, $zero		#count register

vowelBranch:
	lb $t3, 0($t0)
	j isVowel
	
nonvowelLoop:
	sb $t3, 0($t5)
	addi $t0, $t0, 1			#increments sourceString address
	addi $t5, $t5, 1			#increments pre-back address
	j vowelBranch

isVowel:
	beq $t3, $zero, checkLength			#move byte to temp
	beq $t3, $s0, vowelLoop
	beq $t3, $s1, vowelLoop
	beq $t3, $s2, vowelLoop
	beq $t3, $s3, vowelLoop
	beq $t3, $s4, vowelLoop
	j nonvowelLoop
vowelLoop:
	addi $t0, $t0,1				#increments sourceString address
	j vowelBranch
	
vowelEnding:
	move $t0, $a2
	addi $s5, $s5, -1
	add $t0, $t0, $s5
	li $t2, 1
	move $t3, $a1
	
saveBackwards:
	lb $t1, 0($t0)
	beq $t1, $zero, printBackwards			#saves each byte from pre-dest into dest backwards
	sb $t1, 0($t3)
	sub $t0, $t0, $t2
	addi $t3, $t3, 1
	j saveBackwards

printBackwards:
	ori $a0, $zero, 4
	syscall
	jr $ra
	
############### Data Segment  
.data    # at default data segment address
    	.word 9,10,11,12,13,14,15,16,17
vals:
	.word 0x01234567, 0x00AF0001 
sourceString:
	.asciiz  "testing string"

t:	.asciiz "hello - world\n"
x:
	.byte 5,6,7,8,9,124   	
