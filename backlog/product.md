| ID            | 0_0                                                                           |
| ------------- | ----------------------------------------------------------------------------- |
| Titre         | Developper le squellette du programme                                         |
| Priorite      | 100                                                                           |
| Estimation    | 3                                                                             |
| En tant que   | PO                                                                            |
| Je veux que   | Les dev implementent les bases de l'appli                                     |
| Afin de       | Ils puissent par la suite etablir l'interface graphique en se basant dessus   |

### DoD :

1 - Implementer la classe abstraite Oeuvre possedant les attributs suivants :

- Nom
- Auteur
- Libelle auteur
- Origine d'acquisition
- Support
- Note
- Commentaire
- Achevement
- Langue


2 - Puis des classes filles livres et film sans attributs supplementaires, et la classe jeu avec console comme atribut supllementaire et cd audio avec liste de piste comme attribut supplementaire.

3 - Implementer une interface CRUDOeuvre qui sera implementer par les 4 classes filles et qui possedera les methodes suivantes :

- referencer
- modifier
- supprimer


----------


| ID           | 0                                                    |
| ------------ | ---------------------------------------------------- |
| Title        | Acceder a une fenetre d'accueil                      |
| Priority     | 100                                                  |
| Estimation   | 8                                                    |
| As a         | un user                                              |
| I want       | pouvoir acceder a une fenetre d'accueil              |
| So that      | d'acceder aux fonctionalites disponibles             |

### DoD :

 1 - disposer d'une fenetre qui servira de point de depart a l'appli
 Voir le png JAMM_Accueil.png, le menu "Ajouter".
 Inutiles qu'elle soit completement conforme a la maquette, une simple ebauche suffira suffia


----------


| ID           | 0.5                                                  |
| ------------ | ---------------------------------------------------- |
| Title        | Acceder a un menu de creation d'oeuvre               |
| Priority     | 100                                                  |
| Estimation   | 8                                                    |
| As a         | un user                                              |
| I want       | pouvoir acceder a un menu de creation d'oeuvre       |
| So that      | d'enregistrer un oeuvre dans l'appli                 |

### DoD :

 1 - disposer d'une entree dans le menu differente pour chaque type d'oeuvre :
 
 a) livre
 b) cd audio
 c) film
 d) jeu video
 
 2 - rebaculer vers la fenetres correspondantes (voir les stories 1, 2, 3, 4).
 Voir le png JAMM_Accueil.png, le menu "Ajouter"


----------


| ID           | 1                                          |
| ------------ | -----------------------------------        |
| Title        | Acceder a une fenetre de creation de livre |
| Priority     | 99                                         |
| Estimation   | 20                                         |
| As a         | un user                                    |
| I want       | enregistrer un livre dans l'appli          |
| So that      | je puisse la consulter                     |

### DoD

1 - disposer de champs de saisie pour les donnees obligatoires relatives au livre :

a) titre
b) auteur
c) origine d'acquisition
d) support 

et optionnellement : 

a) note
b) commentaire
c) achevement
d) langue

2 - disposer d'un bouton pour soummettre la requete et d'un autre pour tout effacer


----------


| ID           | 2                                             |
| ------------ | --------------------------------              |
| Title        | Acceder a une fenetre de creation de cd audio |
| Priority     | 99                                            |
| Estimation   | 13                                            |
| As a         | un user                                       |
| I want       | enregistrer un cd dans l'appli                |
| So that      | je puisse la consulter                        |

### DoD

1 - disposer de champs de saisie pour les donnees obligatoires relatives au cd :

a) titre de l'album (ou single)
b) artiste
c) origine d'acquisition
d) support
e) liste des pistes

et optionnellement :

a) note
b) commentaire
c) achevement
d) langue

2 - disposer d'un bouton pour soummettre la requete, et d'un autre pour tout effacer


----------


| ID           | 3                                         |
| ------------ | ----------------------------------        |
| Title        | Acceder a une fenetre de creation de film |
| Priority     | 99                                        |
| Estimation   | 13                                        |
| As a         | un user                                   |
| I want       | enregistrer un film dans l'appli          |
| So that      | je puisse la consulter                    |

### DoD

1 - disposer de champs de saisie pour les donnees obligatoires relatives au film :

a) titre
b) realisateur
c) origine d'acquisition
d) version (VF, VOSTFR)
e) support

et optionnellement :

