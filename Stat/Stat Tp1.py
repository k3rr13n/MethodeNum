import numpy as np
import matplotlib.pyplot as plt

#X = np.random.randint(0, 9, 100)
#Xcopy = X
#N = len(X)
#print(X)
#
#Xmoy = np.mean(X)
#print(Xmoy)
#
#Xvar = np.var(X)
#print(Xvar)
#
#
#    # Extraction des valeurs possibles et de leur effectif
#X, counts = np.unique(X, return_counts=True)
#    # Les valeurs presentent dans la sequence
#print(X)
## Le nombre d’apparition de chacune des valeurs dans la sequence
#print(counts)
#    # Frequences pour chaque modalite
#f = counts / N
#print(f)
#
#
##    # Creation de la figure et des sous-graphiques
##fig, ax = plt.subplots(1, 2, figsize=(12, 5))
##    # Histogramme vertical
##ax[0].bar(X, counts, color='indigo')
##ax[0].set_title("Histogramme vertical")
##ax[0].set_xlabel("Valeurs")
##ax[0].set_ylabel("Effectifs")
##    # Histogramme horizontal
##ax[1].set_title("Histogramme horizontal")
##ax[1].set_xlabel("Effectifs")
##ax[1].barh(X, counts, color='pink')
##ax[1].set_ylabel("Valeurs")
##    # Ajustement des espacements
##plt.tight_layout()
##plt.show()
##    # Creation d’un histogramme en barres verticales
##plt.bar(X, counts)
##    # Creation d’un histogramme en barres horizontales
##plt.barh(X, counts)
#
#
#    # Frequences cumulees
#F = np.cumsum(f)
#    # Creation du graphique en escalier
#plt.step(X, F, where='mid', color='lime', linewidth=2, label="Graphe en escalier")
#    # Ajout des labels et du titre
#plt.xlabel("Valeurs")
#plt.ylabel("Frequence cumulee")
#plt.title("Graphe en escalier de la frequence cumulee")
#plt.legend()
#plt.grid()
#plt.show()
#
#Xmod = max(X) #plus grande valeur de X
#
#Xcopy.sort()
#Xmed = Xcopy[N//2] #la mediane de X trié
#
##print(sum(X)/N)
##print(np.sum(X * f))
##print(np.mean(X))
#
#PrQua = 0 # premier quartile
#for i in range(len(f)):
#    if f[i] <= 0.25:
#        PrQua = i
#print(PrQua)

#===========================================================================================================================

X=np.random.binomial(9, 0.6, 100)

frequence = dict()
for nb in X:
    if nb in frequence.keys():
        frequence[nb] += 1
    else:
        frequence[nb] = 1
print(frequence) 

plt.bar(frequence.keys(), frequence.values())
plt.show()






