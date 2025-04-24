import itertools
myrelations = [{ 'A ' , 'B ' , 'C ' , 'G ' , 'H ' , 'I '} ,{ 'X ' , 'Y '}]
mydependencies = [[{'A'},{'B'}],
                  [{'A'},{'C'}],
                  [{'C','G'},{'H'}],
                  [{'C','G'},{'I'}],
                  [{'B'},{'H'}]]
#1
def printDependencies(F):
    for alpha,beta in F :
        print("\t",alpha,"---->",beta)

#2
def printRelations(T):
    for R in T :
        print("\t",R)

#3
def powerSet(inputset):
    _result = []
    for r in range(1,len(inputset)+1):
        _result += map(set,itertools.combinations(inputset,r))
    return  _result
#4
def fermetureAttributs(F,K):
    K_plus = set(K)
    size = 0
    while size != len(K_plus):
        size = len(K_plus)
        for alpha,beta in F :
            if alpha.issubset(K_plus):
                K_plus.update(beta)

    return K_plus
#5
def clotureDependances(F):
    R = set()
    # On reupère les attributs
    for alpha,beta in F :
        R.update(alpha | beta)
    F_plus = []
    #On applique la reflexivité et l'augementation en générant les sous-ensembles possibles
    for K in powerSet(R):
        for beta in powerSet(fermetureAttributs(F,K)):
            #On applique la transitivité
            F_plus.append([K,beta])
    return  F_plus

#6
def isDependency(F,alpha,beta):
    return beta.issubset(fermetureAttributs(F,alpha))
#7
def isSuperKey(F,R,K):
    return R.issubset(fermetureAttributs(F,K))
#8
def isCadidateKey(F,R,K):
    if not isSuperKey(F,R,K) :
        return False
    for K_prime in K:
        K_prime2 = set(K).discard(K_prime)
        if isSuperKey(F,R,K_prime2) :
            return False

    return True
#9
def listCandidateKeys(F,R):
    candKeys = []
    for K in powerSet(R) :
        if isCadidateKey(F,R,K) :
            candKeys.append(K)

    return candKeys

#10
def listSuperKeys(F,R):
    superKeys = []
    for K in powerSet(R) :
        if isSuperKey(F,R,K) :
            superKeys.append(K)

    return superKeys
#11
def oneCandidateKey(F,R):
    K = set(R)
    while not isCadidateKey(F,R,K):
        # On tente de reduire un maximum la clé
        for A in K :
            #Si reductible alors recommencer le traitement avec le nouvel ensemble
            if isCadidateKey(F,R,K - {A}) :
                K.discard(A)
                break
#12
# def isBCNFRelation(F,R):
#     for alpha,beta in F :
#         if not isSuperKey(F,R,alpha) or not beta.issubset(fermetureAttributs(F,alpha)) :
#             return False
#
#     return True
def isBCNFRelation(F, R):
    for K in powerSet(R):
        K_plus = fermetureAttributs(F, K)
        Y = K_plus.difference(K)
        if not R.issubset(K_plus) and not Y.isdisjoint(R):
            return False, [K, Y & R]

    return True, [{}, {}]
#13
# def isBCNFRelations (F,T ) :
#     for R in T :
#         if not isBCNFRelation(F, R):
#             return False
#     return True , {}
def isBCNFRelations (F,T) :
    for R in T :
        if isBCNFRelation (F, R) == False :
            return False
#14
def computeBCNFDecomposition (F,T) :
    OUT,size = list (T),0
    while size != len (OUT) :
        size = len (OUT)
        for R in OUT :
            _isR_BCNF,[alpha,beta] = isBCNFRelation (F,R)
            if _isR_BCNF == False :
                if alpha | beta not in OUT :
                    OUT.append (alpha | beta)
                if R.difference (beta) not in OUT :
                    OUT.append (R.difference (beta))
                OUT.remove (R)
                break

    return OUT


# # Exercice 3.1
relation = {'A','B','C','D','E'}
dependencies =  [ [{'A'},{'B','C'}],
                  [{'C','D'},{'E'}],
                  [{'B'},{'D'}],
                  [{'E'},{'A'}]]
# print(printDependencies(clotureDependances(dependencies)[:16]))

# Exercice 3.2
relation = [{'A','B','C','D','E','F'}]
dependencies =  [ [{'A'},{'B','C','D'}],
                  [{'B','C'},{'D','E'}],
                  [{'B'},{'D'}],
                  [{'D'},{'A'}]]
# #a
# print(fermetureAttributs(dependencies,{'A','B'}))
# #b
# print(fermetureAttributs(dependencies,{'A','F'}))
# print(isSuperKey(dependencies,relation,{'A','F'}))

#c
# print(isBCNFRelation(dependencies,relation))

# print(computeBCNFDecomposition(dependencies,relation))

print(printDependencies(clotureDependances(dependencies)))