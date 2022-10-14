# Starter app Spring Boot Kotlin

Un support de formation

## Prérequis

* git opérationnel sur la machine
* IntelliJ opérationnel avec un jdk 17

Deux façons différentes de télécharger le projet.

## (option 1) Cloner le projet 

Copier le lien : https://github.com/ldv-melun/sbfirst.git

Ouvrir une console (passage en ligne de commande) 

```
cd [dossier de travail]

git clone https://github.com/ldv-melun/sbfirst.git

```

Le dossier du projet est alors créé dans le dossier de travail.

## (option 2) ou Téléchargement le zip

Choisir `Downlad ZIP`

![image](docs/sbfirst-download.png)

Puis le décompresser dans le dossier de travail.

## Ouvrir le projet 

Ouvrir le dossier du projet avec Intellij IDE

### Attention : Ouvrir le dossier du projet, et non son dossier parent.   

![image](docs/sbfirst-ide.png)

... et **attendre que les dépendances soient toutes téléchargées et indexées !** (consulter la barre d'état au bas de la fenêtre).

## En cas de problème

L'application `sbfirst` utilise [Apache Maven](https://maven.apache.org/) pour la gestion de ses dépendances.

Si vous utilisez des postes informatiques d'une organisation dont les connexions réseaux sont filtrées par un **proxy**, il vous faudra renseigner les données du proxy auprès de Maven.

Pour cela vous devez comprendre comment fonctionne Maven : Par défaut, les librairies dont dépend une application sont stockées dans un dossier nommé `.m2`, à la racine du compte utilisateur (le `home directory`). 

La solution consiste alors à créer un fichier nommé `settings.xml` à la racine de `.m2`, dont le contenu est basé sur ce schéma 

`~/.m2/settings.xml` (source : https://maven.apache.org/guides/mini/guide-proxies.html)
```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
 
  <proxies>
    <proxy>
      <id>myproxy</id>
      <active>true</active>
      <protocol>http</protocol>
      <host>proxy.somewhere.com</host>
      <port>8080</port>
    </proxy>
  </proxies>
 
</settings>
```

Remarque : le protocole `http` est celui utilisé pour atteindre le proxy. À modifier le cas échéant.

## Build 

Une opération qui consiste, dans les grandes lignes,  à 

* précompiler             : kotlin -> java
* (si réussi) compiler    : java -> binaire


![image](docs/sbfirst-build.png)

