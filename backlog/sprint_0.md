| ID          | 0_0                                                                         |
|-------------|-----------------------------------------------------------------------------|
| Titre       | Developper le squellette du programme                                       |
| Priorite    | 100                                                                         |
| Estimation  | 3                                                                           |
| En tant que | PO                                                                          |
| Je veux que | Les dev implementent les bases de l'appli                                   |
| Afin de     | Ils puissent par la suite etablir l'interface graphique en se basant dessus |

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