a) note
b) commentaire
c) achevement

2 - disposer d'un bouton pour soummettre la requete, et d'un autre pour tout effacer

----------


| ID         | 4                                     |
|------------|---------------------------------------|
| Title      | Acceder a une fenetre de creation de jeu video                  |
| Priority   | 99                                    |
| Estimation | 13                                    |
| As a       | un user                               |
| I want     | enregistrer un jeu video dans l'appli |
| So that    | je puisse la consulter                |

### DoD

1 - disposer de champs de saisie pour les donnees obligatoires relatives au jeu :

a) titre
b) studio
c) origine d'acquisition
d) support
e) console

et optionnellement :

a) note
b) commentaire
c) achevement
d) langue

2 - disposer d'un bouton pour soummettre la requete, et d'un autre pour tout effacer


----------


| ID           | 15                                       |
| ------------ | ---------------------------------------- |
| Title        | Afficher les oeuvres dans un tableau     |
| Priority     | 90                                       |
| Estimation   | 8                                        |
| As a         | un user                                  |
| I want       | visualiser mes oeuvres enregistrer       |
| So that      | connaitre le contenu de ma mediatheque   |

### DoD

1 - visualiser dans un tableau l'ensemble des oeuvres dans un tableau, de la plus recente a la plus ancienne

2 - il n'est pas neccessaire de faire apparaitre toutes les donnes de l'oeuvre, on se contentera de : le titre, l'auteur et la categorie.
Pour obtenir les renseignement en detail voir la story "Afficher les details d'une oeuvre" (ID5)


----------


| ID           | 5                                         |
| ------------ | ----------------------------------------- |
| Title        | Afficher les details d'une oeuvre         |
| Priority     | 90                                        |
| Estimation   | 8                                         |
| As a         | un user                                   |
| I want       | visualiser les details d'une oeuvre       |
| So that      | je puisse les consulter et les modifier   |

### DoD

1 - visualiser dans une fenetre les details caracteristiques de chacun des oeuvres suivantes :

a) livre
b) cd audio
c) film
d) jeu video
(pour connaitre les details de chaque type d'oeuvre, voir les stories 1, 2, 3, 4)


----------


| ID           | 14                                             |
| ------------ | ---------------------------------------------- |
| Title        | Rechercher parmi les ouevres                   |
| Priority     | 80                                             |
| Estimation   | 20                                             |
| As a         | un user                                        |
| I want       | acceder a des ouvres en fonction de criteres   |
| So that      | je puisse consulter mes ouvres eficacement     |

### DoD

1 - pouvoir saisir des mots cles

2 - disposer d'un critere parmi lesquel chercher les mots cles

3 - faire apparitre les oeuvres correspndantes


----------


| ID           | 16                                                   |
| ------------ | ---------------------------------------------------- |
| Title        | Modifier une oeuvre                                  |
| Priority     | 50                                                   |
| Estimation   | 8                                                    |
| As a         | un user                                              |
| I want       | Modifier les details d'une oeuvre                    |
| So that      | je puisse les mettre a jour ou corriger une erreur   |

### DoD

0 - On suppose qu'afficher les detail d'une oeuvre est deja realisee (ID 6)

1 - visualiser dans une fenetre les details caracteristiques de chacun des oeuvres suivantes :

a) livre
b) cd audio
c) film
d) jeu video
(pour connaitre les details de chaque type d'oeuvre, voir les stories 1, 2, 3, 4)

2 - les modifier independament les unes des autres

3 - bouton modifier et annuler

4 - verifier l'application des modifications


----------


| ID           | 9                                  |
| ------------ | ---------------------------------- |
| Title        | Supprimer une oeuvre               |
| Priority     | 25                                 |
| Estimation   | 5                                  |
| As a         | un user                            |
| I want       | supprimer un oeuvre dans l'appli   |
| So that      | de ne plus le referencer           |

### DoD

1 - selectionner l'oeuvre a supprimer

2 - confirmer la volonte de suppression

3 - l'oeuvre ne doit plus apparaitre null part"



----------


| ID           | 0_1                                    |
| ------------ | -------------------------------------- |
| Title        | Developper l'interface                 |
| Priority     | 100                                    |
| Estimation   |                                        |
| As a         | un user                                |
| I want       | acceder au fonctionalites de l'appli   |
| So that      | de l'utiliser de maniere agreable      |

 ### DoD ?
