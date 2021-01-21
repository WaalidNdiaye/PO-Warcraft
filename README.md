# PO-Warcraft

  - A L'ATTENTION DU PROFESSEUR
Avant tout bonjour et merci à vous de prendre le temps de noter et tester notre projet de fin de semestre que nous avons nommé Succubus & Goblins !
Sachez que nous avons pris énormément de plaisirs à le développer et que nous seront ravis de recevoir quelconques critiques afin de s'améliorer par la suite,
même après avoir reçus les notes final afin d'avoir de plus amples explications sur votre recentie.
Nous sommes notamment plutot fier des nombreux monstres et gardiens implémentés dans le jeu ainsi que du résultat final, ayant fait en sorte que le tout soit le plus
armonique et face le plus possible "vrai" jeu.
  
  - PRESENTATIONS
Succubus & Goblins est un jeu de type Tower Defense réalisé pour notre projet de fin de semestre pour l'UE de PO de notre année de L2.
Le jeu en lui même ce déroule par vague, au démarrage de celui-ci le joueur choisi sur l'écran d'accueil le nombre de vague qu'il veut jouer (en cliquant sur le chiffre voulu)
et son but sera de tuer tout les monstres qui spawneront afin de protéger son chateau des assaillants. Pour cela il pourra placer des gardiens sur le plateau de jeu afin
de se défendre.
Vous un sous-menu clicable nommé "i" qui vous permet d'avoir de plus amples informartion sur les commandes, le lore...

  - PRISE EN MAINS
Afin de lancer le jeu et de le tester il vous suffit d'importer le .zip dans l'IDE Eclipse et de run le fichier "Main.java".
Voilà, vous pouvez maintenant vous amuser sur un super jeu développé avec passion !
NOTE: LE MANUEL D'UTILISATION DU JEU SE TROUVE DANS LE MENU

  - INFORMATION GENERALE :
    - MONSTRE & BOSS :
      - LAND MONSTER :      PV : 125  /  VITESSE : 0.002    /  DROP : 3 COINS  /  Vole : NON
      - FLYING MONSTER :    PV : 110  /  VITESSE : 0.0035   /  DROP : 5 COINS  /  Vole : OUI
      - WolF MONSTER :      PV : 160  /  VITESSE : 0.004    /  DROP : 10 COINS /  Vole : NON
      - BOSS WOLF :         PV : 500  /  VITESSE : 0.0018   /  DROP : 50 COINS /  Vole : NON
          PARTICULARITE : Lorsque sont habilité est rechargé il fait apparaitre autour de lui une horde de loups de plus en plus grande, et il se soigne de 55 PV.
      - BOSS FINAL :        PV : 700  /  VITESSE : 0.0015   /  DROP : 0 COINS  /  Vole : OUI
          PARTICULARITE : Lorsque sont habilité est rechargé elle fait apparaitre une horde de monstre de plus en plus grande autour d'elle, elle rajoute 80 pv a tout les monstres a sa portée (0.1), et se soigne de 80 PV.

    - DEFENCEUR :
      - ARCHERY TOWER : Cout : 30 Coins / Projectile : Arrow / Temp de rechargement : 30 / Portée : 0.2 / Cible : Terrestre & aerienne 
          Niveau 2 : Cout de l'amelioration : 60 / Portée : 0.25 /  Temp de rechargement : 25
      - BOMB TOWER : Cout : 55 Coins / Projectile : Bomb / Temp de rechargement : 50 / Portée : 1.5 / Cible : Terrestre (mais l'explotion peut toucher les monstres volants)
          Niveau 2 : Cout de l'amelioration : 110 / Portée : 0.18 /  Temp de rechargement : 44
      - GUARDIAN : Cout : 100 / Projectile : Attaque spéciale / Temp de rechargement : 90 / Portée : de 0.1 a 0.3 / Cible : Terrestre & aerienne 
          PARTICULARITE : Son attaque se decoupe en trois attaques de zones : les deux premières inflige 35 de dégats aux monstres terrestres et la dernière inflige 55 de dégats au monstres terrestres et aeriennes (cf animation de l'attaque).
    
    - PROJECTILE : 
      - ARROW : Dégats : 40 / Vitesse : 0.007 / Dégats de zone : NON
      - BOMB : Dégats : 65 / Vitesse : 0.004 / Dégats de zone : OUI

  - AUTEURS
NDYIA Tangi: Développeur (Hitbox, Monstre et Projectiles/Gardiens), L1 2ans - 2ème année;
PACARY Hassan: Développeur (Menu, implémentation des éléments du jeu sur le plateau de jeu et chemins), L1 2ans - 2ème année.

  - CONTRIBUTEUR
Thibaut Grelet: Artiste (Logo et background du plateau de jeu), Connaissance de PACARY Hassan.
(vous trouverez tout dans le drive indiqué plus bas)
  
  - STANDARDISATIONS
Une majorité du programme utilise des fonctions et methode static
cela signifie/permet 2 choses :
    - Il ne peut y avoir qu un seul plateau de jeu de lancer en meme temps (ce qui est ici pas derangeant
      car un joueur ne lance qu une seule partie a la fois sur son ordinateur et non plusieurs.
    - Cela permet de contrer le fait que certaines fonctions nous demande elles d etre en static obligatoirement
      afin d initialiser certaines valeurs par exemple.
Le plateau de jeu est divisé en de nombreux rectangles cela nous permet de juste faire appel au numéro du rectangle (son index dans la liste des rectangles) afin d'avoir la
position de celui-ci.

  - OPTIMISATION :
   - Utilisation de float : Les variable les plus utilisé dans le programme sont des floats, leur taille etant plus petite que des doubles, nous avons choisit d'utilisé des
     float en pessant que les calculs seraient plus efficace car moin précis.
   - Certain objet ne sont pas mit a jour a chaque boucle du jeu par exemple : le calcul de la cible la plus pour une tour ne se fait que toute les 3 boucles de jeu, le 
     calcul de la rotation de l'image d'une fleche (par rapport a sa cible) ne se fait que tout les 10 boucles de jeu...


  - DROIT D'AUTEURS
GARDIENS ET MONSTRES DE TANGI
  
  - CREDITS
NOITA (jeu-vidéo), inspiration pour le titre de Succubus & Goblins

GITHUB: https://github.com/WaalidNdiaye/PO-Warcraft
DRIVE: https://drive.google.com/drive/folders/1KUGh0dKl-Co6EqXfvqdEgERCLbbuVD3I?usp=sharing
