# libraries
import matplotlib.pyplot as plt
import numpy as np
import seaborn as sns
import pandas as pd
 
timeHill  =  [395,5242,21016,97399,316232,]
timeSimul =  [148,153,173,193,433,]
x = [0,1,2,3,4]
label = ["(10,100)", "(20,200)", "(30,300)", "(40,400)", "(50,500)"]
 
# Usual boxplot
plt.plot(x,timeHill, marker='o', color="#4B0082", mfc ="#FF00FF", mec="#EE82EE", label="Hill Climbing")
plt.plot(x,timeSimul, marker='o', color="#ffa500", mfc ="#ff6500", mec="#ffe500", label="Simulated Annealing")
plt.xticks(x, label)
plt.ylabel('temps d\'execució (ms)')
plt.xlabel('(Centres,Gasolineres)')
plt.legend(loc="upper left")
plt.show()
