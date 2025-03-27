import numpy as np
import matplotlib.pyplot as plt

# Genere 50 nombres aleatoires entre 0 et 1
X = np.random.rand(50)
# Ajoute un bruit gaussien de moyenne -1 et ecart-type 0.2
Y = 2 * X + np.random.normal(-1,0.2,50)

#plt.scatter(X, Y, color='blue', marker='o', alpha=0.7)
#plt.show()

# Genere 50 nombres aleatoires entre 0 et 1
#X = np.random.rand(50)
# Ajoute un bruit gaussien de moyenne -1 et ecart-type 3
#Z =-3 * X**4 + np.random.normal(-1, 3,50)

#plt.scatter(X, Y, color='blue', marker='o', alpha=0.7)
#plt.show()

#On pourra s’aider du code suivant (que vous devez comprendre ET connaitre)
# Etape 1 : Calcul des moyennes
mean_X = sum(X) / len(X)
mean_Y = sum(Y) / len(Y)
# Etape 2 : Calcul de la difference X - moyenne
X_diff = [x - mean_X for x in X]
Y_diff = [y - mean_Y for y in Y]
# Etape 3 : Calcul du numerateur (somme des produits des ecarts quadratiques)
num = sum(xd * yd for xd, yd in zip(X_diff, Y_diff))
# Etape 4 : Calcul du denominateur (les variances de X et Y)
denom_X = sum(xd ** 2 for xd in X_diff)
denom_Y = sum(yd ** 2 for yd in Y_diff)
# Etape 5 : Calcul du coefficient de correlation
correlation = num / (np.sqrt(denom_X) * np.sqrt(denom_Y))
#print("Coefficient de correlation de Pearson :", correlation)


def regression_lineaire(X, Y):
    #===========================================
    mean_X = sum(X) / len(X)
    mean_Y = sum(Y) / len(Y)
    #===========================================
    X_diff = [x - mean_X for x in X]
    Y_diff = [y - mean_Y for y in Y]
    #===========================================
    num = sum(xd * yd for xd, yd in zip(X_diff, Y_diff))
    #===========================================
    denom_X = sum(xd ** 2 for xd in X_diff)
    denom_Y = sum(yd ** 2 for yd in Y_diff)
    #===========================================

    cov = sum(xd * yd for xd, yd in zip(X_diff, Y_diff))
    var = sum(xd ** 2 for xd in X_diff)
    a = cov/var
    b = mean_Y - a * mean_X
    plt.scatter(X, Y, color='blue', marker='o', alpha=0.7)
    plt.plot(X, a*X+b, color='grey', alpha=0.7)
    plt.show()

#regression_lineaire(X, Y)

#===========================================================================================================================

Annees = np.array([1950, 1960, 1965, 1973, 1985, 1990, 2000, 2005, 2006, 2008, 2010, 2012])
W = np.array([63, 90, 115, 180, 202, 229, 269, 277, 276, 273, 263, 259])
G = np.array([30, 50, 66, 100, 132, 154, 188, 203, 208, 213, 210, 214])
P = np.array([41, 46, 49, 52, 55, 57, 59, 61, 61.4, 62.1, 62.8, 63.4])

i=0
listW = []
listG = []
while (Annees[i] <= 2000):#!= 2005
    listW.append(W[i])
    listG.append(G[i])
    i+=1

#W = np.array(listW)
#G = np.array(listG)

def regression_lineaire_2(W, G):
    #===========================================
    mean_W = sum(W) / len(W)
    mean_G = sum(G) / len(G)
    #===========================================
    W_diff = [w - mean_W for w in W]
    G_diff = [g - mean_G for g in G]
    #===========================================
    num = sum(wd * gd for wd, gd in zip(W_diff, G_diff))
    #===========================================
    denom_W = sum(wd ** 2 for wd in W_diff)
    denom_G = sum(gd ** 2 for gd in G_diff)
    #===========================================

    cov = sum(wd * gd for wd, gd in zip(W_diff, G_diff))
    var = sum(wd ** 2 for wd in W_diff)
    a = cov/var
    b = mean_G - a * mean_W
    plt.scatter(W, G, color='blue', marker='o', alpha=0.7)
    plt.plot(W, a*W+b, color='grey', alpha=0.7)
    plt.show()


i=len(Annees)-1
listW = []
listG = []
while (Annees[i] > 2000):#!= 2005
    listW.append(W[i])
    listG.append(G[i])
    i-=1

#W = np.array(listW)
#G = np.array(listG)

#regression_lineaire_2(W, G)

#plt.scatter(Annees, G/W, color='blue', marker='o', alpha=0.7)
#plt.show()

#plt.scatter(G, P, color='blue', marker='o', alpha=0.7)
#plt.show()

#===========================================================================================================================

Region = np.array([1,2,3,4,5,6,7,8,9,10,11,12])
X = np.array([7.7,5.8,11.5,2.1,3.7,3.6,7.5,4.2,3.8,10.3,8.6,7.2])
Y = np.array([12,9,15,4,4,2,10,3,5,11,10,11])

def regression_lineaire_2(X, Y):
    #===========================================
    mean_X = sum(X) / len(X)
    mean_Y = sum(Y) / len(Y)
    #===========================================
    X_diff = [x - mean_X for x in X]
    Y_diff = [y - mean_Y for y in Y]
    #===========================================
    num = sum(xd * yd for xd, yd in zip(X_diff, Y_diff))
    #===========================================
    denom_X = sum(xd ** 2 for xd in X_diff)
    denom_Y = sum(yd ** 2 for yd in Y_diff)
    #===========================================
    correlation = num / (np.sqrt(denom_X) * np.sqrt(denom_Y))
    print("Coefficient de correlation de Pearson :", correlation)
    #===========================================

    cov = sum(xd * yd for xd, yd in zip(X_diff, Y_diff))
    var = sum(xd ** 2 for xd in X_diff)
    a = cov/var
    b = mean_Y - a * mean_X
    c = a*7.5+b
    print(c)
    plt.scatter(X, Y, color='blue', marker='o', alpha=0.7)
    plt.plot(X, a*X+b, color='grey', alpha=0.7)
    plt.show()

#plt.scatter(X, Y, color='blue', marker='o', alpha=0.7)
#plt.show()

regression_lineaire_2(X, Y)

