import matplotlib.pyplot as plt

labels = ['Buit', 'Mes Proper', 'Tants Possibles', '']
Rotar = [0.0000, 0.00011, 0.0463, 0]
Afegir = [0.9610, 0.95300, 0.0090, 0]
Eliminar = [0.0001, 0.00020, 0.0146, 0]
IntercanviarPropi = [0.0140, 0.01560, 0.6150, 0]
IntercanviarAltre = [0.0210, 0.02640, 0.3140, 0]
MoveOver = [0.0027, 0.00399, 0.0005, 0]
Doubleswap = [0.0000, 0.00000, 0.0000, 0]
width = 0.35

fig, ax = plt.subplots()

ax.bar(labels, Rotar, 0.8, label='Rotar', color='#ff0000')
sub = [Rotar[j] for j in range(len(Rotar))]
ax.bar(labels, Afegir, 0.8, label='Afegir', bottom=sub, color ='#ffa500')
sub = [Rotar[j] + Afegir[j] for j in range(len(Rotar))]
ax.bar(labels, Eliminar, 0.8, label='Eliminar', bottom=sub, color ='#ffff00')
sub = [Rotar[j] + Afegir[j] + Eliminar[j] for j in range(len(Rotar))]
ax.bar(labels, IntercanviarPropi, 0.8, label='Intercanviar Propi', bottom=sub, color = '#008000')
sub = [Rotar[j] + Afegir[j] + Eliminar[j]
        + IntercanviarPropi[j] for j in range(len(Rotar))]
ax.bar(labels, IntercanviarAltre, 0.8, label='Intercanviar Altre', bottom=sub, color = '#0000ff')
sub = [Rotar[j] + Afegir[j] + Eliminar[j]
        + IntercanviarAltre[j] + IntercanviarPropi[j] for j in range(len(Rotar))]
ax.bar(labels, MoveOver, 0.8, label='Moure', bottom = sub, color = '#4b0082')
sub = [Rotar[j] + Afegir[j] + Eliminar[j]
        + IntercanviarAltre[j] + IntercanviarPropi[j] + MoveOver[j] for j in range(len(Rotar))]
ax.bar(labels, Doubleswap, 0.8, label='Intercanviar Doble', bottom = sub, color = '#ee82ee')

ax.set_ylabel('Percentatge')
ax.set_title('Us d\'Operadors segons estat inicial en HC')
ax.legend()

plt.show()
