import sys
import fileinput
import enchant
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
	prof_final = []
	for s in prof:
                if ',' in s:
                        ss=s.split(",")
                        prof_final.append(ss[0])
                elif '.' in s:
                        ss=s.split(".")
                        if ' ' in ss[-1]:
                                sss=ss[-1].split(" ")
                                prof_final.append(sss[-2])
                        else:
                                prof_final.append(ss[-1])
                else:
                        ss=s.split(" ")
                        prof_final.append(ss[-2])
	x=len(prof_final)
	for i in range(0,x):
                prof_final[i]=prof_final[i].title()

#############################################################################

	prof_u=set(prof_final)
	prof_uni=list(prof_u)
	prof_uni.sort()
	pl2=len(prof_uni)
	count=0
	c_final = []
	for i in range(0,pl2):
		c_final.append([])
	for i in range(0,pl2):
		for j in range(0,x):
			if prof_final[j]==prof_uni[i]:
				c_ss=cours[j].split("|")
				xy=len(c_ss)
				for k in range(0,xy):
					#c_final[i].append(c_ss[k].title())
					c_final[i].append(c_ss[k])
	#pri(prof_uni,c_final)
	c_f2=ench(c_final)
	c_f3=jsend(c_f2)
	#print (c_f3)
	pri(prof_uni,c_f3)
	
def pri(prof_uni,c_final):
	pl2=len(prof_uni)
	for i in range(0,pl2):
		c_final[i].sort()                       
	for i in range(0,pl2):
		print (prof_uni[i],"-",end=' ')
		tr=len(c_final[i])
		for j in range(0,tr):
			if j==tr-1:
				print (c_final[i][j],end='')
#				sys.stdout.softspace=False
			else:
				print (c_final[i][j]+"|",end='')
#				sys.stdout.softspace=False
		print ("")
#		sys.stdout.softspace=False

def ench(c_final):
	#print (c_final)
	l=len(c_final)
	#print (l)
	for i in range(0,l):
		l2=len(c_final[i])
		for j in range(0,l2):
			c_final[i][j]=stsplit(c_final[i][j])
			#print (c_final[i][j])
			#print ("____________________")
	return c_final

def stsplit(st):
	#print (co)
	#print ("________________")
	d=enchant.Dict("en_US")
	sts=[word.strip(string.punctuation) for word in st.split(" ")]
	while '' in sts:
		sts.remove('')
	#sts=st.split(" ")
	#print (sts)
	for i in range(0,len(sts)):
		if len(sts[i])>2:
 			sts[i]=sts[i].title()
		#print (sts[i])
	#print (sts)
	l=len(sts)
	for i in range(0,l):
		#print (sts[i])
		#print ("___________________")
		if (d.check(sts[i]))==False:
			sug=d.suggest(sts[i])
			flag=0
			if len(sts[i])==len(sug[0]):
				dist=edit(sts[i],sug[0])
				if dist<2 and (len(sts[i]))>3:
					st=st.replace(sts[i],sug[0])
				flag=1
			if len(sts[i])==len(sug[1]) and flag==0:
				dist=edit(sts[i],sug[1])
				if dist<2 and (len(sts[i]))>3:
					st=st.replace(sts[i],sug[1])
			else:
				dist=edit(sts[i],sug[0])
				if dist<2 and (len(sts[i]))>3:
					st=st.replace(sts[i],sug[0])
		#print (st)
		#print ("____________")
	return st

def jsend(st):
	l=len(st)
        #print (l)
	for i in range(0,l):
		l2=len(st[i])
		#print (st[i])
                #for j in range(0,l2):
		st[i]=jacc(st[i])
	return st

def jacc(st1):
	l=len(st1)
	#print (l)
	#stnew=[]
	if l==1:
		return st1
	for i in range(0,(len(st1)-1)):
		for j in range(i+1,len(st1)):
			dist=jcomp(st1[i],st1[j])
			if dist>0.7:
				st1.remove(st[j])
	return st1

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
	
			
	

def edit(s1, s2):
    m=len(s1)+1
    n=len(s2)+1

    tbl = {}
    for i in range(m): tbl[i,0]=i
    for j in range(n): tbl[0,j]=j
    for i in range(1, m):
        for j in range(1, n):
            cost = 0 if s1[i-1] == s2[j-1] else 1
            tbl[i,j] = min(tbl[i, j-1]+1, tbl[i-1, j]+1, tbl[i-1, j-1]+cost)

    return tbl[i,j]

#print(edit_distance("Vizion", "Vision"))


if __name__ == '__main__':
    run()
