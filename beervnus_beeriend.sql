-- phpMyAdmin SQL Dump
-- version 4.0.10.18
-- https://www.phpmyadmin.net
--
-- Client: localhost:3306
-- Généré le: Lun 20 Février 2017 à 20:05
-- Version du serveur: 10.1.21-MariaDB
-- Version de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `beervnus_beeriend`
--

-- --------------------------------------------------------

--
-- Structure de la table `Aime`
--

CREATE TABLE IF NOT EXISTS `Aime` (
  `Utilisateurs_idUtilisateurs` int(11) NOT NULL,
  `Biere_idBiere` int(11) NOT NULL,
  PRIMARY KEY (`Utilisateurs_idUtilisateurs`,`Biere_idBiere`),
  KEY `fk_Utilisateurs_has_Biere_Biere1_idx` (`Biere_idBiere`),
  KEY `fk_Utilisateurs_has_Biere_Utilisateurs1_idx` (`Utilisateurs_idUtilisateurs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Bar`
--

CREATE TABLE IF NOT EXISTS `Bar` (
  `idBar` int(11) NOT NULL AUTO_INCREMENT,
  `nom_bar` varchar(35) NOT NULL,
  `style` varchar(20) DEFAULT NULL,
  `adresse` varchar(100) NOT NULL,
  `horaire_lundi_ouverture` time DEFAULT NULL,
  `horaire_lundi_fermeture` time DEFAULT NULL,
  `horaire_mardi_ouverture` time DEFAULT NULL,
  `horaire_mardi_fermeture` time DEFAULT NULL,
  `horaire_mercredi_ouverture` time DEFAULT NULL,
  `horaire_mercredi_fermeture` time DEFAULT NULL,
  `horaire_jeudi_ouverture` time DEFAULT NULL,
  `horaire_jeudi_fermeture` time DEFAULT NULL,
  `horaire_vendredi_ouverture` time DEFAULT NULL,
  `horaire_vendredi_fermeture` time DEFAULT NULL,
  `horaire_samedi_ouverture` time DEFAULT NULL,
  `horaire_samedi_fermeture` time DEFAULT NULL,
  `horaire_dimanche_ouverture` time DEFAULT NULL,
  `horaire_dimanche_fermeture` time DEFAULT NULL,
  `happy_hours_debut` time DEFAULT NULL,
  `happy_hours_fin` time DEFAULT NULL,
  `horaire_mardi_debuthh` time DEFAULT NULL,
  `horaire_mardi_finhh` time DEFAULT NULL,
  `horaire_mercredi_debuthh` time DEFAULT NULL,
  `horaire_mercredi_finhh` time DEFAULT NULL,
  `horaire_jeudi_debuthh` time DEFAULT NULL,
  `horaire_jeudi_finhh` time DEFAULT NULL,
  `horaire_vendredi_debuthh` time DEFAULT NULL,
  `horaire_vendredi_finhh` time DEFAULT NULL,
  `horaire_samedi_debuthh` time DEFAULT NULL,
  `horaire_samedi_finhh` time DEFAULT NULL,
  `horaire_dimanche_debuthh` time DEFAULT NULL,
  `horaire_dimanche_finhh` time DEFAULT NULL,
  `ambiance2` varchar(20) DEFAULT NULL,
  `ambiance3` varchar(20) DEFAULT NULL,
  `sportif` varchar(3) DEFAULT NULL,
  `terrasse` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`idBar`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- Contenu de la table `Bar`
--

INSERT INTO `Bar` (`idBar`, `nom_bar`, `style`, `adresse`, `horaire_lundi_ouverture`, `horaire_lundi_fermeture`, `horaire_mardi_ouverture`, `horaire_mardi_fermeture`, `horaire_mercredi_ouverture`, `horaire_mercredi_fermeture`, `horaire_jeudi_ouverture`, `horaire_jeudi_fermeture`, `horaire_vendredi_ouverture`, `horaire_vendredi_fermeture`, `horaire_samedi_ouverture`, `horaire_samedi_fermeture`, `horaire_dimanche_ouverture`, `horaire_dimanche_fermeture`, `happy_hours_debut`, `happy_hours_fin`, `horaire_mardi_debuthh`, `horaire_mardi_finhh`, `horaire_mercredi_debuthh`, `horaire_mercredi_finhh`, `horaire_jeudi_debuthh`, `horaire_jeudi_finhh`, `horaire_vendredi_debuthh`, `horaire_vendredi_finhh`, `horaire_samedi_debuthh`, `horaire_samedi_finhh`, `horaire_dimanche_debuthh`, `horaire_dimanche_finhh`, `ambiance2`, `ambiance3`, `sportif`, `terrasse`) VALUES
(1, 'Le buen', NULL, '6 rue des petits carreaux', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, 'Les tontons bringueurs ', 'Bar', '1 Rue Boyer, Paris, France', '12:00:00', '02:00:00', '12:00:00', '02:00:00', '12:00:00', '02:00:00', '12:00:00', '02:00:00', '12:00:00', '02:00:00', '17:00:00', '02:00:00', '11:00:00', '11:00:00', '17:00:00', '22:00:00', '17:00:00', '22:00:00', '17:00:00', '22:00:00', '17:00:00', '22:00:00', '17:00:00', '22:00:00', '17:00:00', '22:00:00', '17:00:00', '22:00:00', 'Projection de film', '', 'Non', 'Non'),
(9, 'le', 'km', '5 Avenue Montaigne, Paris, France', '14:30:00', '18:30:00', '14:30:00', '18:30:00', '14:30:00', '18:30:00', '14:30:00', '18:30:00', '14:30:00', '18:30:00', '14:30:00', '18:30:00', '14:30:00', '18:30:00', '14:30:00', '17:30:00', '14:30:00', '17:30:00', '14:30:00', '17:30:00', '14:30:00', '17:30:00', '14:30:00', '17:30:00', '14:30:00', '17:30:00', '14:30:00', '17:30:00', 'Je', 'Si', 'Oui', 'Oui'),
(10, 'buenass', 'buen', 'Rue de Rivoli, Paris, France', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '', '', 'Oui', 'Oui'),
(11, 'buenn', 'djdj', 'Rue Saint-Honoré, Paris, France', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '', '', 'Oui', 'Oui'),
(12, 'Only', 'jj', 'Rueil-Malmaison, France', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '18:15:00', '', '', 'Oui', 'Oui'),
(13, 'lol', '\n', 'Rue du Faubourg Saint-Honoré, Paris, France', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '18:30:00', '', 'lol', 'Oui', 'Oui'),
(14, 'Is', 'ju', 'Jœuf, France', '18:30:00', '19:30:00', '18:30:00', '19:30:00', '18:30:00', '19:30:00', '18:30:00', '19:30:00', '18:30:00', '19:30:00', '18:30:00', '19:30:00', '18:30:00', '19:30:00', '18:30:00', '18:45:00', '18:30:00', '18:45:00', '18:30:00', '18:45:00', '18:30:00', '18:45:00', '18:30:00', '18:45:00', '18:30:00', '18:45:00', '18:30:00', '18:45:00', '', '', 'Oui', 'Oui'),
(15, 'pabuen', 'rock', 'Châtelet - Les Halles, Paris, France', '19:15:00', '19:30:00', '19:15:00', '19:30:00', '19:15:00', '19:30:00', '19:15:00', '19:30:00', '19:15:00', '19:30:00', '19:15:00', '19:30:00', '19:15:00', '19:30:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '11:00:00', '', '', 'Oui', 'Oui');

-- --------------------------------------------------------

--
-- Structure de la table `Biere`
--

CREATE TABLE IF NOT EXISTS `Biere` (
  `idBiere` int(11) NOT NULL AUTO_INCREMENT,
  `nom_biere` varchar(40) CHARACTER SET latin1 COLLATE latin1_general_ci NOT NULL,
  `nationalite` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `type` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `type2` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `couleur` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `brasserie` varchar(40) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `methodebrassage` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  `degre_alcool` varchar(11) DEFAULT NULL,
  `commentaires` longtext CHARACTER SET latin1 COLLATE latin1_general_ci,
  `common_name` varchar(40) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`idBiere`),
  FULLTEXT KEY `nom` (`nom_biere`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=436 ;

--
-- Contenu de la table `Biere`
--

INSERT INTO `Biere` (`idBiere`, `nom_biere`, `nationalite`, `type`, `type2`, `couleur`, `brasserie`, `methodebrassage`, `degre_alcool`, `commentaires`, `common_name`) VALUES
(1, '1664 blonde', 'Française', 'Lager', '', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', 'Fermentation basse', '5.5%', '', '1664'),
(2, '1664 blanc', 'Française', '', '', 'Blanche', 'Brasserie Kronenbourg (Carlsberg)', '', '5.0%', '', '1664'),
(3, '1664 sans alcool', 'Française', '', '', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', '', '0.5%', '', '1664'),
(4, '1664 Gold', 'Française', '', 'Double', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', '', '6.1%', '', '1664'),
(5, '1664 Fruits Rouges', 'Française', '', 'Blanche', 'Fruitée', 'Brasserie Kronenbourg (Carlsberg)', '', '4.5%', '', '1664'),
(6, '1664 Rosé', 'Française', '', 'Blonde', 'Fruitée', 'Brasserie Kronenbourg (Carlsberg)', '', '4.5%', '', '1664'),
(7, '1664 Millésime', 'Française', '', '', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', '', '', '', '1664'),
(8, '3 Brasseurs Blanche', 'Française', '', '', 'Blanche', 'Brasserie 3 Brasseurs', '', '4.7%', '', '3 Brasseurs '),
(9, '3 Brasseurs Blonde', 'Française', '', '', 'Blonde', 'Brasserie 3 Brasseurs', '', '5.2%', '', '3 Brasseurs '),
(10, '3 Brasserus Ambrée', 'Française', '', '', 'Ambrée', 'Brasserie 3 Brasseurs', '', '6.2%', '', '3 Brasseurs '),
(11, '3 Brasseurs Brune', 'Française', '', '', 'Brune', 'Brasserie 3 Brasseurs', '', '4.8%', '', '3 Brasseurs '),
(12, '3 Brasserus Triple', 'Française', '', 'Triple', 'Blonde', 'Brasserie 3 Brasseurs', '', '7.9%', '', '3 Brasseurs '),
(13, '3 Brasseurs La Belle Province', 'Française', '', '', 'Ambrée', 'Brasserie 3 Brasseurs', 'Fermentation haute', '7.0%', '', '3 Brasseurs '),
(14, '3 Monts', 'Française', 'Bière de garde', '', 'Blonde', 'Brasserie de Saint Sylvestre', 'Fermentation haute', '8.5%', '', '3 Monts'),
(15, '33 Export', 'Indochinoise', 'Lager', '', 'Blonde', 'Brasserie du Pelican (Heineken)', '', '4.5%', '', '33 Export'),
(16, '8.6 Original', 'Hollandaise', '', '', 'Blonde', 'Bavaria', '', '8.6%', '', '8.6'),
(17, '8.6 Gold', 'Hollandaise', '', '', 'Blonde', 'Bavaria', '', '6.5%', '', '8.6'),
(18, '8.6 Red', 'Hollandaise', '', '', 'Ambrée', 'Bavaria', '', '7.9%', '', '8.6'),
(19, '8.6 Absinthe', 'Hollandaise', '', '', 'Blonde', 'Bavaria', '', '8.3%', '', '8.6'),
(20, '8.6 Extreme', 'Hollandaise', '', '', 'Blonde', 'Bavaria', '', '10.5%', '', '8.6'),
(21, 'Abbaye d''Aulne-Blonde des pères sur lie ', 'Belge', 'Bière d''Abbaye', '', 'Blonde', 'Brasserie du Val de Sambre', 'Fermentation haute', '6.3%', '', 'Abbaye d''Aulne'),
(22, 'Abbaye d''Aulne-Brune des pères sur lie ', 'Belge', 'Bière d''Abbaye', '', 'Brune', 'Brasserie du Val de Sambre', 'Fermentation haute', '6.5%', '', 'Abbaye d''Aulne'),
(23, 'Abbaye d''Aulne-Super Noël', 'Belge', 'Bière d''Abbaye', 'Bière de Noël', 'Brune', 'Brasserie du Val de Sambre', 'Fermentation haute', '9.0%', '', 'Abbaye d''Aulne'),
(24, 'Abbaye d''Aulne-Triple Blonde sur Lie', 'Belge', 'Bière d''Abbaye', '', 'Blonde', 'Brasserie du Val de Sambre', 'Fermentation haute', '8.0%', '', 'Abbaye d''Aulne'),
(25, 'Abbaye d''Aulne-Triple Brune sur Lie', 'Belge', 'Bière d''Abbaye', '', 'Brune', 'Brasserie du Val de Sambre', 'Fermentation haute', '8.0%', '', 'Abbaye d''Aulne'),
(26, 'Abbaye d''Aulne-Val de Sambre Ambrée sur ', 'Belge', 'Bière d''Abbaye', '', 'Ambrée', 'Brasserie du Val de Sambre', 'Fermentation haute', '6.4%', '', 'Abbaye d''Aulne'),
(27, 'Abbaye de Bonne-Espérance Brune', 'Belge', 'Bière d''Abbaye', '', 'Brune', 'Brasseire de la Binchoise', '', '6.3%', '', 'Abbaye de Bonne-Espérance'),
(28, 'Abbaye de Bonne-Espérance Blonde', 'Belge', 'Bière d''Abbaye', '', 'Blonde ', 'Brasserie de la Binchoise', '', '7.8%', '', 'Abbaye de Bonne-Espérance'),
(29, 'Abbaye de Cambron Blonde', 'Belge', 'Bière d''Abbaye', '', 'Blonde', 'Brasserie de Cambron', '', '5.0%', '', 'Abbaye de Cambron'),
(30, 'Abbaye de Forest', 'Belge', 'Bière d''Abbaye', '', '', 'Brasserie de Silly', '', '6.5%', '', 'Abbaye de Forest'),
(31, 'Abbaye de Saint-Martin Blonde', 'Belge', 'Bière d''Abbaye', '', 'Blonde', 'Brasserie de Brunehaut', '', '7.0%', '', 'Abbaye de Saint-Martin '),
(32, 'Abbaye de Saint-Martin Brune', 'Belge', 'Bière d''Abbaye', '', 'Brune', 'Brasserie de Brunehaut', '', '8.0%', '', 'Abbaye de Saint-Martin '),
(33, 'Abbaye de Saint-Martin Triple', 'Belge', 'Bière d''Abbaye', 'Triple', '', 'Brasserie de Brunehaut', '', '9.0%', '', 'Abbaye de Saint-Martin '),
(34, 'Abbaye des Rocs Blonde', 'Belge', 'Bière d''Abbaye', '', 'Blonde', 'Brasserie de l''Abbaye des Rocs', '', '6.0%', '', 'Abbaye des Rocs'),
(35, 'Abbaye des Rocs Brune', 'Belge', 'Bière d''Abbaye', '', 'Brune', 'Brasserie de l''Abbaye des Rocs', '', '6.0%', '', 'Abbaye des Rocs'),
(36, 'Abbaye des Rocs Grand cru', 'Belge', 'Bière d''Abbaye', '', '', 'Brasserie de l''Abbaye des Rocs', '', '10.0%', '', 'Abbaye des Rocs'),
(37, 'Adelscott', 'Française', '', '', 'Ambrée', 'Brasserie de l''Espérance', 'Fermentation basse', '6.6%', '', 'Adelscott'),
(38, 'Affligem Blond', 'Belge', 'Bière d''abbaye', '', 'Blonde', 'Brasserie Affligem (Heineken)', 'Fermentation haute', '6.7%', '', 'Affligem'),
(39, 'Affligem Dubbel', 'Belge', 'Bière d''abbaye', 'Double', 'Brune', 'Brasserie Affligem (Heineken)', '', '6.8%', '', 'Affligem'),
(40, 'Affligem Tripel', 'Belge', 'Bière d''abbaye', 'Triple', 'Blonde', 'Brasserie Affligem (Heineken)', '', '8.5%', '', 'Affligem'),
(41, 'Affligem Patersvat', 'Belge', 'Bière d''abbaye', 'Bière de saison', 'Blonde', 'Brasserie Affligem (Heineken)', '', '6.8%', '', 'Affligem'),
(42, 'Affligem Christmas', 'Belge', 'Bière d''abbaye', 'Bière de Noël', 'Brune', 'Brasserie Affligem (Heineken)', '', '9.0%', '', 'Affligem'),
(43, 'Affligem 950 Cuvée', 'Belge', 'Bière d''abbaye', '', '', 'Brasserie Affligem (Heineken)', '', '6.8%', '', 'Affligem'),
(44, 'Akerbeltz Blanche', 'Française', '', '', 'Blanche', 'Akerbeltz', '', '4.0%', '', 'Akerbeltz'),
(45, 'Akerbeltz Blonde', 'Française', '', '', 'Blonde', 'Akerbeltz', '', '4.0%', '', 'Akerbeltz'),
(46, 'Akerbeltz Ambrée', 'Française', '', '', 'Ambrée', 'Akerbeltz', '', '5.5%', '', 'Akerbeltz'),
(47, 'Akerbeltz Brune', 'Française', '', '', 'Brune', 'Akerbeltz', '', '6.5%', '', 'Akerbeltz'),
(48, 'Akerbeltz Primtemps', 'Française', '', '', 'Blonde', 'Akerbeltz', '', '5.0%', '', 'Akerbeltz'),
(49, 'Akerbeltz Noël', 'Française', 'Bière de Noël', '', 'Ambrée', 'Akerbeltz', 'Fermentation haute', '6.5%', '', 'Akerbeltz'),
(50, 'Aldaric', 'Belge', 'Ale', '', 'Brune', 'Brasserie Duwac', 'Fermentation haute', '7.0%', '', 'Aldaric'),
(51, 'Amadeus', 'Française', '', '', 'Blanche', ' Les Brasseurs de Gayant', 'Fermentation haute', '4.5%', '', 'Amadeus'),
(52, 'Anchor Liberty Ale', 'Américaine ', 'American Pale Ale', '', 'Ambrée', 'Achor Brewing Company', '', '5.9%', '', 'Anchor'),
(53, 'Anchor Steam Beer', 'Américaine ', 'Steam Beer', '', 'Ambrée', 'Achor Brewing Company', '', '4.8%', '', 'Anchor'),
(54, 'Anchor Porter', 'Américaine ', 'Porter', '', 'Noire', 'Achor Brewing Company', '', '5.6%', '', 'Anchor'),
(55, 'Anchor Brekles Brown', 'Américaine ', 'Brown Ale', '', 'Brune', 'Achor Brewing Company', '', '6.0%', '', 'Anchor'),
(56, 'Anchor California Lager', 'Américaine ', 'Lager', '', 'Blonde', 'Achor Brewing Company', '', '4.9%', '', 'Anchor'),
(57, 'Anchor Go West IPA', 'Américaine ', 'India Pale Ale', '', 'Blonde', 'Achor Brewing Company', '', '6.7%', '', 'Anchor'),
(58, 'Augustijn Grand Cru', 'Belge', 'Triple', '', 'Blonde', 'Brasserie Van Steenberge', '', '9.0%', '', 'Augustijn'),
(59, 'Augustijn Blond', 'Belge', 'Belgian Pale Ale', '', 'Blonde', 'Brasserie Van Steenberge', '', '7.5%', '', 'Augustijn'),
(60, 'Augustijn Brune', 'Belge', 'Belgian Dark Ale', '', 'Brune', 'Brasserie Van Steenberge', '', '7.0%', '', 'Augustijn'),
(61, 'Bapbap Originale', 'Française', 'Pale Ale', '', 'Blonde', 'Brasserie Bapbap', 'Fermentation haute', '5.9%', '', 'Bapbap'),
(62, 'Bapbap Blanc Bec', 'Française', '', '', 'Blanche', 'Brasserie Bapbap', '', '4.7%', '', 'Bapbap'),
(63, 'Bapbap Vertigo', 'Française', 'India Pale Ale', '', 'Blonde', 'Brasserie Bapbap', '', '6.0%', '', 'Bapbap'),
(64, 'Bapbap Toast', 'Française', '', '', 'Brune', 'Brasserie Bapbap', '', '4.5%', '', 'Bapbap'),
(65, 'Bapbap Belle Saison', 'Française', 'Printemps ', '', 'Blonde', 'Brasserie Bapbap', '', '4.5%', '', 'Bapbap'),
(66, 'Barbar', 'Belge', 'Pale Ale', '', 'Blonde', 'Brasserie Lefebvre', '', '8.0%', '', 'Barbar'),
(67, 'Barbar Bok', 'Belge', 'Dark Ale', '', 'Brune', 'Brasserie Lefebvre', '', '8.5%', '', 'Barbar'),
(68, 'Beck''s', 'Allemande', 'Lager', '', 'Blonde', 'Brauerei Beck & Co (A.B. inBev)', 'Fermentation basse', '5.0%', '', 'Beck''s'),
(69, 'Belgian Framboise', 'Belge', '', 'Blanche ', 'Fruitée', 'Brasserie Lefebvre', '', '3.5%', '', 'Belgian Framboise'),
(70, 'Belgian Kriek', 'Belge', 'Kriek', 'Blanche ', 'Fruitée', 'Brasserie Lefebvre', '', '3.5%', '', 'Belgian Kriek'),
(71, 'Belgian Pêche', 'Belge', '', 'Blanche ', 'Fruitée', 'Brasserie Lefebvre', '', '3.5%', '', 'Belgian Pêche'),
(72, 'Belle Fleur', 'Belge', 'India Pale Ale', '', 'Blonde', 'De Dochter van de Korenaar', '', '6.0%', '', 'Belle Fleur'),
(73, 'Bitter XX', 'Belge', 'India Pale Ale', '', 'Blonde', 'Brasserie De Ranke', '', '6.2%', '', 'Bitter XX'),
(74, 'Blanche de Bruxelles', 'Belge', 'Witbier', '', 'Blanche', 'Brasserie Lefebvre', '', '4.5%', '', 'Blanche de Bruxelles'),
(75, 'Blanche de Namur', 'Belge', '', '', 'Blanche', 'Brasserie du Bocq', '', '4.5%', '', 'Blanche de Namur'),
(76, 'Blanche de Namur Rosée', 'Belge', '', 'Blanche ', 'Fruitée', 'Brasserie du Bocq', '', '3.4%', '', 'Blanche de Namur'),
(77, 'Blanche des neiges', 'Belge', 'Witbier', 'Blanche ', 'Blanche ', 'Brasserie Huyghe', '', '5.0%', '', 'Blanche des neiges'),
(78, 'Blue Moon Belgian white ', 'Belge', '', 'Blanche', 'Blanche', 'Blue Moon brewing co. (MillerCoors)', '', '5.4%', '', 'Blue Moon'),
(79, 'Bornem Double', 'Belge', 'Biere d''Abbaye', '', 'Brune', 'Brasserie Van Steenberge', '', '8.0%', '', 'Bornem'),
(80, 'Bornem Triple', 'Belge', 'Biere d''Abbaye', '', 'Blonde', 'Brasserie Van Steenberge', '', '9.0%', '', 'Bornem'),
(81, 'Boscoli', 'Belge', '', 'Blanche ', 'Fruitée', 'Brasserie Het Anker', 'Fermentation haute', '3.5%', '', 'Boscoli'),
(82, 'Bourgogne des Flandres', 'Belge', 'Brune', 'Lambic', 'Brune', 'Timmermans', '', '5.0%', '', 'Bourgogne des Flandres'),
(83, 'L''Ange Blond', 'Française', 'India Pale Ale', '', 'Blonde', 'Brasserie des Anges', '', '5.7%', '', 'Brasserie des Anges'),
(84, 'L''Ange Ambrée', 'Française', 'Ambrée', '', 'Ambrée', 'Brasserie des Anges', '', '7.5%', '', 'Brasserie des Anges'),
(85, 'Brewdog Jack Hammer', 'Ecossaise', 'India Pale Ale', '', 'Blonde', 'Brasserie Brewdog', '', '7.4%', '', 'Brewdog'),
(86, 'Brewdog Hardcore IPA', 'Ecossaise', 'Imperial IPA', 'Double', 'Ambrée', 'Brasserie Brewdog', '', '9.2%', '', 'Brewdog'),
(87, 'Brewdog Punk IPA', 'Ecossaise', 'India Pale Ale', '', 'Blonde', 'Brasserie Brewdog', '', '5.6%', '', 'Brewdog'),
(88, 'Brigand', 'Belge', 'Belgian Pale Ale', '', 'Ambrée', 'Brasserie von Honsenbrouck', '', '9.0%', '', 'Brigand'),
(89, 'Britt blanche', 'Française', '', '', 'Blanche', 'Brasserie de Bretagne Kerouel', 'Fermentation haute', '5.4%', '', 'Britt'),
(90, 'Britt Blonde', 'Française', '', '', 'Blonde', 'Brasserie de Bretagne Kerouel', 'Fermentation haute', '5.0%', '', 'Britt'),
(91, 'Britt Rousse', 'Française', '', '', 'Rousse', 'Brasserie de Bretagne Kerouel', 'Fermentation haute', '5.4%', '', 'Britt'),
(92, 'Britt Rosée', 'Française', '', 'Blanche ', 'Fruitée', 'Brasserie de Bretagne Kerouel', 'Fermentation haute', '3.0%', '', 'Britt'),
(93, 'Brooklyn Lager', 'Américaine ', 'Lager ', '', 'Blonde', 'Brasserie Brooklyn', '', '5.2%', '', 'Brooklyn'),
(94, 'Brooklyn Sorachi Ace', 'Américaine ', 'Farmhouse Ale', '', 'Blonde', 'Brasserie Brooklyn', '', '7.6%', '', 'Brooklyn'),
(95, 'Brooklyn Summer Ale', 'Américaine ', 'Golden Ale', '', 'Blonde', 'Brasserie Brooklyn', '', '4.5%', '', 'Brooklyn'),
(96, 'Brooklyn East India Pale Ale', 'Américaine ', 'India Pale Ale', '', 'Blonde', 'Brasserie Brooklyn', '', '6.9%', '', 'Brooklyn'),
(97, 'Brooklyn Brown Ale', 'Américaine ', 'Brown Ale', '', 'Brune', 'Brasserie Brooklyn', '', '5.6%', '', 'Brooklyn'),
(98, 'Bruegel', 'Belge', 'Ale', '', 'Ambrée ', 'Brasserie Van Steenberge', 'Fermentation haute', '5.2%', '', 'Bruegel'),
(99, 'Buck Blonde', 'Canada', 'Ale', '', 'Blonde', 'Multi-Brasses', '', '5.0%', '', 'Buck'),
(100, 'Buck Ambrée', 'Canada', '', '', 'Ambrée', 'Multi-Brasses', '', '5.0%', '', 'Buck '),
(101, 'Bush Ambrée', 'Belge', '', '', 'Ambrée', 'Brasserie Dubuisson', '', '12.0%', '', 'Bush'),
(102, 'Bush Ambrée Triple', 'Belge', '', 'Triple', 'Ambrée', 'Brasserie Dubuisson', '', '12.0%', '', 'Bush'),
(103, 'Bush de Noël', 'Belge', 'Bière de Noël', '', '', 'Brasserie Dubuisson', 'Fermentation haute', '12.0%', '', 'Bush'),
(104, 'Bush Blonde', 'Belge', '', '', 'Blonde', 'Brasserie Dubuisson', 'Fermentation haute', '10.5%', '', 'Bush'),
(105, 'Bush Blonde Triple', 'Belge', '', '', 'Blonde', 'Brasserie Dubuisson', '', '10.5%', '', 'Bush'),
(106, 'Bush de Noël Premium', 'Belge', 'Bière de Noël', '', '', 'Brasserie Dubuisson', '', '12.0%', '', 'Bush'),
(107, 'Pêche Mel Bush', 'Belge', '', '', 'Fruitée', 'Brasserie Dubuisson', '', '8.5%', '', 'Bush'),
(108, 'Bush Prestige', 'Belge', '', '', 'Ambrée', 'Brasserie Dubuisson', 'Mûrissement en fûts ', '13.0%', '', 'Bush'),
(109, 'Bush de Nuits', 'Belge', '', '', '', 'Brasserie Dubuisson', 'Mûrissement dans des', '13.0%', '', 'Bush'),
(110, 'Bush de Charmes ', 'Belge', '', '', 'Blonde', 'Brasserie Dubuisson', 'Mûrissement dans le ', '10.5%', '', 'Bush'),
(111, 'Buxton Axe Edge', 'Anglaise', 'Imperial IPA', 'Double', 'Ambrée', 'Brasserie Buxton', '', '6.8%', '', 'Buxton'),
(112, 'Campus Premium', 'Belge', '', '', 'Blonde', 'Brasserie Huyghe', '', '5.0%', '', 'Campus'),
(113, 'Campus Gold', 'Belge', '', '', 'Blonde', 'Brasserie Huyghe', '', '6.2%', '', 'Campus'),
(114, 'Campus', 'Belge', '', '', 'Ambrée', 'Brasserie Huyghe', '', '7.0%', '', 'Campus'),
(115, 'Car d''Or', 'Belge', '', '', 'Blonde', 'Brasserie St-Feuillien', 'Fermentation haute', '6.5%', '', 'Car d''Or'),
(116, 'Carlsberg', 'Danoise', '', '', 'Blonde', 'Brasserie Carlsberg', '', '5.0%', '', 'Carlsberg'),
(117, 'Gouden Carolus Classique', 'Belge', 'Dark Ale', '', 'Brune', 'Brasserie Het Anker', 'Fermentation haute', '8.5%', '', 'Carolus'),
(118, 'Gouden Carolus Tripel', 'Belge', 'Triple', '', 'Blonde', 'Brasserie Het Anker', 'Fermentation haute', '9.0%', '', 'Carolus'),
(119, 'Gouden Carolus Ambrio', 'Belge', '', 'Brune', 'Ambrée', 'Brasserie Het Anker', 'Fermentation haute', '8.0%', '', 'Carolus'),
(120, 'Gouden Carolus Hopsinjoor', 'Belge', 'Pale Ale', '', 'Blonde', 'Brasserie Het Anker', 'Fermentation haute', '8.0%', '', 'Carolus'),
(121, 'Gouden Carolus Pâques', 'Belge', 'Bière de saison', '', 'Rubis', 'Brasserie Het Anker', 'Fermentation haute', '10.0%', '', 'Carolus'),
(122, 'Gouden Carolus Christmas', 'Belge', 'Bière de Noël', 'Brune', 'Rubis', 'Brasserie Het Anker', 'Fermentation haute', '10.5%', '', 'Carolus'),
(123, 'Gouden Carolus Cuvée Van de Keizer Rouge', 'Belge', 'Pale Ale', '', 'Blonde', 'Brasserie Het Anker', 'Fermentation haute', '10.0%', '', 'Carolus'),
(124, 'Gouden Carolus Cuvée Van de Keizer Bleu', 'Belge', 'Dark Ale', '', 'Brune', 'Brasserie Het Anker', 'Fermentation haute', '11.0%', '', 'Carolus'),
(125, 'Gouden Carolus Indulgence', 'Belge', '', '', 'Brune', 'Brasserie Het Anker', 'Fermentation haute', '11.7%', '', 'Carolus'),
(126, 'Chimay Bleue', 'Belge', 'Trappiste', '', '', 'Abbaye de Scourmont', '', '9.0%', '', 'Chimay'),
(127, 'Chimay Dorée', 'Belge', 'Trappiste', '', 'Blonde', 'Abbaye de Scourmont', '', '4.8%', '', 'Chimay'),
(128, 'Chimay Rouge ', 'Belge', 'Trappiste', '', 'Fruitée', 'Abbaye de Scourmont', '', '7.0%', '', 'Chimay'),
(129, 'Chimay Triple', 'Belge', 'Trappiste', 'Triple', '', 'Abbaye de Scourmont', '', '8.0%', '', 'Chimay'),
(130, 'La Chimay Bleue vieillie au fût de bois ', 'Belge', 'Trappiste', '', '', 'Abbaye de Scourmont', '', '10.0%', '', 'Chimay'),
(131, 'Chouffe Bok', 'Belge', '', '', '', 'Brasserie d''Achouffe', '', '6.66%', '', 'Chouffe'),
(132, 'Chouffe Soleil', 'Belge', '', '', 'Blonde', 'Brasserie d''Achouffe', '', '6.0%', '', 'Chouffe'),
(133, 'Houblon Chouffe', 'Belge', 'India Pale Ale', '', '', 'Brasserie d''Achouffe', '', '9.0%', '', 'Chouffe'),
(134, 'La Chouffe', 'Belge', '', '', 'Blonde', 'Brasserie d''Achouffe', '', '8.0%', '', 'Chouffe'),
(135, 'Mc Chouffe', 'Belge', '', '', 'Brune', 'Brasserie d''Achouffe', '', '8.0%', '', 'Chouffe'),
(136, 'N''Ice Chouffe', 'Belge', '', '', 'Brune', 'Brasserie d''Achouffe', '', '10.0%', '', 'Chouffe'),
(137, 'Ch''ti Ambrée', 'France', 'Bière de garde', '', 'Ambrée', ' Brasserie de Bénifontaine', 'Basse', '5.9%', '', 'Ch''ti '),
(138, 'Ch''ti Blonde', 'France', 'Bière de garde', '', 'Blonde', ' Brasserie Castelain', '', '6.4%', '', 'Ch''ti '),
(139, 'Ch''ti Blanche', 'France', '', '', 'Blanche', ' Brasserie Castelain', '', '4.5%', '', 'Ch''ti '),
(140, 'Ch''ti Triple', 'France', '', 'Triple', 'Blonde', ' Brasserie Castelain', '', '7.5%', '', 'Ch''ti '),
(141, 'Ch''ti Brune', 'France', '', '', 'Brune', ' Brasserie Castelain', '', '6.4%', '', 'Ch''ti '),
(142, 'Maltesse', 'France', '', 'Triple', 'Blonde', ' Brasserie Castelain', '', '7.7%', '', 'Ch''ti '),
(143, 'Colomba', 'Française', '', '', 'Blanche', 'Brasserie Pietra', 'Fermentation haute', '5.0%', '', 'Colomba'),
(144, 'Corona Extra', 'Mexique', 'Lager', '', 'Blonde', 'Cerveceria Modelo S.A. de C.V. (A.B. inB', 'Basse', '4.6%', '', 'Corona'),
(145, 'Corsendonk Blonde', 'Belge', 'Biere d''Abbaye', 'Triple', 'Blonde', 'Brasserie Corsendonk', 'Fermentation haute', '7.5%', '', 'Corsendonk'),
(146, 'Cruzcampo', 'Espagnole', 'Pilsen', '', 'Blonde', 'Brasserie de la Valentine (Heineken)', '', '4.8%', '', 'Cruzcampo'),
(147, 'Cubanisto', 'Belge', 'Aromatisé', 'Rhum', 'Blonde', 'AB inBev', '', '5.9%', '', 'Cubanisto'),
(148, 'Cuvée des Trolls', 'Belge', '', '', 'Blonde', 'Brasserie Dubuisson', '', '7.0%', '', 'Cuvée'),
(149, 'Cuvée des Trolls Triple', 'Belge', '', 'Triple', 'Blonde', 'Brasserie Dubuisson', '', '7.0%', '', 'Cuvée'),
(150, 'Delirium Tremens', 'Belge', '', '', 'Blonde', 'Brasserie Huyghe', '', '8.5%', '', 'Delirium'),
(151, 'Delirium Nocturnom', 'Belge', '', '', 'Brune', 'Brasserie Huyghe', '', '8.5%', '', 'Delirium'),
(152, 'Delirium Christmas', 'Belge', 'Bière de Noël', '', '', 'Brasserie Huyghe', '', '10.0%', '', 'Delirium'),
(153, 'Delirium Red', 'Belge', '', '', 'Fruitée', 'Brasserie Huyghe', '', '8.5%', '', 'Delirium'),
(154, 'Delirium Argentum', 'Belge', 'India Pale Ale', '', 'Blonde', 'Brasserie Huyghe', '', '7.0%', '', 'Delirium'),
(155, 'Deliria', 'Belge', '', '', 'Blonde', 'Brasserie Huyghe', '', '8.5%', '', 'Delirium'),
(156, 'Desperados', 'Française', '', '', 'Blonde', 'Brasserie de l''Espérance (Heineken)', '', '5.9%', '', 'Desperados'),
(157, 'Desperados Lime', 'Française', '', '', 'Fruitée', 'Brasserie de l''Espérance (Heineken)', '', '3.9%', '', 'Desperados'),
(158, 'Desperados Red', 'Française', '', '', 'Fruitée', 'Brasserie de l''Espérance (Heineken)', '', '5.9%', '', 'Desperados'),
(159, 'Desperados Verde', 'Française', '', '', 'Fruitée', 'Brasserie de l''Espérance (Heineken)', '', '4.7%', '', 'Desperados'),
(160, 'Desperados Black', 'Française', '', '', 'Aromatisée', 'Brasserie de l''Espérance (Heineken)', '', '5.9%', '', 'Desperados'),
(161, 'Desperados Fuego', 'Française', '', '', 'Aromatisée', 'Brasserie de l''Espérance (Heineken)', '', '5.9%', '', 'Desperados'),
(162, 'DeuS', 'Belge', '', '', 'Blonde', 'Brasserie Bosteels', '', '11.5%', '', 'DeuS'),
(163, 'Doigt de Dieu', 'Française', '', '', 'Ambrée', 'Brasserie d''Uberach', 'Fermentation basse', '4.8%', '', 'Doigt de Dieu'),
(164, 'Doreleï', 'France', '', '', 'Ambrée', 'Brasserie du Pêcheur', 'Fermentation basse', '6.3%', '', 'Doreleï'),
(165, 'Duvel', 'Belge', 'Ale', '', 'Blonde ', 'Brasserie Duvel Moortgat', 'Fermentation haute', '8.5%', '', 'Duvel'),
(166, 'Duvel Tripel Hop 2016', 'Belge', 'Pale Ale', '', 'Blonde', 'Brasserie Duvel Moortgat', '', '9.5%', '', 'Duvel'),
(167, 'Edelweiss', 'Française', 'Hefeweizen', '', 'Blanche', 'Brasserie de l''Espérance (Heineken)', '', '5.0%', '', 'Edelweiss'),
(168, 'Edelweiss fruits des bois et fleur de su', 'Française', '', '', 'Fruitée', 'Brasserie de l''Espérance (Heineken)', '', '4.0%', '', 'Edelweiss'),
(169, 'Edelweiss zestes d’agrumes et miel', 'Française', '', '', 'Fruitée', 'Brasserie de l''Espérance (Heineken)', '', '4.0%', '', 'Edelweiss'),
(170, 'Erdinger Weissbier', 'Allemande', '', '', 'Blanche', 'Erdinger', '', '5.3%', '', 'Erdinger'),
(171, 'Faro Chapeau', 'Belge', 'Faro', '', 'Rousse', 'Brasserie De Troch', 'Fermentation spontan', '4.7%', '', 'Faro'),
(172, 'Faro Lindemans', 'Belge', 'Faro', '', 'Rousse ', 'Brasserie Lindemans', 'Fermentation spontan', '4.0%', '', 'Faro'),
(173, 'Filou', 'Belge', 'Belgian Ale', '', 'Blonde', 'Brasserie Van Honsebrouck', '', '8.5%', '', 'Filou'),
(174, 'Fischer Tradition', 'Française', '', '', 'Blonde', 'Brasserie de l''Espérance (Heineken)', '', '6.0%', '', 'Fischer'),
(175, 'Fischer Réserve Ambrée', 'Française', '', 'Ambrée', 'Fruitée', 'Brasserie de l''Espérance (Heineken)', '', '6.3%', '', 'Fischer'),
(176, 'Pëcheur', 'Française', 'Pilsen', '', '', 'Brasserie de l''Espérance (Heineken)', '', '4.9%', '', 'Fischer'),
(177, 'Fischer Blanche', 'Française', '', '', 'BLanche', 'Brasserie de l''Espérance (Heineken)', '', '5.0%', '', 'Fischer'),
(178, 'Floreffe Prima Melior', 'Belge', 'Bière d''abbaye', '', 'Brune rouge', 'Brasserie Lefebvre', 'Fermentation haute', '8.0%', '', 'Floreffe'),
(179, 'Floreffe Blonde', 'Belge', '', '', 'Blonde', 'Brasserie Lefebvre', '', '6.5%', '', 'Floreffe'),
(180, 'Floreffe Double', 'Belge', '', 'Double', 'Brune', 'Brasserie Lefebvre', '', '6.5%', '', 'Floreffe'),
(181, 'Floreffe Triple', 'Belge', '', 'Triple', 'Blonde', 'Brasserie Lefebvre', '', '8.0%', '', 'Floreffe'),
(182, 'Floreffe Prima Melior', 'Belge', 'Dark Ale', '', 'Brune', 'Brasserie Lefebvre', '', '8.0%', '', 'Floreffe'),
(183, 'Floris Passion', 'Belge', 'Fruité', '', 'Blonde', 'Brasserie Huyghe', '', '3.6%', '', 'Floris'),
(184, 'AppleBocq', 'Belge', '', '', 'Fruite', 'Brasserie du Bocq', '', '3.1%', '', 'FruitBocq'),
(185, 'RedBocq', 'Belge', '', '', 'Fruite', 'Brasserie du Bocq', '', '3.1%', '', 'FruitBocq'),
(186, 'Agrumbocq', 'Belge', '', '', 'Fruite', 'Brasserie du Bocq', '', '3.1%', '', 'FruitBocq'),
(187, 'Gauloise', 'Belge', '', 'Triple', 'Blonde', 'Brasserie du Bocq', '', '9.7%', '', 'Gauloise'),
(188, 'Gavroche', 'Française', 'Bière de garde', '', 'Ambrée', 'Brasserie de Saint Sylvestre', 'Fermentation haute', '8.5%', '', 'Gavroche'),
(189, 'Grimbergen Rouge', 'Belge', 'Bière d''Abbaye', '', 'Fruitée', 'Brasserie Kronenbourg (Carlsberg)', 'Fermentation haute', '6.0%', '', 'Grimbergen'),
(190, 'Grimbergen Ambrée', 'Belge', 'Bière d''Abbaye', '', 'Ambrée', 'Brasserie Kronenbourg (Carlsberg)', 'Fermentation haute', '6.5%', '', 'Grimbergen'),
(191, 'Grimbergen Bière de Printemps', 'Belge', 'Bière d''Abbaye', '', '', 'Brasserie Kronenbourg (Carlsberg)', 'Fermentation haute', '6.0%', '', 'Grimbergen'),
(192, 'Grimbergen Blanche', 'Belge', 'Bière d''Abbaye', '', 'Blanche', 'Brasserie Kronenbourg (Carlsberg)', 'Fermentation haute', '6.0%', '', 'Grimbergen'),
(193, 'Grimbergen Blonde', 'Belge', 'Bière d''Abbaye', '', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', 'Fermentation haute', '6.7%', '', 'Grimbergen'),
(194, 'Grimbergen Brassin de Noël', 'Belge', 'Bière d''Abbaye', '', '', 'Brasserie Kronenbourg (Carlsberg)', 'Fermentation haute', '6.5%', '', 'Grimbergen'),
(195, 'Grimbergen Kriek', 'Belge', 'Bière d''Abbaye', '', 'Fruitée', 'Brasserie Kronenbourg (Carlsberg)', 'Fermentation haute', '6.0%', '', 'Grimbergen'),
(196, 'Grimbergen La réserve', 'Belge', 'Bière d''Abbaye', '', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', 'Fermentation haute', '8.5%', '', 'Grimbergen'),
(197, 'Grimbergen Poire', 'Belge', 'Bière d''Abbaye', '', 'Fruitée', 'Brasserie Kronenbourg (Carlsberg)', 'Fermentation haute', '6.0%', '', 'Grimbergen'),
(198, 'Grisette Fruits des bois', 'Belge', '', '', 'Fruitée', 'Brasserie St-Feuillien', '', '3.5%', '', 'Grisette'),
(199, 'Grisette Cerise', 'Belge', '', '', 'Fruitée', 'Brasserie St-Feuillien', '', '3.5%', '', 'Grisette'),
(200, 'Grisette Blanche', 'Belge', '', '', 'Blanche', 'Brasserie St-Feuillien', '', '5.5%', '', 'Grisette'),
(201, 'Grisette Blonde Bio', 'Belge', 'Bière Bio', '', 'Blonde', 'Brasserie St-Feuillien', '', '5.5%', '', 'Grisette'),
(202, 'Gueuze Vieux Bruges', 'Belge', 'Gueuze', '', 'Blonde', 'Brasserie Timmermans', 'Fermentation spontan', '5.0%', '', 'Gueuze Vieux Bruges'),
(203, 'Guinness Draught', 'Irlandaise', 'Stout', '', 'Stout', 'Guinness', 'Fermentation haute', '4.2%', '', 'Guinness'),
(204, 'Gulden Draak', 'Belge', '', 'Triple', 'Brune', 'Brasserie Van Steenberge', 'Fermentation haute', '10.5%', '', 'Gulden'),
(205, 'Gulden Draak 9000 Quadruple', 'Belge', '', 'Triple', 'Brune', 'Brasserie Van Steenberge', 'Fermentation haute', '10.5%', '', 'Gulden'),
(206, 'Heineken', 'Néerlandaise', '', '', 'Blonde', 'Heineken', '', '5.4%', '', 'Heineken'),
(207, 'Hercule Stout', 'Belge', 'Imperial Stout', '', 'Noire', 'Brasserie Ezzeloise', '', '9.0%', '', 'Hercule'),
(208, 'Hoegaarden Blanche', 'Belge', '', '', 'Blanche', ' Brasserie Hoegaarden (A.B. InBev)', '', '4.9%', '', 'Hoegaarden'),
(209, 'Hoegaarden Radler Lemon & Lime', 'Belge', '', '', '', ' Brasserie Hoegaarden (A.B. InBev)', '', '2.0%', '', 'Hoegaarden'),
(210, 'Hoegaarden', 'Belge', 'Sans alcool', '', '', ' Brasserie Hoegaarden (A.B. InBev)', '', '0.0%', '', 'Hoegaarden'),
(211, 'Hoegaarden Rosée', 'Belge', 'Sans alcool', '', 'Fruitée', ' Brasserie Hoegaarden (A.B. InBev)', '', '0.0%', '', 'Hoegaarden'),
(212, 'Hoegaarden Fruit défendu', 'Belge', '', '', 'Fruitée', ' Brasserie Hoegaarden (A.B. InBev)', '', '8.8%', '', 'Hoegaarden'),
(213, 'Hoegaarden Grand Cru', 'Belge', '', '', 'Fruitée', ' Brasserie Hoegaarden (A.B. InBev)', '', '8.5%', '', 'Hoegaarden'),
(214, 'Hoegaarden Radler Agrum', 'Belge', '', '', 'Fruitée', ' Brasserie Hoegaarden (A.B. InBev)', '', '2.0%', '', 'Hoegaarden'),
(215, 'Hoegaarden Rosée', 'Belge', '', '', 'Fruitée', ' Brasserie Hoegaarden (A.B. InBev)', '', '3.0%', '', 'Hoegaarden'),
(216, 'Hoegaarden Spéciale', 'Belge', '', '', 'Blonde', ' Brasserie Hoegaarden (A.B. InBev)', '', '5.7%', '', 'Hoegaarden'),
(217, 'Hollandia', 'Hollandaise', 'Lager', '', 'Blonde', 'Brasserie Bavaria', 'Fermentation basse', '5.0%', '', 'Hollandia'),
(218, 'Hopus', 'Belge', 'Pale Ale', '', 'Blonde', 'Brasserie Lefebvre', '', '8.3%', '', 'Hopus'),
(219, 'Innis & gunn Rum finish', 'Ecossaise', 'Scotch Ale', '', 'Rubis', 'Brasserie Innis & gunn ', '', '6.8%', '', 'Innis & gunn '),
(220, 'Innis & gunn Original', 'Ecossaise', '', '', 'Ambrée', 'Brasserie Innis & gunn ', '', '6.6%', '', 'Innis & gunn '),
(221, 'Innis & gunn Scotch Whisky Porter', 'Ecossaise', 'Porter', '', 'Noire', 'Brasserie Innis & gunn ', '', '7.4%', '', 'Innis & gunn '),
(222, 'Innis & gunn Seasonnal Irish Whisky Cask', 'Ecossaise', 'Stout', '', 'Noire', 'Brasserie Innis & gunn ', '', '7.4%', '', 'Innis & gunn '),
(223, 'Innis & gunn Toasted OAK IPA', 'Ecossaise', 'India Pale Ale', '', '', 'Brasserie Innis & gunn ', '', '5.6%', '', 'Innis & gunn '),
(224, 'IPA sous sénart', 'Française', 'Imperial IPA', '', 'Blonde', 'Brasserie Parisis', '', '7.9%', '', 'IPA'),
(225, 'Jade sans Gluten', 'France', 'Bière sans Gluten', '', 'Blonde', ' Brasserie Castelain', '', '4.5%', '', 'Jade'),
(226, 'Jade aromatisée à la grenade', 'France', '', '', 'Fruitée', ' Brasserie Castelain', '', '4.5%', '', 'Jade'),
(227, 'Jade la blonde BIO', 'France', 'Bière Bio', '', 'Blonde', ' Brasserie Castelain', '', '4.5%', '', 'Jade'),
(228, 'Judas', 'Belge', 'Pale Ale', '', 'Blonde ', 'Brasserie Alken Maes', 'Fermentation haute', '8.5%', '', 'Judas'),
(229, 'Jupiler', 'Belge', 'Lager', '', 'Blonde', 'Brasserie Jupiler (A.B. InBev)', 'Fermentation basse', '5.2%', '', 'Jupiler'),
(230, 'Tripel Karmeliet', 'Belge', '', 'Triple', '', 'Brasserie Bosteels', '', '8.4%', '', 'Karmeliet'),
(231, 'Kasteel Donker', 'Belge', '', 'Quadruple', 'Brune ', 'Brasserie Van Honsebrouck', '', '11.0%', '', 'Kasteel '),
(232, 'Kasteel Rouge', 'Belge', '', 'Brune', 'Fruitée', 'Brasserie Van Honsebrouck', '', '8.0%', '', 'Kasteel '),
(233, 'Kasteel Triple', 'Belge', '', 'Triple', 'Blonde', 'Brasserie Van Honsebrouck', '', '11.0%', '', 'Kasteel '),
(234, 'Kasteel Blond', 'Belge', '', '', 'Blonde', 'Brasserie Van Honsebrouck', '', '7.0%', '', 'Kasteel '),
(235, 'Kasteel Hoppy', 'Belge', '', '', 'Blonde', 'Brasserie Van Honsebrouck', '', '6.5%', '', 'Kasteel '),
(236, 'Kilkenny', 'Irlandaise', 'Rousse', '', 'Rousse', 'Diageo', '', '4.3%', '', 'Kilkenny'),
(237, 'George Killian''s', 'Irlandaise', '', '', 'Rouse', 'Brasserie de l''Espérance (Heineken)', 'Fermentation haute', '6.5%', '', 'Killian''s'),
(238, 'Kingsbräu', 'Française', 'Lager', '', 'Blonde', 'Kingsbräu', 'Fermentation basse', '4.7%', '', 'Kingsbräu'),
(239, 'Alpirsbacher Klosterbräu Spezial', 'Allemande', '', '', 'Blonde', 'Brasserie d''Alpirsbach', 'Fermentation basse', '5.2%', '', 'Klosterbräu'),
(240, 'Alpirsbacher Klosterbräu Pils', 'Allemande', 'Pilsen', '', '', 'Brasserie d''Alpirsbach', 'Fermentation basse', '4.9%', '', 'Klosterbräu'),
(241, 'Alpirsbacher Klosterbräu Alkohol Frei', 'Allemande', 'Sans alcool', '', 'Blonde', 'Brasserie d''Alpirsbach', 'Fermentation basse', '0.5%', '', 'Klosterbräu'),
(242, 'Alpirsbacher Klosterbräu Weizen', 'Allemande', 'Hefe Dunkel', '', 'Brune', 'Brasserie d''Alpirsbach', 'Fermentation haute', '5.2%', '', 'Klosterbräu'),
(243, 'Kronenbourg', 'Française', '', '', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', '', '4.2%', '', 'Kronenbourg'),
(244, 'Kronenbourg pur malt', 'Française', 'Sans alcool', '', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', '', '1%', '', 'Kronenbourg'),
(245, 'Kronenbourg blonde', 'Française', '', '', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', '', '7.2%', '', 'Kronenbourg'),
(246, 'Kronenbourg ambrée', 'Française', '', '', 'Ambrée', 'Brasserie Kronenbourg (Carlsberg)', '', '7.2%', '', 'Kronenbourg'),
(247, 'Kronenbourg Tigre Bock', 'Française', 'Bock', '', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', '', '5.5%', '', 'Kronenbourg'),
(248, 'K by Kronenbourg Mangue', 'Française', '', 'Blonde', 'Fruitée', 'Brasserie Kronenbourg (Carlsberg)', '', '5.0%', '', 'Kronenbourg'),
(249, 'K by Kronenbourg Citron-Citron Vert', 'Française', '', 'Blonde', 'Fruitée', 'Brasserie Kronenbourg (Carlsberg)', '', '5.0%', '', 'Kronenbourg'),
(250, 'K by Kronenbourg Fruit rouge', 'Française', '', 'Blonde', 'Fruitée', 'Brasserie Kronenbourg (Carlsberg)', '', '5.0%', '', 'Kronenbourg'),
(251, 'Kwak', 'Belge', '', '', 'Ambrée', 'Brasserie Bosteels', 'Fermentation haute', '8.4%', '', 'Kwak'),
(252, 'La Phare ', 'Française', '', '', 'Brune', 'Brasserie La Baleine', 'Haute fermentation', '5.0%', '', 'La Baleine'),
(253, 'La Lucite', 'Française', '', '', 'Blonde', 'Brasserie La Baleine', 'Haute fermentation', '4.2%', '', 'La Baleine'),
(254, 'La Gitane', 'Française', '', '', 'Ambrée', 'Brasserie La Baleine', 'Haute fermentation', '5.0%', '', 'La Baleine'),
(255, 'La Picardo', 'Française', '', '', 'Blanche', 'Brasserie La Baleine', 'Haute fermentation', '5.0%', '', 'La Baleine'),
(256, 'La Binchoise Triple', 'Belge', '', 'Triple', 'Blonde', 'Brasserie La Binchoise', '', '8.5%', '', 'La Binchoise'),
(257, 'La Binchoise Blonde', 'Belge', 'Pale Ale', '', 'Blonde', 'Brasserie La Binchoise', '', '6.2%', '', 'La Binchoise'),
(258, 'La Binchoise XO', 'Belge', 'Dark Ale', '', 'Brune', 'Brasserie La Binchoise', '', '12.0%', '', 'La Binchoise'),
(259, 'La corne du bois des pendus black', 'Belge', 'Dark Ale', 'Belgian Dark Ale', 'Brune', 'La Corne du bois des pendus', '', '8.0%', '', 'La Corne du bois des pendus'),
(260, 'La corne du bois des pendus triple', 'Belge', 'Triple', 'Tripel', 'Blonde', 'La Corne du bois des pendus', '', '10.0%', '', 'La Corne du bois des pendus'),
(261, 'La corne du bois des pendus blonde', 'Belge', 'Belgian Pale Ale', '', 'Blonde', 'La Corne du bois des pendus', '', '5.9%', '', 'La Corne du bois des pendus'),
(262, 'La Goudale', 'Française', 'Bière de garde', '', 'Blonde', 'Les Brasseurs de Gayant', 'Fermentation haute', '7.2%', '', 'La Goudale'),
(263, 'La Goudale Ambrée', 'Française', 'Bière de garde', '', 'Ambrée', 'Les Brasseurs de Gayant', '', '7.2%', '', 'La Goudale'),
(264, 'La Goudale de Printemps', 'Française', 'Bière de garde', 'Bière de saison', 'Blonde', 'Les Brasseurs de Gayant', '', '6.8%', '', 'La Goudale'),
(265, 'La Goudale de Noël', 'Française', 'Bière de garde', 'Bière de Noël', 'Ambrée', 'Les Brasseurs de Gayant', 'Fermentation haute', '7.2%', '', 'La Goudale'),
(266, 'La Goudale IPA', 'Française', 'India Pale Ale', '', 'Blonde', 'Les Brasseurs de Gayant', '', '7.2%', '', 'La Goudale'),
(267, 'La Goudale Grand Cru Houblon Mandarina', 'Française', '', '', 'Blonde', 'Les Brasseurs de Gayant', '', '7.9%', '', 'La Goudale'),
(268, 'La Goudale Grand Cru Houblons Citra & Am', 'Française', '', '', 'Blonde', 'Les Brasseurs de Gayant', '', '7.9%', '', 'La Goudale'),
(269, 'La Goudale Grand Cru Houblons Fantasia', 'Française', '', '', 'Blonde', 'Les Brasseurs de Gayant', '', '7.9%', '', 'La Goudale'),
(270, 'La Goule originale', 'Française', '', '', 'Blonde', 'Brasserie artisanale La Goule', 'Fermentation haute', '6.0%', '', 'La Goule'),
(271, 'La Goule Ambrée', 'Française', '', '', 'Ambrée', 'Brasserie artisanale La Goule', '', '6.0%', '', 'La Goule'),
(272, 'La Goule Bio', 'Française', 'Bière Bio', '', 'Blonde', 'Brasserie artisanale La Goule', '', '6.0%', '', 'La Goule'),
(273, 'La Goule Notre-Dame', 'Française', '', '', 'Blanche', 'Brasserie artisanale La Goule', '', '5.0%', '', 'La Goule'),
(274, 'La Goule Black Prince', 'Française', '', '', 'Brune', 'Brasserie artisanale La Goule', '', '6.0%', '', 'La Goule'),
(275, 'La Goule Kick', 'Française', '', '', 'Blonde', 'Brasserie artisanale La Goule', '', '6.0%', '', 'La Goule'),
(276, 'La Guillotine', 'Belge', 'Belgian Pale Ale', '', 'Blonde', 'Brasserie Huyghe', '', '8.5%', '', 'La Guillotine'),
(277, 'La Marise', 'Belge', 'Pale Ale', '', 'Blonde', 'Brasserie De Proef Brouwerij', 'Haute fermentation', '5.2%', '', 'La Marise'),
(278, 'La Parisienne Blonde', 'Française', 'Pale Ale', '', 'Blonde', 'Brasserie La Parisienne', '', '6.0%', '', 'La Parisienne'),
(279, 'La Parisienne Blanche', 'Française', 'Belgian White Ale', '', 'Blanche', 'Brasserie La Parisienne', '', '6.0%', '', 'La Parisienne'),
(280, 'La Parisienne Rousse', 'Française', 'Amber Ale', '', 'Rousse', 'Brasserie La Parisienne', '', '6.0%', '', 'La Parisienne'),
(281, 'La Parisienne Brune', 'Française', 'Scotch Ale', '', 'Brune', 'Brasserie La Parisienne', '', '6.0%', '', 'La Parisienne'),
(282, 'La Parisienne Libérée', 'Française', 'Lager', '', '', 'Brasserie La Parisienne', '', '5.0%', '', 'La Parisienne'),
(283, 'La Parisienne Le Poulbot', 'Française', 'Bière de saison', '', '', 'Brasserie La Parisienne', '', '5.5%', '', 'La Parisienne'),
(284, 'La Parisienne Le Titi Parisien', 'Française', 'India Pale Ale', '', '', 'Brasserie La Parisienne', '', '6.0%', '', 'La Parisienne'),
(285, 'L''Apache', 'Française', 'Stout', '', 'Noire', 'Brasserie La Parisienne', '', '5.5%', '', 'La Parisienne'),
(286, 'La Trappe Blonde', 'Hollandaise', 'Trappiste', 'Pale Ale', 'Blonde', ' Brasserie De Koningshoeven', 'Fermentation haute', '6.5%', '', 'La Trappe'),
(287, 'La Trappe Dubbel', 'Hollandaise', 'Trappiste', 'Double', 'Brune', ' Brasserie De Koningshoeven', '', '7.0%', '', 'La Trappe'),
(288, 'La Trappe Tripel', 'Hollandaise', 'Trappiste', 'Triple', 'Ambrée', ' Brasserie De Koningshoeven', '', '8.0%', '', 'La Trappe'),
(289, 'La Trappe Quadrupel', 'Hollandaise', 'Trappiste', 'Quadruple', 'Ambrée', ' Brasserie De Koningshoeven', '', '10.0%', '', 'La Trappe'),
(290, 'La Trappe Witte Trappist', 'Hollandaise', 'Trappiste', '', 'Blanche', ' Brasserie De Koningshoeven', '', '5.5%', '', 'La Trappe'),
(291, 'La Trappe Bockbier', 'Hollandaise', 'Trappiste', 'Dark Ale', 'Brune', ' Brasserie De Koningshoeven', '', '7.0%', '', 'La Trappe'),
(292, 'La Trappe Isid''or', 'Hollandaise', 'Trappiste', 'Pale Ale', 'Blonde', ' Brasserie De Koningshoeven', '', '7.5%', '', 'La Trappe'),
(293, 'La Trappe Puur', 'Hollandaise', 'Trappiste', 'Pale Ale', 'Blonde', ' Brasserie De Koningshoeven', '', '4.7%', '', 'La Trappe'),
(294, 'Leffe Blonde', 'Belge', 'Bière d''Abbaye', 'Pale Ale', 'Blonde', 'Abbaye de  Leffe (A.B. inBev)', '', '6.6%', '', 'Leffe'),
(295, 'Leffe Brune ', 'Belge', 'Bière d''Abbaye', 'Pale Ale', 'Brune', 'Abbaye de  Leffe (A.B. inBev)', '', '6.5%', '', 'Leffe'),
(296, 'Leffe Triple', 'Belge', 'Bière d''Abbaye', 'Triple', 'Blonde', 'Abbaye de  Leffe (A.B. inBev)', '', '8.5%', '', 'Leffe'),
(297, 'Leffe Rubis ', 'Belge', 'Bière d''Abbaye', 'Rubis ', 'Fruitée', 'Abbaye de  Leffe (A.B. inBev)', '', '5.0%', '', 'Leffe'),
(298, 'Leffe Nectar', 'Belge', 'Bière d''Abbaye', 'Blonde', 'Aromatisée', 'Abbaye de  Leffe (A.B. inBev)', '', '5.5%', '', 'Leffe'),
(299, 'Leffe Rituel', 'Belge', 'Bière d''Abbaye', '', 'Blonde', 'Abbaye de  Leffe (A.B. inBev)', 'Fermentation haute', '9.0%', '', 'Leffe'),
(300, 'Leffe Bière de Noël', 'Belge', 'Bière d''Abbaye', 'Bière de Noël', 'Ambrée', 'Abbaye de  Leffe (A.B. inBev)', '', '6.6%', '', 'Leffe'),
(301, 'Leffe Radieuse', 'Belge', 'Bière d''Abbaye', 'Dark Ale', 'Brune', 'Abbaye de  Leffe (A.B. inBev)', '', '8.2%', '', 'Leffe'),
(302, 'Leffe Royale Cascade IPA', 'Belge', 'Bière d''Abbaye', 'India Pale Ale', 'Blonde', 'Abbaye de  Leffe (A.B. inBev)', '', '7.5%', '', 'Leffe'),
(303, 'Leffe Royale Whitbread Golding', 'Belge', 'Bière d''Abbaye', 'Pale Ale', 'Blonde', 'Abbaye de  Leffe (A.B. inBev)', '', '7.5%', '', 'Leffe'),
(304, 'Leffe Royale Crystal', 'Belge', 'Bière d''Abbaye', 'Strong Ale', 'Blonde', 'Abbaye de  Leffe (A.B. inBev)', '', '7.5%', '', 'Leffe'),
(305, 'Leffe Royale Mapuche', 'Belge', 'Bière d''Abbaye', 'Pale Ale', 'Blonde', 'Abbaye de  Leffe (A.B. inBev)', '', '7.5%', '', 'Leffe'),
(306, 'Léon 1893', 'Belge', '', '', 'Blonde', 'Brasserie St-Feuillien', 'Fermentation haute', '6.5%', '', 'Léon'),
(307, 'Liefmans Fruitesse', 'Belge', 'Fruité', '', 'Fruitée', 'Brasserie Liefmans', '', '4.2%', '', 'Liefmans '),
(308, 'Kriek', 'Belge', 'Kriek', 'Lambic', 'Fruitée', 'Lindemans', '', '3.5%', '', 'Lindemans'),
(309, 'Gueuze', 'Belge', 'Gueuze', 'Lambic', 'Blonde', 'Lindemans', '', '5.0%', '', 'Lindemans'),
(310, 'Faro', 'Belge', 'Faro', 'Lambic', 'Ambrée', 'Lindemans', '', '4.5%', '', 'Lindemans'),
(311, 'Pecheresse', 'Belge', 'Fruité', 'Lambic', 'Fruitée', 'Lindemans', '', '2.5%', '', 'Lindemans'),
(312, 'Framboise', 'Belge', 'Fruité', 'Lambic', 'Fruitée', 'Lindemans', '', '2.5%', '', 'Lindemans'),
(313, 'Cassis', 'Belge', 'Fruité', 'Lambic', 'Fruitée', 'Lindemans', '', '3.5%', '', 'Lindemans'),
(314, 'Apple', 'Belge', 'Fruité', 'Lambic', 'Fruitée', 'Lindemans', '', '3.5%', '', 'Lindemans'),
(315, 'Lucifer', 'Belge', '', '', 'Blonde', 'Brasserie Het Anker', 'Fermentation haute', '8.0%', '', 'Lucifer'),
(316, 'Maneblusser', 'Belge', '', '', 'Blonde', 'Brasserie Het Anker', 'Fermentation haute', '5.8%', '', 'Maneblusser'),
(317, 'Maneblusser Lente', 'Belge', 'Bière de saison', 'Pilsen', 'Blonde', 'Brasserie Het Anker', 'Fermentation haute', '6.5%', '', 'Maneblusser'),
(318, 'Manneken Pils', 'Belge', 'Pilsen', '', 'Blonde', 'Brasserie Lefebvre', 'Fermentation basse', '5.0%', '', 'Manneken Pils'),
(319, 'Maredsous Blonde', 'Belge', 'Bière d''Abbaye', '', 'Blonde', 'Duvel Moortgat', '', '6.0%', '', 'Maredsous'),
(320, 'Maredsous Brune', 'Belge', 'Bière d''Abbaye', '', 'Brune', 'Duvel Moortgat', '', '8.0%', '', 'Maredsous'),
(321, 'Maredsous Triple', 'Belge', 'Bière d''Abbaye', 'Blonde', 'Ambrée', 'Duvel Moortgat', '', '10.0%', '', 'Maredsous'),
(322, 'Moeder Overste', 'Belge', '', 'Triple', 'Blonde', 'Brasserie Lefebvre', '', '8.0%', '', 'Moeder Overste'),
(323, 'Murphy''s Irish Stout', 'Irlandaise', 'Stout', '', '', 'Brasserie Murphy''s (Heineken)', 'Fermentation haute', '4.3%', '', 'Murphy''s '),
(324, 'Murphy''s Irish Red', 'Irlandaise', 'Red Ale', '', 'Ambrée', 'Brasserie Murphy''s (Heineken)', '', '5.0%', '', 'Murphy''s '),
(325, 'Newton', 'Belge', '', 'Blanche ', 'Fruitée', 'Brasserie Lefebvre', '', '3.5%', '', 'Newton'),
(326, 'Orval', 'Belge', 'Trappiste', '', '', 'Brasserie d''Orval', '', '6.2%', '', 'Orval'),
(327, 'Page 24 Blanche', 'Française', 'Witbier', '', 'Blanche', 'Brasserie Saint-Germain', '', '4.9%', '', 'Page 24'),
(328, 'Page 24 Blonde', 'Française', 'Bière de garde', '', 'Blonde', 'Brasserie Saint-Germain', '', '5.9%', '', 'Page 24'),
(329, 'Page 24 Blonde Triple', 'Française', 'Triple', '', 'Blonde', 'Brasserie Saint-Germain', '', '7.9%', '', 'Page 24'),
(330, 'Page 24 Blonde de Printemps', 'Française', 'Bière de saison', '', 'Blonde', 'Brasserie Saint-Germain', '', '6.0%', '', 'Page 24'),
(331, 'Page 24 Brune', 'Française', 'Bière de garde', '', 'Brune', 'Brasserie Saint-Germain', '', '7.9%', '', 'Page 24'),
(332, 'Page 24 Bière de Noël', 'Française', 'Bière de Noël', '', 'Ambrée', 'Brasserie Saint-Germain', '', '6.9%', '', 'Page 24'),
(333, 'Page 24 Réserve Hidelgarde Ambrée', 'Française', 'Bière de garde', '', 'Ambrée', 'Brasserie Saint-Germain', '', '6.7%', '', 'Page 24'),
(334, 'Page 24 Réserve Hidelgarde Blonde', 'Française', 'Bière de garde', '', 'Blonde', 'Brasserie Saint-Germain', '', '6.9%', '', 'Page 24'),
(335, 'Page 24 Malts & Hops', 'Française', 'Bière de garde', 'Ambrée', 'Blonde', 'Brasserie Saint-Germain', '', '8.9%', '', 'Page 24'),
(336, 'Panach''', 'Française', 'Panaché', '', '', 'Brasserie de la Valentine (Heineken)', '', '1.2 %', '', 'Panach'''),
(337, 'Panach'' le Monaco', 'Française', 'Panaché', '', 'Fruitée', 'Brasserie de la Valentine (Heineken)', '', '1.2 %', '', 'Panach'''),
(338, 'Iparisis', 'Française', 'India Pale Ale', '', 'Blonde', 'Brasserie Parisis', '', '6.2%', '', 'Parisis'),
(339, 'Parisis Blonde ', 'Française', 'Pale Ale ', '', 'Blonde', 'Brasserie Parisis', '', '6.5%', '', 'Parisis'),
(340, 'Parisis Ambrée', 'Française', 'Amber Ale', 'Rousse', 'Ambrée', 'Brasserie Parisis', '', '6.2%', '', 'Parisis'),
(341, 'Parisis Blanche', 'Française', 'Weissbier', '', 'Blanche', 'Brasserie Parisis', 'Fermentation haute', '4.1%', '', 'Parisis'),
(342, 'Parisis Triple', 'Française', '', 'Triple', 'Blonde', 'Brasserie Parisis', '', '8.0%', '', 'Parisis'),
(343, 'Parisis bière de printemps', 'Française', 'Rye IPA', '', '', 'Brasserie Parisis', '', '6.0%', '', 'Parisis'),
(344, 'Paulaner Münchner Hell', 'Allemande', 'Lager', 'Helles', 'Blonde', 'Brasserie Paulaner', 'Fermentation basse', '4.9%', '', 'Paulaner'),
(345, 'Paulaner Oktoberfest Bier', 'Allemande', 'Märzen', '', 'Blonde', 'Brasserie Paulaner', 'Fermentation basse', '6.0%', '', 'Paulaner'),
(346, 'Paulaner Salvator', 'Allemande', 'Doppelbock', '', 'Ambrée', 'Brasserie Paulaner', '', '7.9%', '', 'Paulaner'),
(347, 'Paulaner Hefe-Weißbier Naturtrüb', 'Allemande', 'Weissbier', '', '', 'Brasserie Paulaner', 'Fermentation haute', '5.5%', '', 'Paulaner'),
(348, 'Paulaner Weißbier Kristallklar', 'Allemande', 'Weissbier', '', 'Blanche', 'Brasserie Paulaner', 'Fermentation haute', '5.5%', '', 'Paulaner'),
(349, 'Paulaner Hefe-Weißbier Non-Alcoholic', 'Allemande', 'Weissbier', 'Sans alcool', 'Blanche', 'Brasserie Paulaner', 'Fermentation haute', '0.0%', '', 'Paulaner'),
(350, 'Paulaner Weißbier-Radler Non-Alcoholic', 'Allemande', 'Weissbier', 'Sans alcool', 'Blanche', 'Brasserie Paulaner', 'Fermentation haute', '0.0%', '', 'Paulaner'),
(351, 'Paulaner Hefe-Weißbier Dunkel', 'Allemande', 'Weissbier', '', 'Brune', 'Brasserie Paulaner', 'Fermentation haute', '5.3%', '', 'Paulaner'),
(352, 'Pelforth Blonde', 'Française', '', '', 'Blonde', 'Brasseries du Pelican (Heineken)', '', '5.8%', '', 'Pelforth'),
(353, 'Pelforth Brune', 'Française', '', '', 'Brune', 'Brasseries du Pelican (Heineken)', '', '6.5%', '', 'Pelforth'),
(354, 'Pelforth Ambrée', 'Française', '', '', 'Ambrée', 'Brasseries du Pelican (Heineken)', '', '6.0%', '', 'Pelforth'),
(355, 'Pelforth 3 Malts', 'Française', '', '', 'Blonde', 'Brasseries du Pelican (Heineken)', '', '6.9%', '', 'Pelforth'),
(356, 'Pelforth de Printemps', 'Française', 'Bière de saison', '', '', 'Brasseries du Pelican (Heineken)', '', '6.0%', '', 'Pelforth'),
(357, 'Pelforth Radler', 'Française', '', '', 'Fruitée', 'Brasseries du Pelican (Heineken)', '', '2.5%', '', 'Pelforth'),
(358, 'Petrus Blond', 'Belge', 'Belgian Pale Ale', '', 'Blonde', 'Brasserie Bavik', 'Fermentation haute', '6.6%', '', 'Petrus'),
(359, 'Piedboeuf Blonde', 'Belge', 'Bière de table', '', 'Blonde', 'Brasserie Jupiler', '', '1.2%', '', 'Piedboeuf'),
(360, 'Piedboeuf Brune', 'Belge', 'Bière de table', '', 'Brune', 'Brasserie Jupiler', '', '1.2%', '', 'Piedboeuf'),
(361, 'Piedboeuf Triple', 'Belge', 'Bière de table', 'Triple', '', 'Brasserie Jupiler', '', '3.8%', '', 'Piedboeuf'),
(362, 'Pietra', 'Française', 'Lager', '', 'Ambrée', 'Brasserie Pietra', 'Fermentation basse', '6.0%', '', 'Pietra'),
(363, 'Pietra Bionda', 'Française', '', 'Blonde', 'Ambrée', 'Brasserie Pietra', '', '5.5%', '', 'Pietra'),
(364, 'Pietra Rossa', 'Française', '', '', 'Fruitée', 'Brasserie Pietra', '', '6.5%', '', 'Pietra'),
(365, 'Serena', 'Française', '', '', 'Blonde', 'Brasserie Pietra', 'Fermentation basse', '5.0%', '', 'Pietra'),
(366, 'Pietra de Noël', 'Française', 'Bière de Noël', '', 'Rousse', 'Brasserie Pietra', '', '7.0%', '', 'Pietra'),
(367, 'Pilsner Urquell', 'Tchèque', 'Pilsner', 'Pilsen', 'Blonde', 'Pilsner Urquell', 'Fermentation basse', '4.4%', '', 'Pilsner Urquell'),
(368, 'Piraat', 'Belge', 'Belgian Pale Ale', '', 'Ambrée', 'Brasserie Van Steenberge', '', '10.5%', '', 'Piraat'),
(369, 'Piraat Triple Hop', 'Belge', 'Belgian Pale Ale', 'Triple', 'Blonde', 'Brasserie Van Steenberge', '', '10.5%', '', 'Piraat'),
(370, 'Queue de Charrue Blonde', 'Belge', 'Belgian Pale Ale', '', 'Blonde', 'Brasserie Du Bocq (Vanuxeem)', '', '6.6%', '', 'Queue de Charrue'),
(371, 'Queue de Charrue Ambrée', 'Belge', '', '', 'Ambrée', 'Brasserie Du Bocq (Vanuxeem)', '', '5.6%', '', 'Queue de Charrue'),
(372, 'Queue de Charrue Triple', 'Belge', 'Triple', '', 'Blonde', 'Brasserie Van Steenberge (Vanuxeem)', '', '9.0%', '', 'Queue de Charrue'),
(373, 'Queue de Charrue Brune', 'Belge', '', '', 'Brune', 'Brasserie Verhaeghe (Vanuxeem)', '', '5.4%', '', 'Queue de Charrue'),
(374, 'Page 24 Rhub IPA', 'Française ', 'India Pale Ale', '', '', 'Brasserie Saint-Germain', '', '6.9%', '', 'Rhub IPA'),
(375, 'Rince cochon', 'Belge', 'Pale Ale', '', 'Blonde', 'Brasserie Haacht', '', '8.5%', '', 'Rince cochon'),
(376, 'Rince cochon rouge', 'Belge', '', 'Rubis', 'Fruitée', 'Brasserie Haacht', '', '7.5%', '', 'Rince cochon'),
(377, 'Rince cochon cuvée spéciale sur Lie', 'Belge', '', '', 'Blonde', 'Brasserie Haacht', '', '8.5%', '', 'Rince cochon'),
(378, 'Rochefort 8', 'Belge', 'Trappiste', '', 'Brune', 'Abbaye de Rochefort', '', '9.2%', '', 'Rochefort'),
(379, 'Rochefort 6', 'Belge', 'Trappiste', '', 'Brune', 'Abbaye de Rochefort', '', '7.5%', '', 'Rochefort'),
(380, 'Rochefort 10', 'Belge', 'Trappiste', 'Quadrupel', 'Brune', 'Abbaye de Rochefort', '', '11.3%', '', 'Rochefort'),
(381, 'Tempete du Desert', 'Française', 'Ale', 'Golden Ale', 'Blonde', 'Brasserie Sainte-Cru', '', '5.5%', '', 'Sainte-Cru'),
(382, 'White Rabbit', 'Française', '', '', 'Blanche', 'Brasserie Sainte-Cru', '', '5.0%', '', 'Sainte-Cru'),
(383, 'Red is Dead', 'Française', 'Rousse', 'Amber ale', 'Ambrée', 'Brasserie Sainte-Cru', '', '7.0%', '', 'Sainte-Cru'),
(384, 'Orange Mécanique', 'Française', 'Miel', 'Triple', 'Blonde', 'Brasserie Sainte-Cru', '', '7.0%', '', 'Sainte-Cru'),
(385, 'Saison 1900', 'Belge', 'Bière de saison', 'Farmhouse Ale', 'Ambrée', 'Brasserie Lefebvre', '', '5.4%', '', 'Saison 1900'),
(386, 'Samuel Adams Boston Lager', 'Américaine ', 'Lager', '', 'Blonde', 'Shepherd Neame Brewery', '', '4.8%', '', 'Samuel Adams'),
(387, 'San Miguel', 'Espagnole', 'Lager', '', 'Blonde', 'San Miguel', '', '5.4%', '', 'San Miguel'),
(388, 'Secret des moines Triple', 'Française', 'Triple', '', 'Blonde', 'Les Brasseurs de Gayant', '', '8.0%', '', 'Secret des moines'),
(389, 'Sköll Tuborg', 'Française', '', '', 'Blonde', 'Brasserie Kronenbourg (Carlsberg)', '', '6.0%', '', 'Sköll '),
(390, 'St Bernardus ABT 12', 'Belge', 'Bière d''Abbaye', 'Quadruple', 'Brune ', 'Brasserie St Bernard', '', '10.0%', '', 'St Bernardus'),
(391, 'St Bernardus Wit', 'Belge', 'Bière d''Abbaye', 'Blanche', 'Blanche', 'Brasserie St Bernard', '', '5.5%', '', 'St Bernardus'),
(392, 'St Louis Gueuze Fond Tradition', 'Belge', 'Gueuze', '', 'Blonde', 'Brasserie Van Honsebrouck', 'Fermentation spontan', '5.0%', '', 'St Louis '),
(393, 'Stella artois', 'Belge', 'Lager', '', 'Blonde ', 'InterBrew (A.B. inBev)', 'Fermentation Basse', '5.2%', '', 'Stella'),
(394, 'St-Feuillien Blonde', 'Belge', '', '', 'Blonde', 'Brasserie St-Feuillien', '', '7.5%', '', 'St-Feuillien'),
(395, 'St-Feuillien Brune Réserve', 'Belge', '', '', 'Brune', 'Brasserie St-Feuillien', '', '8.5%', '', 'St-Feuillien'),
(396, 'St-Feuillien Triple', 'Belge', 'Triple', '', 'Blonde', 'Brasserie St-Feuillien', '', '8.5%', '', 'St-Feuillien'),
(397, 'St-Feuillien Cuvée de Noël', 'Belge', 'Bière de Noël', '', 'Rubis', 'Brasserie St-Feuillien', '', '9.0%', '', 'St-Feuillien'),
(398, 'Saison from St-Feuillien', 'Belge', '', '', 'Blonde', 'Brasserie St-Feuillien', 'Fermentation haute', '6.5%', '', 'St-Feuillien'),
(399, 'St-Feuillien Grand Cru', 'Belge', '', '', 'Blonde', 'Brasserie St-Feuillien', '', '9.5%', '', 'St-Feuillien'),
(400, 'Mythique Saint Landelin', 'Française', '', '', 'Blonde', 'Les Brasseurs de Gayant', '', '7.5%', '', 'St-Landelin'),
(401, 'Saint Landelin Blonde', 'Française', 'Bière de garde', '', 'Blonde', 'Les Brasseurs de Gayant', '', '6.5%', '', 'St-Landelin');
INSERT INTO `Biere` (`idBiere`, `nom_biere`, `nationalite`, `type`, `type2`, `couleur`, `brasserie`, `methodebrassage`, `degre_alcool`, `commentaires`, `common_name`) VALUES
(402, 'Saint Landelin Ambrée', 'Française', '', '', 'Ambrée', 'Les Brasseurs de Gayant', '', '6.5%', '', 'St-Landelin'),
(403, 'Saint Landelin Blanche', 'Française', '', '', 'Blanche', 'Les Brasseurs de Gayant', '', '4.5%', '', 'St-Landelin'),
(404, 'St-Stefanus Grand cru', 'Belge', 'Belgian Pale Ale', '', 'Blonde', 'St-Stefanus (Brasserie Van Steenberge)', '', '9.0%', '', 'St-Stefanus'),
(405, 'St-Stefanus Blonde', 'Belge', 'Belgian Pale Ale', '', 'Blonde', 'St-Stefanus (Brasserie Van Steenberge)', '', '7.0%', '', 'St-Stefanus'),
(406, 'Surfine', 'Belge', 'Bière de saison', 'Farmhouse Ale', 'Blonde', 'Brasserie Dubuisson', '', '6.5%', '', 'Surfine'),
(407, 'Tiger', 'Singapourienne', '', '', 'Blonde', 'Asia Pacific Breweries (Heineken)', '', '5.0%', '', 'Tiger'),
(408, 'Vedett Extra Blond', 'Belge', 'Lager', '', 'Blonde', 'Vedett', '', '5.2%', '', 'Vedett'),
(409, 'Vedett IPA', 'Belge', 'India Pale Ale', '', 'Blonde', 'Vedett', '', '5.5%', '', 'Vedett'),
(410, 'Vedett White', 'Belge', 'Blanche', '', 'Blanche', 'Vedett', '', '4.7%', '', 'Vedett'),
(411, 'Westmalle Triple', 'Belge', 'Trappiste', '', 'Blonde', 'Abbaye de Westmalle', '', '9.5%', '', 'Westmalle'),
(412, 'Westmalle Dubble Brune', 'Belge', 'Trappiste', 'Brune', 'Ambrée', 'Abbaye de Westmalle', '', '7.0%', '', 'Westmalle'),
(413, 'Trappist Westvleteren Blond', 'Belge', 'Trappiste', '', 'Blonde', 'Abbaye de Saint-Sixte', '', '5.8%', '', 'Westvleteren'),
(414, 'Trappist Westvleteren 8', 'Belge', 'Trappiste', '', 'Brune', 'Abbaye de Saint-Sixte', '', '8.0%', '', 'Westvleteren'),
(415, 'Trappist Westvleteren 12', 'Belge', 'Trappiste', '', 'Brune', 'Abbaye de Saint-Sixte', '', '10.2%', '', 'Westvleteren'),
(416, 'Primator 24 Double', 'Tchèque', '', '', 'Brune', 'Brasserie Primator', '', '10.5%', '', 'Primator'),
(417, 'Primator 10 Svelty', 'Tchèque', '', '', 'Blonde', 'Brasserie Primator', '', '4.0%', '', 'Primator'),
(418, 'Primator 11', 'Tchèque', '', '', 'Blo nde', 'Brasserie Primator', '', '4.7%', '', 'Primator'),
(419, 'Primator 12 Premium', 'Tchèque', '', '', 'Blonde', 'Brasserie Primator', '', '5.0%', '', 'Primator'),
(420, 'Primator 13', 'Tchèque', '', '', 'Ambrée', 'Brasserie Primator', '', '5.5%', '', 'Primator'),
(421, 'Primator 16 Exkluziv', 'Tchèque', '', '', 'Blonde', 'Brasserie Primator', '', '7.5%', '', 'Primator'),
(422, 'Primator 21 Rytirsky', 'Tchèque', '', '', 'Blonde', 'Brasserie Primator', '', '9.5%', '', 'Primator'),
(423, 'Primator Premium Dark', 'Tchèque', '', '', 'Brune', 'Brasserie Primator', '', '4.8%', '', 'Primator'),
(424, 'Primator Stout', 'Tchèque', '', '', 'Noire', 'Brasserie Primator', '', '4.8%', '', 'Primator'),
(425, 'Primator Pale Ale', 'Tchèque', 'Pale Ale', '', 'Blonde', 'Brasserie Primator', '', '5.0%', '', 'Primator'),
(426, 'Primator Weizen', 'Tchèque', 'Weissbier', '', 'Blanche', 'Brasserie Primator', '', '5.0%', '', 'Primator'),
(427, 'Primator Chipper', 'Tchèque', 'Blanche', '', 'Fruitée', 'Brasserie Primator', '', '2.0%', '', 'Primator'),
(428, 'La Bête', 'Française', 'Pilsen', '', 'Ambrée', 'Brasserie Castelain ', '', '8.0%', '', 'La Bête'),
(429, 'Carlsberg', 'Danoise', 'Lager', '', 'Blonde', 'Brasserie Carlsberg', '', '7.2%', '', 'Elephant'),
(430, 'O''Hara''s Leann Follain', 'Irlandaise', 'Stout', '', 'Noire', 'Carlow Brewing Company', '', '6.0%', '', 'O''Hara''s'),
(431, 'Belhaven Twisted Thistle IPA', 'Ecossaise', 'India Pale Ale', '', 'Ambrée', 'Brasserie Belhaven ', '', '5.3%', '', 'Belhaven'),
(432, 'American Bud', 'Américaine ', 'Lager', '', 'Blonde', 'Brasserie Anheuser-Busch', 'Fermentation basse', '4.9%', '', 'Bud'),
(433, 'Budweiser Budvar', 'Tchèque', 'Pilsen', '', 'Ambrée', 'Brasserie Budweiser Budvar', 'Fermentation basse', '5.0%', '', 'Bud'),
(434, 'Buckler', 'Allemande', 'Bière Sans Alcool', '', 'Blonde', 'Brasserie Heineken', '', '0.9%', '', 'Buckler'),
(435, 'Blonde', 'Bière de bar', '', '', 'Blonde', '', '', '', '', 'Blonde pas chère');

-- --------------------------------------------------------

--
-- Structure de la table `Frequente`
--

CREATE TABLE IF NOT EXISTS `Frequente` (
  `Utilisateurs_idUtilisateurs` int(11) NOT NULL,
  `Bar_idBar` int(11) NOT NULL,
  PRIMARY KEY (`Utilisateurs_idUtilisateurs`,`Bar_idBar`),
  KEY `fk_Utilisateurs_has_Bar_Bar1_idx` (`Bar_idBar`),
  KEY `fk_Utilisateurs_has_Bar_Utilisateurs1_idx` (`Utilisateurs_idUtilisateurs`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateurs`
--

CREATE TABLE IF NOT EXISTS `Utilisateurs` (
  `idUtilisateurs` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL,
  `password` varchar(45) NOT NULL,
  `adresse_mail` varchar(50) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `isConnected` tinyint(1) NOT NULL,
  PRIMARY KEY (`idUtilisateurs`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `Utilisateurs`
--

INSERT INTO `Utilisateurs` (`idUtilisateurs`, `userName`, `password`, `adresse_mail`, `age`, `isConnected`) VALUES
(1, 'Filed', 'moule', 'mathieucolin91@gmail.com', 23, 0),
(2, 'beigbeder', 'moule', 'xeno', 8, 0),
(3, 'sebite', 'seb', 'sebastiendossant', 23, 0),
(4, 'L''allemand', 'HUMtmi60', 'mathiasbaily@Gmail.com', 23, 0);

-- --------------------------------------------------------

--
-- Structure de la table `Vend`
--

CREATE TABLE IF NOT EXISTS `Vend` (
  `Bar_idBar` int(11) NOT NULL,
  `Biere_idBiere` int(11) NOT NULL,
  `Prix` decimal(10,1) NOT NULL,
  `conditionnement` varchar(10) NOT NULL,
  `prix_happy_hour` decimal(11,1) NOT NULL,
  PRIMARY KEY (`Bar_idBar`,`Biere_idBiere`),
  KEY `fk_Bar_has_Biere_Biere1_idx` (`Biere_idBiere`),
  KEY `fk_Bar_has_Biere_Bar_idx` (`Bar_idBar`),
  KEY `Bar_idBar` (`Bar_idBar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `Vend`
--

INSERT INTO `Vend` (`Bar_idBar`, `Biere_idBiere`, `Prix`, `conditionnement`, `prix_happy_hour`) VALUES
(1, 42, '4.0', 'Bouteille', '3.0'),
(1, 110, '6.0', 'Bouteille', '3.0'),
(1, 206, '8.0', 'Bouteille', '5.0'),
(2, 13, '182.0', 'Bouteille', '158.0'),
(2, 14, '4.0', 'Bouteille', '6.0'),
(2, 70, '97.0', 'Bouteille', '86.0'),
(2, 73, '6.0', 'Bouteille', '6.0'),
(2, 131, '9.0', 'Pression', '6.0'),
(2, 132, '6.0', 'Bouteille', '4.0'),
(2, 133, '7.0', 'Pression', '10.0'),
(2, 135, '6.0', 'Bouteille', '4.0'),
(2, 136, '11.0', 'Pression', '14.0'),
(2, 150, '12.0', 'Bouteille', '15.0'),
(2, 151, '8.6', 'Bouteille', '5.4'),
(2, 206, '14.0', 'Bouteille', '18.0'),
(2, 207, '4.0', 'Bouteille', '2.0'),
(2, 209, '79.0', 'Pression', '86.0'),
(2, 297, '5.0', 'Bouteille', '5.0'),
(2, 418, '6.0', 'Bouteille', '8.0'),
(2, 435, '400000.0', 'Pression', '55.0');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Aime`
--
ALTER TABLE `Aime`
  ADD CONSTRAINT `fk_Utilisateurs_has_Biere_Biere1` FOREIGN KEY (`Biere_idBiere`) REFERENCES `Biere` (`idBiere`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Utilisateurs_has_Biere_Utilisateurs1` FOREIGN KEY (`Utilisateurs_idUtilisateurs`) REFERENCES `Utilisateurs` (`idUtilisateurs`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Frequente`
--
ALTER TABLE `Frequente`
  ADD CONSTRAINT `fk_Utilisateurs_has_Bar_Bar1` FOREIGN KEY (`Bar_idBar`) REFERENCES `Bar` (`idBar`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Utilisateurs_has_Bar_Utilisateurs1` FOREIGN KEY (`Utilisateurs_idUtilisateurs`) REFERENCES `Utilisateurs` (`idUtilisateurs`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `Vend`
--
ALTER TABLE `Vend`
  ADD CONSTRAINT `fk_Bar_has_Biere_Bar` FOREIGN KEY (`Bar_idBar`) REFERENCES `Bar` (`idBar`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Bar_has_Biere_Biere1` FOREIGN KEY (`Biere_idBiere`) REFERENCES `Biere` (`idBiere`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
