'''
Created on Feb 17, 2016

@author: Bhavya
'''
from itertools import count
import operator
from operator import itemgetter
import collections
def main():
    splitNameCourse()
    #f = open('class.txt')
def splitNameCourse():
    name=[]
    courses=[]
    for line in open("class.txt"):
        line = line.strip()
        course_row=(line.split("-",1)[1])
        
        
       # print(course_row)
        parts = line.split(" - ")
      #  parts[0]=parts[0].strip()
        name.append(parts[0])
        courses.append(parts[1])
    #print(len(course_row))
     #   name=name.strip()
    prof = clean_prof(name)
    x=len(prof)
    for i in range(x):
       prof[i]= prof[i].title()
       

        
    
    #################################### print prof and courses
   # for i in range(0,x):
    #  print (prof[i]," - ",courses[i])
    #################################### print prof and courses
    
   # unique_prof=[]
    unique_p=set(prof)
    prof_uni=list(unique_p)
    prof_uni.sort()
    course_uni=[]
    #for i in range(0, len(prof_uni)):
     #   print (prof_uni[i])
      #  for j in range(0,len(prof)):
       #     if(prof_uni[i]==prof[j]):
        #        print (courses[j])
        
        #print ("|")       
        
        ### lists of lists 
    
  #  for i in range(0, len(prof_uni)):
   #     for j in range(0,len(prof)):
    #        if(prof_uni[i]==prof[j]):
     #           unique_course=courses[j].split("/")
      #          for m in range(0, len(unique_course)):
       #             course_uni[i].append(unique_course[m])
                    
    #for x in range(0,len(course_uni)):
     #   print(course_uni[i])
        
        #### lists of lists
        
         #coursepro_dict=dict()
    
    
    
   # dictionary = dict(zip(prof, courses))
   # print (dictionary)
       
   
    
    #for k, v in dictionary.items():
     #   print(k,'-',v)
        
    #print(len(dictionary))
    ##########################################
    #split_course=[]
    #for i in range (0,len(courses)):
    
     #       if "|" in courses[i]:
      #          course_name=courses[i].split("|")
            
            #for j in range(0, len(course_name)):
             #   split_course.append(course_name[j])
                
   # print(split_course)
            
    #dct = collections.defaultdict(list)
    #for p,c in zip(prof,courses):
     #   dct[p].append(c)
    d=dict()
    def dictionary(namess,course_row):
        for x in course_row.rstrip("\n").split("|"):
            x1=x.rstrip(" ")
            if namess in d:
                d[namess].append(x1)
            else:
                d[name]=[x1]
                
    for i in range(len(courses)):
          dictionary(prof, course_row)      
          
    for k in sorted(d.keys()):
        
        print(k,'-',d[k])
        
        
        
                
                
         
     
     
     
    dic={}
    for i in range(len(courses)):
        temp=dic.keys()
        if(prof[i] in temp):
            print(prof[i])
            t=dic[prof[i]]
            x=course_row.split("|")
            t.extend(x)
            dic[prof[i]]=t
        else:
                x=course_row.split("|")
                dic[prof[i]]=x
                
                
                
                
    dic={}
    for i in range(len(courses)):
        temp=dic.keys()
        if(prof[i] in temp):
            t=dic[prof[i]]
            t=t+'|'+courses[i]
            dic[prof[i]]=t
        else:
            dic[prof[i]]=courses[i]
            
    for k in sorted(dic.keys()):
        
        print(k,'-',dic[k])
        
    print(len(dic))
  
            
    #for k in sorted(dic.keys()):
        
     #  print(k,'-',dic[k])
        
    print(len(dic))
        
   # dct = dict(dct)
   # dct2= {key: list(map(str, value.split())) for key, value in dct.items()}
    #for k in sorted(dct.keys()):
       # print(k,'-',dct[k])
        
  #  dictlist=[]   
   # dictlist=list(dct.values())
    #for k in sorted(dic.keys()):
        #print(k,'-',dic[k])
   # for key in sorted(dct.items()):
    #    temp = [key]
     #   dictlist.append(temp)
   # s1 =dictlist[0].split("|")
    #print(dictlist[0])
    #print (s1)
    #for k, v in dct.items():
     #   print(k,'-',v)
    #print(len(dct))
    
    #########################33#############3#
    #sorted_dic=sorted(dic.items(), key=operator.itemgetter(1))
    #sorted_dic = sorted(dic.items(), key=operator.itemgetter(1))
    #sortByValueDict= sorted(dic.items(), key= lambda t:t[1])
   # print(sortByValueDict)
    
        
   # print(len(k.keys()))
        
        
        
          
                                    
                     
             
                
                
                
                
                
    #print(unique_prof)
    
    
        #print(prof)
        #subject = parts[1]
       # print(name + " teaches " + subject)
        
    
        

def clean_prof(name):
 #   name_len=.length
    #print (name)
    lastname=[]
    for i in range (0,len(name)):
    
         
        if name[i].find(",")!=-1:
        #if "," in name[i]:
            pro_name=name[i].split(",")
            #print (pro_name)
            #print ("__________")
            lastname.append(pro_name[0])
        
        elif "." in name[i]:
            pro_name=name[i].split(".")
            if ' ' in pro_name[-1]:
                pro_name=pro_name[-1].split(" ")
                lastname.append(pro_name[-2])
            else:
                lastname.append(pro_name[1])
        
        else:
            pro_name=name[i].split(" ")
            #if ' ' in pro_name[-1]:
            #pro_name=pro_name[-1].split(" ")
            lastname.append(pro_name[-2])
                
           # print (pro_name)
            #print ("___________")
            #pro_name=name[i].find(" ");
            #if pro_name[-1]=='':
             #   lastname.append(pro_name[-2])
              #  print("hello")
            #else:
             #   lastname.append(pro_name[1])
        
    
        
    return lastname
        
        
        
        
        

if __name__ == "__main__": main()