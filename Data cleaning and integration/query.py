'''
Created on Feb 25, 2016

@author: Bhavya
'''
def main():
    

 
    name=[]
    courses=[]
    sep_courses=[]
    for line in open("cleaned.txt"):
        
        line = line.strip()
        parts = line.split(" - ")
        name.append(parts[0])
        courses.append(parts[1])

    query1(courses)
    
    
        
    for i in range(len(courses)):
        query2(name[i],courses[i])
        
    query3(name,courses)
        
def query2(prof,course_group):
    d=dict()    
    if prof in d:
            
        x=course_group.split("|")
        d[prof].extend(x)
           
    else:
         x=course_group.split("|")
         d[prof]=x
      
    for t in d:
        if t == "Theys":
            li = d[t]
            print("Query2: All courses taught by professor Mitchell Theys in comma-separated form are:")
            for temp in li[:-1]:
                print(temp, end =",")
            print(li[-1])

        
def query1(courses):  
    sep_courses=[]
    for ind_courses in courses:
        x=ind_courses.split("|")
        for i in range(len(x)):
            sep_courses.append(x[i])

    s=set(sep_courses)
    s1=list(s)
    print("Query1: Number of distinct courses the dataset contains are as follows:")
    print(len(s1))  
    
def query3(name,courses):
    #name_prof=[]
    #all_courses=[]
    #print(courses)
    op=[]
    print(" Two professors have the most aligned teaching interests based on course titles are:")

    
    for i in range(0,len(courses)):
        op.append([])
        split_c=courses[i].split("|")
        for j in range(len(split_c)):
            op[i].append(split_c[j])
   # print(op) 
    
    prof_name2=[]
    ja=[]
    prof_name=[]
    for i in range(len(name)):
        if(len(op[i])>4):
            prof_name.append(name[i])
    for i in range(len(prof_name)):
        prof_name2.append([])
        for j in range(len(prof_name)):
            prof_name2.append([prof_name[i],prof_name[2]])
            ja.append(jaccard(op[i],op[j]))
            
    j=max(ja)

    
    m=ja.index(j)
    print(prof_name2[m])
    
    
def jaccard(s1, s2):
        st1=set(s1)
        st2=set(s2)
        u = set(st1).union(st2)
        i = set(st1).intersection(st2)
        return len(i)/len(u)
    
    
            
        
    
    
            
    


if __name__ == '__main__':main()