# libraries
import matplotlib.pyplot as plt
import numpy as np
import seaborn as sns
import pandas as pd
 
# Dataset:
Buit = [97,81,100,94,88,97,89,89,98,103,91,100,105,99,89,94,96,87,96,95,98,103,82,98,104,90,98,105,93,82,101,92,107,93,86,85,99,107,89,100,85,101,92,96,103,89,97,91,99,87]
MesProper = [86,78,88,81,98,73,79,86,88,82,78,89,95,95,78,80,73,84,86,87,91,91,84,94,71,83,81,81,84,79,94,92,79,89,73,76,73,92,93,90,86,82,92,83,87,85,92,81,86,76]
TantsPossibles = [13,22,22,21,20,18,25,25,22,19,18,13,24,28,32,24,23,30,20,22,25,20,19,18,16,22,25,15,27,17,13,19,14,22,19,22,21,24,18,16,19,19,24,22,34,23,27,15,21,21]

a = pd.DataFrame({ 'Estat Inicial' : np.repeat('Buit',50), 'Nodes Explorats': Buit })
b = pd.DataFrame({ 'Estat Inicial' : np.repeat('Mes Proper',50), 'Nodes Explorats': MesProper })
c = pd.DataFrame({ 'Estat Inicial' : np.repeat('Tants Possibles',50), 'Nodes Explorats': TantsPossibles })
#b = pd.DataFrame({ 'group' : np.repeat('B',500), 'value': np.random.normal(13, 1.2, 500) })
#c = pd.DataFrame({ 'group' : np.repeat('B',500), 'value': np.random.normal(18, 1.2, 500) })
#d = pd.DataFrame({ 'group' : np.repeat('C',20), 'value': np.random.normal(25, 4, 20) })
#e = pd.DataFrame({ 'group' : np.repeat('D',100), 'value': np.random.uniform(12, size=100) })
df=a.append(b).append(c)
 
# Usual boxplot
sns.boxplot(x='Estat Inicial', y='Nodes Explorats', data=df)
plt.show()
