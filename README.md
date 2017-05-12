# JAMM
Java Multimedia Manager


----------


|ID|0_0|
|---|---|
|Title|Developper le squellette du programme|
|Priority|100|
|Estimation||
|As a|PO|
|I want|Les dev implementent les bases de l'appli|
|So that|Ils puissnet par la suite etablir l'interface graphique en se basant dessus|
|DoD|Implementer la classe abstraite Oeuvre possedant les attributs suivants :<br/><br/>a) ID<br/>b) Nom<br/>c) Auteur<br/>d) Libelle auteur<br/>e) Origine d'acquisition<br/>f) Support<br/>g) Note<br/>h) Note<br/>i) Commentaire<br/>j) Achevement<br/>k) langue<br/><br/>2 - Puis des classes filles livres et film sans attributs supplementaires, et la classe jeu avec console comme atribut supllementaire et cd audio avec liste de piste comme attribut supplementaire.<br/><br/>3 - Implementer une classe CRUDOeuvre qui sera agreger a Oeuvre et qui possedera les methodes suivantes :<br/><br/>a) referencer<br/>b) modifier<br/>c) supprimer||


----------


|ID|0|
|---|---|
|Title|Acceder a une fenetre de creation d'oeuvre|
|Priority|100|
|Estimation|8|
|As a|un user|
|I want|pouvoir acceder a une fenetre de creation d'oeuvre|
|So that|d'enregistrer un oeuvre dans l'appli|
|DoD|1 - disposer d'un bouton different pour chaque type d'oeuvre :<br/><br/>a) livre<br/>b) cd audio<br/>c) film<br/>d) jeu video<br/><br/>2 - rebaculer vers la fenetres correspondantes (voir les stories 1, 2, 3, 4)|


----------


|ID|1|
|---|---|
|Title|Ajouter un livre |
|Priority|99|
|Estimation|20|
|As a|un user|
|I want|enregistrer un livre dans l'appli|
|So that|je puisse la consulter|
|DoD|1 - disposer de champs de saisie pour les donnees obligatoires relatives au livre :<br/><br/>a) titre<br/>b) auteur<br/>c) origine d'acquisition<br/>d) support <br/><br/>et optionnellement : <br/><br/> a) note<br/>b) commentaire<br/>c) achevement<br/>d) langue<br/><br/>2 - disposer d'un bouton pour soummettre la requete et d'un autre pour tout effacer<br/><br/>3 - lorsqu'un ou plusieurs champs manquent, un message d'erreur "Un ou plusieurs champs obligatoires sont manquant, vueillez les remplir", le focus est donnee au premier champs vide, et tous les champs vides sont surlignes en rouge|


----------


|ID|3|
|---|---|
|Title|Ajouter un film|
|Priority|99|
|Estimation|13|
|As a|un user|
|I want|enregistrer un film dans l'appli|
|So that|je puisse la consulter|
|DoD|1 - disposer de champs de saisie pour les donnees 
obligatoires relatives au film :<br/><br/>a) titre<br/>b) realisateur<br/>c) origine d'acquisition<br/>d) version (VF, VOSTFR)<br/>e) support<br/><br/>et optionnellement :<br/><br/>a) note<br/>b) commentaire<br/>c) achevement<br/><br/>2 - disposer d'un bouton pour soummettre la requete, et d'un autre pour tout effacer<br/><br/>3 - lorsqu'un ou plusieurs champs manquent, un message d'erreur "Un ou plusieurs champs obligatoires sont manquant, vueillez les remplir", le focus est donnee au premier champs vide, et tous les champs vides sont surlignes en rouge"|


----------


|ID|4|
|---|---|
|Title|Ajouter un jeu video|
|Priority|99|
|Estimation|13|
|As a|un user|
|I want|enregistrer un jeu video dans l'appli|
|So that|je puisse la consulter|
|DoD|1 - disposer de champs de saisie pour les donnees obligatoires relatives au jeu :<br/><br/>a) titre<br/>b) studio<br/>c) origine d'acquisition<br/>d) support<br/>e) console<br/><br/>et optionnellement :<br/><br/>a) note<br/>b) commentaire<br/>c) achevement<br/>d) langue<br/><br/>2 - disposer d'un bouton pour soummettre la requete, et d'un autre pour tout effacer<br/><br/>3 - lorsqu'un ou plusieurs champs manquent, un message d'erreur "Un ou plusieurs champs obligatoires sont manquant, vueillez les remplir", le focus est donnee au premier champs vide, et tous les champs vides sont surlignes en rouge|


