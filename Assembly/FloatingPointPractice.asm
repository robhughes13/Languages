#Program to explore floating point operations
#Take a 32-bit fl.pt. number and break it into pieces
#print the result like:    - 1 & 5/128 x 2^8

####  DO NOT REDUCE FRACTIONS,  LEAVE THEM IN TERMS OF 128ths  #######


 .globl	__start
.text
__start:

	la $a1, name
	li $a0, 4
	syscall	
	
	la  $t0, n		#address of single precision FP value in memory
	lwc1 $f12, 0($t0)	#load into f.p. registers for confirmation later
	lw  $t0, 0($t0) 	#load value into $t0 (leave it here!)
	
        #isolate sign bit into $t1
            #?? add code here   to isolate the sign bit in $t1
        srl $t1, $t0, 31          
                        
     	#isolate exponent's actual value into $t2
            #?? add code here to isolate the exponent value properly (remember bias)         
        srl $t2, $t0, 23
        andi $t2, $t2, 0x0FF
        addi $t2, $t2, -127
         

    	#isolate significand into $t3 
	#   for simplicity, use only the bits of the number necessary to produce 128ths 
            #?? add code here  
        li $t4, 0x007FFFFF          
	and $t3, $t0, $t4
	srl $t3, $t3, 16

	
	##################
	#print output values
            #?? add code here to call syscall to print the proper sign char  + or -          
	beq $t1, $zero, nothing
	li $a0, 11
	li $a1, '-'
	syscall
	
nothing:

	#The remaining code does not need changing in part 1- it will print values in t1,t2,and t3
	#The remaining code does not need changing in part 1
	li $t5, 0xFF
	addi $t5, $t5, -127
	bne $t2, $t5, nonInf
	beq $t3, $zero, isinf

nonInf:
	bne $t2, $zero, norm
	bne $t3, $zero, denorm
	
norm:
	li $a0,4		#print entire number as a fraction
    	la $a1,ival1    	###??? temp working solution
    	syscall
    	j complete
    	
denorm:
	li $a0,4		#print entire number as a fraction
    	la $a1,ival0    	###??? temp working solution
    	syscall


complete:

	li $a0,1		#print top: (how many 128ths)
	move $a1,$t3
	syscall
	li $a0,11		#print char: /
	li $a1,'/'
	syscall
	li $a0,1		#print:fraction bottom (128ths)
	li $a1,128
	syscall
	
	li $a0,4		#print string : exp
	la $a1,exp
	syscall
	li $a0,1		#print int: exponent value 
	move $a1,$t2
	syscall
	
	li $a0,4		#print separation
	la $a1,sep       	#
	syscall

	li $a0,2		#print as a float as confirmation of original value
	syscall
	j end

isinf:
	la $a1, inf
	li $a0, 4
	syscall
	
end:	
	li $a0,10
	syscall

	.data
n:	.float 0.04
anything: .word 0xFF800000

ival1:  .asciiz "1 & "
exp:    .asciiz " x 2^"
sep:    .asciiz " == "

ival0:  .asciiz "0 & "

inf:	.asciiz "infinity"

name:	.asciiz "Rob Hughes\n"
