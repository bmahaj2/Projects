'''
Created on Feb 23, 2016

@author: Bhavya
'''

from bs4 import BeautifulSoup
import urllib
import csv
#f=open('C:/Users/BHAVYA/workspace/Hw2_ds/outfileSuperBowl2.txt','w')
#errorFile=open('C:/Users/BHAVYA/workspace/Hw2_ds/errorSuperBowl2.txt','w')

#x=0
#while(x<50):
from urllib.request import urlopen
   # html = urlopen("http://www.google.com/")
    #print(html)

soup=BeautifulSoup(urlopen('https://en.wikipedia.org/wiki/List_of_Super_Bowl_champions').read(),'html')
tableStats=soup.findAll("table",{"class" :"wikitable sortable"})
source_table=tableStats[1]

table_heading=["Game number","year","winning team","score","losing team","venue"]



with open('result.csv','w',newline='') as fp:
         a = csv.writer(fp, delimiter = ',')
         a.writerow(table_heading)

         for row in source_table.findAll("tr")[1:51]:
            cells = row.findAll("td")
            SuperBowl_data=[]
            #print(cells)
            game_no=cells[0].find('a').get_text()
            game_no=game_no.strip(" ")
            SuperBowl_data.append(game_no)
            #print(game_no)
            #if cells[1].find('a').get_text() :
             #   print(cells[0].find('a').get_text())
            #year_kk=cells[1].find('span').get_text()
            #print(year_kk[-4:])
            #split_year=cells[1].split(',')
            #split_year2=split_year[1]
           # print(split_year2[5:])
            year=cells[1].get_text()
            year1=year[-4:]
            year1=year1.strip(" ")
            SuperBowl_data.append(year1)
           # print(year1)
            #visa = cells[1].find(text=True).get_text()
            
           # print(visa[-4:])
            winning_team=cells[2].get_text()
            winning_teamsplit=winning_team.split('!')
            winner=winning_teamsplit[0]
            winner=winner.strip(" ")
            SuperBowl_data.append(winner)
            
            score=cells[3].get_text()
            score_split=score.split('!')
            score_compare=score_split[1]
            score_compare=score_compare.strip(" ")
            SuperBowl_data.append(score_compare)
           
            losing_team=cells[4].get_text()
            losing_teamsplit=losing_team.split('!')
            loser=losing_teamsplit[0]
            loser=loser.strip(" ")
            SuperBowl_data.append(loser)
            
            venue=cells[5].get_text()
            venue_split=venue.split('!')
            venue_place=venue_split[0]
            venue_place=venue_place.strip(" ")
            SuperBowl_data.append(venue_place)
            
            print(game_no+','+year1+','+winner+','+score_compare+','+loser+','+venue_place)
            
            a.writerow(SuperBowl_data)
            
           
    
    
    
   # with open('result.csv','w',newline='') as fp:
    #     a = csv.writer(fp, delimiter = ',')
     #    a.writerow(header_data)
         # Have ur parsing logic here
         # super_bowl_champions_details -- >  list of parsed data
      #   a.writerow(super_bowl_champions_details)
    
    
    
#rows = source_table.find_all('tr')
#for row in rows:
 #   cols = row.find_all('td')
  #  cols = [ele.text.strip() for ele in cols]
   # data.append([ele for ele in cols if ele]) # Get rid of empty values
    #print(data)
#print(source_table)
###################################################################################################################################
#for row in source_table.findAll('tr')[1:]:
    ##table_cell= row.findAll('td')
     #   col=row.findAll('td')
        
      #  try:
       #     game=col[0].a.string.strip()
        #    f.write(game+'\n')
            
        #except Exception as e:
            ##errorFile.write(str(x)+ '********' + str(e) + '****'+ str(col) +'\n')
            #print("Hello")
            #pass
    
   # x=x+40

#f.close
#errorFile.close