----------


|ID|2|
|---|---|
|Title|Ajouter un cd audio |
|Priority|99|
|Estimation|13|
|As a|un user|
|I want|enregistrer un cd dans l'appli|
|So that|je puisse la consulter|
|DoD|1 - disposer de champs de saisie pour les donnees obligatoires relatives au cd :<br/><br/>a) titre de l'album (ou single)<br/>b) artiste<br/>c) origine d'acquisition<br/>d) support<br/>e) liste des pistes<br/><br/>et optionnellement :<br/><br/>a) note<br/>b) commentaire<br/>c) achevement<br/>d) langue<br/><br/>2 - disposer d'un bouton pour soummettre la requete, et d'un autre pour tout effacer<br/><br/>3 - lorsqu'un ou plusieurs champs manquent, un message d'erreur "Un ou plusieurs champs obligatoires sont manquant, vueillez les remplir", le focus est donnee au premier champs vide, et tous les champs vides sont surlignes en rouge|


----------


|ID|15|
|---|---|
|Title|Afficher les oeuvres dans un tableau|
|Priority|90|
|Estimation|8|
|As a|un user|
|I want|visualiser mes oeuvres enregistrer|
|So that|connaitre le contenu de ma mediatheque|
|DoD|1 - visualiser dans un tableau l'ensemble des oeuvres dans un tableau, de la plus recente a la plus ancienne<br/><br/>2 - il n'est pas neccessaire de faire apparaitre toutes les donnes de l'oeuvre, on se contentera de : le titre, l'auteur et la categorie.<br/>Pour obtenir les renseignement en detail voir la story "Afficher les details d'une oeuvre" (ID5)|


----------


|ID|5|
|---|---|
|Title|Afficher les details d'une oeuvre|
|Priority|90|
|Estimation|8|
|As a|un user|
|I want|visualiser les details d'une oeuvre|
|So that|je puisse les consulter et les modifier|
|DoD|1 - visualiser dans une fenetre les details caracteristiques de chacun des oeuvres suivantes :<br/><br/>a) livre<br/>b) cd audio<br/>c) film<br/>d) jeu video<br/>(pour connaitre les details de chaque type d'oeuvre, voir les stories 1, 2, 3, 4)|


----------


|ID|14|
|---|---|
|Title|Rechercher parmi les ouevres|
|Priority|80|
|Estimation|20|
|As a|un user|
|I want|acceder a des ouvres en fonction de criteres|
|So that|je puisse consulter mes ouvres eficacement|
|DoD|1 - pouvoir saisir des mots cles<br/><br/>2 - disposer d'un critere parmi lesquel chercher les mots cles<br/><br/>3 - faire apparitre les oeuvres correspndantes |


----------


|ID|16|
|---|---|
|Title|Modifier une oeuvre|
|Priority|50|
|Estimation|8|
|As a|un user|
|I want|Modifier les details d'une oeuvre|
|So that|je puisse les mettre a jour ou corriger une erreur|
|DoD|0 - On suppose qu'afficher les detail d'une oeuvre est deja realisee (ID 6)<br/><br/>1 - visualiser dans une fenetre les details caracteristiques de chacun des oeuvres suivantes :<br/><br/>a) livre<br/>b) cd audio<br/>c) film<br/>d) jeu video<br/>(pour connaitre les details de chaque type d'oeuvre, voir les stories 1, 2, 3, 4)<br/><br/>2 - les modifier independament les unes des autres<br/><br/>3 - bouton modifier et annuler<br/><br/>4 - verifier l'application des modifications|


----------


|ID|9|
|---|---|
|Title|Supprimer une oeuvre|
|Priority|25|
|Estimation|5|
|As a|un user|
|I want|supprimer un oeuvre dans l'appli|
|So that|de ne plus le referencer|
|DoD|1 - selectionner l'oeuvre a supprimer<br/><br/>2 - confirmer la volonte de suppression<br/><br/>3 - l'oeuvre ne doit plus apparaitre null part" |



----------


|ID|0_1|
|---|---|
|Title|Developper l'interface|
|Priority|100|
|Estimation||
|As a|un user|
|I want|acceder au fonctionalites de l'appli|
|So that|de l'utiliser de maniere agreable|
|DoD|?|
