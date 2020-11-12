# Book_Store

les étapes de réalisation : 

__1- analyse et spécifique des besoins__

les utilisateurs de cette applications sont :


   1.1- Un administrateur ayant les fonctionalites suivante :

 * Gérer les livres : Ajouter un livre, Modifier un livre, Supprimer un livre, Supprimer tous les livres , afficher tous les livres de la librairie.
 
 * Gérer les utilisateurs : Ajouter un utilisateur, afficher la liste des utilisateurs, modifiers un utilisateur (ses informations).
 
 
  1.2- Un utilisateur ayant les fonctionnalités suivante :

 * Ajouter une ligne de commande (une ligne de commande pour chaque achat d'un livre avec une quantité d'achat précise).
 
 * Ajouter une commande (une commande est définie par des lignes de commandes ayont un montant total).
 
 
__2-Conception__

 - Réaliser un diagramme de cas d'utilisation.
 - Réaliser un diagramme de classes.
 
 
__3-realisation__

Commancons par cree les différentes classes

 * realiser l'etape 1 demander :
 
une ligne de commande ayont un montant de chaque livre par quantité .

une commande ayont un montant total de tous les lignes de commande par utilisateur.

* realiser l'etape 2 demander :

-Création de la base de donner nommer "bookstore_db".

-Définir le modèle relationnel de l'application :


    administrator(__id_admin__ , name_admin,firstname_admin,password_admin,address_admin,phonenumber_admin);
   
    book(__ref_Book__,titel_book,author_book,price_book,stock_quantity,relaseDate,admin_book#);
   
    command_ligne(__Id_commandligne__,purchase_quantity,__reforder_CL__#,__book_cl__#);
    
    order(__ref_Order__ ,prix_ttc, date_order,user_c#);
    
    user(__Id_user__ ,password_user,user_name,firstname_user,adress_user,numberphone_user,add_byadmin#);
    
-Réalisation d'une classe responsable à la connexion avec notre base .

-Ajouter les méthodes nécessaires liées aux bases de données construites comme l'ajout des utilisateurs, l'ajout des livres ...

