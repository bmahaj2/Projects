import sys
import fileinput
import string
def run():
	arr = [] 
	for stri in fileinput.input():
		stri=stri.strip()
		arr.append(stri)
	prof = []
	cours = []
	for i in arr:
		ies=i.split(" - ")
		prof.append(ies[0])
		cours.append(ies[1])
	#print (prof)
	#print (cours)
	#print (len(prof))
	pl2=len(cours)
	c_final = []
	for i in range(0,pl2):       
		c_final.append([])
	for i in range(0,pl2):
		c_ss=cours[i].split("|")                                
		xy=len(c_ss)                                
		for k in range(0,xy):
			c_final[i].append(c_ss[k])
	#for i in range(0,len(c_final)):
	#	print (c_final[i])
	#	print ("_________________")
	q1(c_final)
	q2(prof,c_final)
	q3(prof,c_final)
	#print ("1: How many distinct courses does this dataset contain?")
	#print ("Answer: ",sol1)
	

def q1(cf):
	#print (cf)
	cf_1=[]
	for i in range(0,len(cf)):
		for j in range(0,len(cf[i])):
			cf_1.append(cf[i][j])
	#print (cf_1)
	#print ("__________")
	#print (len(cf_1))
	cf_1_u=set(cf_1)
	cf_uni=list(cf_1_u)
	cf_len=len(cf_uni)
	print ("1: How many distinct courses does this dataset contain?")
	print ("")
	print ("Answer: ",cf_len)
	print ("")
	#return cf_len

def q2(pr,cf):
	print ("2: List all the courses (in alphabetical order) taught by Professor Mitchell Theys in comma‐separated form.")
	print ("")
	print ("Answer:")
	print ("")
	for i in range(0,len(cf)):
		if pr[i]=="Theys":
			for j in range(0,len(cf[i])):
				if j==(len(cf[i])-1):
					print (cf[i][j])
				else:
					print (cf[i][j]+",",end='')
	print ("")

def q3(pr,cf):
	prn=[]
	cfn=[]
	for i in range(0,len(pr)):
		if len(cf[i])>4:
			prn.append(pr[i])
			cfn.append(cf[i])
	jdist,pro_n=jsend(prn,cfn)
	index=jdist.index(max(jdist))
	print ("3: For professors who have taught at least 5 courses, using Jaccard distance to determine which two professors have the most aligned teaching interests based on course titles. Note that you should implement the function to calculate Jaccard distance instead of using an existing package.")
	print ("")
	print ("Answer:")
	print ("")
	print ("Given below are the list of professors who have taught at least 5 courses:-")
	print ("")
	l=len(prn)
	for i in range(0,l):
		print (i+1,")",prn[i])
	print ("")
	print ("The two professors who have aligned teaching interests are:-")
	print ("")
	l2=len(pro_n[index])
	for i in range(0,l2):
		print (i+1,")",pro_n[index][i])
		if i!=l2-1:
			print ("AND")
		
print ("")
	#print (max(jdist))
	#print (index)
	#print (jdist)
	#print (pro_n)
	#print (len(jdist))
	#print (len(pro_n))
	#print (prn)
	#print (cfn)
	#print (len(prn))
	#print (len(cfn))

def jsend(pr,cf):
	jdist=[]
	pro_n=[]	
	l=len(cf)
	for i in range(0,(len(cf)-1)):
		for j in range(i+1,len(cf)):
			jd=jacc(cf[i],cf[j],i,j,pr[i],pr[j])
			jdist.append(jd)
			pro_n.append([pr[i],pr[j]])
			#print (pr[i])
			#print (pr[j])
	#print (jdist)
	#print (pro_n)
	return jdist,pro_n
			

def jacc(s1,s2,n1,n2,p1,p2):
	l1=len(s1)
	l2=len(s2)
	#print (s1)
	#print (s2)
	dist=0
	c=0
	for i in range(0,len(s1)):
		for j in range(0,len(s2)):
			dist=dist+jcomp(s1[i],s2[j])
			c=c+1
	avg=dist/c
	return avg
	#print (dist)

def jcomp(s1,s2):
	s1s=[word.strip(string.punctuation) for word in s1.split(" ")]
	while '' in s1s:
		s1s.remove('')
	s2s=[word.strip(string.punctuation) for word in s2.split(" ")]
	while '' in s2s:
		s2s.remove('')
	nc1=set(s1s).intersection(s2s)
	nc2=list(nc1)
	nc=len(nc2)
	na=len(s1s)
	nb=len(s2s)
	t=nc/(na+nb-nc)
	return t
	#print (s1s)
	#print (s2s)
	
	
if __name__ == '__main__':
	run()          
