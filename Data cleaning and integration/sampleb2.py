'''
Created on Feb 17, 2016

@author: Bhavya
'''
from itertools import count
import operator
from operator import itemgetter
import enchant
import collections
#from _ast import NotIn
def main():
    print("program is running--Please wait")
    splitNameCourse()
def splitNameCourse():
    name=[]
    courses=[]
    for line in open("class.txt"):
        line = line.strip()
        parts = line.split(" - ")
        name.append(parts[0])
        courses.append(parts[1])
    prof = clean_prof(name)
    x=len(prof)
    for i in range(x):
       prof[i]= prof[i].title()
    

    
    
    
        
    d=dict()
    correct_incorrectdic=dict()
    def dictionary_course_split(prof,course_group):

        if prof in d:
            
            x=course_group.split("|")
            d[prof].extend(x)
           
        else:
                x=course_group.split("|")
                d[prof]=x
                
      
    
    for i in range(len(courses)):
        
         dictionary_course_split(prof[i],courses[i])

    
    s = enchant.Dict("en_US")
    incorrect_list=[]
    
    for k in sorted(d.keys()):
        for x in sorted(d[k]):
            for y in x.split(" "):
            

                y=''.join(e for e in y if e.isalnum())
                flag=0
                y=y.title()
                if y:

                    for char in y:
                        if char.isdigit():
                            flag=1
                    if flag==0:
                         if(s.check(y)==False):
                    
                             incorrect_list.append(y)
                             
     ########################################################################Peter Norvig      
    import re, collections

    def words(text): return re.findall('[a-z]+', text.lower()) 
    
    def train(features):
        model = collections.defaultdict(lambda: 1)
        for f in features:
            model[f] += 1
        return model
    
    NWORDS = train(words(open('learn.txt').read()))
    
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    
    def edits1(word):
       splits     = [(word[:i], word[i:]) for i in range(len(word) + 1)]
       deletes    = [a + b[1:] for a, b in splits if b]
       transposes = [a + b[1] + b[0] + b[2:] for a, b in splits if len(b)>1]
       replaces   = [a + c + b[1:] for a, b in splits for c in alphabet if b]
       inserts    = [a + c + b     for a, b in splits for c in alphabet]
       return set(deletes + transposes + replaces + inserts)
    
    def known_edits2(word):
        return set(e2 for e1 in edits1(word) for e2 in edits1(e1) if e2 in NWORDS)
    
    def known(words): return set(w for w in words if w in NWORDS)
    
    def correct(word):
        candidates = known([word]) or known(edits1(word)) or known_edits2(word) or [word]
        return max(candidates, key=NWORDS.get)
    
    
    
    for p in incorrect_list:
        
        u=correct(p)
        correct_incorrectdic[p]=u.title()

           
        
         
     
     #########################################################################Peter Norvig                  
                             
     
     
     
    def edit_distance(p,m):   
        word1=p
    
        word2=m
        
        len_1=len(word1)
        
        len_2=len(word2)
        
        x =[[0]*(len_2+1) for _ in range(len_1+1)]#the matrix whose last element ->edit distance
        
        for i in range(0,len_1+1): #initialization of base case values
        
            x[i][0]=i
        for j in range(0,len_2+1):
        
            x[0][j]=j
        for i in range (1,len_1+1):
        
            for j in range(1,len_2+1):
        
                if word1[i-1]==word2[j-1]:
                    x[i][j] = x[i-1][j-1] 
        
                else :
                    x[i][j]= min(x[i][j-1],x[i-1][j],x[i-1][j-1])+1
        
        return(x[i][j])
            
                                 
     ######################################################################################## edit distance                       
                        
                             
                             
 ##################################################################################WITHOUT PETER  ##uncomment it
    """for p in incorrect_list:
        print(p+"__________________________________________________")
        for m in (s.suggest(p)):
            print(m)
            edit_value=edit_distance(p, m)
            if(len(p)==len(m) and edit_value<3):
               correct_incorrectdic[p]=m
            
    for p in incorrect_list:
        if p not in correct_incorrectdic.keys():
            correct_incorrectdic[p]=p
        
            #else:
             #  correct_incorrectdic[p]=p """
     ####################################################################################uncomment it          
            


        
 ################################################################################ WITHOUT PETER NORVIC       
    def  hasNumbers(inputString):
        return any (char.isdigit() for char in inputString)
        
        
    ####################################################### OUTPUT TXT FILE
    file = open('cleaned.txt', 'w')
    for prof_name in sorted(d.keys()):
        print("\n")
        print(prof_name," - ",end="")
        prof_details = prof_name+" - "
        file.write(prof_details)
        count = 0
        for course_names in sorted(d[prof_name]):
            count=count+1

            for word in course_names.rstrip(" ").split(" "):
                if(word[-1]=="z"):
                    course_names=course_names.replace(word[-1],"s")
                    
                    
                if(word.lower() == "&"):
                    course_names=course_names.replace(word,"and")
                
                without_special_word = ''.join(e for e in word if e.isalnum())
                if(without_special_word.lower() == "intro." or without_special_word.lower() == "intro"):
                    course_names=course_names.replace(word,"Introduction")
                #print(">>>>>>>>>>>>>>>/////   ",word)
                if hasNumbers(without_special_word) == True:
                    course_names=course_names.replace(without_special_word,without_special_word.upper())
                   
                if hasNumbers(without_special_word) != True:
                    if without_special_word:
                       if without_special_word in course_names:
                            if(s.check(without_special_word.lower().capitalize()) == False):
                                without_special_word=without_special_word.title()
                                course_names = course_names.replace(without_special_word, correct_incorrectdic[without_special_word])
                                course_names = course_names[0].upper() + course_names[1:]
                               #print("\\\\\\\\\\\  ", course)
            if(count==len(d[prof_name])):
                print(course_names,end="")
                course_details = course_names + "\n"
                file.write(course_details)
            else:
                print(course_names,"|",end="") 
                course_details = course_names+"|"
                file.write(course_details)       
                        
    file.close()
        
    
        

def clean_prof(name):

    lastname=[]
    for i in range (0,len(name)):
    
         
        if name[i].find(",")!=-1:
       
            pro_name=name[i].split(",")

            lastname.append(pro_name[0])

        elif name[i].find(".")!=-1:
            pro_name=name[i].split(".")
            if ' ' in pro_name[-1]:
                pro_name=pro_name[-1].split(" ")
                lastname.append(pro_name[-2])
            else:
                lastname.append(pro_name[1])
        
        else:
            pro_name=name[i].split(" ")

            lastname.append(pro_name[-2])
                

        
    
        
    return lastname
        
        
        
        
        

if __name__ == "__main__": main()